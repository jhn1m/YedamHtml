// number1.js

"use strict"

// let num1 = 100.123

// console.log(Math.floor(num1))
// console.log(Math.ceil(num1))
// console.log(Math.round(num1))

// for (let i = 0; i < 10; i++) {
//   let temp = Math.random()
//   console.log(temp)
// }

// console.log(parseInt(Math.random() * 5) + 1)

let findVal = -1
let order = parseInt(Math.random() * 9)

for (let i = 0; i < 9; i++) {
  let temp = parseInt(Math.random() * 9) + 1
  document.write(`<div onclick="clickFnc(event)">${temp}</div>`)
  if (i % 3 == 2) {
    document.write("<br>")
  }
  if (i == 0) {
    findVal = temp
  }
}

window.alert(findVal + "을 찾으세요.")

function clickFnc(e) {
  console.log(e.target.innerText)
  if (e.target.innerText == findVal) {
    window.alert(findVal + "을 찾았습니다 ! ")
    e.target.style.color = "blue"
  }
}

let divElem = document.getElementsByTagName("div")
for (let i = 0; i < divElem.length; i++) {
  divElem[i].onclick = clickFnc
}
