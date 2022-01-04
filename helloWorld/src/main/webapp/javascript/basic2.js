// basic2.js

var fruits = ["Apple", "Banana", "Cherry"];

// document.write("<ul>");
str += "<ul>";
for (var i = 0; i <fruits.length; i++){
    console.log(fruits[i]);
    // str += "<li>" + fruits[i] + "</li>";
    str += `<li>${fruits[i]}</li>`;
    // document.write("<li>" + fruits[i] + "</li>");
}

str += "</ul>";

// document.write("</ul>");

document.write(str);