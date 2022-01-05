// calendar.js

// lastDay.getDate()
// document.write(lastDay.getDate())

// console.log(today)
// console.log(today.getFullYear())
// console.log(today.getMonth() + 1) // 달은 0부터 시작함
// console.log(today.getDate())
// console.log(today.getDay())

// var otherDay = new Date(2021, 4, 3)
// console.log(otherDay.getFullYear())
// console.log(otherDay.getMonth())
// console.log(otherDay.getDate())
// console.log(otherDay.getDay())
"use strict"

//#region 달력 틀
var year = 2022
var month = 5
var today = new Date(year, month - 1, 1)
var lastDay = new Date(year, month, 0) // 월의 마지막 날
var firstDayOfMonth = today.getDay()
var lastDateOfMonth = lastDay.getDate()
var days = ["Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"]

document.write(`<h1>${today.getFullYear()}년 ${today.getMonth() + 1}월</h1>`)
for (var day of days) {
  document.write(`<span>${day}</span>`)
}
document.write("<br>")

for (var n = 0; n < today.getDay(); n++) {
  document.write(`<span class = "calblank">&nbsp</span>`)
}
for (var i = 1; i <= lastDay.getDate(); i++) {
  if (i == today.getDate()) {
    document.write(`<span style = font-weight:bold;> ${i} </span>`)
    if ((i + today.getDay()) % 7 == 0) {
      document.write("<br>")
    }
    continue
  }
  document.write(`<span>${i}</span>`)
  if ((i + today.getDay()) % 7 == 0) {
    document.write("<br>")
  }
}
document.write(`</div>`)
//#endregion

// #region 연간 달력 출력

for (var i = 0; i < 12; i++) {
  document.write(`<div id="calendar">`)
  var tod = new Date(2022, i, 1)
  var lad = new Date(2022, i + 1, 0)
  var days = ["일", "월", "화", "수", "목", "금", "토"]
  document.write(`<h1>${tod.getFullYear()}년 ${tod.getMonth() + 1}월</h1>`)

  document.write(`<span class = "calheader">일</span>`)
  document.write(`<span class = "calheader">월</span>`)
  document.write(`<span class = "calheader">화</span>`)
  document.write(`<span class = "calheader">수</span>`)
  document.write(`<span class = "calheader">목</span>`)
  document.write(`<span class = "calheader">금</span>`)
  document.write(`<span class = "calheader">토</span>`)
  document.write("<br>")
  for (var n = 0; n < tod.getDay(); n++) {
    document.write(`<span class = "calblank">&nbsp</span>`)
  }
  for (var k = 1; k <= lad.getDate(); k++) {
    if (k == tod.getDate()) {
      document.write(`<span style = font-weight:bold;> ${k} </span>`)
      if ((k + tod.getDay()) % 7 == 0) {
        document.write("<br>")
      }
      continue
    }
    document.write(`<span>${k}</span>`)
    if ((k + tod.getDay()) % 7 == 0) {
      document.write("<br>")
    }
  }
  document.write(`</div>`)
}

//#endregion
