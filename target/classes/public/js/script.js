
  
window.onload = getallticket;

		

async function getallticket(){
	
		const BASE_FINANCE_URL = "http://localhost:7000/VIEWPASTTICKETFILL";
		
			const response = await fetch(BASE_FINANCE_URL);
			    
				if( response.status === 200){
					
					const remtickobj = await response.json();
					addallticket(remtickobj);
		
				}
	
			}


function addallticket(rembobj){
	
	for(let rem of rembobj){
		addRowf(rem);
	}
}


function addRowf(rem){
    //Append this onto my table, 
    
   
    let tableBody = document.getElementById("rembTableBody");

    //Creating a table row
    let tableRow = document.createElement("tr");

    //Create the columns

    let rembid = document.createElement("td");
    let approvedid = document.createElement("td");
	let rembtypeid = document.createElement("td");
    let remamount = document.createElement("td");
	let createdtime = document.createElement("td");
    let description = document.createElement("td");
	
	let type;
	if (rem.rembtypeid===1){
		type ="Lodging";
	}else if (rem.rembtypeid===2){
		 type ="Travel";
	}else if (rem.rembtypeid===3){
		type ="Food";}
	else{
		 type ="Other";
	}

	let approved;
	if (rem.approvedid===1){
		approved ="Pending";
	}else if (rem.approvedid===2){
		 approved ="Approved";
	}else{
		 approved ="Rejected";
	}
	
    rembid.innerText = rem.rembid;
    approvedid.innerText = approved;
	rembtypeid.innerText = type;
	remamount.innerText =rem.remamount;
    createdtime.innerText = Date(rem.createdtime);
    description.innerText = rem.description;

    //attach the columns to our newly created row 
    tableRow.appendChild(rembid);
	tableRow.appendChild(approvedid);
	tableRow.appendChild(rembtypeid);
	tableRow.appendChild(remamount);
	tableRow.appendChild(createdtime);
	tableRow.appendChild(description);

    
    //attach the row itself to the table
    tableBody.appendChild(tableRow);
	
}