if (!token) {
  window.location.relode(); //href = '../pages/index.html';
// }else if(token.split(":")[1] == 1){
//   window.location.href = '../pages/index.html';
}else{
  
  let col_map = {
      reimbId:"REIMB ID",
      reimbAmount:"REIMB AMOUNT",
      reimbSubmitted:"REIMB SUBMITTED",
      reimbResolved:"REIMB RESOLVED",
      reimbDescription:"REIMB DESCRIPTION",
      reimbReceipt:"REIMB RECEIPT",
      reimbAuthor:"REIMB AUTHOR",
      reimbResolver:"REIMB RESOLVER",
      reimbStatusId:"REIMB STATUS ID",
      reimbTypeId:"REIMB TYPE ID",
      ersUserId:"USER ID",
      ersUsername:"USERNAME",
      ersPassword:"PASSWORD",
      userFirstName:"FIRST NAME",
      userLastName: "LAST NAME",
      userEmail: "EMAIL",
      userRoleId: "ROLE ID"
  }
  
  document.getElementById('myReimbursements')
  .addEventListener("click", tableMyReimbursements);

  document.getElementById('pending')
  .addEventListener("click", tableMyPendingReimbursements);

  document.getElementById('resolved')
  .addEventListener("click", tableMyResolvedReimbursements);

  document.getElementById('viewMyAccount')
  .addEventListener("click", getMyAccount);

  document.getElementById('updateMyAccount')
  .addEventListener("click", setAccountForUpdate);

  document.getElementById('fileReimbursement')
  .addEventListener("click", fileReimbursement);


  
  let reimbUrl = 'http://localhost:7000/reimbursements';
  let empUrl = 'http://localhost:7000/ersUsers';
  let empId = token.split(":")[0];

  async function commitUpdates(){
    let data = collectUpdates();
    let response = await fetch(`${empUrl}/${empId}`, {
        method:'PUT',
        headers:{
          "Authorization":token
        },
        body: JSON.stringify(data)
      });
    if(response.status == 200){
      window.location.reload();
      } else {
        document.getElementById('error-div').innerHTML='Unable to submit reimbursement.'
    }
  }

  function collectUpdates() {
    let cells = document.getElementById("updatable").rows[1].cells;
    let str = "";
    for(let i=0; i<cells.length; i++){
      str = str + cells.item(i).innerHTML + ":";
    }      
    if(typeof(Storage) !== "undefined"){
      sessionStorage.setItem("update", str);
    }
    let savedUpdate = sessionStorage.getItem("update");
    let th = ["ersUsername", "ersPassword", "userFirstName", "userLastName", "userEmail"];
    let tr = savedUpdate.slice(0,-1).split(":");
    let result =  tr.reduce(function(result, field, index) {
        result[th[index]] = field;
        return result;
      }, {})
    return result;
  }

  async function setAccountForUpdate() {
    let response = await fetch(`${empUrl}/${empId}`);
    if(response.status >= 200 && response.status < 300){
        data = await response.json();
        delete data.ersUserId;
        delete data.userRoleId;
        populateData(data);
        editBtn = document.createElement("button");
        editBtn.setAttribute("class","btn btn-outline-primary");
        editBtn.setAttribute("id", "editBtn");
        editBtn.innerHTML = 'Save Changes';
        document.body.appendChild(editBtn);
        document.getElementById('editBtn')
        .addEventListener("click", commitUpdates);
    }
  }

  function populateData(response) {
    function generateTableHead(table, data) {
        let thead = table.createTHead();
        let row = thead.insertRow();
        for (let key of data) {
          let th = document.createElement("th");
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
          cell.setAttribute("contenteditable", "true");
        }
      }
    } 
    let table = document.querySelector("table");
    table.innerHTML = "";
    table.setAttribute("class", "table table-hover")
    table.setAttribute("id", "updatable")
    if(!Array.isArray(response)){
      let listResponse = [];
      listResponse.push(response);
      let data1 = Object.keys(listResponse[0]);
      generateTableHead(table, data1);
      generateTable(table, listResponse);
      }else{
          let data = Object.keys(response[0]);
          generateTableHead(table, data);
          generateTable(table, response);
      }
  }

  function fileReimbursement(){
    let newReimbursement = {
      reimbAmount:0,
      reimbSubmitted: + new Date(),
      reimbResolved:null,
      reimbDescription:null,
      reimbReceipt: null,
      reimbAuthor:empId,
      reimbResolver:null,
      reimbStatusId:0,
      reimbTypeId:0
  };
  populateData(newReimbursement);
  editBtn = document.createElement("button");
  editBtn.setAttribute("class","btn btn-outline-primary");
  editBtn.setAttribute("id", "editBtn");
  editBtn.innerHTML = 'Save Changes';
  document.body.appendChild(editBtn);
  document.getElementById('editBtn')
  .addEventListener("click", commitUpdates);
  }

  function tableMyReimbursements(){
    let authId = empId;
    let data = getReimbursementsByAuthorId(authId);
    populateData(data);
    console.log("my reimbursements on table");
  }

  function tableMyResolvedReimbursements(){
    let authId = empId;
    let status = "resolved";
    getMyReimbursementsByStatus(authId,status);
    console.log("my resolved reimbursements on table");
  }

  function tableMyPendingReimbursements(){
    let status = "pending";
    let authId = empId;
    getMyReimbursementsByStatus(authId,status);
    console.log("my pending reimbursements on table");
  }

  async function getMyAccount() {
    id = empId;
    let response = await fetch(`${empUrl}/${id}`);
    if(response.status >= 200 && response.status < 300){
      let data = await response.json();
      populateData(data);
    }
  }

  function getMyReimbursementsByStatus(authId, status) {
    let data = getReimbursementsByAuthorId(authId);
    let reimbs = [];
    if(data != null){
      for (const reimb in data) {
        console.log(reimb);
        if(status == "pending" && reimb[reimbStatusId] == 1){
          reimb[reimbSubmitted] = new Date(reimb[reimbSubmitted])
          .toLocaleDateString();
          if(reimb[resolved] != null){
            reimb[reimbResolved] = new Date(reimb[reimbSubmitted])
            .toLocaleDateString();
          }
          reimbs.push(reimb);
        }else if(status == "resolved" && reimb[reimbStatusId] != 1){
          reimb[reimbSubmitted] = new Date(reimb[reimbSubmitted])
          .toLocaleDateString();
          if(reimb[resolved] != null){
            reimb[reimbResolved] = new Date(reimb[reimbSubmitted])
            .toLocaleDateString();
          }
          reimbs.push(reimb);
        }
        
      }
      console.log(reimbs);
      populateData(data);
    }
  }

  async function getReimbursementsByAuthorId(authorId) {
    let reimbs = [];
    authorId = empId;
    let userInput = "?reimbAuthId=" + authorId;
    let response = await fetch(`${reimbUrl}${userInput}`);
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        if(data != null){
        for (const reimb of data) {
            reimb.reimbSubmitted = new Date(reimb.reimbSubmitted)
            .toLocaleDateString();
            if(reimb.reimbResolved != null){
              reimb.reimbResolved = new Date(reimb.reimbResolved)
              .toLocaleDateString();
            }
            reimbs.push(reimb);
        return reimbs;
    }
  }
    
  async function getAllReimbursements() {
    let reimbs = [];
    let response = await fetch(reimbUrl);
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        if(data != null){
          for (const reimb of data) {
            reimb.reimbSubmitted = new Date(reimb.reimbSubmitted)
            .toLocaleDateString();
            if(reimb.resolved != null){
              reimb.reimbResolved = new Date(reimb.reimbSubmitted)
              .toLocaleDateString();
            }
            reimbs.push(reimb);
          }
          return reimbs;
        }
    }
  }

  
  // async function getMyPendingReimbursements(authId) {
  //   return getReimbursementByStatus("under review");
  // }

  // async function getMyResolvedReimbursements(authId){
  //   authId = empId;
  //   let resolved = [];
  //   let myReimbs = getMyReimbursements(authId);
  //   for (const reimb of myReimbs) {
  //     if(reimb != null && reimb.reimbStatusId != 1){
  //         reimb.reimbSubmitted = new Date(reimb.reimbSubmitted)
  //         .toLocaleDateString();
  //         reimb.reimbResolved = new Date(reimb.reimbSubmitted)
  //         .toLocaleDateString();
  //         resolved.push(reimb);
  //     }
  //   }
  //   return resolved;
  // }
  // async function getReimbursementByStatus(status) {
  //   let reimbs = [];
  //   let userInput = "?status=" + status;
  //   let response = await fetch(`${reimbUrl}${userInput}`);
  //   if(response.status >= 200 && response.status < 300){
  //     let data = await response.json();
  //     if(data != null){
  //       for (const reimb of data) {
  //         reimb.reimbSubmitted = new Date(reimb.reimbSubmitted)
  //         .toLocaleDateString();
  //         if(reimb.resolved != null){
  //           reimb.reimbResolved = new Date(reimb.reimbSubmitted)
  //           .toLocaleDateString();
  //         }
  //         reimbs.push(reimb);
  //       }
  //       return reimbs;
  //     }
  //   }
  // }







  // async function getMyReimbursements() {
  //   let myReimbs = []
  //   let response = await fetch(reimbUrl);
  //   if(response.status >= 200 && response.status < 300){
  //       let data = await response.json();
  //       for (const reimb of data) {
  //         if(reimb.reimbAuthor == empId){
  //           reimb.reimbSubmitted = new Date(reimb.reimbSubmitted)
  //           .toLocaleDateString();
  //           reimb.reimbResolved = new Date(reimb.reimbSubmitted)
  //           .toLocaleDateString();
  //           myReimbs.push(reimb);
  //         }
  //       }
  //       populateData(myReimbs);
  //   }
  // }



  // async function getPendingReimbursements() {
  //   let pending = [];
  //   let response = await fetch(reimbUrl);
  //   if(response.status >= 200 && response.status < 300){
  //     let data = await response.json();
  //     for (const reimb of data) {
  //       if((reimb != null && reimb.reimbStatusId == 1) 
  //         && reimb.reimbAuthor == empId){
  //         reimb.reimbSubmitted = new Date(reimb.reimbSubmitted)
  //         .toLocaleDateString();
  //         pending.push(reimb);
          
  //       }
  //     }
  //     populateData(pending);
  //   }
    
    
  // }

  // async function getResolvedReimbursements() {
  //   let resolved = [];
  //   let response = await fetch(reimbUrl);
  //   if(response.status >= 200 && response.status < 300){
  //       let data = await response.json();
  //       for (const reimb of data) {
  //         if(reimb != null && (reimb.reimbAuthor == empId) 
  //           && reimb.reimbStatusId != 1){
  //             reimb.reimbSubmitted = new Date(reimb.reimbSubmitted)
  //             .toLocaleDateString();
  //             reimb.reimbResolved = new Date(reimb.reimbSubmitted)
  //             .toLocaleDateString();
  //             resolved.push(reimb);
            
  //         }
  //       }
  //       console.log(data);
  //       populateData(resolved);
  //   }
  // }


  
        // let nRows = document.getElementById("updatable").rows.length;
        // let str = "";
        // for(let i=1; i<nRows; i++){
        //   let nCols = document.getElementById("updatable").rows[i].cells.length;
        //   for(let j=0; j<nCols; j++){
        //     let x = document.getElementById("updatable").rows[i].cells.item(j).innerHTML;
        //     str = str + x + ":";
        //   }
        //   str = str + "#";

    }
    
  
    
    // function populateDataEditable(response){

    //     function generateTableHead2(table, data) {
    //         let thead = table.createTHead();
    //         let row = thead.insertRow();
    //         for (let key of data) {
    //           let th = document.createElement("th");
    //           if(Object.keys(col_map).includes(key)){
    //             let text = document.createTextNode(col_map[key]);
    //             th.appendChild(text);
    //             row.appendChild(th);
    //           }         
    //         }
    //       }
          
    //       function generateTable2(table, data) {
    //           let uneditable = ['ersUserId', 'urerRoleId'];
    //         for (let element of data) {
    //           let row = table.insertRow(); 
    //           for (key in element) {
    //             let cell = row.insertCell();
    //             cell.setAttribute("contenteditable", "true");
    //             let text = document.createTextNode(element.key);
    //             cell.appendChild(text);
    //           }
    //         }
    //       }
    //       editBtn = document.createElement("button");
    //       editBtn.setAttribute("class","btn btn-outline-primary");
    //       editBtn.setAttribute("id", "editBtn");
    //       editBtn.innerHTML = 'Save Changes';
    //     //   editBtn.setAttribute("type","button");
    //       let table = document.querySelector("table");
    //       table.innerHTML = "";
    //       table.setAttribute("class", "table table-hover")
    //       table.setAttribute("id", "updater")

    //       if(!Array.isArray(response)){
    //         let listResponse = [];
    //         listResponse.push(response);
    //         let data1 = Object.keys(listResponse[0]);
    //         generateTableHead2(table, data1);
    //         generateTable2(table, listResponse);
    //         }else{
    //             let data = Object.keys(response[0]);
    //             generateTableHead2(table, data);
    //             generateTable2(table, response);
    //         }

    //     //   let data = Object.keys(response[0]);
    //     //   generateTableHead(table, data);
    //     //   generateTable(table, response)


    //       editBtn.addEventListener('click', function(e) {
    //           editBtn.innerHTML = 'Save Changes';
    //         // Save the data in sessionStorage
    //           setInterval(function() {
    //             sessionStorage.setItem(table.rows[1].getAttribute('id'), table.rows[1].innerHTML);
    //             }, 5000);
    //       });

    
    }
}