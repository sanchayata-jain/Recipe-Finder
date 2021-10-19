import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food2 from '../Resources/searchingIngredient.jpeg';
import SearchByIngredientContainer from '../Containers/searchbyingredientcontainer';

export default function searchingredient() {
    return (
<div> 
    <div className= "ingredient-container" style={{ backgroundImage: `url(${food2})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}/>
    <div>
        <Nav/> 
        {/* <SearchBar/>  */}
        <SearchByIngredientContainer />
    </div>
</div>
    )
}


// className= "ingredient-container" style={{ backgroundImage: `url(${food2})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>
