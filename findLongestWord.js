function  findLongestWord(array){

    var longestLength=0;
    var index;
    for(var i=0; i<array.length; i++){
        if (array[i].length>longestLength){
        longestLength=array[i].length;
        index=i;
    }
    }
    

document.getElementById("result1").innerHTML=array[index];
document.getElementById("result2").innerHTML=longestLength;


}
function start(){

    var words=['mystery','brother','aviator','crocodile','pearl','orchard','crackpott'];
    findLongestWord(words);
}

window.addEventListener("load",start);