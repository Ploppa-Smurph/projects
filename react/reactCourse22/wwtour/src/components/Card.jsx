import React from 'react';

export default function Card(props) {
    return (
        <div className="data-card">
        <img src={props.item.img} className="data-img" alt="image of an amazing place" />    
        <p className="card-title">{props.item.title}</p>
        <p className="card-description">{props.item.description}</p>
        </div>
    ) 
}