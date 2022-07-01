import React from 'react';

export default function MainContent() {
    return (
        <div className="maincontent-container">
            <h1>Walley Works & Bob Ziroll present: the Meme Slinger</h1>
            <input className="top-meme-text" type="text" placeholder="Top Text" />
            <input className="bottom-meme-text" type="text" placeholder="Bottom Text" />
            <div className="meme-img-container">
            <h3 className="meme-title">Sling A New Image</h3>
            <img className="meme-image" src={"#"} alt="Meme Template" />
            </div>
            <button className="meme-button">Save My Sling</button>
        </div>
    )
}