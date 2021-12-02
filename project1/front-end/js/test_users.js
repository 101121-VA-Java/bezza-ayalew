let token = sessionStorage.getItem("token");
// let userUrl = 'http://localhost:7000/ersUsers';
// let reimbUrl = 'http://localhost:7000/reimbursements';

if (!token) {
    window.location.href = 'index.html';
} else {
    document.getElementById('option1').addEventListener('click', getUserById);
    document.getElementById('option2').addEventListener('click', getReimbByUserId);
    
    populateTable();
}

function getUserById() {
    apiUrl = 'http://localhost:7000/ersUsers/' + token.split(':')[0];
    populateTable(apiUrl);
}

function getReimbByUserId() {
    apiUrl = 'http://localhost:7000/reimbursements?authId=' + token.split(':')[0];
    populateTable(apiUrl);
}

async function populateTable(apiUrl) {
    let response = await fetch(apiUrl, {
        headers: {
            'Authorization': token
        }
    });

    let data = await response.json();
    let table = document.getElementById('table');

    function generateTableHead(table, data ) {
        let thData = data[0];
        let thead = table.createTHead();
        let row = thead.insertRow();
        for (let key of thData) {
          let th = document.createElement("th");
          th.setAttribute("scope", "cols")
          th.setAttribute("data-editable", "true");
          if(Object.keys(col_map).includes(key)){
            let text = document.createTextNode(col_map[key]);
            th.appendChild(text);
            row.appendChild(th);
          }         
        }
      }
      
      function generateTable(table, data) {
        for (let element of data) {
          let row = table.insertRow();
          for (key in element) {
            let cell = row.insertCell();
            let text = document.createTextNode(element[key]);
            cell.appendChild(text);
          }
          console.log("Table generated");
        }
      }
   
    // document.getElementById('update-button').addEventListener('click', updateUserAccount);
}

// async function updateUserAccount(){
//     let newUserName = document.getElementById('new-username').value;
//     let newPassword = document.getElementById('new-password').value;
//     let newFirstName = document.getElementById('new-first-name').value;
//     let newLastName = document.getElementById('new-last-name').value;
//     let newEmail = document.getElementById('new-email').value;

//     let updateAccount = {
//         ersUserId : newUserName,
//         ersPassword : newPassword,
//         userFirstName : newFirstName,
//         userLastName : newLastName,
//         userEmail : newEmail
//     }

//     let response = await fetch(`http://localhost:7000/ersUsers/${employeeId}`, {
//         method: 'PUT',
//         headers: {
//             'Authorization': token
//         },
//         body: JSON.stringify(updateAccount)
//     });

//     async

//     if(response.status == 200){
//         window.location.reload();
//     } else {
//         document.getElementById('error-div').innerHTML='Unable to update employee.'
//     }
    
// }