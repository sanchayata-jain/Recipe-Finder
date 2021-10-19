import React from 'react';
import './home.css';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food from '../Resources/homepageBackground.jpeg';

   


export default function home() {
    return ( 
    
        <div className = "overlay">
            <div className= "home-container" style={{ backgroundImage: `url(${food})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>

            <div className= "background">
                <div className = "middle-section"> 
                    <h1>Cookbook</h1>
                </div>
                <div className="bottom-middle">
                    <p>Change your mood with food</p>
                </div>
            </div>
            
                <div>
                    <Nav/> 
                </div>
            </div>
        </div>
        
       
    )
}

        


//export default function home() {
//  return ()
//}