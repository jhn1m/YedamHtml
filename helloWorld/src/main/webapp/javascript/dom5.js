// dom5.js

const data = [
  {
    name: "Kim",
    phone: "010-1111-2222",
    addr: "USA",
    email: "Kim@email.com",
  },
  {
    name: "Lee",
    phone: "010-3333-4444",
    addr: "CANADA",
    email: "Lee@email.com",
  },
  {
    name: "Park",
    phone: "010-5555-6666",
    addr: "KOREA",
    email: "Kim@email.com",
  },
]
function makeHead() {
  let thd = document.createElement("thead")
  let tr = document.createElement("tr")
  let th = document.createElement("th")
  let text = document.createTextNode("이름")
  th.appendChild(text)
  tr.appendChild(th)
  thd.appendChild(tr)

  return thd
}

// tr 생성
function makeTr() {
  let tr = document.createElement("tr")
  for (let field in obj) {
    let td = document.createElement("td")
    let text = document.createTextNode(obj[field])
    td.appendChild(text)
    tr.appendChild(td)
  }
  tbd.appendChild(tr)
}

function makeBody() {
  let tbd = document.createElement("tbody")
  data.forEach(function (obj) {})
  return tbd
}

// 즉시 실행 함수 > 괄호 안에 넣으면 함수 이름이 없어도 실행됨
;(function () {
  let tbl = document.createElement("table")
  tbl.setAttribute("border", "1")
  tbl.appendChild(makeHead())
  tbl.appendChild(makeBody())
  document.getElementById("list").appendChild(tbl)
})()
let parent = document.getElementById("show")
