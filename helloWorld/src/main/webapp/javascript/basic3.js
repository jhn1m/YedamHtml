// basic3.js

"use strict"

var member1 = {
  memberId: 1001,
  memberName: "홍길동",
  memberPhone: "010-1111-1111",
  memberAddr: "DAEGU 1",
}

var member2 = {
  memberId: 1002,
  memberName: "동길홍",
  memberPhone: "010-2222-2222",
  memberAddr: "SEOUL 1",
}

var member3 = {
  memberId: 1003,
  memberName: "길홍동",
  memberPhone: "010-3333-3333",
  memberAddr: "DAEGU 2",
}

var member4 = {
  memberId: 1004,
  memberName: "동홍길",
  memberPhone: "010-4444-4444",
  memberAddr: "SEOUL 2",
}

var members = [member1, member2, member3, member4]
var str = ""
// for (var field in members) {
//   document.write(members[field].memberId + "&nbsp")
//   document.write(members[field].memberName + "&nbsp")
//   document.write(members[field].memberPhone + "&nbsp")
//   document.write(members[field].memberAddr + "<br>")
// }

str += '<table id = "tbl" border = "1">'
str += "<thead><tr>"
for (var field in member1) {
  str += `<th>${field}</th>`
}
str += "</tr></thead>"
str += "<tbody>"
// for (String str : strings) { }
for (var member of members) {
  str += "<tr>"
  for (var field in member) {
    str += `<td>${member[field]}</td>`
  }
  str += "</tr>"
}
str += "</tbody></table>"

document.write(str)

// string, number, boolean, array, object

// null, undefined
