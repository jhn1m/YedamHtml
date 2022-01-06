// array1.js

"use strict"

let delBtn = document.getElementById("delBtn")
delBtn.onclick = function () {
  let sname = document.getElementById("sname").value
  if (!sname) {
    alert("값을 입력하세요.")
    return
  }
  let list = document.querySelectorAll("ul > li")
  console.log(list)
  for (let i = 0; i < list.length; i++)
    if (list[i].innerText == sname) {
      list[i].style.display = "none"
    }
}
const numAry = [23, 17, 33, 72, 88]

let sum = 0
numAry.forEach(function (item, idx, ary) {
  if (idx % 2 == 0) {
    sum += item
  }
})

console.log(`합계 : ${sum}`)

const names = ["김", "황", "이", "최", "박"]
//   const name = window.prompt("추가 이름 입력 >> ")
// for (let i = 0; i < 3; i++) {
// const sname = window.prompt("삭제할 이름 입력 >>")
//   if (names[i] == sname) {
//     names.splice(i, 1)
//   }
// }
//   names.push(name)
console.log(names)

names.splice(1, 2, "누군가", "누군가2")
console.log(names)

// let list = document.querySelectorAll("ul:nth-child(1)>li")
// console.log(list)
// list.forEach(function (item, idx, ary) {
//   console.log(item, idx, ary)
//   //   console.log(item, item.innerHTML)
//   if (idx % 2 == 0) {
//     item.innerHTML = "<h3>hello</h3>"
//   }
// })
