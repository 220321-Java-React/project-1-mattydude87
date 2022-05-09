const url = "http://localhost:5000"; // putting base url in variable for cleaner code below
// eventually, we'll use this in our fetch request and make calls into our server by appending endpoints

document.getElementById("getReimbRequests").addEventListener("click", getReimbursementRequests);
document.getElementById("getAllReimbursements").addEventListener("click", getReimbursements);
document.getElementById("logout").addEventListener("click", logout)

async function logout() {
    window.location.href = url + 'ERS.html'
}

// getUsers is an async function which has a fetch request to get employees from our server
// remember, async makes a function return a promise (which fetch requests return)
async function getReimbursementRequests() {

    // we will send a fetch request to get out user data
    let response = await fetch(url + "/reimbursement/requests");
    document.getElementById("reimbRequestsBody").innerHTML = "";
    console.log(response);

    if(response.status === 200) { // if the response has a status code of 200 ...
        //parse JSON into JS object
        let reimbursementRequests = await response.json();

        // log the actual user data thats been parsed from JSON (good for debugging)
        for(let reimbursement of reimbursementRequests) {

            // create table row
            let row = document.createElement("tr");

            let cell = document.createElement("td");
            cell.innerHTML = reimbursement.reimb_id;
            row.appendChild(cell)

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.date_submitted;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.description
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursement.status_id_fk ? reimbursement.status_id_fk.reimb_status : '';
            row.appendChild(cell5);

            // append tr which we called "row" to the table body (tbody)
            // new row appended for every user that got returned in the fetch

            document.getElementById("reimbRequestsBody").appendChild(row);

        }




    }  else {
        alert("uh oh your request failed for some reason :(")
    }
}

    async function getReimbursements() {

        // we will send a fetch request to get out user data
        let response = await fetch(url + "/reimbursements");
        document.getElementById("reimbRequestsBody").innerHTML = "";
        console.log(response);
    
        if(response.status === 200) { // if the response has a status code of 200 ...
            //parse JSON into JS object
            let reimbursements = await response.json();
    
            // log the actual user data thats been parsed from JSON (good for debugging)
            for(let reimbursement of reimbursements) {
    
                // create table row
                let row = document.createElement("tr");
    
                let cell = document.createElement("td");
                cell.innerHTML = reimbursement.reimb_id;
                row.appendChild(cell)
    
                let cell2 = document.createElement("td");
                cell2.innerHTML = reimbursement.amount;
                row.appendChild(cell2);
    
                let cell3 = document.createElement("td");
                cell3.innerHTML = reimbursement.date_submitted;
                row.appendChild(cell3);
    
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimbursement.description
                row.appendChild(cell4);
    
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimbursement.status_id_fk ? reimbursement.status_id_fk.reimb_status : '';
                row.appendChild(cell5);
    
                // append tr which we called "row" to the table body (tbody)
                // new row appended for every user that got returned in the fetch
    
                document.getElementById("reimbRequestsBody").appendChild(row);
    
            }
    
    
    
    
        }  else {
            alert("uh oh your request failed for some reason :(")
        }

}