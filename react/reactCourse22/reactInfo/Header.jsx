// must import React in order for JSX to work
//import React from 'react';

export default function Header() {
    return (
    <header>
    <nav className="navbar">
    <div className="nav-logo">
    <img src="s&sf_logo.png"/>
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
