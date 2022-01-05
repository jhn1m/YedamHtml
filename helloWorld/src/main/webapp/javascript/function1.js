// sample2.js

function addNumber(n1, n2) {
  var sum = n1 + n2
  console.log(`합계는 ${sum}`)
}

addNumber(25, 30)

function showNumber(yourName, yourScore, yourBirth) {
  document.write(
    `<p>이름 : ${yourName}, 점수 : ${yourScore}, 출생연도 : ${yourBirth}</p>`
  )
}
document.write("showNumber Test ")
showNumber("홍길동", 80)
document.write("<br>")

// var yourName = "최씨냐"
// var yourScore = 88
// showNumber(yourName, yourScore)

function showInfo(yourName, birthYear) {
  var today = new Date()
  var age = today.getFullYear() - birthYear
  document.write(`${yourName} 은 올해 (만)${age}세 입니다.`)
}

var students = [
  {
    studentName: "홍길동",
    score: 80,
    birth: 2001,
  },
  {
    studentName: "김민수",
    score: 90,
    birth: 1990,
  },
  {
    studentName: "박이현",
    score: 85,
    birth: 1996,
  },
]

for (var student of students) {
  showNumber(student.studentName, student.score, student.birth)
  showInfo(student.studentName, student.birth)
}
