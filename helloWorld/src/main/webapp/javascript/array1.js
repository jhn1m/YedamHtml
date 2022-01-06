// array1.js

const numAry = [23, 17, 33, 72, 88]

let sum = 0
numAry.forEach(function (item, idx, ary) {
  if (idx % 2 == 0) {
    sum += item
  }
})

console.log(`합계 : ${sum}`)

const names = ["김", "황", "이", "최", "박"]
// for (let i = 0; i < 3; i++) {
//   const name = window.prompt("추가 이름 입력 >> ")
//   names.push(name)
// }
console.log(names)

names.splice(1, 2, "누군가")

// let list = document.querySelectorAll("ul:nth-child(1)>li")
// console.log(list)
// list.forEach(function (item, idx, ary) {
//   console.log(item, idx, ary)
//   //   console.log(item, item.innerHTML)
//   if (idx % 2 == 0) {
//     item.innerHTML = "<h3>hello</h3>"
//   }
// })
