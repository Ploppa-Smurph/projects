// import ReactDOM from 'react-dom' each time

import React from 'react';
import ReactDOM from 'react-dom'
import "./style.css";  // must import style.css in order for CSS to work
import Header from "./components/Header.jsx";
import MainContent from "./components/MainContent.jsx";
import Footer from "./components/Footer.jsx";

function App() {
    return(
    <div className="container"> 
        <Header />
        <MainContent />
        <Footer />
    </div>
    )
}
   
//-- creates JSON objects -- not working HTML
//document.getElementById("root").append(JSON.stringify(page)) 

ReactDOM.render(<App />, document.getElementById("root"))
