import React from "react";

export default function Card(props) {
    let badgeText
    if (props.openSpots === 0) {
            badgeText = "SOLD OUT"
    } else if (props.location === "Online") {
        badgeText = "Online"
    }
    
    return (
    <div className="data-card">
        {badgeText && <div className="card-badge">{badgeText}</div>}
            <img src= {props.item.img} alt="Images of Fun Things" className="data-img" />
            <div className="data-stats">
            <i class="fa-solid fa-star"></i>
            <span>{props.item.stats.rating}&nbsp;</span>
            <span className="text-muted">({props.item.stats.reviewCount})&nbsp;</span>
            <span className="text-muted">&#8226;{props.item.country}</span>
        </div>
            <p className="card-title">{props.item.title}</p>
            <p className="card-price"><span className="bold">From ${props.item.price}&nbsp;</span>/ person</p>
            <p className="card-description">{props.item.description}</p>
    </div>
    )
}