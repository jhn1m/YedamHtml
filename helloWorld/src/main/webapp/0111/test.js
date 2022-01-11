// test.js

"use strict"

const data = [
  {
    bookID: "P12301285",
    bookName: "이것이 자바다",
    Author: "홍성문",
    Publisher: "신흥출판사",
    price: "25,000원",
  },
  {
    bookID: "P12301285",
    bookName: "이것이 자바다",
    Author: "홍성문",
    Publisher: "신흥출판사",
    price: "25,000원",
  },
  {
    bookID: "P12301285",
    bookName: "이것이 자바다",
    Author: "홍성문",
    Publisher: "신흥출판사",
    price: "25,000원",
  },
  {
    bookID: "P12301285",
    bookName: "이것이 자바다",
    Author: "홍성문",
    Publisher: "신흥출판사",
    price: "25,000원",
  },
  {
    bookID: "P12301285",
    bookName: "이것이 자바다",
    Author: "홍성문",
    Publisher: "신흥출판사",
    price: "25,000원",
  },
]

function makeHead() {
  const field = ["도서코드", "도서명", "저자", "출판사", "가격", "삭제"]
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

  // 삭제버튼
  td = document.createElement("td")
  let button = document.createElement("button")
  button.setAttribute("id", "del")
  button.textContent = "삭제"
  button.onclick = function (e) {
    e.target.parentNode.parentNode.remove()
  }
  let text = document.createTextNode("삭제")
  td.appendChild(button)
  tr.appendChild(td)

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
  let bId = document.querySelector("input[name = 'bid']").value
  let bName = document.querySelector("input[name = 'bname']").value
  let Author = document.querySelector("input[name = 'author']").value
  let Publisher = document.querySelector("input[name = 'publisher']").value
  let Price = document.querySelector("input[name = 'price']").value
  if (bId == "" || bName == "" || Price == "") {
    window.alert("필수값을 입력하세요 !")
    return
  }

  let obj = {
    bId: bId,
    bName: bName,
    Author: Author,
    Publisher: Publisher,
    Price: Price,
  }
  let tr = makeTr(obj)
  document.querySelector("#list > table > tbody").appendChild(tr)
  let el = document.querySelectorAll("input")
  for (var i = 0; i < el.length; i++) {
    el[i].value = ""
  }
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

// 삭제버튼 이벤트 등록2
let delbtn = document.getElementsByClassName("delbtn")
for (let i = 0; i < delbtn.length; i++) {
  delbtn[i].addEventListener("click", function () {
    let parent = document.querySelectorAll("#list")
    parent.removeChild(this.parentElement.parentElement)
    i--
  })
}

// 입력 후 초기화
function all_reset() {
  document.form.reset()
}
