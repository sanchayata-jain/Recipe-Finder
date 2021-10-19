// import React from 'react';
// import {useLocation} from 'react-router-dom';
// import axios from 'axios';


// class Recipes extends React.Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             // recipe: ''
//         }
//     } 
      
//     componentDidMount(props) {
//         // this.getRecipeInfo();
//         <button onClick={()=>this.click}>onClick</button>
        
//         // <h1>this.props.location.state.recipe</h1>
//     }

//     click() {
//         console.log("hi");
//     }

 
      
//     // getRecipeInfo() {
//     //     const pathname = window.location.pathname;
//     //     axios.get(`http://localhost:8080/recipes/${pathname}`)
//     //       .then(res => {
//     //         const recipeInfo = res.data;
//     //         this.setState({ recipeInfo });
//     //         console.log(res.data);
//     //       })
//     // }


//     render() {
//         return (
//             <>
//                 <h1>Recipes</h1>
//             </>
//         )
        
//     }


// }


import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food3 from '../Resources/food4.jpg';
import SearchBarFind from '../Components/findsearchbar';

export default function Recipes() {
    return (
<div className= "ingredient-container" style={{ backgroundImage: `url(${food3})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>



            <div>
                <Nav/> 
                <SearchBarFind/>
            </div>
</div>
    )
}
