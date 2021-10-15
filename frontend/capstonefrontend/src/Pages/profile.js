import Useraccount from "../Containers/useraccountcontainer";
import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';

export default function Profile() {
    return (
        // <div className= "ingredient-container" style={{ backgroundImage: `url(${food4})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>
        // </div>
        <div>  
            <Nav/>
            <h1>Your Details</h1>
            {/* <Useraccount/> */}
        </div>
        
    );
}
