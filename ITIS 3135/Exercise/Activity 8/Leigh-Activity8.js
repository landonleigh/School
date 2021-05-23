var days = [];
var temperature = [];

var $ = function (id) {
  return document.getElementById(id);
};

window.onload = function () {
  $("displayResults").onclick = displayResults;
  $("addTemperature").onclick = addTemperature;
  $("displayTemperature").onclick = displayTemperature;
};

displayResults = function(){
  var sum = 0;
  var avg = 0;
  var high = temperature[0];
  var highDay = days[0];
  for(i = 0; i < temperature.length; i++){
    sum += temperature[i];
    if(high < temperature[i]){
      high = temperature[i];
      highDay = days[i];
    }
  }
  avg = sum / temperature.length;

  document.getElementById("result").innerHTML = "<h2>Result</h2> <p>Average Temperature = " + avg + " F </p>" +
    "<p>Highest Temperature was on " + highDay + " with a temperature of " + high + " F </p>";
};

displayTemperature = function(){
  var tempTable = "<h2>Day-Temperature</h2> <table><tr><th>Day</th> <th>Temperature</th></tr>";
  for (i = 0; i < temperature.length; i++){
    addTable += "<tr><td>" + days[i] + "</td><td>" + temperature[i] + "</td></tr>";
  }
  tempTable += "</table>";

  document.getElementById("temperature_table").innerHTML = tempTable;
};

addTemperature = function(){
  if(isInteger(temp)){
    days.push(document.getElementById("Day"));
    temperature.push(document.getElementById("Temperature"));
  }
  else{
    alert("You must enter a day and a valid temperature");
  }
};