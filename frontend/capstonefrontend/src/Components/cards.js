import './cards.css'
import React from 'react'


function SignUpCard(props) {
    return (
        <div className="card" styles="width: 18rem;">
            {/* <img src={props.imageSrc} className="card-img-top" alt="Hongkong city skyline in the evening" /> */}
            <div className ="card-body">
                <p className ="card-title">{props.form} </p>
            </div>
        </div>
    )
}



export {
    SignUpCard
}