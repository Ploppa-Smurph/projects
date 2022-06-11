import React from "react";

export default function Joke(props) {
    console.log(props.isBarJoke)
    console.log(props.upvotes)
    console.log(props.downvotes)
    console.log(props.comments)
    console.log(props.comments.title) // showing up as 'undefined'
    return (
        <div className="joke-container">
            <div className="joke">
                {/* if 'props.question' is a 'truthy value' (true) - then render the content to the right */}
                {props.question && <h3>{props.question}</h3>}
                {/* if 'props.answer' is a 'truthy value' (true) - then render the content to the right */}
                {props.answer && <p><i>{props.answer}</i></p>}
                <hr />
            </div>
        </div>
    )
}