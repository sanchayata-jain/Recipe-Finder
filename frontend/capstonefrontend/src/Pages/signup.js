import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food4 from '../Resources/tan.jpg';
import Signupcontainer from '../Containers/Signupcontainer';
import Logincontainer from '../Containers/Logincontainer';



export default function signup() {
    return (
        <div className= "ingredient-container" style={{ backgroundImage: `url(${food4})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>
            <div>  
                <Nav/>
               <Signupcontainer/>
               <Logincontainer/>
            </div>
        </div>
    );
}




