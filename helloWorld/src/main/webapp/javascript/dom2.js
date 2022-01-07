// dom2.js
// document object model
// element(element node, attribute node, text node), tag
// <img src = "sample.jpg">, <input type = "text" value = "sample">

"use strict"

let img = document.createElement("img")
img.setAttribute("src", "../img/home.png")
img.setAttribute("id", "mypicture")
img.setAttribute("width", "200px")
console.log(img)

document.getElementById("show").appendChild(img)
console.log(img)

// <ul><li>apple</li><li>Banana</li><li>Cherry</li></ul>
// ul , li * 3, li > text
let fruits = ["Apple", "Banana", "Cherry"]
let ul = document.createElement("ul")

// 밑 과정을 forEach로 변형
fruits.forEach(callBackFnc)

// 이 내용이 원래는 forEach에 있었음
function callBackFnc(item) {
  let li = document.createElement("li")
  let text = document.createTextNode(item)
  li.appendChild(text)
  ul.appendChild(li)
}

// forEach2

// 밑 과정을 for으로 변형
// for (let fruit of fruits) {
//   li = document.createElement("li")
//   text = document.createTextNode(fruit)
//   li.appendChild(text)
//   ul.appendChild(li)
// }

// // li 태그 생성 후 text를 자식으로 삽입
// let li = document.createElement("li")
// let text = document.createTextNode("Apple")
// li.appendChild(text)
// ul.appendChild(li)

// li = document.createElement("li")
// text = document.createTextNode("Banana")
// li.appendChild(text)
// ul.appendChild(li)

// li = document.createElement("li")
// text = document.createTextNode("Cherry")
// li.appendChild(text)
// ul.appendChild(li)

console.log(ul)

document.getElementById("bdy").appendChild(ul)

let delBtn = document.getElementById("delBtn")
delBtn.onclick = function () {
  let sname = document.getElementById("sname").value
  let list = document.querySelectorAll("#nameList > li")

  for (let i = 0; i < list.length; i++) {
    if (list[i].innerText == sname) {
      list[i].remove()
      break
    }
  }
}

// 이벤트 등록
// 이벤트 기능 : 사용자의 입력값 > <li>입력값</li>
// ul태그 찾고 ul 하위에 붙여넣기

let addBtn = document.getElementById("addBtn")
addBtn.onclick = function () {
  let liTag = document.createElement("li")
  let sname = document.getElementById("sname").value
  liTag.innerHTML = sname
  let ul = document.querySelector("ul")
  ul.appendChild(liTag)
  //   let sname = "<li>" + document.getElementById("sname").value + "</li>"
  //   let list = document.querySelectorAll("#nameList > li")
}

