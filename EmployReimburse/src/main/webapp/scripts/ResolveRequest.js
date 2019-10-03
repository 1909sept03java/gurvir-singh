window.onload = function () {
    populateTable();

}

let requests =[];
let myDiv = document.getElementById('unResolved');

function createEle(ele) {
    return document.createElement(ele); 
  }

  function addToEle(ele1, ele2) {
    return ele1.appendChild(ele2); 
  }

function populateTable() {
    fetch("http://localhost:8082/EmployReimburse/myResolve").then(function(response) {
		return response.json(); 
	}).then(function(data) {
        requests = data;
        console.log(requests);

        for(let i = 0; i < requests.length; i ++) {
        	let d = createEle("div");
        	d.setAttribute("class", "myForms1");
        	let h = createEle("h4");
        	h.innerHTML = `Approve or Deny Request`;
        	
        	let p = createEle("p");
        	let span1 = createEle("span");
        	let span2 = createEle("span");
        	span1.innerHTML = `Amount $ ${requests[i].amount} `;
        	span2.innerHTML = `Details: ${requests[i].detail} `;
            
            let myForm = createEle('form');
            myForm.setAttribute('action', 'resolve');
            myForm.setAttribute('method', 'POST');
            let ho = createEle("Input");
            ho.setAttribute("type", "hidden");
            ho.setAttribute("name", "reimburseId");
            ho.setAttribute("value", requests[i].reimburseId);            
            let s3 = createEle("span");
            s3.innerHTML = `Approve `;
            let o1 = createEle("input");
            o1.setAttribute("type", "radio");
            o1.setAttribute("name", "option");
            o1.setAttribute("value", "Approve");
            let s4= createEle("span");
            s4.innerHTML = `Deny `;
            let o2 = createEle("input");
            o2.setAttribute("type", "radio");
            o2.setAttribute("name", "option");
            o2.setAttribute("value", "Deny");
            let s = createEle("input");
            s.setAttribute("type", "submit");
            s.setAttribute("value", "submit");
            
            addToEle(d, h);
            addToEle(p, span1);
            addToEle(p, span2);
            addToEle(d, p);
            addToEle(myForm, ho);
            addToEle(myForm, s3);
            addToEle(myForm, o1);
            addToEle(myForm, s4);
            addToEle(myForm, o2);
            addToEle(myForm, s);
            addToEle(d, myForm);
            addToEle(myDiv, d);
        }
        
    })
    
}