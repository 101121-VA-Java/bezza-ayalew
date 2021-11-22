// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let apiUrl = 'http://localhost:7000/reimbursements';

async function getData() {

//   let userInput = document.getElementById('dataInput').value;

  let response = await fetch(`${apiUrl}`);
//   /${userInput}

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
          let text = document.createTextNode(key);
          th.appendChild(text);
          row.appendChild(th);
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
        }
      }
      
      let table = document.querySelector("table");
      let data = Object.keys(response[0]);
      generateTableHead(table, data);
      generateTable(table, response);
}