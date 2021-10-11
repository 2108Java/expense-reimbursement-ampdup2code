function displayRowCount(tableId) {
    tableData = document.getElementById(tableId);
    let totalNumOfRows = tableData.rows.length - 1;
    console.log(totalNumOfRows);
    return `You have ${totalNumOfRows} tickets open`;
}

document.getElementById("ticket-greeting").innerHTML = displayRowCount("e-reimbursement");