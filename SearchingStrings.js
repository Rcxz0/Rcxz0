// Fig. 11.7: SearchingStrings.js
// Searching strings with indexOf and lastIndexOf.


var letters = "abcdefghijklmnopqrstuvwxyzabcdefghijklm";

function searchingStrings(){

//get the sub string input to start searching

var inputVal=document.getElementById("inputField").value;

//call indexof() and las indexof()


var output=
"<p>The first accurance of this value is located  "+letters.indexOf(inputVal)+"</p>"+
"<p>The last accurance of this value is located  "+letters.lastIndexOf(inputVal)+"</p>"+
"<p>The first accurance of this value (starting from index 12) is located at  "+letters.indexOf(inputVal,  12)+"</p>"+
"<p>The last accurance of this value (starting from index 12) is located at  "+letters.lastIndexOf(inputVal,  12)+"</p>";

document.getElementById("results").innerHTML=output;


}

function start(){

var sButton=document.getElementById("searchButton");
sButton.addEventListener("click", searchingStrings);


}

window.addEventListener("load", start);