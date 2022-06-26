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
                        img={item.img}
                        rating={item.stats.rating}
                        reviewCount={item.stats.reviewCount}
                        location={item.location}
                        title={item.title}
                        price={item.price}
                        description={item.description}
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