import React from 'react';
import './nav.css';
import Nav from './nav';
import food2 from './food3.jpg';
import SearchBar from './search';

export default function searchingredient() {
    return (
<div className= "ingredient-container" style={{ backgroundImage: `url(${food2})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>




            <div>
                <Nav/> 
                <SearchBar/>
            </div>
</div>
    )
}
