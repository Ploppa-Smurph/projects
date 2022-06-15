/* ex01 == 'let' & 'const'*/

let myName = 'Trelvyn';
console.log(myName);

/* ex02 == 'arrow functions' */
function printName(name) {
    console.log(name)
}

printName('Padre')

/* Arrow*/
const printMyName = (name) => {
    console.log(name)
}
printMyName('Glen')

/* multiple parameters */
const me = (name, age) => {
    console.log(name, age)
}
me('Simp', 45)

/* don't need {} curly braces in shortcut */
const nickname = name => console.log(name)
nickname('Simpkins')

/* don't need 'return' keyword in shortcut */
var myAgeNextYear = age => age+1 
console.log(myAgeNextYear(46))

/* Export and Import (modules / components) */
/* see examples in index.html */