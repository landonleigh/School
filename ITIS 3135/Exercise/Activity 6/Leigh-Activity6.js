//prompts user to input number of sides and calls function
var sides = prompt("Enter number of sides");
converShape(sides);

//takes in number of sides and returns the name of shape
function converShape(numSides) {
    while(sides){
        if (numSides == 3) {
            window.alert("Number of sides = " + numSides + "\nName of the polygon = Triangle");
        }else if (numSides == 4) {
            window.alert("Number of sides = " + numSides + "\nName of the polygon = Square");
        }else if (numSides == 5) {
            window.alert("Number of sides = " + numSides + "\nName of the polygon = Pentagon");
        }else if (numSides == 6) {
            window.alert("Number of sides = " + numSides + "\nName of the polygon = Hexagon");
        }else if (numSides == 7) {
            window.alert("Number of sides = " + numSides + "\nName of the polygon = Heptagon");
        }
            sides = prompt("Enter number of sides");
            converShape(sides);
    }
}




