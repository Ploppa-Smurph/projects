import React from 'react';

import Header from './Header.jsx'
import Hero from './Hero.jsx'
import MainContent from './MainContent.jsx'
import Card from './Card.jsx'
import Footer from './Footer.jsx'
import data from './data.js';
/* import dataLogo from "../img/wwCirLogo.png; */

export default function App() {
      /* mapping over the data */
      const cards = data.map(item => {
            return (
            <Card      
               key={item.id}
               item={item}
            />      
            )
      })
    return(
        <div className="container">
        <Header />
        <Hero />
        <MainContent />
        <section className="cards-list">
            {cards}
        </section>
        <Footer />
        </div>
    )
}