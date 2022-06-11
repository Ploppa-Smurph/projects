// must import React in order for JSX to work
import React from 'react';
import wwLogo from "../img/wwCat_nobg.png";

export default function Header() {
    return (
    <header className="header">
    
    <div className="logo-container">
    <img src={wwLogo} alt="Walley Works Logo" className="nav-logo" />
  </div>
        {/* <div className="nav-title">
        <h1>WALLEY WORKS</h1>
        <p>IT & WEB DESIGN</p>
       
   </div> */}
    </header>
    )
}
