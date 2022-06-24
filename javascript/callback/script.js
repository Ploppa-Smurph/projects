const button01 = document.querySelector('.button01')

function toggle() {
    button01.classList.toggle('altColor')
    //button01.innerHTML = "You Pushed Me"
}

// by using the arrow function I can use a function as a parameter in a callback
document.addEventListener('click', ()=>setTimeout(toggle, 200))