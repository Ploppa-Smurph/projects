var menuBtn = document.getElementById("menuBtn");
var sideNav = document.getElementById("sideNav");
var menu = document.getElementById("menu");

sideNav.style.right = "-200px";

menuBtn.onclick = function() {
    if (sideNav.style.right == "-200px") {
        sideNav.style.right = "0";
        //menu.src = "img/close.png";
    } else {
        sideNav.style.right = "-200px";
        //menu.src = "img/bars.png";
    }
}