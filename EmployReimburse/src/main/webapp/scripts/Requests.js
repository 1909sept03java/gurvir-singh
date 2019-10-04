window.onload = function () {
    populateTable();
    populateTable2();
    
    document.getElementById('retrieve').addEventListener("click", addEmployee);

}

let allData =[];
let myRT = document.getElementById('resolved');
let eData =[];
let myET = document.getElementById('employees');
let myDiv = document.getElementById('myEmployees');
let employData =[];

function createEle(ele) {
    return document.createElement(ele); 
  }

function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
  }

function replace(ele1, ele2, ele3) {
	return ele1.replaceChild(ele2, ele3);
}

function populateTable() {
    fetch("http://localhost:8082/EmployReimburse/resolvedSession").then(function(response) {
		return response.json(); 
	}).then(function(data) {
        allData = data;

        for(let i = 0; i < allData.length; i ++) {
            let myRow = createEle('tr');
            let myTab1 = createEle('td'); 
            let myTab2 = createEle('td'); 
            let myTab3 = createEle('td');
            let myTab4 = createEle('td'); 
            let myTab5 = createEle('td'); 
            
            myTab1.innerHTML = `${allData[i].username}`;
            myTab2.innerHTML = `${allData[i].status}`;
            myTab3.innerHTML = `$ ${allData[i].amount}`;
            myTab4.innerHTML = `${allData[i].detail}`;
            myTab5.innerHTML = `${allData[i].manager}`;

            addToEle(myRow, myTab1);
            addToEle(myRow, myTab2);
            addToEle(myRow, myTab3);
            addToEle(myRow, myTab4);
            addToEle(myRow, myTab5);
            addToEle(myRT, myRow);
        }
        
    })
    
}

function populateTable2() {
    fetch("http://localhost:8082/EmployReimburse/empManSession").then(function(response) {
		return response.json(); 
	}).then(function(data) {
        eData = data;

        for(let i = 0; i < eData.length; i ++) {
            let myRow = createEle('tr');
            let myTab1 = createEle('td'); 
            let myTab2 = createEle('td'); 
            
            myTab1.innerHTML = `${eData[i].employee}`;
            myTab2.innerHTML = `${eData[i].manager}`;

            addToEle(myRow, myTab1);
            addToEle(myRow, myTab2);
            addToEle(myET, myRow);
        }
        
    })
    
}

function addEmployee() {
	let myT = document.getElementById('replaceT');
	myDiv.removeChild(myT);
	let empId =[];
    fetch("http://localhost:8082/EmployReimburse/myEmployees").then(function(response) {
		return response.json(); 
	}).then(function(data) {
        employData = data;
        let inspect = document.getElementById('myId').value; 
        
        for(let i = 0; i < employData.length; i ++) {
        	if(employData[i].id == inspect) {
        		empId.push(employData[i]);
        	}
        		
        }
        
	    let tabl = createEle('table');
	    tabl.setAttribute('id', 'replaceT');
	    tabl.setAttribute('class', 'table table-striped table-dark')
	    let firstR = createEle('tr');
	    let th1 = createEle('th')
	    let th2 = createEle('th')
	    let th3 = createEle('th')
 	    let th4 = createEle('th')  
 	    th1.innerHTML = `Username`;
 	    th2.innerHTML = `Status`;
 	    th3.innerHTML = `Amount`;
 	    th4.innerHTML = `Details`;
 	    addToEle(firstR, th1);
 	    addToEle(firstR, th2);
 	    addToEle(firstR, th3);
 	    addToEle(firstR, th4);
 	    addToEle(tabl, firstR);

       for(let i = 0; i < empId.length; i ++) {
            let myRow = createEle('tr');
            let myTab1 = createEle('td'); 
            let myTab2 = createEle('td');
            let myTab3 = createEle('td');
            let myTab4 = createEle('td');
            
            myTab1.innerHTML = `${empId[i].username}`;
            myTab2.innerHTML = `${empId[i].status}`;
            myTab3.innerHTML = `$ ${empId[i].amount}`;
            myTab4.innerHTML = `${empId[i].detail}`;

            addToEle(myRow, myTab1);
            addToEle(myRow, myTab2);
            addToEle(myRow, myTab3);
            addToEle(myRow, myTab4);            
            addToEle(tabl, myRow);
        } 
       
       addToEle(myDiv, tabl);
        
    })	
}