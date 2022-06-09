import React from "react";
import dataLogo from "../img/wwLogo.png";

export default function Data() {
    return (
    <div className="data-card">
            <img src={dataLogo} alt="Data" className="data-img" />
        <div className="data-stats">
            <i class="fa-solid fa-star"></i>
            <span>5.0</span>
            <span className="text-muted">(26) </span>
            <span className="text-muted">&nbsp;USA</span>
        </div>
            <p>Felting lessons with Ra</p>
            <p><span className="bold">From $125&nbsp;</span>/ person</p>
    </div>
    )
}