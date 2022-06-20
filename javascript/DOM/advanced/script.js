document.querySelector("#notesTitle").textContent = "WALLEY WORKS and London App Brewery Present: NOTES"
document.querySelector("#project-header-title").innerHTML = "<em>DRUM PROJECT</em>"

// eventlistener --
 
/* document.querySelector("button").addEventListener("click", handleClick)
function handleClick() { 
    alert("I got clicked")
}  
 */

// the above listener function written as an anonymous function -- shortened even further into an anonymous arrow function
// document.querySelector("button").addEventListener("click", () => alert("I got clicked"));

/* Event Listener for ALL of the buttons using a 'for' loop */
//determine the amount of "drum buttons" in the HTML
let drumButtonNum = document.querySelectorAll(".drum").length; // variable to 'get' length
for (var i=0; i<drumButtonNum; i++) {   // iterate through the .drum buttons
document.querySelectorAll(".drum")[i].addEventListener("click", () => alert("I got clicked")); // anonymous arrow function w/ event listener
}

// ep03 higher order functions and passing functions
