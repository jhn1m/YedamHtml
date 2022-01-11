// map.js

"use strict"
const fields = [
  "id",
  "centerName",
  "address",
  "phoneNumber",
  "sido",
  "sigungu",
  "map",
]
function showCenterList(data) {
  // 전체 카운트 : data.currentCount : 284
  // 현재 페이지 : data.page : 1
  // 전체 데이터 : data.data : 284건의 접종센터 정보

  // table 요소가 있으면 삭제

  if (document.getElementById("tbl")) {
    document.getElementById("tbl").remove()
  }

  let table = document.createElement("table")
  table.setAttribute("border", "1")
  table.setAttribute("id", "tbl")
  let thead = document.createElement("thead")
  let tbody = document.createElement("tbody")

  // table의 하위요소로 thead, tbody 추가
  table.append(thead, tbody)

  // thead 작성
  let tr = document.createElement("tr")
  fields.forEach(function (field) {
    let td = document.createElement("th")
    let text = document.createTextNode(field.toUpperCase())
    td.append(text)
    tr.append(td)
  })
  thead.append(tr)

  // tbody 작성
  data.forEach(function (item) {
    let tr = document.createElement("tr")
    fields.forEach(function (field) {
      // map => link 생성
      if (field == "map") {
        let linkTag = document.createElement("a")
        linkTag.setAttribute(
          "href",
          `daum.html?lat=${item.lat}&lng=${item.lng}&facility=${item.facilityName}`
        )
        linkTag.setAttribute("target", "_blank")
        linkTag.innerText = item.centerName

        let td = document.createElement("td")
        td.appendChild(linkTag)
        tr.append(td)
      } else {
        let td = document.createElement("td")
        let text = document.createTextNode(item[field])
        td.append(text)
        tr.append(td)
      }
    })
    tbody.append(tr)
  })

  document.getElementById("show").append(table)
}

// 시도별로 센터정보 보여주기
function showCenterListBySido(data) {
  //data.totalCount, data.page, data.data
  let centers = data.data
  // 시도 => 정보생성
  let filteredCenter = [] // 시 도 이름,, 중복값 제거
  centers.forEach(function (item) {
    // filteredCenter 값 중에서 item.sido 같은 값이 없으면 추가.
    // 값이 없으면 -1 리턴
    if (filteredCenter.indexOf(item.sido) == -1) {
      filteredCenter.push(item.sido)
    }
    console.log(filteredCenter)
  })
  // 버튼생성
  let show = document.getElementById("show")
  filteredCenter.forEach(function (centerName) {
    let btn = document.createElement("button")
    btn.innerText = centerName
    btn.addEventListener("click", showSidoList)
    show.appendChild(btn)
  })

  function showSidoList() {
    // 서울특별시 => 서울특별시 소속의 센터출력.
    console.log(this.innerText)
    let searchCenterName = this.innerText
    let filterAry = centers.filter(function (item) {
      return item.sido == searchCenterName
    })
    console.log(filterAry)
    showCenterList(filterAry)
  }
}

// Asynchoronous Javascript And Xml(ajax)
// perPage = 가져올 데이터 건 수
let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=N%2FyDCz6DnRrV45AM81yqvJ9T0C1jPO6x8V8bh1ZUPRwTHQg9C%2B3vOgc6%2FtZcvfaQAwypSKSxXNUW2cpmJBqoZA%3D%3D`
let xhtp = new XMLHttpRequest()
xhtp.onreadystatechange = function () {
  //readyState 1, 2, 3은 준비중을 뜻함
  if (xhtp.readyState == 4 && xhtp.status == 200) {
    console.log("readyState : " + xhtp.readyState)
    console.log("status : " + xhtp.status)
    let data = JSON.parse(xhtp.responseText)
    // {currentCount : 284, data : [{}{}{}]
    // console.log(data)

    // makePage(data)
    // showCenterList(data.data)
    showCenterListBySido(data)
  }
}

xhtp.open("get", url)
xhtp.send()
