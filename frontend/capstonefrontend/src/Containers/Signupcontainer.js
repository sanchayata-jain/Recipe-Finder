import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav.js';
import food4 from '../Resources/food5.jpg';
import axios from 'axios';
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
    
       axios.post("http://localhost:8080/api/users/new-account", null, { params: { userName: username, userEmail: email, userPassword: password }})

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
          
          <div className="register">
            <form onSubmit={this.handleSubmit}>
              <h2>Sign Up!</h2>  
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
    
                <button className="button" type="submit">Register</button>
              </div>
            </form>
          </div>
          
        );
      }
    }