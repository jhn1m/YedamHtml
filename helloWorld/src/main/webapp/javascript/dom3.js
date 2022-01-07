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
document.getElementById("bdy").appendChild(input)
console.log(input)

let delBtn = document.createElement("button")
delBtn.append("삭제")
let addBtn = document.createElement("button")
addBtn.append("추가")
document.getElementById("bdy").appendChild(delBtn)
document.getElementById("bdy").appendChild(addBtn)
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

document.getElementById("bdy").appendChild(ul)
console.log(ul)
