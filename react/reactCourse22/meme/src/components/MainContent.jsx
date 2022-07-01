import React from 'react';

export default function MainContent() {
    return (
        <div className="maincontent-container">
            <h1>Walley Works/Bob Ziroll: the Meme Slinger</h1>
            <form className="meme-form">
            <input className="meme-text" type="text" placeholder="Enter Top Text" />
            <input className="meme-text" type="text" placeholder="Enter Bottom Text" />
            <button className="meme-button">Sling NEW Meme Image<i class="fa-solid fa-image"></i></button>
            </form>
            <img className="meme-image" src={"#"} alt="Meme Template" />            
        </div>
    )
}