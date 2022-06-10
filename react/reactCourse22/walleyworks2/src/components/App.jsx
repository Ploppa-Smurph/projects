import React from 'react'
import Header from './Header.jsx'
import MainContent from './MainContent.jsx'
import Joke from './Joke.jsx'
import Footer from './Footer.jsx'

export default function App() {
  return (
    <div className="container">
      <Header />
      <MainContent />
      <Joke question="Why don’t pirates take a shower before they walk the plank?"
            answer="They just wash up on shore."/>
      <Joke question="A grasshopper walks into a bar. The bartender looks at him and says, “Hey, they named a drink after you!”"
            answer="“Really?” replies the grasshopper. “There’s a drink named Stan?”"/>
      <Joke question="A man went into a seafood restaurant and asked for a lobster tail. The waitress smiled sweetly and said, “Once upon a time there was this handsome lobster…”"
            answer=""/>
      <Joke question="Two eggs, a bagel, and a sausage walk into a bar. “Bartender, my friends and I would like a cold one,” says one of the eggs."
            answer="“Sorry,” the barman replies. “We don’t serve breakfast.”"/>
      <Joke question="At our weekly alumni meetings, the football coach shows the film of the most recent game and holds a question-and-answer period afterward. One of the alumni, who had played on the football team many years ago and had a son on this year’s squad, posed a question concerning the defensive line. “I’d like to know,” he said, “why our boys are so slow getting into the opposition’s backfield after the ball is snapped.”"
            answer="“I’m not sure, Fred,” answered the coach. “But it could be hereditary.”"/>
      <Footer />
    </div>
  )
}
