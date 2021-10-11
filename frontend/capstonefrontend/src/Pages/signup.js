import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food4 from '../Resources/food5.jpg';

export default function signup() {
    return (
<div className= "ingredient-container" style={{ backgroundImage: `url(${food4})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>



            <div>
                <Nav/> 
            </div>
</div>


    )
}