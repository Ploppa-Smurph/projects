import React from "react";

export default function Card(props) {
    //console.log(props)
    return (
    <div className="data-card">
            <img src= {props.img} alt="Images of Fun Things" className="data-img" />
            <div className="data-stats">
            <i class="fa-solid fa-star"></i>
            <span>{props.rating}&nbsp;</span>
            <span className="text-muted">({props.reviewCount})&nbsp;</span>
            <span className="text-muted">&#8226;{props.country}</span>
        </div>
            <p>{props.title}</p>
            <p><span className="bold">From ${props.price}&nbsp;</span>/ person</p>
    </div>
    )
}