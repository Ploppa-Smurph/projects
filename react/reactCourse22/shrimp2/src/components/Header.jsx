// must import React in order for JSX to work
import React from 'react';
import shrimpLogo from "../img/s&sf_logo.png";

export default function Header() {
    return (
    <header>
    <nav className="navbar">
    <div className="nav-logo">
    <img src={shrimpLogo} alt="Shrimp & Snail Friends" className="img-logo" />
    </div>
    <div className="nav-title">
        <h1>Shrimp & Snail Friends</h1>
        <p>Your place for Shrimp & Snail friends</p>
    </div>    
    <div className="nav-links">
        <ul className="nav-list">
            <li>About</li>
            <li>Blog</li>
            <li>Merchandise</li>
            <li>Contact</li>
        </ul>
    </div>    
   
    </nav>
    </header>
    )
}
