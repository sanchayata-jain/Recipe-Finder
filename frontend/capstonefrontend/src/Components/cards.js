import './cards.css'
import React from 'react'


function AboutUsCard(props) {
    return (
        <div className="card" styles="width: 18rem;">
            <img src={props.imageSrc} className="card-img-top" alt="food" />
            <div className ="card-body">
                <p className ="card-title">{props.form} </p>
            </div>
        </div>
    )
}



export {
   AboutUsCard
}