import React from "react";

export default function Joke(props) {
    return (
        <div className="joke-container">
            <div class="joke">
                {/* if 'props.question' is a 'truthy value' (true) - then render the content to the right */}
                {props.question && <h3>{props.question}</h3>}
                {/* if 'props.answer' is a 'truthy value' (true) - then render the content to the right */}
                {props.answer && <p><i>{props.answer}</i></p>}
                <hr />
            </div>
        </div>
    )
}