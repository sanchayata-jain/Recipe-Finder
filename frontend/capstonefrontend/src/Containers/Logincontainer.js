import React from 'react'
import axios from 'axios'


export default class Logincontainer extends React.Component{
    constructor(props){
        super(props);
        this.state={
            email: " ",
            password: " "
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit=this.handleSubmit.bind(this)
    }
      
      handleChange = (event) => {
      this.setState( { [event.target.name]: event.target.value } )
    }
    handleSubmit(event) {
        const { email,password } = this.state;
   
    
   
   axios.post(`http://localhost:8081/api/users/login`,null,{ params: { userEmail: email, userPassword: password }})
   .then(response => {
    if (response.data.logged_in) {
      this.props.handleSuccessfulAuth(response.data);
    }
  }) 
  .catch(error => {
    console.log("login error", error);
  });
  
        event.preventDefault();
   }
   handleClick= (addEventListener)
   render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <input
            type="email"
            name="email"
            placeholder="email"
            value={this.state.email}
            onChange={this.handleChange}
            required
          />

          <input
            type="password"
            name="password"
            placeholder="Password"
            value={this.state.password}
            onChange={this.handleChange}
            required
          />

          <button type="submit" onClick={this.handleClick}>Login</button>
        </form>
      </div>
    );
  }
       

        
   
}



// export default class Logincontainer extends React.Component {
//     constructor(props){
//         super(props);
//    this.state= {
//         email: " ",
//         password: " "
//     };
//     }
//     handleChange = (event) => {
//         this.setState( { [event.target.name]: event.target.value } )
//       }
//    handleSubmit= event => {
//    event.preventDefault();
    
//    const user= {
//        email: this.state.email,
//        password: this.state.password
//    }
//    axios.post(`http://localhost:8081/api/users/login`, null,{ params: { userEmail: email, userPassword: password }})
//    }.then()
//     render() {
//         return (
//             <div>
//                 <form onSubmit={this.handleSubmit}> 
//                 <label>
//                 <input type="text" name="email"  placeholder="email"  value={this.state.email} onChange={this.handleChange} />
//                 </label>
//                 <label>
//                     <input type="password" name="password" placeholder="password" value={this.state.password} onChange={this.handleChange}/>
//                 </label>
//                 <button>
//                     Log in
//                 </button>

//                 </form>
                
//             </div>
//         )
//     }
// }