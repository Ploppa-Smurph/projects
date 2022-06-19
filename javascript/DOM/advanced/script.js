document.querySelector("#notesTitle").textContent = "WALLEY WORKS and London App Brewery Present: NOTES"
document.querySelector("#project-header-title").innerHTML = "<em>DRUM PROJECT</em>"

// eventlistener --
 
document.querySelector("button").addEventListener("click", handleClick)
function handleClick() { 
    alert("I got clicked")
}  

