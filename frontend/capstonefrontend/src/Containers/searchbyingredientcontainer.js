import React from 'react';
import axios from 'axios';
import '../Components/findsearchbar.css';


class SearchByIngredientContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
          recipes: [],
          ingredient: '',
          redirect: false,
          recipe: ''
        }
    
        this.getRecipes = this.getRecipes.bind(this);
        
        // this.renderRecipe = this.renderRecipe.bind(this);
        // this.gotoRecipe = this.gotoRecipe.bind(this);
    } 
      
    componentDidMount() {
        this.getRecipes();
    }
      
    getRecipes() {
        axios.get('http://localhost:8080/recipe-ingredients/get-recipes-by-ingredient', {params: {ingredientName1: this.state.ingredient} })
          .then(res => {
            const recipes = res.data;
            this.setState({ recipes });
          })
          console.log(this.state);
    }


    handleChange=(e) =>{
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    handleSubmit=(e) =>{
        this.componentDidMount();
        e.preventDefault();
    }

    gotoRecipe = (index) => {
        this.setState ({
            redirect: true,
            recipe: this.state.recipes[index]
            
        })
    }

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
                <div>
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

                        <div>
                            {recipes.map((r, index) =>
                                <span key={r}>
                                    <div className="found-recipe">
                                        {/* {this.renderRecipe()} */}
                                        {/* <div onClick={() => this.gotoRecipe(index)}> */}
                                        {/* <strong><font color="#f4f4f4">{r}</font></strong> */}
                                        {/* </div> */}
                                        {recipes.map(recipe => <li key = {1}>{recipe.value0}</li>)}
                                        {recipes.map(recipe => <li key = {2}>{recipe.value1}</li>)}
                                        {recipes.map(recipe => <li key = {3}>{recipe.value2}</li>)}
                                        {recipes.map(recipe => <li key = {4}>{recipe.value3}</li>)}
                                    </div>
                               
                                </span>)
                            }
                        </div>
                    </div>
                    
                </div>
            );

        }
        

    }
            
            


export default SearchByIngredientContainer

                

