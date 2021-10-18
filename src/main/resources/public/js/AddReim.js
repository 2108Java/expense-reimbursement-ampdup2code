


const url = "http://localhost:7000/TOREIMBURSMENT"
document.getElementById("addRembSubmit").addEventListener("click", addreimb);

// function addreimb1(){
//     console.log("it is called");
//     console.log("asdfhjjhgfdshgfds");
// }
async function addreimb(){
    console.log("it is called");

    let amount = document.getElementById("amount").value;
   
    //var cate = e.options[e.selectedIndex].value;

    let sel = document.getElementById("category");
    let cate= sel.options[sel.selectedIndex].value;
    




   // let Cate = document.getElementById("Category").value;
   // let cate = "Lodging";


    let description = document.getElementById("description").value;
    console.log("amount");
    console.log("type");
    console.log("description");


	if (cate=="Lodging"){
		type = 1;
	}else if (cate=="Travel"){
		type = 2;
	}else if (cate=="Food"){
		type = 3;
    }else{
		 type =4;
	}
    console.log("type ="+type);

    
    let reim = {
        remamount: amount,
        rembtypeid: type,
        description: description
    };

    console.log(reim);

   
//we are senf=ding to java
    let response = fetch(url, {
        method: 'POST',
        body: JSON.stringify(reim)
        });



    console.log(response.status);

    if(response.status === 200){
        let res = document.getElementById("form-response");
        res.setAttribute("style", "color:green;");
        res.innerHTML = "Reimbursment successfuly added.";
    } else {
        let res = document.getElementById("form-response");
        res.setAttribute("style", "color:red;");
        res.innerHTML = "Reimbursment not added.";
    }
}