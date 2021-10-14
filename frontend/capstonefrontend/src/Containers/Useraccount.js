import React, { Component } from 'react'
import Logincontainer from './Logincontainer';

export default class Useraccount extends Component {
    constructor(props) {
        super(props);
        this.state = {
          user: []
    
        }
    
        this.getUsers = this.getUsers.bind(this);
      }
      
      componentDidMount() {
        this.getUsers();
      }
      
      getUsers(){
        axios.get(`http://localhost:8081/api/users/user-account-details`)
          .then(res => {
            const users = res.data;
            this.setState({ users });
          })
      }

    render() {
        return (
            <div>
                <Logincontainer getUsers={this.getUsers}/>
            </div>
        )
    }
}
