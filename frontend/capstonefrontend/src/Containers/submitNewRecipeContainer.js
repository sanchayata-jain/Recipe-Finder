import React from 'react';
import axios from 'axios';

export default class SubmitNewRecipeContainer extends React.Component {
    
    constructor(props) {
        super(props);
        
        this.state = {
            name: '',
            description: '',
            difficulty: '' //enum
        }

        this.setRecipe = this.getRecipes.bind(this);
    }
    
    handleNameChange = event => {
        this.setState({name: event.target.value});
    }

    handleDescriptionChange = event => {
        this.setState({description: event.target.value});
    }

    handleDifficultyChange = event => {
        this.setState({difficulty: event.target.value});
    }

    handleSubmit = event => {
        event.preventDefault();

        const newRecipe = {
            name: this.state.name,
            description: this.state.description,
            difficulty: this.state.difficulty
        };

        axios.post('http://localhost:8080/recipes/add-recipe', {params: {recipeName: this.state.name, recipeDescription: this.state.description, difficulty: this.state.difficulty}})
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    Recipe Name: 
                    <input type="text" name="name" onChange = {this.handleNameChange}/>
                    Recipe Description: 
                    <input type="text" name="name" onChange = {this.handleDescriptionChange}/>
                    Recipe Difficulty Level: 
                    <input type="text" name="name" onChange = {this.handleDifficultyChange}/>
                </label>
                <button type = "submit">Add Recipe</button>
            </form>
        )
    }
}