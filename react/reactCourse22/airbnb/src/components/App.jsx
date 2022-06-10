import React from 'react';

//import "../src/style.css";  // must import style.css in order for CSS to work
import Header from "./Header.jsx";
import Gallery from "./Gallery.jsx";
import MainContent from "./MainContent.jsx";
import Data from "./Data.jsx";
import Contact from "./Contact.jsx"
import Footer from "./Footer.jsx";
// lame that I have to import all images even for these cards
import CatLogo from "../img/wwCat.png"
import CatLight from "../img/wwCatLight.png"
import CirLogo from "../img/wwCirLogo.png"
import WWLogo from "../img/wwLogo.png"

export default function App() {
    return(
    <div className="container"> 
        <Header />
        <Gallery />
        <MainContent />
        <Data />
        <Contact img= {CatLogo}
                  name="Mr. Whiskerson" 
                  phone="(225)921 0945" 
                  email="whiskey@catface.com" />
        <Contact img= {CatLight}
                  name="Swampi"
                  phone="(555)555-5555"
                  email="swamriver@catface.com" />
        <Contact img= {CirLogo}
                  name="Gus"
                  phone="(555)555-5555"
                  email="freindofthedevil@catface.com" />
        <Contact img= {WWLogo}
                  name="Trelvyn"
                  phone="(555)555-5555"
                  email="masterclassT@catface.com" />
        
        <Footer />
    </div>
    )
}
