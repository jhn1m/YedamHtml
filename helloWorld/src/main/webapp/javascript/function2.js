// function2.js

"use strict"

function addNumber(firstNum, lastNum) {
  var sum = firstNum + lastNum
  return sum
}

var result1 = addNumber(10, 20)
var result2 = addNumber(15, 25)
var result3 = addNumber(addNumber(10, 20), addNumber(15, 25))
console.log(`첫번째 결과 : ${result1} 두번째 결과 : ${result2}`)
console.log(`총 합은 : ${result3}`)

function sumBetweenNum(firstNum, lastNum, num) {
  // 첫번째 매개값과 두번째 매개값의 사이의 값을 합.
  // 홀수값만 더하도록
  var sum = 0
  for (var i = firstNum; i < lastNum; i++) {
    if (i % num == 0) {
      sum += i
    }
  }
  return sum
}

document.write(`<p>${sumBetweenNum(1, 20, 3)}</p>`)
document.write(`<p>${sumBetweenNum(1, 20, 2)}</p>`)
