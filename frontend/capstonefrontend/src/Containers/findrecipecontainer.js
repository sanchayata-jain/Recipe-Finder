import React from 'react';
import axios from 'axios';
import '../Components/findsearchbar.css';
import './findrecipecontainer.css'

class Findrecipecontainer extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {
            recipes: [],
            userInput: '',
            redirect: false,
        }

        this.getRecipes = this.getRecipes.bind(this);
    }
    

    componentDidMount() {
        this.getRecipes();
        
    }


    getRecipes() {
            axios.get('http://localhost:8080/recipes/get-recipes', {params: {recipeName: this.state.userInput}})
            .then(res => {
                const recipes = res.data;    
                this.setState({ recipes });
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


    render() {
        const{recipes, userInput} = this.state;
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
                            value={userInput}
                            onChange={this.handleChange}
                            id="header-search"
                            placeholder="What do you fancy?"
                            name="userInput" 
                        />
                        <button type="submit" value="Submit">Search</button>
                    </form>
                </div>
                <div className="recipes">
                    <div className="recipe-name">{recipes.map(recipe => <li key={1}>{recipe.value0}</li>)}</div>
                    <div className="recipe-author">{recipes.map(recipe => <li key={3}>by {recipe.value2}</li>)}</div>
                    <div className="recipe-difficulty">{recipes.map(recipe => <li key={4}>{recipe.value3}</li>)}</div>
                    <div className="description">{recipes.map(recipe => <pre key={2}>{recipe.value1}</pre>)}</div>
                </div>
            </>
        )
    }
}

export default Findrecipecontainer