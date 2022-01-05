// string1.js

"use strict"

var h3Tag = document.querySelector("h3")
var text = h3Tag.innerHTML
var str = text.substring(2, 10)
text = text.substring(2, 6)
var elem = document.getElementById("show")
// elem.innerHTML = "<h3>Hello</h3>"
elem.innerText = text
console.log(elem)
