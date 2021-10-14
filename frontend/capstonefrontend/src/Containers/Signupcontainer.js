import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav.js';
import food4 from '../Resources/food5.jpg';
import axios from 'axios';
import { Container } from 'react-bootstrap';
import './Signupcontainer.css'

export default class Signupcontainer extends React.Component {
    constructor(props) {
        super(props);
    
        this.state = {
          email: "",
          username: "",
          password: ""
          
        };
    
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
      }
    
      handleChange(event) {
        this.setState({
          [event.target.name]: event.target.value
        });
      }
    
      handleSubmit(event) {
        const { email, username, password } = this.state;
       console.log("welldone")
    
       axios.post("http://localhost:8081/api/users/new-account", null, { params: { userName: username, email: email, password: password }})

          .then(response => {
            if (response.data.status === "created") {
              this.props.handleSuccessfulAuth(response.data);
            }
          })
          .catch(error => {
            console.log("registration error", error);
          });
        event.preventDefault();
      }
    
      render() {
        return (
          <Container className="register">
          <div>
            <form onSubmit={this.handleSubmit}>
              <div className="signup">
              <input className= "sign"
                type="email"
                name="email"
                placeholder="Email"
                value={this.state.email}
                onChange={this.handleChange}
                required
              /> 
              <input className= "sign"
                type="text"
                name="username"
                placeholder="username"
                value={this.state.username}
                onChange={this.handleChange}
                required
              />
    
              <input className="sign"
                type="password"
                name="password"
                placeholder="Password"
                value={this.state.password}
                onChange={this.handleChange}
                required
              />
              <div className="register-button">
             <button className="sign" type="submit">Register</button>
             </div>
               
             </div>
            </form>
          </div>
          </Container>
             
          
        );
      }
      
   
   
//       constructor (props){
//       super(props);

//       this.state = {
//         name: '',
//         email: '',
//         password: ''
//       }
//       this.handleChange=this.handleChange.bind(this);
//       this.handleChange=this.handleSubmit.bind(this)
//     }
    
  
//     handleChange = (event) => {
//       this.setState( { [event.target.id]: event.target.value } )
//     }
  
//     handleSubmit = event => {
//       event.preventDefault();
  
//       const user = {
//         name: this.state.name,
//         email: this.state.email,
//         password: this.state.password,
//       };

  
     
//       axios.post(`http://localhost:8081/api/users/new-account`, null, { params: { userName: username, email: email, password: password })}
//         .then(() => {
//           this.setState ({
//           name: '',
//           email: '',
//           password: ''})
//         })
         
    
// }
  
//     render() {
//       return (
//         <div className="sign-into">
//           <form onSubmit={this.handleSubmit}>
//             <label>
//               Name:
//               <input type="text" name="name" id="name" value={this.state.name} onChange={this.handleChange} required />
//             </label>
//             <label>
//               Email:
//               <input type="text" name="email" id="email" value={this.state.email} onChange={this.handleChange} required />
//             </label>
//             <label>
//               Password:
//               <input type="text" name="password" id="password"  value={this.state.password} onChange={this.handleChange} required />
//             </label>
//             <button type="Create User">Add</button>
//           </form>

        /* <div>
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLongTitle">Add New User</h5>
            <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form onSubmit={this.handleSubmit}>
              <label>
                Name:
                <input type="text" name="name" id="name" onChange={this.handleChange} />
              </label>
              <label>
                Email:
                <input type="text" name="email" id="email" onChange={this.handleChange} />
              </label>
              <label>
                Password:
                <input type="text" name="password" id="password" onChange={this.handleChange} />
              </label>
              <button type="Create User">Save New User</button>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
          </div> */}

        {/* </div> */}
    //     </div>
    //   )

    // }
    //   }
  

// export default class Signupcontainer extends React.Component {
//     constructor(props){
//         super(props);
//         this.state= {
//             name: " ",
//             email: " ",
//             password: " "
//         };
     
//     }
   
//    handleChange = (event) => {
//         this.setState( { [event.target.id]: event.target.value } )
//       }
//    handleSubmit= event=> { event.preventDefault();
//    const newUser={
//        name: this.state.name,
//        email:this.state.email,
//        password:this.state.password,

//    };
//    axios.post(`http://localhost:8081/api/users/new-account`,newUser).
//    then(() => {
//     this.setState ({
//     name: ' ',
//     email: ' ',
//     password: ' '})
//   }).catch()
//    }

//     render(){
//     return (
       

//         <div>
            
//           <div >
             
//                 <form className="signUp" onSubmit={this.handleSubmit}> 
//                 <label>
//                     <input type ="text" name= "name" id="name" placeholder="name" onChange={this.handleChange}/>
//                 </label>
//                 <label>
//                 <input type="text" name="email" id="email" placeholder="email" onChange={this.handleChange} />
//                 </label>
//                 <label>
//                     <input type="password" name="password" id="password"placeholder="password" onChange={this.handleChange}/>
//                 </label>
//                 <button>
//                     Sign Up
//                 </button>

//                 </form>
                
//             </div>
//             </div>
//     )
//     }
// }