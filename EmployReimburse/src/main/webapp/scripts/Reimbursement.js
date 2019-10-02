window.onload = function () {
    populateTable();

}

let allData =[];
let pending = [];
let approved = [];
let denied = [];
let myRT = document.getElementById('resolved');
let myPT = document.getElementById('pending');

function createEle(ele) {
    return document.createElement(ele); 
  }

  function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
  }

function populateTable() {
    fetch("http://localhost:8082/EmployReimburse/Rsession").then(function(response) {
		return response.json(); 
	}).then(function(data) {
        allData = data;
        console.log(allData);
        for(let i = 0; i < allData.length; i++) {
            if(allData[i].status == 0) {
                pending.push(allData[i]);
                console.log(pending);
            } else if(allData[i].status == 1) {
                approved.push(allData[i]);
            } else
                denied.push(allData[i]);
        }

        for(let i = 0; i < pending.length; i ++) {
            let myRow = createEle('tr');
            let myTab1 = createEle('td'); 
            let myTab2 = createEle('td'); 
            let myTab3 = createEle('td'); 
            
            myTab1.innerHTML = `Pending`;
            myTab2.innerHTML = `$ ${pending[i].amount}`;
            myTab3.innerHTML = `${pending[i].detail}`;

            addToEle(myRow, myTab1);
            addToEle(myRow, myTab2);
            addToEle(myRow, myTab3);
            addToEle(myPT, myRow);
        }

        for(let i = 0; i < approved.length; i ++) {
            let myRow = createEle('tr');
            let myTab1 = createEle('td'); 
            let myTab2 = createEle('td'); 
            let myTab3 = createEle('td'); 
            
            myTab1.innerHTML = `Approved`;
            myTab2.innerHTML = `$ ${approved[i].amount}`;
            myTab3.innerHTML = `${approved[i].detail}`;

            addToEle(myRow, myTab1);
            addToEle(myRow, myTab2);
            addToEle(myRow, myTab3);
            addToEle(myRT, myRow);
        }

        for(let i = 0; i < denied.length; i ++) {
            let myRow = createEle('tr');
            let myTab1 = createEle('td'); 
            let myTab2 = createEle('td'); 
            let myTab3 = createEle('td'); 
            
            myTab1.innerHTML = `Denied`;
            myTab2.innerHTML = `$ ${denied[i].amount}`;
            myTab3.innerHTML = `${denied[i].detail}`;

            addToEle(myRow, myTab1);
            addToEle(myRow, myTab2);
            addToEle(myRow, myTab3);
            addToEle(myRT, myRow);
        }
        
    })
    
}