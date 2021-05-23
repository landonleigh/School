var days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
var calories = [3000,2500,1500,4000,2200,1200,4400];

var $ = function(id) { return document.getElementById(id); };

window.onload = function() {
    //event handlers
    document.getElementById("update").onclick = function(){updateCalorie()};
    document.getElementById("avgButton").onclick = function(){showAverageCalories()};
    document.getElementById("show_max").onmouseover = function(){showMax()};
};

updateCalorie = function() {
    var cal = document.getElementById("calorie").value;
    var indexName = "";
    var index = 0;

    if(!document.getElementById("calorie").value || !document.getElementById("day")){
        alert("Enter a valid number or select day");
    } else{
        document.getElementById("calorie").value = "";
        var day = document.getElementsByName("day");

        for(i = 0; i < day.length; i++){
            if(day[i].checked){
                indexName = day[i].value;
            }
        }
        index = days.indexOf(indexName);
        calories[index] = cal;
        alert("Your updated calorie details are:\n" + calories);
    }
}

showAverageCalories = function() {
    var average = 0;
    var sum = 0;

    for(i = 0; i < calories.length; i++){
        sum += calories[i];
    }
    average = sum / calories.length;

    document.getElementById("avgCal").value = average;
    document.getElementById("avgCal").style.color = "green";
    document.getElementById("avgCal").style.backgroundColor = "transparent";
}

showMax = function () {
    document.getElementById("showMax").innerHTML = "Your maximun consumed calorie is " +
        Math.max(...calories) + " on " + days[calories.indexOf(Math.max(...calories))];
}
