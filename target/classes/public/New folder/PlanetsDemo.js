/**
 * 
 */
 
function getPlanet(){ //getting a single planet
	
}

function getAllPlanets(){ //getting all the planets
	
	

	let planetsUrl = "http://localhost:8000/planets";
	
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

let button = document.getElementById("planetSubmit");
button.addEventListener('click',getAllPlanets);

window.onload = function(){

	getAllPlanets();
	
//This functions get invoked when the page is loaded in!
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

    //attach the row itself to the table
    tableBody.appendChild(tableRow);
	
}

function addAllPlanets(planetArray){
	
	for(let planet of planetArray){
		addRow(planet);
	}
	
	
}