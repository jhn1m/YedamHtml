// dom2.js
// document object model
// element(element node, attribute node, text node), tag
// <img src = "sample.jpg">, <input type = "text" value = "sample">

let img = document.createElement("img")
img.setAttribute("src", "../img/home.png")
img.setAttribute("id", "mypicture")
console.log(img)

document.getElementById("show").appendChild(img)
console.log(img)

// <ul><li>apple</li><li>Banana</li><li>Cherry</li></ul>
// ul , li * 3, li > text
let fruits = ["Apple", "Banana", "Cherry"]
let ul = document.createElement("ul")

// 밑 과정을 for으로 변형
for (let fruit of fruits) {
  li = document.createElement("li")
  text = document.createTextNode(fruit)
  li.appendChild(text)
  ul.appendChild(li)
}

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
