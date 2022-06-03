

const page = (
    <div>
        <h1>react project starter</h1>
        <p>this is a test</p>
        <ol>
            <li>react is composable</li>
            <li>react is declarative</li>
            <li>react is a hireable skill</li>
            <li>react is actively maintained</li>
        </ol>
    </div>
)

document.getElementById("root").append(JSON.stringify(page))

//ReactDOM.render(page, document.getElementById("root"))