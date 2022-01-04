// basic.js

// 선언되지 않은 변수를 체크해주는 구문
'use strict';

var v1;
var name1 = "Hong";
v1 = "FIRST world";
v1 = "SECOND world";
v1 = 'nice "world"';
v1 = "nice" + name1;
v1 = `nice, ${name1}`;

v1 = 100;

v1 = 3.14;

var v2 = 10;

var result = v1 + v2;

var trueOrFalse = true;
trueOrFalse = 10 < 20;
trueOrFalse = 10; // 0, null, undefined, '' 아무 값도 들어가 있지 않다!

if (trueOrFalse) {
    console.log("TRUE 입니다")
} else {
    console.log("FALSE 또는 값이 없습니다.")
}

var str = "<ul>";
str += "<li>Apple</li>";
str += "<li>Banana</li>";
str += "<li>Cherry</li>";
str += "</ul>";

// var 변수선언
var num1 = 10;
// var이 없어도 선언은 가능하나 오류를 유발할 수 있음
var num3 = 30; 
console.log("DECLAIRE num1 : " + num1);

function f1() {
    num1 = 20;
    num3 = 40;
    console.log("FUNC num1 : " + num1);
    console.log("FUNC num3 : " + num3);
}

f1();

console.log("FINAL num1 : " + num1); // function이 끝나면 값이 초기화 됨
console.log("FINAL num3 : " + num3);

console.log(v1);
console.log(typeof v1); 

console.log(result);
console.log(typeof result);


console.log(trueOrFalse);
console.log(typeof trueOrFalse);

console.log(str);
console.log(typeof str);

document.write(str);