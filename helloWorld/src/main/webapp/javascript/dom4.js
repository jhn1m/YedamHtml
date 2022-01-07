// dom4.js

const titles = ["이름", "학생번호", "점수"]
const students = [
  {
    fullName: "김",
    studNo: "1001",
    score: 60,
  },
  {
    fullName: "이",
    studNo: "1002",
    score: 70,
  },
  {
    fullName: "최",
    studNo: "1003",
    score: 50,
  },
]

let parent = document.getElementById("show")

// table > thead > tbody
let tbl = document.createElement("table")
tbl.setAttribute("border", "1")
parent.appendChild(tbl)

let thd = document.createElement("thead")
let tr = document.createElement("tr")

// <thead></thead>
thd.appendChild(tr)
titles.forEach(function (title) {
  let th = document.createElement("th")
  let text = document.createTextNode(title)
  th.appendChild(text)
  tr.appendChild(th)
})
thd.appendChild(tr)
tbl.appendChild(thd)

// 삭제 열 추가
th = document.createElement("th")
text = document.createTextNode("삭제")
th.appendChild(text)
tr.appendChild(th)

// <tbdoy></tbody>
let tbd = document.createElement("tbody")
students.forEach(function (obj) {
  let tr = document.createElement("tr")
  tr.onmouseover = function (e) {
    e.target.style.backgroundColor = "yellow"
  }
  tr.onmouseout = function (e) {
    e.target.style.backgroundColor = "white"
  }

  // field 갯수만큼 반복해서 생성
  for (let field in obj) {
    let td = document.createElement("td")
    let text = document.createTextNode(obj[field])
    td.appendChild(text)
    tr.appendChild(td)
  }
  // 삭제버튼
  td = document.createElement("td")
  let btn = document.createElement("button")
  btn.onclick = function (e) {
    e.target.parentNode.parentNode.remove()
  }

  text = document.createTextNode("삭제")
  btn.appendChild(text)
  td.appendChild(btn)
  tr.appendChild(td)

  tbd.appendChild(tr)
})
tbl.appendChild(tbd)
