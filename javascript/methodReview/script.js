const items = [
    {name:'Couch', price: 250},
    {name:'TV', price: 500},
    {name:'Bed', price: 800},
    {name:'Pots & Pans', price: 200},
    {name:'Clothes', price: 1000},
    {name:'Car', price: 10000},
    {name:'Pet', price: 200},
    {name:'Electricity', price: 150},
    {name:'Gas', price: 150},
    {name:'Internet', price: 100}
]
console.log(items);

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
console.log(numbers);

/* filter */ 
const filteredItems = items.filter((item) => item.price <= 150)
console.log(filteredItems);

/* map */
const mapItemName = items.map((item) => item.name)
console.log(mapItemName);

/* find */
const findItem = items.find((item) => item.name === 'Clothes')
console.log(findItem)

/* forEach */
items.forEach((item) => console.log(item.name))

/* some */
const hasInexpensive = items.some((item) => item.price <= 100)
console.log(hasInexpensive)

const free = items.some((item) => item.price <= 0)
console.log(free)

/* every */
const hasCost = items.every((item) => item.price >= 0)
console.log(hasCost)

/* reduce */
const total = items.reduce((currentTotal, item) => {
    return item.price + currentTotal
}, 0) // item is primed to 0 here. the currentTotal is updated with each iteration through the array
console.log(total) 

/* includes */
const includes3 = numbers.includes(3)
console.log(includes3)