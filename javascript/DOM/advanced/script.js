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
for (var i=0; i<drumButtonNum; i++) {    // iterate through the .drum buttons
/*document.querySelectorAll(".drum")[i].addEventListener("click", () => alert("I got clicked")); // anonymous arrow function w/ event listener
}
 */
// ep03 higher order functions and passing functions
// find which button triggered the event so that each can call a different sound    
/* document.querySelectorAll(".drum")[i].addEventListener("click", function() {
        console.log(this.innerHTML)
}); 
} */

/* let drum = new Audio('./mp3s/tom_plastic_hard.mp3');
        drum.play() */

// ep06 Switch functions in javascript //
document.querySelectorAll(".drum")[i].addEventListener("click", function() {
    let buttonInnerHTML = this.innerHTML;

    switch (buttonInnerHTML) {
        case "W":
            let tom_hard = new Audio('./mp3s/tom_plastic_hard.mp3');
            tom_hard.play() 
        break;
        case "A":
            let tom_mid = new Audio('./mp3s/tom_mid_low_01.mp3');
            tom_mid.play()
        break; 
        case "S":
            let tom_high = new Audio('./mp3s/tom_high_01.mp3');
            tom_high.play() 
        break;
        case "D":
            let kick_drum = new Audio('./mp3s/kickDrum_01.mp3');
            kick_drum.play() 
        break;
        case "J":
            let hi_closed = new Audio('./mp3s/gamelan_drum_large.mp3');
            hi_closed.play() 
        break;
        case "K":
            let hi_open = new Audio('./mp3s/beatbox_open_hi_hat.mp3');
            hi_open.play() 
        break;
        case "L":
            let cymbal_crash = new Audio('./mp3s/cymbal_crash.mp3');
            cymbal_crash.play() 
        break;   
        default: 
            console.log(buttonInnerHTML)
            break;
    }
}); 
}

// Ep08 Using Keyboard Event Listeners //


