import React from 'react'
// import './Card.css'

function Card(props) {
    return (
        <div className="card flip-card" styles="width: 18rem;">
            <div className="flip-card-inner">
                <div className ="card-body flip-card-front">
                {/* <img src={props.imageSrc} className="card-img-top" alt="..." /> */}
                    <h5 className ="card-title">{props.title}</h5>
                    <p className ="card-text">{props.text}</p>
                    <p className ="card-deadline"> {props.deadline}</p>
                </div>
                <div className="card-body flip-card-back">
                    <p className="card-description">{props.description}</p>
                </div>
            </div>
        </div>
    )
}

export default Card
