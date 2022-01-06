// string1.js

"use strict"

// var val = "hello"
// val = new String("Hello")
// console.log(typeof val)

// var h3Tag = document.querySelector("h3")
// var text = h3Tag.innerHTML
// var str = text.substring(2, 10)
// str = text.slice(1, 5)

// var elem = document.getElementById("show")
// // elem.innerHTML = "<h3>Hello</h3>"
// elem.innerText = str
// console.log(elem)

const person = {
  fullName: "Hong",
  age: 10,
  toString: function () {
    return this.fullName + ", " + this.age
  },
}

person.fullName = "Hwang"
person.toString

const str = "Hwang"
str.length
let newStr = str.substring(1, 5)
newStr = str.slice(-3, -1)

newStr = str.replace("a", ",").replace(",", ".")

console.log(newStr)

function getGender(jm) {
  if (jm.length != 13 && jm.length != 14) {
    return
  }
  let genNum = jm.replace("-", "").replace(" ", "").substring(6, 7)
  genNum = jm.slice(-7, -6)
  let gender = "남자"
  if (genNum == "1" || genNum == "3") {
    gender = "남자"
  } else if (genNum == "2" || genNum == "4") {
    gender = "여자"
  } else {
    gender = "NONE"
  }
  return gender
}

console.log(getGender("850101-1234567"))
console.log(getGender("870101 2234567"))
console.log(getGender("9201012123456"))
console.log(getGender("92010121234562345"))

console.log("Hello".toUpperCase().toLowerCase())

let str1 = "hello",
  str2 = "world"

console.log(str.concat(" ", str2, "!!"))

let str3 = str1.concat(" ", str2, "!!")
console.log(str3)

let pos = str3.charAt("w")
console.log(pos)

let ary = str3.split(" ")
for (let str of ary) {
  console.log(str)
}

let temp =
  "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugiat, sint quo, consequuntur saepe beatae dolor fugit similique quasi odit veritatis numquam doloribus minus cupiditate laboriosam cum totam quos repellendus eaque."
let tempAry = temp.split(" ")
console.log(tempAry.length)

let fruits = "Apple Banana Cherry Melon"
let fruit = prompt("과일 입력 : ")

// 검색 비슷한 기능
function getLoc(fruit) {
  if (!fruit) {
    return
  }
  let temp = fruits.split(" ")
  let cnt = 0
  for (let i = 0; i < temp.length; i++) {
    if (temp[i].toUpperCase() == fruit.toUpperCase()) {
      cnt = i + 1
    }
  }
  if (cnt == 0) {
    return "만족하는 값이 없습니다."
  }
  return cnt + "번째"
}

console.log(getLoc(fruit))
