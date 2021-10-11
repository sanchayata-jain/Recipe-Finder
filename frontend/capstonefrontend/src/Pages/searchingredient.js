import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food2 from '../Resources/food3.jpg';
import SearchBar from '../Components/search';

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
