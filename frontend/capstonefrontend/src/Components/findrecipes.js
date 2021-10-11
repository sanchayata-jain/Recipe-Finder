import React from 'react';
import './nav.css';
import Nav from './nav';
import food3 from './food4.jpg';
import SearchBarFind from './findsearchbar';

export default function findrecipes() {
    return (
<div className= "ingredient-container" style={{ backgroundImage: `url(${food3})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>



            <div>
                <Nav/> 
                <SearchBarFind/>
            </div>
</div>
    )
}