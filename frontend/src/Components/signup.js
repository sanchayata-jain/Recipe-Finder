import React from 'react';
import './nav.css';
import Nav from './nav';
import food4 from './food5.jpg';

export default function signup() {
    return (
<div className= "ingredient-container" style={{ backgroundImage: `url(${food4})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>



            <div>
                <Nav/> 
            </div>
</div>


    )
}