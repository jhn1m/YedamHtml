// employee.js

"use strict"

const titles = [
  "EmpID",
  "fName",
  "lName",
  "HireDate",
  "E-mail",
  "job",
  "Salary",
]
const fields = [
  "employeeId",
  "firstName",
  "lastName",
  "hireDate",
  "email",
  "jobId",
  "salary",
]

function makeHead() {
  let thd = document.createElement("thead")
  let tr = document.createElement("tr")

  // 체크박스
  let td = document.createElement("td")
  let checkbox = document.createElement("input")
  checkbox.setAttribute("type", "checkbox")
  checkbox.addEventListener("click", allCheckFnc)
  td.appendChild(checkbox)
  tr.appendChild(td)

  titles.forEach(function (field) {
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
function makeBody(data) {
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

  // 데이터영역
  for (let field of fields) {
    let td = document.createElement("td")
    let text = document.createTextNode(obj[field])
    td.appendChild(text)
    tr.appendChild(td)
  }
  return tr
}

// 즉시 실행 함수 > 괄호 안에 넣으면 함수 이름이 없어도 실행됨
;(function () {
  // ajax 호출
  //readyState 1, 2, 3은 준비중을 뜻함
  let xhtp = new XMLHttpRequest()
  xhtp.onreadystatechange = function () {
    if (xhtp.readyState == 4 && xhtp.status == 200) {
      console.log("readyState : " + xhtp.readyState)
      console.log("status : " + xhtp.status)
      let data = JSON.parse(xhtp.responseText)
      console.log(data)

      let tbl = document.createElement("table")
      tbl.setAttribute("border", "1")
      tbl.appendChild(makeHead())
      tbl.appendChild(makeBody(data))
      document.getElementById("list").appendChild(tbl)
      //   showCenterList(data)
    }
    // ajax 호출
  }
  xhtp.open("get", "../EmpList.json")
  xhtp.send()
})()

// 등록버튼 이벤트
let addBtn = document.querySelector("#btn > button")
addBtn.addEventListener("click", addCallback)

function addCallback() {
  let eid = document.querySelector("input[name = 'eid']").value
  let fname = document.querySelector("input[name = 'fname']").value
  let lname = document.querySelector("input[name = 'lname']").value
  let hire_date = document.querySelector("input[name = 'hire_date']").value
  let email = document.querySelector("input[name = 'email']").value
  let salary = document.querySelector("input[name = 'salary']").value
  if (eid == "" || lname == "" || hire_date == "" || email == "") {
    window.alert("필수값을 입력하세요 !")
    return
  }
  // json => javascript object 변경
  const xhtp = new XMLHttpRequest()
  xhtp.onload = function () {
    let result = JSON.parse(xhtp.responseText)
    console.log(result)
    let tr = makeTr(result)
    document.querySelector("#list > table > tbody").appendChild(tr)
  }
  xhtp.open("post", "../InsertEmployeeServlet")
  xhtp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
  xhtp.send(
    `employee_id=${eid}&first_name=${fname}&last_name=${lname}&email=${email}&hire_date=${hire_date}&salary=${salary}`
  )
}

// let obj = {
//   name: name,
//   phone: phone,
//   addr: addr,
//   email: email,
// }

// 삭제버튼 이벤트 등록
let delBtn = document.querySelector("#btn > button:nth-child(2)")
delBtn.addEventListener("click", delCallback)

function delCallback() {
  let chks = document.querySelectorAll("tbody input[type = 'checkbox']")
  for (let i = 0; i < chks.length; i++) {
    if (chks[i].checked == true) {
      console.log(chks[i].parentNode.nextSibling.innerText)
      let del_id = chks[i].parentNode.nextSibling.innerText
      // ajax 호출부분 (삭제 서블릿 호출 > 화면에서 삭제.)
      const xhtp = new XMLHttpRequest()
      xhtp.onload = function () {
        //   서버 호출 결과 값을 받아오면 실행하는 부분.
        console.log(xhtp.responseText)
        let result = JSON.parse(xhtp.responseText)
        if (result.retCode == "Success") {
          chks[i].parentNode.parentNode.remove()
        } else {
          window.alert("조회된 데이터가 없습니다.")
        }
      }
      // ajax 호출

      // 화면 삭제
    }
  }

  xhtp.open("post", "../DeleteEmployeeServlet")
  xhtp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
  xhtp.send(`emp_id=${del_id}`)
}

// 리스트 > 입력화면에 보여주기.
let names = document.querySelectorAll("table tbody tr td:nth-child(2)")
for (let i = 0; i < names.length; i++) {
  names[i].addEventListener("click", showInfo)
  function showInfo() {
    let parent = names[0].parentNode
    document.querySelector("input[name='name']").value =
      names[i].parentNode.childNodes[1].innerText
    document.querySelector("input[name='phone']").value =
      names[i].parentNode.childNodes[2].innerText
    document.querySelector("input[name='addr']").value =
      names[i].parentNode.childNodes[3].innerText
    document.querySelector("input[name='email']").value =
      names[i].parentNode.childNodes[4].innerText
  }
  console.log(parent)
}
