
import React from 'react';
import './home.css';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food from '../Resources/food3.jpg';

   


export default function home() {
    return ( 
    

        <div className= "home-container" style={{ backgroundImage: `url(${food})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>

        <div className= "background">
            <div className = "left-section"> 
                <p>Executive Pick of the Week</p>
                <h1>Highlighted Reviews </h1>
                <h1>Random Recipes</h1>
            </div>
            <div className ="right-section">
                <h1>Most Popular Recipes of the Week</h1>
            </div>
        </div>
        
            <div>
                <Nav/> 
            </div>
        </div>
        
       
    )
}

        


//export default function home() {
//  return ()
//}