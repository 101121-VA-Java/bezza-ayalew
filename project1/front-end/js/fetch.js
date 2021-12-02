let col_map = {
  reimbId:"ID",
  reimbAmount:"AMOUNT",
  reimbSubmitted:"DATE SUBMITTED",
  reimbResolved:"DATE RESOLVED",
  reimbDescription:"DESCRIPTION",
  reimbReceipt:"RECEIPT",
  reimbAuthor:"AUTHOR",
  reimbResolver:"RESOLVER",
  reimbStatusId:"STATUS",
  reimbTypeId:"TYPE",
  ersUserId:"ID",
  ersUsername:"USERNAME",
  ersPassword:"PASSWORD",
  userFirstName:"FIRST NAME",
  userLastName: "LAST NAME",
  userEmail: "EMAIL",
  userRoleId: "ROLE"
}
document.getElementById('getData').addEventListener("click", getData);

let apiUrl = 'http://localhost:7000/reimbursements';

async function getData() {

  let userInput = document.getElementById('dataInput').value;
  let response = await fetch(`${apiUrl}?${userInput}`);

  if(response.status >= 200 && response.status < 300){
      let data = await response.json();
      populateData(data);
  }
}

function populateData(response) {
 
    function generateTableHead(table, data) {
        let thead = table.createTHead();
        let row = thead.insertRow();
        for (let key of data) {
          let th = document.createElement("th");
          th.setAttribute("scope", "cols")
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
          row.setAttribute('data-toggle', 'modal');
          row.setAttribute('data-target', '#updateReimbursementModal');//target varies
          // row.addEventListener('click', setupModal);
          for (key in element) {
            let cell = row.insertCell();
            cell.setAttribute("contenteditable", "true");
            let text = document.createTextNode(element[key]);
            cell.appendChild(text);
          }
        }
      }

      let table = document.querySelector("table");
      table.innerHTML = "";
      table.setAttribute("class", "table table-hover")
      let data = Object.keys(response[0]);
      generateTableHead(table, data);
      generateTable(table, response);
}
let saveChanges = document.createElement("input");
saveChanges.setAttribute("type", "button");
saveChanges.setAttribute("value", "save edits");
saveChanges.setAttribute("onClick", "saveEdits()");

function saveEdits(){
  let editElem = document.getElementById("edit");
  let userVersion = editElem.innerHTML;
  sessionStorage.userEdits = userVersion;
  // localStorage.userEdits = userVersion;    //Should the changes be saved in the users localStorage?
  document.getElementById("update").innerHTML = "Edits saved!";
}