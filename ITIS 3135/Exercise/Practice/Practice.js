var total = 0;

var $ = function(id) {
	return document.getElementById(id);
};

window.onload = function() {
	//add onclick event handler for each image
	// for click event add item to order and update total
	// display order and total

	document.getElementById("espresso").onclick= function(){addEspresso()};

	document.getElementById("cappuccino").onclick= function(){addEspresso()};

}; // end onload

function addEspresso() {
	total += espressoPrice;
	document.getElementById("order").innerHTML += "$1.95 - Delicious espresso. Wanna try it?<br>";
}

function addCappuccino() {
	total += cappuccinoPrice;
	document.getElementById("order").innerHTML += "$3,75 - Delicious Cappuccino!";
}

