// control.js

var num = window.prompt("점수를 입력하세요.")
var grade = ""
if (num > 100) {
  document.write("점수가 잘못 입력되었습니다.")
} else if (num > 94) {
  grade = "A+"
} else if (num > 90) {
  grade = "A"
} else if (num > 84) {
  grade = "B+"
} else if (num > 80) {
  grade = "B"
} else if (num > 74) {
  grade = "C+"
} else if (num > 70) {
  grade = "C"
} else if (num > 64) {
  grade = "D+"
} else if (num > 60) {
  grade = "D"
} else {
  grade = "F"
}

// num = parseInt(num / 10)
// switch (num) {
//   case 9:
//     grade = "A"
//   case 8:
//     grade = "B"
//   case 7:
//     grade = "C"
//   case 6:
//     grade = "D"
//   default:
//     grade = "F"
// }

// console.log(`등급은 ${grade} 입니다.`)
document.write(`점수는 ${num}점 이고 등급은 ${grade}입니다.`)
