// basic2.js

"use strict"

var fruits = ["Apple", "Banana", "Cherry"]

// document.write("<ul>");
str += "<ul>"
for (var i = 0; i < fruits.length; i++) {
  console.log(fruits[i])
  // str += "<li>" + fruits[i] + "</li>";
  str += `<li>${fruits[i]}</li>`
  // document.write("<li>" + fruits[i] + "</li>");
}

str += "</ul>"

// document.write("</ul>");

document.write(str)

// 10 + "20" : 1020 문자열이 있으면 모두를 문자열으로 인식
var numbers = [10, "20", 30, 40]

var sum = 0
console.log(numbers.length)
for (var i = 0; i < numbers.length; i++) {
  // Integer.parseInt("30")
  sum += parseInt(numbers[i])
}

console.log(`합계 : ${sum}`)

// var s1Name = "Hong";
// var s1Age = 20;
// var s1Score = 80;

var student1 = {
  name: "Hong",
  age: 20,
  score: 80,
}

// for .. in : object의 필드 속성을 반복.
for (var field in student1) {
  console.log(field, student1[field])
}

// console.log(student1.name);
// console.log(student1.age);
// console.log(student1.score);

// console.log(`name => ${student1.name}`);
// // console.log(`age => ${student1.age}`);
// console.log(`age => ${student1["age"]}`);
// console.log(`score => ${student1.score}`);

var student2 = {
  name: "Kim",
  age: 22,
  score: 50,
}

var student3 = {
  name: "Lee",
  age: 27,
  score: 40,
}

var students = [student1, student2, student3]

str = ""
str += '<table border = "1">'
str += "<thead><tr>"
for (var field in student1) {
  str += `<th>${field}</th>`
}
str += "</tr></thead>"
str += "<tbody>"
for (var i = 0; i < students.length; i++) {
  var field = "score"
  console.log(`${i + 1}번째 name => ${students[i].name}`)
  console.log(`${i + 1}번째 age => ${students[i]["age"]}`)
  console.log(`${i + 1}번째 score => ${students[i].score}`)
  str += "<tr>"
  for (var field in student1) {
    str += `<td>${students[i][field]}</td>`
  }
  str += "</tr>"
}
str += "</tbody></table>"
document.write(str)
