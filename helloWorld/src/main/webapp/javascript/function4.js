// function4.js

var students = [
  {
    name: "홍길동",
    score: 60,
    birth: "1999-12-30",
    phone: "010-1111-2222",
    gender: "남",
  },
  {
    name: "김가삿",
    score: 70,
    birth: "1979-12-30",
    phone: "010-1111-2222",
    gender: "여",
  },
  {
    name: "고운오",
    score: 90,
    birth: "1999-12-30",
    phone: "010-1111-2222",
    gender: "여",
  },
  {
    name: "케이크",
    score: 10,
    birth: "2009-12-30",
    phone: "010-1111-2222",
    gender: "여",
  },
  {
    name: "갹으동",
    score: 62,
    birth: "1992-12-30",
    phone: "010-1111-2222",
    gender: "남",
  },
]

function makeTable(ary) {
  var str = ""
  str += `<table border='1'>`
  str += `<thead><tr><th>이름</th><th>점수</th><th>생년월일</th><th>연락처</th><th>성별</th></tr></thead>`
  str += `<tbody>`
  for (var student of ary) {
    str += `<tr>`
    for (var field in student) {
      str += `<td>${student[field]}</td>`
    }
    // str += `<td>${student.name}</td>`
    // str += `<td>${student.score}</td>`
    // str += `<td>${student.birth}</td>`
    // str += `<td>${student.phone}</td>`
    str += `</tr>`
  }
  str += "</tbody>"
  str += "</table>"
  return str
}

document.write(makeTable(students))
makeCal(2022, 5)
