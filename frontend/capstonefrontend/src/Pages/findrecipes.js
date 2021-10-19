import React from 'react';
import '../Components/nav.css';
import Nav from '../Components/nav';
import food3 from '../Resources/recipeBackground.jpeg';
// import SearchBarFind from '../Components/findsearchbar';
import Findrecipecontainer from '../Containers/findrecipecontainer';

export default function findrecipes() {
    return (
        <div> 
            <div className= "ingredient-container" style={{ backgroundImage: `url(${food3})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}/>
            <div>
                <Nav/> 
                {/* <SearchBar/>  */}
                <Findrecipecontainer />
            </div>
        </div>
            )
        }









    // return (
    //     <>
    //         <Findrecipecontainer/>
    //     </>




// <div className= "ingredient-container" style={{ backgroundImage: `url(${food3})`, backgroundSize: "cover", height:"100vh", backgroundPosition:"center"}}>



//             <div>
//                 {/* <Nav/>  */}
//                 {/* <SearchBarFind/> */}

//             </div>
            
// </div>
//     )
// }