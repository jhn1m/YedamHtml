// event1.js

let str = `
<table border="1">
      <thead>
        <tr>
          <th>이름</th>
          <th>전화번호</th>
          <th>주소</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>홍길동</td>
          <td>010-1234-5678</td>
          <td>대구 중구 100번지</td>
          <td><button onclick="delFnc()">삭제</button></td>
        </tr>
        <tr>
          <td>김철수</td>
          <td>010-1111-2222</td>
          <td>대구 남구 10번지</td>
          <td><button>삭제</button></td>
        </tr>
        <tr>
          <td>최오우</td>
          <td>010-3333-5555</td>
          <td>대구 중구 0번지</td>
          <td><button>삭제</button></td>
        </tr>
      </tbody>
    </table>`

document.write(str)

let names = document.querySelectorAll("table>tbody>tr>td:nth-child(1)")

console.log(names)

for (let i = 0; i < names.length; i++) {
  names[i].onclick = function (e) {
    console.log(e.target.innerText)
    let text = e.target.innerText
    alert(text + "입니다.")
  }
}

let rows = document.querySelectorAll("tbody>tr")
for (let i = 0; i < rows.length; i++) {
  rows[i].onmouseover = function (e) {
    console.log(e.target.parentNode)
    e.target.parentNode.style.backgroundColor = "Yellow"
    // e.target.parentNode.style.display = "none"
  }

  // <div style = "background-color : yellow; display : none"></div>

  rows[i].onmouseout = function (e) {
    e.target.parentNode.style.backgroundColor = null
  }
}

let btns = ""
for (let i = 0; i < btns.length; i++) {
  //   btns[i].onclick = deleteFnc
  btns[i].addEventListener("click", deleteFnc)
}

function deleteFnc(e) {
  e.target.parentNode.parentNode.remove()
}
