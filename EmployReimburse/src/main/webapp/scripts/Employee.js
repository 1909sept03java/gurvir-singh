let employ = {};

window.onload = function() {
	populateEmployeeInfo();
}

function populateEmployeeInfo() {
	fetch("http://localhost:8082/EmployReimburse/Session").then(function(response) {
		return response.json(); 
	}).then(function(data) {
		if(data.session === null) {
			window.location = "http://localhost:8082/EmployReimburse/login"
		} else {
			employ = data;
			document.getElementById("username").innerText = employ.username;
			document.getElementById("email").innerText = employ.email;
        }
        
    })
    
}