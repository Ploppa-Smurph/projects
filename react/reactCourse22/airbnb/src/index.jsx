import React from 'react';
import ReactDOM from 'react-dom'
import "./style.css";  // must import style.css in order for CSS to work
import Header from "./components/Header.jsx";
import Gallery from "./components/Gallery.jsx";
import MainContent from "./components/MainContent.jsx";
import Data from "./components/Data.jsx";
import Footer from "./components/Footer.jsx";

function App() {
    return(
    <div className="container"> 
        <Header />
        <Gallery />
        <MainContent />
        <Data />
        <Footer />
    </div>
    )
}

ReactDOM.render(<App />, document.getElementById("root"))