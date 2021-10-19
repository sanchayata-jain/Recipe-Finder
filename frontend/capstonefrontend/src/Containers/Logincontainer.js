import React from 'react'
import axios from 'axios'
import './Logincontainer.css'
import {Redirect} from 'react-router-dom';


export default class Logincontainer extends React.Component{
    constructor(props){
        super(props);
        this.state={
            email: " ",
            password: " ",
            redirect: false
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit=this.handleSubmit.bind(this);
        this.renderRecipe = this.renderRecipe.bind(this);
    }
      
    handleChange = (event) => {
        this.setState( { [event.target.name]: event.target.value } )
    }


    handleSubmit(event) {
        const { email,password } = this.state;
   
    
   
   axios.post(`http://localhost:8080/api/users/login`,null,{ params: { userEmail: email, userPassword: password }})
   .then(response => {
    if (response.data.logged_in) {
      this.props.handleSuccessfulAuth(response.data);
    }
    this.setState({ redirect:false });
    console.log(this.state);
  }) 

  


  .catch(error => {
    console.log("login error", error);
    alert("The email or password you have entered is incorrect");
  });
        event.preventDefault();
}

renderRecipe = () => {
  if (this.state.redirect) {
      return (<Redirect to={{
                              pathname:`/profile`
                            
                          }} />)
  }
}


   render() {
    return (
      <div className="login-form">
        <form onSubmit={this.handleSubmit}>
            <h2>Login</h2>
            <div className="login">
              {this.renderRecipe()}
                <input className="user-input"
                    type="email"
                    name="email"
                    placeholder="email"
                    value={this.state.email}
                    onChange={this.handleChange}
                    required
                />

                <input className="user-input"
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={this.state.password}
                    onChange={this.handleChange}
                    required
                />

                <button className="button" type="submit" onClick={this.handleClick}>Login</button>
            </div>
        </form>
      </div>
    );
  }
       

        
   
}