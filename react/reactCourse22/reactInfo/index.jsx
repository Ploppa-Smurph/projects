
const nav = (
    <nav>
    <a href="https://flyclipart.com/react-logo-import-io-react-logo-png-221727" title="React Logo Import Io - React Logo PNG"><img src="https://flyclipart.com/thumb2/react-logo-import-io-221727.png" width="350" /></a>
        <h1>Shrimp & Snail Friends</h1>
        <p>your place for shrimp & snails friends</p>
        <ul>
            <li>About</li>
            <li>Blog</li>
            <li>Merchandise</li>
            <li>Contact</li>
        </ul>
    </nav>
)
//-- creates JSON objects -- not working HTML
//document.getElementById("root").append(JSON.stringify(page)) 

ReactDOM.render(nav, document.getElementById("root"))