// control.js

var num = window.prompt("점수를 입력하세요.")
var grade = ""
if (num > 90) {
  grade = "A"
} else if (num > 80) {
  grade = "B"
} else if (num > 70) {
  grade = "C"
} else if (num > 60) {
  grade = "D"
} else {
  grade = "F"
}

// console.log(`등급은 ${grade} 입니다.`)
document.write(`점수는 ${num}점 이고 등급은 ${grade}입니다.`)
