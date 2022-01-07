// dom5.js

"use strict"

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
  const field = ["Name", "Phone", "Addr", "Email"]
  let thd = document.createElement("thead")
  let tr = document.createElement("tr")

  // 체크박스
  let td = document.createElement("td")
  let checkbox = document.createElement("input")
  checkbox.setAttribute("type", "checkbox")
  checkbox.addEventListener("click", allCheckFnc)
  td.appendChild(checkbox)
  tr.appendChild(td)

  field.forEach(function (field) {
    let th = document.createElement("th")
    let text = document.createTextNode(field)
    th.appendChild(text)
    tr.appendChild(th)
  })
  thd.appendChild(tr)

  return thd
}

function allCheckFnc() {
  // tbody쪽 checkbox 찾아서 checked == true
  let findChk = document.querySelectorAll("tbody input[type = 'checkbox']")
  for (let i = 0; i < findChk.length; i++) {
    findChk[i].checked = this.checked
  }
}

// tbody 영역
function makeBody() {
  let tbd = document.createElement("tbody")
  data.forEach(function (obj) {
    tbd.appendChild(makeTr(obj))
  })
  return tbd
}

// tr 생성
function makeTr(obj) {
  let tr = document.createElement("tr")

  // 체크박스
  let td = document.createElement("td")
  let checkbox = document.createElement("input")
  checkbox.setAttribute("type", "checkbox")
  td.appendChild(checkbox)
  tr.appendChild(td)

  for (let field in obj) {
    let td = document.createElement("td")
    let text = document.createTextNode(obj[field])
    td.appendChild(text)
    tr.appendChild(td)
  }
  return tr
}

// 즉시 실행 함수 > 괄호 안에 넣으면 함수 이름이 없어도 실행됨
;(function () {
  let tbl = document.createElement("table")
  tbl.setAttribute("border", "1")
  tbl.appendChild(makeHead())
  tbl.appendChild(makeBody())
  document.getElementById("list").appendChild(tbl)
})()

// 등록버튼 이벤트
let addBtn = document.querySelector("#btn > button")
addBtn.addEventListener("click", addCallback)

function addCallback() {
  let name = document.querySelector("input[name = 'name']").value
  let phone = document.querySelector("input[name = 'phone']").value
  let addr = document.querySelector("input[name = 'addr']").value
  let email = document.querySelector("input[name = 'email']").value
  if (name == "" || phone == "" || addr == "" || email == "") {
    window.alert("필수값을 입력하세요 !")
    return
  }

  let obj = {
    name: name,
    phone: phone,
    addr: addr,
    email: email,
  }
  let tr = makeTr(obj)
  document.querySelector("#list > table > tbody").appendChild(tr)
}

// 삭제버튼 이벤트 등록
let delBtn = document.querySelector("#btn > button:nth-child(2)")
delBtn.addEventListener("click", delCallback)

function delCallback() {
  let chks = document.querySelectorAll("tbody input[type = 'checkbox']")
  for (let i = 0; i < chks.length; i++) {
    if (chks[i].checked == true) {
      chks[i].parentNode.parentNode.remove()
    }
  }
}
