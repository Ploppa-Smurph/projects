/* /* /* ex01 == 'let' & 'const'*/

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
var myAgeNextYear = ageNow => ageNow+1 
console.log(myAgeNextYear(46))  

/* Export and Import (modules / components) */
/* see examples in index.html */

/* Classes in javascript */
/* class Human {
    constructor() {
        this.age = 41;
    }

    printAge() {
        console.log(this.age);
    }
}

class Person extends Human {
    constructor() {
        super();
        this.name = 'Ra';
    }
    
    printPersonName() {
        console.log(this.name);
    }
}

const person = new Person();
person.printPersonName();
person.printAge(); */

/* Classes, Properties & Methods */

/* the example from above can be further simplified with new syntax */
class Age {
    age = 41;
    
    printAge = () => {
        console.log(this.age);
    }
}

class Person extends Age {
        name = 'KaRo';
        age = '41.5';

    
    printPersonName = () => {
        console.log(this.name);
    }
}

const person = new Person();
person.printPersonName();
person.printAge();

/* Spread & Rest Operators */
/* Spread */
const numbers = [1,2,3];
const newNumbers =[...numbers, 4];
console.log(newNumbers);

/*Spread Operator*/
const person1 = {
    name: 'Jim'
};

const newPerson1 = {
    ...person1, 
    age: 28
}
console.log(newPerson1);

/* Rest Operator */
/* rest operator merges 'args' into an array and you can use the .filter() method on arrays */
const filter = (...args) => {
    return args.filter(el => el === 1);
}
console.log(filter(1,2,3));

/* Destructuring */ /*
const numArray = [1, 2, 3, 4];
[n1, n2] = numArray;
console.log(n1, n2);  I could not get this to run without throwing a ReferenceError -- 'n1 is not defined'*/

/* Reference & Primitive Types */
const per = {
    name: 'Tom'
};
const secondPer = per;
const secondPerName = {...per};

per.name = 'Manu';

console.log(secondPer)
console.log(secondPerName)

/* Refreshing Array Functions */
const numberArray = [1,2,3];

const doubleNumArray  = numberArray.map((num) => {
    return num * 2;
})
console.log(numberArray)
console.log(doubleNumArray)