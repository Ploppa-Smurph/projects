// normally you must import ReactDOM from 'react-dom' each time, but i'm using the cdn currently and don't have to
/* import React from 'react';
import ReactDOM from 'react-dom'; */


function Header() {
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

function MainContent() {
    return (
    <body>
        <h1>Shrimp & Snail and Friends</h1>
    </body>
        )
    }

function Footer() {
    return (
    <footer className="footer">
        <p className="indicia">&copy; 2022 Shrimp & Snail Friends / Walley Works. All rights reserved.</p>
    </footer>
        )
    }

function Page() {
    return(
    <div>
        <Header />
        <MainContent />
        <Footer />
    </div>
    )}
    
//-- creates JSON objects -- not working HTML
//document.getElementById("root").append(JSON.stringify(page)) 

ReactDOM.render(<Page />, document.getElementById("root"))
