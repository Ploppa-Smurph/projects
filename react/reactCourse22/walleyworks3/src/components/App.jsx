import React from 'react';

import Header from './Header.jsx'
import Hero from './Hero.jsx'
import MainContent from './MainContent.jsx'
import Card from './Card.jsx'
import Footer from './Footer.jsx'
/* import dataLogo from "../img/wwCirLogo.png; */

export default function App() {
    return(
        <div className="container">
        <Header />
        <Hero />
        <MainContent />
        <Card img="https://picsum.photos/id/124/250/400"
              rating={4.8}
              reviewCount={61}
              country={'US'}
              title={'Fishing Lessons with Ra'}
              price={125}
        />
        <Card img="https://picsum.photos/id/23/250/400"
              rating={3.8}
              reviewCount={1861}
              country={'US'}
              title={'Learning the Shiv'}
              price={14.50}
        />
        <Card img="https://picsum.photos/id/590/250/400"
              rating={5.0}
              reviewCount={60956}
              country={'France'}
              title={'A Hug from Grand-Mere'}
              price={750}
        />
        <Card img="https://picsum.photos/id/284/250/400"
              rating={0.76}
              reviewCount={904}
              country={'US'}
              title={'I use my tounge to clean your teeth'}
              price={'FREE'}
        />
        <Footer />
        </div>
    )
}