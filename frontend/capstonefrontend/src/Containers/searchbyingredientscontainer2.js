// import { useHistory } from "react-router";
// import axios from "axios";
// import React, {useState} from "react";
// import useForm from "react-hook-form";

// export default function GetRecipeFromIngredients(props) {
//     const {register, handleSubmit, errors} = useForm()
//     const [recipes, setRecipes] = React.useState([])
//     const [state, setState] = React.useState({
//         ingredient : ""
//     })

//     React.useEffect(() => {
//       axios.get('http://localhost:8080/recipe-ingredients/get-recipe-names', {params: {ingredientName1: state.ingredient} }).then((response) =>{
//           setRecipes(response.data)
//       });
//     }, []);

//     if(!recipes) {
//         return null;
//     }

//     // const handleChange=(e) =>{
//     //     // this.setState({
//     //     //     [e.target.name]: e.target.value
//     //     // })

//     //     // const {id, value} = e.target.value
//     //     // setState(prevState => ({
//     //     //     ...prevState,
//     //     //     [id] : value
//     //     // }))

//     //     let name = e.target.name;
//     //     let value = e.target.value;

//     // }

//     // const handleSubmit=(e) => {
//     //     e.preventDefault();
        
//     // }

//     const onSubmit = (data) => {
//         console.log(data)
//     }


//     return (
//         <>
//             <div className = "Search"> 
//                 <h1>Search By Ingredient</h1>
//                 <form onSubmit={handleSubmit(onSubmit)}>
//                     <label htmlFor="header-search">
//                         <span className="visually-hidden">Search Ingredient</span>
//                     <input
//                         type="text"
//                         value={state.ingredient}
//                         // onChange={handleChange}
//                         id="header-search"
//                         placeholder="Enter Ingredient"
//                         name="ingredient" 
//                         ref = {register}
//                     />
//                     </label>
//                     <button type="submit" value="Submit">Search</button>
//                 </form>
//             </div>

//             {recipes.map((recipe, index) => 
//                                            <a href="/recipes" ><div key={recipe.id}> {recipe}</div><br></br></a>
//                                             )}
//         </>
//     )
            

// }


import React, {useState} from 'react';
import axios from "axios";

export default function GetRecipeFromIngredients(props) {
	
	const [values, setValues] = React.useState({
		ingredient : ""
	}); 
	
	const [submitted, setSubmitted] = React.useState(false);
    const [recipes, setRecipes] = React.useState([]);

        React.useEffect(() => {
        axios.get('http://localhost:8080/recipe-ingredients/get-recipe-names', {params: {ingredientName1: recipes} })
        .then((res) =>{
             setRecipes(res.data)
      });
    });

    if(!recipes) {
        return null;
    }
	
	const handleChange = (event) => {
		setValues({...values, ingredient: event.target.value})
	}
	
	const handleSubmit = (event) => {
		event.preventDefault();
		console.log(recipes); 
		
	}
	
	 return (
        <>
            <div className = "Search"> 
                <h1>Search By Ingredient</h1>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="header-search">
                        <span className="visually-hidden">Search Ingredient</span>
                    <input
                        type="text"
                        value={values.ingredient}
                        onChange={handleChange}
                        id="header-search"
                        placeholder="Enter Ingredient"
                        name="ingredient" 
                    />
                    </label>
                    <button type="submit" value="Submit">Search</button>
                </form>
            </div>

            {recipes.map((recipe, index) => 
                                           <a href="/recipes" ><div key={recipe}> {recipe}</div><br></br></a>
                                            )}
        </>
    )
}