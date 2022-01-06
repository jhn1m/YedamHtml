// sample1.js
"use strict"
var memNum = window.prompt("입장객은 몇명?")
var colNum = window.prompt("한 줄에 앉을 사람?")

// 56명, 5명씩
document.write(`<div id = "chair">`)
document.write(`입장객은 ${memNum}명 입니다.`)
document.write(`한 줄에 ${colNum}명씩 앉아주세요.`)
document.write(`<br>`)
document.write("<h2>좌석표시</h2>")
for (var i = 1; i <= memNum; i++) {
  for (var j = 1; j <= colNum; j++) {
    document.write(`<p>${i}열 - ${j}번</p>`)
    if (j % colNum == 0) {
      document.write(`<br>`)
    }
  }
}

document.write("</div>")
// 교수님 풀이
// memNum / colNum = 나눈 값이 라인의 수
/*
var cnt = 0;
var rowNum = Math.ceil(memNum / colNum); 올림
for(var i =1; i <= memNum; i++){
    for(var j = 1; j <= colNum; j++){
        document.write(`<span> 좌석 ${i} - ${j} </span>`);
        cnt++
        console.log(cnt,memNum);
        if(cnt == memNum){
            break;
        }
    }
    document.write("<br>");
}
document.write();
*/
