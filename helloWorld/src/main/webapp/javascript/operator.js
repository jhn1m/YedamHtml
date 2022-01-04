// operator.js

"use strict"

// var iVal = window.prompt("값을 입력")
// console.log(iVal)
var numArr = [3, 9, 20, 14, 8, 22]
var sum = 0
for (var num of numArr) {
  console.log(num)
  if (num % 2 == 0) {
    sum += num
  }
  //   if (num === parseInt(iVal)) {
  //     break
}

console.log(`짝수의 합계는 ${sum}`)

// console.log(3 + "5" + (3 + 4))

var sum_2 = 0 // 2의 배수만 받으려는 변수
var sum_3 = 0 // 3의 배수만 받으려는 변수
var sum_2and3 = 0 // 2와 3의 공배수를 받으려는 변수
for (var i = 1; i < 20; i++) {
  if (i % 6 == 0) {
    sum_2and3 += i
  } else if (i % 2 == 0) {
    sum_2 += i
  } else if (i % 3 == 0) {
    sum_3 += i
  }
}

console.log(`2의 배수 합계 : ${sum_2}`)
console.log(`3의 배수 합계 : ${sum_3}`)
console.log(`2와 3의 배수 합계 : ${sum_2and3}`)
