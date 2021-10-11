import React from 'react';
import './search.css';




const SearchBar = () => (
    

    <div className = "Search"> 
    <h1>Search By Ingredient</h1>
    <form action="/" method="get">
        <label htmlFor="header-search">
            <span className="visually-hidden">Search Ingredient</span>
        </label>
       
        <input
            type="text"
            id="header-search"
            placeholder="Enter Ingredient"
            name="s" 
        />
       
        <button type="submit">Search</button>

    </form>
    </div>
    
);



export default SearchBar;