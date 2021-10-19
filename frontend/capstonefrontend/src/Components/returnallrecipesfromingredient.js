// import RecipesByIngredient from './RecipesByIngredient.js';


// // const ReturnAllRecipesFromIngredient = (props) => {

// //     const recipesByIngredient = props.recipesFromIngredient;
// //     const listRecipes = recipesByIngredient.map((recipe) =>
// //         <RecipesByIngredientsList recipesInfo={recipesByIngredient} number={recipesByIngredient.indexOf(recipesByIngredient)} viewAll={props.viewAll}/>
// //     );

// //     return(
// //         <div>
// //             {listRecipes}
// //         </div>
// //     )
// // }

// const ReturnAllRecipesFromIngredient = (props) => {
//     let recipeComponents = [];

//     for(let i=0; i<props.recipesFromIngredient.length; i++) {
//         let recipe = props.recipesFromIngredient[i];
//         let recipeComponent = <RecipesByIngredient key={recipe.value1} recipe={recipe} />
//         recipeComponents.push(recipeComponent);
//     }

//     return (
//         <div className="recipeComponent">
//             {recipeComponents}
//         </div>
//     )
// }

// export default ReturnAllRecipesFromIngredient