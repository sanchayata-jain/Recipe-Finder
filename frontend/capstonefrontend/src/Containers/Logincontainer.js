import React from 'react'
import axios from 'axios'
import React, { Component } from 'react'




export default class Logincontainer extends Component {
   state= {
        email: " ",
        password= " "
    };
    handleChange = (event) => {
        this.setState( { [event.target.name]: event.target.value } )
      }
   handleSubmit= event => {
   event.preventDefault();
    
   const user= {
       email: this.state.email,
       password: this.state.password
   }
   axios.post(`http://localhost:8081/api/users/login`, {user})
   }
    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}> 
                <label>
                <input type="text" name="email"  placeholder="email" onChange={this.handleChange} />
                </label>
                <label>
                    <input type="password" placeholder="password" onChange={this.handleChange}/>
                </label>
                <button>
                    Log in
                </button>

                </form>
                
            </div>
        )
    }
}