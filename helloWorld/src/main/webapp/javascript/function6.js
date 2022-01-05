// function6.js
"use strict"

// let sum = function sum(a, b) {
//   return a + b
// }

let sum = function (first, last) {
  return first + last
}

let anotherSum = sum
console.log(sum(10, 20))
console.log(anotherSum(30, 40))

// Arrow Fuction(화살표 함수)
let getMinVal = (first, last) => {
  return first > last ? last : first
}

//     if (first > last) {
//         result = last;
//     } else {
//         result = first;
// }
//   return result

console.log(getMinVal(10, 5))
