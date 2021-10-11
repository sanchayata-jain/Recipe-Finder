import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food3 from '../Resources/food4.jpg';
import SearchBarFind from '../Components/findsearchbar';

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