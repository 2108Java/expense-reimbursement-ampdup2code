
  
window.onload = getallpending;
	

async function getallpending(){
	
		const BASE_FINANCE_URL = "http://localhost:7000/VIEWFINANCEDETAIL";
		
			const response = await fetch(BASE_FINANCE_URL);
			   
				if( response.status === 200){
					
					const remtickobj = await response.json();
                    console.log(remtickobj);
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
    
   
    let tableBody = document.getElementById("finview");

    //Creating a table row
    let tableRow = document.createElement("tr");

    //Create the columns

    let rembid = document.createElement("td");
    let approvedid = document.createElement("td");
	let rembtypeid = document.createElement("td");
    let remamount = document.createElement("td");
	let createdtime = document.createElement("td");
    let description = document.createElement("td");


    let approveButtonColumn = document.createElement("td");
    let approveButton = document.createElement("button");
    approveButton.innerText = "Approve";
    approveButton.setAttribute("id",rem.rembid);
   // approveButton.setAttribute("class","btn btn-success" );
    approveButton.addEventListener('click',approverem);

   let rejButtonColumn = document.createElement("td");
   let rejButton = document.createElement("button");
   rejButton.innerText = "Reject";
   rejButton.setAttribute("id",rem.rembid);
  // rejButton.setAttribute("class","btn btn-danger" );
  rejButton.addEventListener('click',approverem);

  
  



	
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
	var s = new Date(rem.createdtime).toLocaleDateString("en-US");
    createdtime.innerText = s;
    description.innerText = rem.description;
    tableRow.appendChild(rembid);
	tableRow.appendChild(approvedid);
	tableRow.appendChild(rembtypeid);
	tableRow.appendChild(remamount);
	tableRow.appendChild(createdtime);
	tableRow.appendChild(description);

    //deleteButtonColumn.appendChild(deleteButton);
    tableRow.appendChild(approveButton);
    tableRow.appendChild(rejButton);
    tableBody.appendChild(tableRow);
	
}

function approverem(){

}