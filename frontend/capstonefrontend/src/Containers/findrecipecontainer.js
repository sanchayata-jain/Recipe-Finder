import React from 'react';
import axios from 'axios';

export default class Findrecipecontainer extends React.Component {
    
    constructor(props) {
        super(props);

        this.state = {
            recipes: [],
            userInput: ''
        }

        this.getRecipe = this.getRecipes.bind(this);
    }
    

    componentDidMount() {
        this.getRecipes();
        
    }

    getRecipes() {
        axios.get(`http://localhost:8080/recipes/${this.state.userInput}`).then(res => {
            const recipes = res.data;    
            console.log(res);
            this.setState({ recipes });
        });
    }

    handleSubmit = (e) =>{
        this.componentDidMount();
        e.preventDefault();
    }

    handleChange=(e) =>{
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    render() {
        return (
            <>
            <div className = "FindRecipes"> 
            <h1>Find Recipes</h1>
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="header-search">
                    <span className="visually-hidden">Find Recipes</span>
                </label>
               
                <input
                    type="text"
                    value={this.state.userInput}
                    onChange = {this.handleChange}
                    id="header-search"
                    placeholder="What do you fancy?"
                    name="userInput" 
                />
               
                <button type="submit">Search</button>
        
            </form>
            </div>
            

            <div className = "Recipe Name">
                    {this.state.recipes.map(recipe => <li key = {recipe.value0}>{recipe.value0}</li>)}
            </div>
            <div className = "Recipe description">
                    {this.state.recipes.map(recipe => <li key = {recipe.value1}>{recipe.value1}</li>)}
            </div>
            </>
        )
    }
}