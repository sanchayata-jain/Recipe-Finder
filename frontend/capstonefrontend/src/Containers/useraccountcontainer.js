import React, { Component } from 'react'
import Logincontainer from './Logincontainer';
import axios from 'axios';

export default class Useraccount extends Component {
    constructor(props) {
        super(props);
        this.state = {
          user: {}
    
        }
    
        this.getUsers = this.getUsers.bind(this);
      }
      
      componentDidMount() {
        this.getUsers();
      }
      
      getUsers(){
        axios.get('http://localhost:8080/api/users/user-account-details')
          .then(res => {
            const user = res.data;
            this.setState({ user });
          })
      }

    render() {
        return (
            <div>
                 <h5>Your Details</h5>
                 <div className="recipe-name">{this.state.user.email}</div>
                 {console.log(this.state.user)}
            </div>
        )
    }
}