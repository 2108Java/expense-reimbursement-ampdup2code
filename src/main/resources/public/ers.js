/**
 * 
 */
 
 //window.onload = getAllPlanets;
 function viewReimbursment(){ //getting all the planets
	
	

	let reimbUrl = "http://localhost:8000/Reimbursment";
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function (){ 
		//fat arrow notation does not support "this" keyword
		
		console.log(this.readyState);
		
		if(this.readyState == 4 && this.status == 200){
			
			let reimbArray = JSON.parse(this.responseText);
			console.log(reimbArray);
			
			addAllPlanets(reimbArray);
			
		}
	}
	
	xhttp.open("GET",reimbUrl);
	
	xhttp.send();
	
}
 
 
 
 function getAllPlanets(){ //getting all the planets
	
	

	let planetsUrl = "http://localhost:8000/api/planet";
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function (){ 
		//fat arrow notation does not support "this" keyword
		
		console.log(this.readyState);
		
		if(this.readyState == 4 && this.status == 200){
			
			let planetArray = JSON.parse(this.responseText);
			console.log(planetArray);
			
			addAllPlanets(planetArray);
			
		}
	}
	
	xhttp.open("GET",planetsUrl);
	
	xhttp.send();
	
}

function addRow(planet){
    //Append this onto my table, 
    
   
    let tableBody = document.getElementById("planetTableBody");

    //Creating a table row
    let tableRow = document.createElement("tr");

    //Create the columns
    let idColumn = document.createElement("td");
    let nameColumn = document.createElement("td");
    let descColumn = document.createElement("td");
    let ringsColumn = document.createElement("td");
    let deleteButtonColumn = document.createElement("td");
    let deleteButton = document.createElement("button");
    
    
    deleteButton.innerText = "DELETE";
    deleteButton.setAttribute("id",planet.id);
    deleteButton.addEventListener('click',deletePlanet);
    
    deleteButtonColumn.appendChild(deleteButton);
    

    //assigning the "text value" to our columns 

    idColumn.innerText = planet.id;
    nameColumn.innerText = planet.name;
    descColumn.innerText = planet.description;
    ringsColumn.innerText = planet.rings;

    //attach the columns to our newly created row 
    tableRow.appendChild(idColumn);
    tableRow.appendChild(nameColumn);
    tableRow.appendChild(descColumn);
    tableRow.appendChild(ringsColumn);
    tableRow.appendChild(deleteButtonColumn);

    //attach the row itself to the table
    tableBody.appendChild(tableRow);
	
}

function addAllPlanets(planetArray){
	
	for(let planet of planetArray){
		addRow(planet);
	}
}

function deletePlanet(event){
	console.log("delete planet");
	
	console.log(event.srcElement.id);
	
	
	let url = "http://localhost:8000/planet/" + event.srcElement.id;
	
	console.log(url);
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function (){ 
		//fat arrow notation does not support "this" keyword
		
		console.log(this.readyState);
		
		if(this.readyState == 4 && this.status == 200){

			//resetTables();			

			getAllPlanets();
			
		}
	}
	
	xhttp.open("DELETE",url);
	
	xhttp.send();
};


