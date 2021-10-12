
document.getElementById("viewticket").addEventListener('click',getticketbyempid);

function getticketbyempid(){
	
		console.log("I'm in ticke");
	
		const BASE_EMPLOYEE_URL = "http://localhost:7000/viewpasttickets.html";
	   
		let xhttp = new XMLHttpRequest(); 
		xhttp.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				let responseObject = JSON.parse(this.responseText);
				console.log(responseObject);
				//console.log(responseObject.reimbursement_id);
				//console.log(responseObject.types[0].type.name);
				//console.log(responseObject.sprites.front_shiny);
				let rembobj = new rembobj(responseObject.rembid,
								responseObject.empid,
								responseObject.remamount,
								responseObject.fmid,
								responseObject.rembtypeid,
								responseObject.createdtime,
								responseObject.fmdescriptionid);
	
				addallticket(rembobj);
	
			}

		}
		xhttp.open("GET", BASE_EMPLOYEE_URL);
	
		xhttp.send();
	
	
	
		// DOMManipulation(pokeObject);
	}
function addRow(rem){
    //Append this onto my table, 
    
   
    let tableBody = document.getElementById("Reimbursment Ticket");

    //Creating a table row
    let tableRow = document.createElement("tr");

    //Create the columns
    let rembid = document.createElement("td");
    let empid = document.createElement("td");
    let approvedid = document.createElement("td");
    let remamount = document.createElement("td");
	let fmid = document.createElement("td");
    let rembtypeid = document.createElement("td");
    let createdtime = document.createElement("td");
    let description = document.createElement("td");




   // let deleteButtonColumn = document.createElement("td");
    //let deleteButton = document.createElement("button");

    
   // deleteButton.innerText = "DELETE";
    //deleteButton.setAttribute("id",planet.id);
   // deleteButton.addEventListener('click',deletePlanet);
    
    //deleteButtonColumn.appendChild(deleteButton);
    

    //assigning the "text value" to our columns 

    rembid.innerText = rembid;
    empid.innerText = empid;
    approvedid.innerText = approvedid;
    fmid.innerText = fmid;
	rembtypeid.innerText = rembtypeid;
    createdtime.innerText = createdtime;
    description.innerText = description;

    //attach the columns to our newly created row 
    tableRow.appendChild(rem.rembid);
	tableRow.appendChild(rem.empid);
	tableRow.appendChild(rem.approvedid);
	tableRow.appendChild(rem.fmid);
	tableRow.appendChild(rem.rembtypeid);
	tableRow.appendChild(rem.createdtime);
	tableRow.appendChild(rem.description);

    
    //attach the row itself to the table
    tableBody.appendChild(tableRow);
	
}

function addallticket(rembobj){
	
	for(let rem of rembobj){
		addRow(rem);
	}
}

// function viewpasttickets(){ 
	
// 	let planetsUrl = "http://localhost:7000/Menu";
	
// 	let xhttp = new XMLHttpRequest();
	
// 	xhttp.onreadystatechange = function (){ 
// 		//fat arrow notation does not support "this" keyword
		
// 		console.log(this.readyState);
		
// 		if(this.readyState == 4 && this.status == 200){
			
// 			let Pastticket = JSON.parse(this.responseText);
// 			console.log(Pastticket);
			
// 			addallticket(Pastticket);
			
// 		}
// 	}
	
// 	xhttp.open("GET",planetsUrl);
	
// 	xhttp.send();
	
// }
