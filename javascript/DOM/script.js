// Ep01 -- module intro
// onload.onload=alert("body loaded");

document.querySelector("h1").innerHTML = "DOM / Document Object Model ep01"
document.querySelector("h2").innerHTML = "WALLEY WORKS & London App Brewery Present";

// Ep02 intro to DOM -- 
console.log(document); // returns the entire HTML file that we currently have
console.log(document.firstElementChild); //this will return all content within the HTML
console.log(document.firstElementChild.firstElementChild); // the first element child returns the 'Head'
console.log(document.firstElementChild.lastElementChild); // returns the 'Body' in this example
console.log(document.firstElementChild.lastElementChild.firstElementChild.firstElementChild.firstElementChild) // returns the 'H1' 

// we can now manipulate the H1 code by 
let heading = document.firstElementChild.lastElementChild.firstElementChild.firstElementChild.firstElementChild 
heading.innerHTML = "DOMmmmmmmmity DOM Lessons"

// there are other ways we can manipulate our object
heading.style.color = 'blue'; // changes h1 color to blue

// lets choose the input using the querySelector
document.querySelector("input").click(); // .click() simulates a mouseclick on an input

/* Ep03 Selecting HTML Elements */