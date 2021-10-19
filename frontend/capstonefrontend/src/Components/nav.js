import React from 'react';
import './nav.css'; 
import { Link } from "react-router-dom";



export default function Nav() {
    
    return ( 
        <div className = "navbar">
            <ul>
                <li><Link to = "./" >Home</Link> </li>
                <li><Link to = "./findrecipes">Find Recipes</Link> </li>
                <li><Link to ="./searchingredient">Search By Ingredient</Link> </li>
                <li><Link to ="./signup">Sign Up</Link> </li>
                <li><Link to ="./aboutus">About Us</Link> </li>
            </ul>
        </div>    
    )
}



