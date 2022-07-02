import React from 'react';
import memesData from "../memesData.js"

export default function MainContent() {

    function handleClick() {
        const memesArray = memesData.data.memes
        const randomNumber = Math.floor(Math.random() * memesArray.length)
        const url = memesArray[randomNumber].url
        console.log(url)
    }

    return (
        <div className="maincontent-container">
            <h1>Walley Works/Bob Ziroll: the Meme Slinger</h1>
            <div className="meme-form">
            <input className="meme-text" type="text" placeholder="Enter Top Text" />
            <input className="meme-text" type="text" placeholder="Enter Bottom Text" />
            <button onClick={handleClick} className="meme-button">Sling NEW Meme Image<i className="fa-solid fa-image"></i></button>
            </div>
            <img className="meme-image" src={"#"} alt="Meme Template" />            
        </div>
    )
}