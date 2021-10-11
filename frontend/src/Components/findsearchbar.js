import React from 'react';
import './findsearchbar.css';




const SearchBarFind = () => (
    

    <div className = "FindRecipes"> 
    <h1>Find Recipes</h1>
    <form action="/" method="get">
        <label htmlFor="header-search">
            <span className="visually-hidden">Find Recipes</span>
        </label>
       
        <input
            type="text"
            id="header-search"
            placeholder="What do you fancy?"
            name="s" 
        />
       
        <button type="submit">Search</button>

    </form>
    </div>
    
);



export default SearchBarFind;