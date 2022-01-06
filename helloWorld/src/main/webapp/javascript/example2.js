// example2.js

let datas = `
[{"id":1,"first_name":"Dayle","last_name":"Morcombe","email":"dmorcombe0@oracle.com","gender":"Male"},
{"id":2,"first_name":"Megen","last_name":"Northey","email":"mnorthey1@who.int","gender":"Female"},
{"id":3,"first_name":"Estell","last_name":"Messent","email":"emessent2@odnoklassniki.ru","gender":"Male"},
{"id":4,"first_name":"Yetty","last_name":"Garrad","email":"ygarrad3@ask.com","gender":"Male"},
{"id":5,"first_name":"Clari","last_name":"Phifer","email":"cphifer4@globo.com","gender":"Male"},
{"id":6,"first_name":"Binky","last_name":"Moakson","email":"bmoakson5@com.com","gender":"Male"},
{"id":7,"first_name":"Case","last_name":"Yeaman","email":"cyeaman6@parallels.com","gender":"Female"},
{"id":8,"first_name":"Zebulen","last_name":"Tramel","email":"ztramel7@phoca.cz","gender":"Male"},
{"id":9,"first_name":"Jessa","last_name":"Rosentholer","email":"jrosentholer8@google.co.uk","gender":"Male"},
{"id":10,"first_name":"Rozelle","last_name":"Colkett","email":"rcolkett9@cam.ac.uk","gender":"Female"},
{"id":11,"first_name":"Spenser","last_name":"Beekman","email":"sbeekmana@alibaba.com","gender":"Female"},
{"id":12,"first_name":"Sully","last_name":"Petett","email":"spetettb@tuttocitta.it","gender":"Male"},
{"id":13,"first_name":"Sloan","last_name":"Mollatt","email":"smollattc@reverbnation.com","gender":"Female"},
{"id":14,"first_name":"Dolf","last_name":"Langlands","email":"dlanglandsd@google.cn","gender":"Female"},
{"id":15,"first_name":"Addison","last_name":"Connew","email":"aconnewe@cpanel.net","gender":"Female"}]
`
let employees = JSON.parse(datas)
console.log(employees)

document.write(`<table border = "1">`)
document.write(
  `<thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Gender</th></tr></thead>`
)
document.write("<tbody>")
employees.forEach((item, ind) => {
  console.log(item.id, item.first_name, item["last_name"], item["gender"])
  document.write(
    `<tr><td>${item.id}</td><td>${
      item.first_name + " " + item.last_name
    }</td><td>${item.email}</td>
    <td>${item.gender}</td>`
  )
})
document.write(`</table>`)

let firstNames = []

employees.forEach(function (item, ind) {
  firstNames.push(item.first_name)
})

console.log(firstNames)
