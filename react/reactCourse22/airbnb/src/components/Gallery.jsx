import React from "react";
import galLogo from "../img/wwCirLogo.png"

export default function Gallery() {
    return (
        <div className="gallery-container">
        <img src={galLogo} alt="Gallery" className="gallery-img" />
        </div>
    )
}