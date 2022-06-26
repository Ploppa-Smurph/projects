// must import React in order for JSX to work
import React from 'react';

export default function Header() {
    return (
    <header className="header">
    
    <div className="logo-container">
    <img src={"./img/wwCat_nobg.png"} alt="Walley Works Logo" className="nav-logo" />
  </div>
        {/* <div className="nav-title">
        <h1>WALLEY WORKS</h1>
        <p>IT & WEB DESIGN</p>
       
   </div> */}
    </header>
    )
}
