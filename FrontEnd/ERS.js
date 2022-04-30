const url = "http://localhost:3000"; // putting base url in variable for cleaner code below
// eventually, we'll use this in our fetch request and make calls into our server by appending endpoints

// add an event listener to give our button functionality
// if get user button gets clicked , execute the getUsers function
document.getElementById("getUsersButton").addEventListener("click", getUsers);
document.getElementById("loginButton").addEventListener("click", loginFunction);

// getUsers is an async function which has a fetch request to get employees from our server
// remember, async makes a function return a promise (which fetch requests return)
async function getUsers() {

    // we will send a fetch request to get out user data
    let response = await fetch(url + "/users");

    console.log(response);

    if(response.status === 200) { // if the response has a status code of 200 ...
        //parse JSON into JS object
        let data = await response.json();

        // log the actual user data thats been parsed from JSON (good for debugging)
        for(let user of data) {

            // create table row
            let row = document.createElement("tr");

            let cell = document.createElement("td")
            cell.innerHTML = user.user_id
            row.appendChild(cell)

            let cell2 = document.createElement("td");
            cell2.innerHTML = user.username;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = user.password;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = user.first_name;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = user.role.user_role_id;
            row.appendChild(cell5);

            // append tr which we called "row" to the table body (tbody)
            // new row appended for every user that got returned in the fetch

            document.getElementById("userBody").appendChild(row);

        }




    }  else {
        alert("uh oh your request failed for some reason :(")
    }

}

// this function will send the user inputted login credentials to our server
async function loginFunction(){
    
}