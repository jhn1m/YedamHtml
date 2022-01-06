// dom1.js

"use strict"

let pelemt = document.querySelector("body > p")
console.log(pelemt)
pelemt.innerHTML = "not Hello"

let newP = document.createElement("p")
newP.innerHTML = "Test Inner"
console.log(newP)

pelemt.after(newP)

let list = document.querySelectorAll("ul > li")
list[0].remove()
console.log(list)

document.getElementById("delBtn").onclick = function () {
  let sname = document.getElementById("sname").value
  let liTag = document.createElement("li")
  liTag.innerHTML = sname
  let ul = document.querySelector("ul")
  ul.appendChild(liTag)
}

// let obj = {
//   name: "hong",
//   hobbies: {
//     first: "riding",
//     last: "sleeping",
//   },
// }

// let = obj.hobbies.first
