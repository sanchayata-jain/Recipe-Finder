
import React from 'react';
import './home.css';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food from '../Resources/homepageBackground.jpeg';
import AboutUsBanner from '../Resources/AboutUsBanner.png'
import { AboutUsCard } from '../Components/cards';

export default function AboutUs() {
    return ( 
    
        <div className = "overlay">
            {/* <div className= "home-container" style={{ backgroundImage: `url(${food})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>
            </div> */}
            {/* <div className= "background">
                <div className = "middle-section"> 
                    <h1>About Us</h1>
                </div>
            </div> */}
            
    
                <AboutUsCard imageSrc={AboutUsBanner} title1={"About Us"}/>
                <div className = "middle-section"> 
                    <h1>About Us</h1>
                </div>
                {/* <FindFlightsCard title="Explore Destinations" text="Destination" buttonText="Search" />
                <Card2 imageSrc={TravelMap2} title1={"Discover your Dream Destination"} title2={"with Cipher Airlines"}/> */}
    
  
            
                <div>
                    <Nav/> 
                </div>
            
        </div>
        
       
    )
}