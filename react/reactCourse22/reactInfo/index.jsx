// normally you must import ReactDOM from 'react-dom' each time, but i'm using the cdn currently and don't have to
/* import React from 'react';
import ReactDOM from 'react-dom'; */

function Header() {
    return(
        <div>
    <header>
    <nav className="navbar">
    
    <div className="nav-row">
    <div className="nav-col">
    <img className="nav-logo" src="s&sf_logo.png"/>
    </div>
    <div className="nav-col">
        <h1>Shrimp & Snail Friends</h1>
        <p>Your place for Shrimp & Snail friends</p>
        </div>
        <div className="nav-col">
                <ul className="nav-list">
            <li className="nav-item">About</li>
            <li className="nav-item">Blog</li>
            <li className="nav-item">Merchandise</li>
            <li className="nav-item">Contact</li>
        </ul>
        </div>
       </div>
    </nav>
    </header>
    <body>
        <h1>Shrimp & Snail Friends Live Here</h1>
    </body>
    <footer>
        <p>&copy; 2022 Shrimp & Snail Friends / Walley Works. All rights reserved.</p>
    </footer>
    </div>
    )}
//-- creates JSON objects -- not working HTML
//document.getElementById("root").append(JSON.stringify(page)) 

ReactDOM.render(<Header />, document.getElementById("root"))