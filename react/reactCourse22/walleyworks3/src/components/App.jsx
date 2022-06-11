import React from 'react';

import Header from './Header.jsx'
import Hero from './Hero.jsx'
import MainContent from './MainContent.jsx'
import Card from './Card.jsx'
import Footer from './Footer.jsx'
import dataLogo from "../img/wwCirLogo.png";

export default function App() {
    return(
        <div className="container">
        <Header />
        <Hero />
        <MainContent />
        <Card img={dataLogo}
              rating={4.8}
              reviewCount={61}
              country={'US'}
              title={'Felting Lessons with Ra'}
              price={125}
        />
        <Footer />
        </div>
    )
}