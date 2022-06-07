import React from "react";
import galLogo from "../img/wwCirLogo.png"
import galLogo2 from "../img/wwCatLight.png"
import galLogo3 from "../img/wwLogo.png"

export default function Gallery() {
    return (
        <section className="gallery-container">
        <div className="gallery-img">
        <img src={galLogo} alt="Gallery" className="gallery-img" />
        </div>
        <div className="gallery-img">
        <img src={galLogo2} alt="Gallery" className="gallery-img" />
        </div>
        <div className="gallery-img">
        <img src={galLogo3} alt="Gallery" className="gallery-img" />
        </div>
        </section>
    )
}