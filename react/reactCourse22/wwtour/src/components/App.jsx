import React from 'react';
import Header from './Header.jsx'
import Card from './Card.jsx'
import data from './data.js'
import Footer from './Footer.jsx'

export default function App() {
  /* map over travel data containers */
  const card = data.map(item => {
    return(
      <Card
        key={item.id}
        item={item}
      />  
    )
  })
  console.log(card)
  return (
    <div className="app-container">
      <Header />
    <section className="card-list">
      {card}
    </section>  
    <Footer />
    </div>
  )
}