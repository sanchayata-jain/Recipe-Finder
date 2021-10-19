import React from 'react';
import axios from 'axios';
import '../Components/findsearchbar.css';
import './searchbyingredientcontainer.css'

class SearchByIngredientContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          recipes: [],
          ingredient: '',
          redirect: false,
        }
    
        this.getRecipes = this.getRecipes.bind(this);
    } 

      
    componentDidMount() {
        this.getRecipes();
        
    }


    getRecipes() {
        axios.get('http://localhost:8080/recipe-ingredients/get-recipes-by-ingredient', {params: {ingredientName1: this.state.ingredient}})
        .then(res => {
            const recipes = res.data;
            this.setState({recipes});
        })
    }


    handleChange=(e) => {
        this.setState({
            [e.target.name]: e.target.value
            
        })
    }


    handleSubmit=(e) => {
        this.componentDidMount();
        e.preventDefault();
    }


    // gotoRecipe = (index) => {
    //     this.setState ({
    //         redirect: true,
    //         recipe: this.state.recipes[index]
            
    //     })
    // }

    // renderRecipe = () => {
    //     if (this.state.redirect) {
            
            
    //         return (<Redirect to={{
    //                                 pathname:`/recipes`,
    //                                 state: {recipe: this.state.select}
    //                             }} />)
    //     }
    // }

  

    render() {
        const{recipes, ingredient} = this.state;
            return (
                <>
                    <div className = "Search"> 
                        <h1>Search By Ingredient</h1>
                        <form onSubmit={this.handleSubmit}>
                            <label htmlFor="header-search">
                                <span className="visually-hidden">Search Ingredient</span>
                            </label>
                        
                            <input
                                type="text"
                                value={ingredient}
                                onChange={this.handleChange}
                                id="header-search"
                                placeholder="Enter Ingredient"
                                name="ingredient" 
                            />
                            <button type="submit" value="Submit">Search</button>
                        </form>
                    </div>
                    <div className="recipe-result">
                        <div className="recipe-title">{recipes.map(recipe => <h2 key = {1}>{recipe.value0}</h2>)}</div>
                        <div className="recipe-author">{recipes.map(recipe => <li key = {3}>by {recipe.value2}</li>)}</div>
                        <div className="recipe-difficulty">{recipes.map(recipe => <li key = {4}>{recipe.value3}</li>)}</div>
                        <div className="recipe-description">{recipes.map(recipe => <pre key = {2}>{recipe.value1}</pre>)}</div>
                    </div>
                </>
            )
    }
}
        

    

export default SearchByIngredientContainer

                

