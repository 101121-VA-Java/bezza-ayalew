document.getElementById("submitButton").addEventListener("click", registerReimbursementClaim);
// getErsUsers();
function getErsUsers(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if( xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                let response = xhr.response;
                response = JSON.parse(response);
                console.log(response);
            }
        }
    }

    xhr.open("GET", "http://localhost:7000/ersUsers");
    xhr.send();
}
function getErsReimbursements(){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if( xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                let response = xhr.response;
                response = JSON.parse(response);
                console.log(response);
            }
        }
    }

    xhr.open("GET", "http://localhost:7000/reimbursements");
    xhr.send();
}
function registerReimbursementClaim(){

    let newClaim = {
        reimbAmount:345.56,
        reimbSubmitted: + new Date,
        reimbDescription:'conference attendance',
        reimbReceipt: 'place holder',
        reimbAuthor:1,
        reimbTypeId:2
    };

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if( xhr.readyState === 4){
            if(xhr.status === 201){
                console.log('Reimbursement claim was successfully added!');
            } else{
                console.log('Reimbursement claim was not added...');
            }
        }
    }
    xhr.open("POST", "http://localhost:7000/reimbursements");
    let requestBody = JSON.stringify(newClaim);
    xhr.send(requestBody);
}