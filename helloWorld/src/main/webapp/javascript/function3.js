// function3.js

"use strict"

function sumAry(ary) {
  var sum = 0
  for (var i = 0; i < ary.length; i++) {
    sum += ary[i]
  }
  return sum
}

var result = sumAry([1, 2, 3, 4, 5])
console.log(`결과값 : ${result}`)

function getMax(first, last) {
  if (first > last) {
    return first
  } else {
    return last
  }
}

console.log(getMax(30, 40))

function getMaxVal(ary) {
  var maxVal = ary[0]
  for (var i = 0; i < ary.length; i++) {
    if (ary[i] > maxVal) {
      maxVal = ary[i]
    }
  }
  return maxVal
}

function getMaxValt(ary) {
  var maxVal = 0
  for (var i = 0; i < ary.length; i++) {
    var temp = ary[i]
    maxVal = getMax(temp, maxVal)
    // if (maxVal < temp) {
    //   maxVal = temp
    // }
  }
  return maxVal
}

function getMinVal(ary) {
  var minVal = ary[0]
  for (var i = 0; i < ary.length; i++) {
    if (ary[i] < minVal) {
      minVal = ary[i]
    }
  }
  return minVal
}

var numAry = [34, 32, 20, 15, 8, 99, 10, 55]
console.log(`최대값 : ${getMaxVal(numAry)}`)
console.log(`최소값 : ${getMinVal(numAry)}`)
