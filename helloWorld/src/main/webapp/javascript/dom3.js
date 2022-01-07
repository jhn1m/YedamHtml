// dom3.js
// dom 생성
"use strict"

let div = document.createElement("div")
div.setAttribute("id", "show")
console.log(div)

document.getElementById("bdy").appendChild(div)

let input = document.createElement("input")
input.setAttribute("type", "text")
input.setAttribute("value", "test")
console.log(input)

let delBtn = document.createElement("button")
let addBtn = document.createElement("button")
console.log(delBtn)
console.log(addBtn)

let names = ["김", "황", "최", "이", "박"]

let ul = document.createElement("ul")
names.forEach(nameAdd)

function nameAdd(item) {
  let li = document.createElement("li")
  let text = document.createTextNode(item)
  li.appendChild(text)
  ul.appendChild(li)
}

console.log(ul)
