window.onload = function () {
    document.getElementById("fetchUsers").addEventListener("click", getRandomUsers);
}

let apiUrl = 'https://randomuser.me/api/?results=25';
let state = { users: '' };
let ul = document.getElementById('randomUser');
let myDiv = document.getElementById('container');
let myTable = document.getElementById('myTable');
let age = 0;

function createEle(ele) {
    return document.createElement(ele); 
  }

  function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
  }

  function getRandomUsers() {
    fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}})

    .then((response) => {
        let data = response.json();
        return data;

    }) 

    .then(function(data) {
        let users = data.results; 
        //console.log(users);
        let uLength = users.length;
        let myRow = createEle('tr'); 
        addToEle(myTable, myRow);
        for(let i = 0; i < users.length; i++) { 
        let myTab = createEle('td'); 
        let img = createEle('img');
        let p = createEle('p');
        img.src = users[i].picture.thumbnail; 
        p.innerHTML = `Name: ${users[i].name.first} ${users[i].name.last} Age: ${users[i].dob.age}`; 

        if( i % 4 !== 0) {
            addToEle(myTab, img);
            addToEle(myTab, p);
            addToEle(myRow, myTab);

        } else {
            myRow = createEle.apply('tr');
            addToEle(myTable, myRow);
            addToEle(myTab, img);
            addToEle(myTab, p);
            addToEle(myRow, myTab);

        }
        //console.log(rUser.dob.age);
        age = age + users[i].dob.age
        //console.log(age);
      }
        //console.log(uLength);
        let avg = age / uLength;
        let p2 = createEle('p');
        p2.innerHTML = `Average Age of Users: ${avg}`;
        addToEle(myDiv, p2);

    })

  }