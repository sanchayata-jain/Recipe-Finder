import React from 'react';
import axios from 'axios';

export default class Findrecipecontainer extends React.Component {
    
    constructor(props) {
        super(props);
        
        this.state = {
            recipes: []
        }

        this.getRecipe = this.getRecipes.bind(this);
    }
    

    componentDidMount() {
        this.getRecipes();
        
    }

    getRecipes() {
        axios.get('http://localhost:8080/recipes/Tiramisu').then(res => {
            const recipes = res.data;    
            console.log(res);
            this.setState({ recipes });
        });
    }

    render() {
        return (
            <div>
                    {this.state.recipes.map(recipe => <li key = {recipe.value0}>{recipe.value0}</li>)}
                    {this.state.recipes.map(recipe => <li key = {recipe.value1}>{recipe.value1}</li>)}
            </div>
        )
    }
}