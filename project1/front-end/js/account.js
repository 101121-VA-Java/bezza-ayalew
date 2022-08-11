// // Set the date we're counting down to
// var countDownDate = new Date("Dec 09, 2021 13:27:59").getTime();
// // Update the count down every 1 second
// var x = setInterval(function() {

//   // Get today's date and time
//   var now = new Date().getTime();
    
//   // Find the distance between now and the count down date
//   var distance = countDownDate - now;
    
//   // Time calculations for days, hours, minutes and seconds
//   var days = Math.floor(distance / (1000 * 60 * 60 * 24));
//   var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
//   var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
//   var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
//   // Output the result in an element with id="time"
//   // document.getElementById("time").innerHTML = "Auction expires in " + days + "d " + hours + "h "
//   // + minutes + "m " + seconds + "s ";
    
//   // If the count down is over, write some text 
//   if (distance < 0) {
//     clearInterval(x);
//     // document.getElementById("time").innerHTML = "EXPIRED";
//   }
// }, 1000);

document.getElementById("demo").innerHTML=getArtPieceInfo();

async function getArtPieceInfo(){
  let apiUrl = "https://collectionapi.metmuseum.org/public/collection/v1/objects";
    let response = await fetch(apiUrl);
    if(response.status >= 200 && response.status < 300){
      let data = await response.json();
        if(data != null){
            let gallery = data["objectIDs"];
            console.log("Yes");
            let nArtPieces = [];
            while(nArtPieces.length<=10){
                for(let i = 0; i<gallery.length; i++){
                    if(gallery[i] && (gallery[i]["primaryImage"] || gallery[i]["primaryImageSmall"])){
                        art = {a_id:gallery[i]["objectID"],
                                a_url:(gallery[i]["primaryImage"]? 
                                    gallery[i]["primaryImage"] : 
                                    gallery[i]["primaryImageSmall"]),
                                a_artist_name:gallery[i]["artistDisplayName"],
                                a_artpiece_name:gallery[i]["objectName"]
                            }
                    }
                }
            }
            return nArtPieces.json();
        }
    }
}