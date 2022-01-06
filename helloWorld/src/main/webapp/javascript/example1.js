// example1.js

const students = [
  {
    fullName: "류지희",
    studNo: "1001",
    score: 80,
  },
  {
    fullName: "차주연",
    studNo: "1002",
    score: 60,
  },
  {
    fullName: "전호민",
    studNo: "1003",
    score: 90,
  },
]

students.push({ fullName: "홍정우", studNo: "1004", score: 88 })

students.unshift({ fullName: "고권영", studNo: "1005", score: 90 })

document.write("<ul>")
students.forEach(liFnc) // callback function
document.write("</ul>")

function liFnc(item) {
  document.write(`<li>${item.studNo} - ${item.fullName} - ${item.score}</li>`)
}

const numAry = [1, 2, 3]
numAry.push(4)
numAry.push(10)
numAry.unshift(40)
// numAry[3] = 4
// numAry[numAry.length] = 10
// numAry[numAry.length] = 20
console.log(numAry)
