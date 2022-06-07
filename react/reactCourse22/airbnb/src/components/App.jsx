import React from 'react';

//import "../src/style.css";  // must import style.css in order for CSS to work
import Header from "./Header.jsx";
import Gallery from "./Gallery.jsx";
import MainContent from "./MainContent.jsx";
import Data from "./Data.jsx";
import Footer from "./Footer.jsx";

export default function App() {
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
