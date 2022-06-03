// import React from 'react';
// import ReactDOM from 'react-dom';

// const h1 = document.createElement("h1")
/* h1.textContent = "Declarative programming with javascript"
h1.className = "header"
console.log(h1)

const element = <h1 className = "header">This is React with JSX</h1>
console.log(element) */

// using ReactDom to 'render' the component to the DOM -- it is placing this in the HTML 'id="root" / or #root'
// JSX is a syntax of JavaScript that allows us to write HTML-like code.
// ReactDOM.render(<h1 className = "header">This is React with JSX</h1>, document.getElementById("root"));

// can only render 1 parent element at a time in react, so you wrap multiple elements in a <div>
/* ReactDOM.render(
    <div>
        <h1 className = "header">This is an 'h1' wrapped in a 'div'</h1>
    <p>This is a 'p' in a 'div'</p>
</div>,
    document.getElementById("root")
) */


// here we create a varaiable that saves the JSX
const page = (
    <div>
        <h1 className = "header">This is an 'h1' wrapped in a 'div'</h1>
        <p>This is a 'p' in a 'div'</p>
    </div>
)

const navbar = (
    <nav>
        <h1 className = "brand">BrandSite</h1>
        <ul className = "nav-list">
            <li className = "nav-item">Pricing</li>
            <li className = "nav-item">About</li>
            <li className = "nav-item">Contact</li>
        </ul>
    </nav>
)

// we can call the entire JSX element, so we could create a navBar, a mainBody, contactUs, footer, etc. and call them on every page by calling the variable
ReactDOM.render(
    navbar,
    document.getElementById("root")
)



