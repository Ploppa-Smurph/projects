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
document.getElementsByTagName("li")[2].style.color = "purple";
// you can use array properties to retreive info like the length (total # of li's in the HTML)
console.log(document.getElementsByTagName("li").length)

// getElementsByClassName -- plural -- will return an array of elements
document.getElementsByClassName("selector-item")[2].style.color = "green"

// getElementById -- singular - only 1 id of that name per HTML (must be unique)
console.log(document.getElementById("title"))

// querySelector
console.log(document.querySelector("#ep03title"))

document.querySelector(".selector-item").style.color = "orange"

// set variable to .querySelector to manipulate
let containerP = document.querySelector(".ep03-container p")
console.log(containerP)
containerP.innerHTML = "Is this Test working?"

// querySelectorAll
console.log(document.querySelectorAll("li"))
document.querySelectorAll(".selector-item")[5].style.color = "brown"


/* Ep04 Manipulating and Changing Styles of HTML Elements */
document.querySelector("#ep04title").style.color = "grey"  // the title is grey now!

let another01 = document.querySelectorAll("li.another-list-item")[0]
console.log(another01)
another01.innerHTML = "The manipulated item 1"

// hide an element
document.querySelectorAll("li.another-list-item")[1].style.visibility = "hidden"

// change ep04-button background color
console.log(document.querySelectorAll("button")[1])
document.querySelectorAll("button")[1].style.background = "yellow"

/* Ep05 Seperation of Concerns Structure, Style, and Behavior */
document.querySelector("#ep05-button").classList.add("invisible");

document.querySelector("#ep05-button").classList.remove("invisible");

document.querySelector("#ep05-button").classList.toggle("invisible");
document.querySelector("#ep05-button").classList.toggle("invisible");
// make it 'huge'
document.querySelectorAll("li.list-item-ep05")[0].classList.toggle("huge");

/* Ep06 Text Manipulation and the Text Content Property */


