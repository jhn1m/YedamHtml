// basic.js

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


console.log(v1);
console.log(typeof v1); 

console.log(result);
console.log(typeof result);


console.log(trueOrFalse);
console.log(typeof trueOrFalse);

console.log(str);
console.log(typeof str);

document.write(str);