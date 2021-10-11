import React from 'react';
import './nav.css';
import Nav from './nav';
import food4 from './food5.jpg';
import axios from 'axios';
import './signup.css'

export default class signup extends React.Component {
    state= {
        name: " ",
        email: " ",
        password: " "
    };
    handleChange = (event) => {
        this.setState( { [event.target.id]: event.target.value } )
      }
   handleSubmit= event=> { event.preventDefault();
   const newUser={
       name: this.name,
       email:this.email,
       password:this.password,

   };
   axios.post(`http://localhost:8081/api/users/new-account`).
   then(() => {
    this.setState ({
    name: ' ',
    email: ' ',
    password: ' '})
  })
   }

    render(){
    return (
       

        <div>
             {/* <Nav/> */}
          <div >
             
                <form className="signUp" onSubmit={this.handleSubmit}> 
                <label>
                <input type="text" name="email" id="email" placeholder="email" onChange={this.handleChange} />
                </label>
                <label>
                    <input type="password" id="password"placeholder="password" onChange={this.handleChange}/>
                </label>
                <button>
                    Sign Up
                </button>

                </form>
                
            </div>
            </div>
            


           
         
                 
          


        
       
      
     

    )
    }
}