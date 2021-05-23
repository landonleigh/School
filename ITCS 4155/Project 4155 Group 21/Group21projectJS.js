var $ = function(id) { return document.getElementById(id); };
var username = document.getElementById("update");
var password = document.getElementById("login");

window.onload = function() {
    document.getElementById("update").onclick = function(){showMax()};;
    document.getElementById("newAccount").onclick = function(){storeInformation()}
    document.getElementById("login").onclick = function(){getInformation()}
};

storeInformation = function () {
    localStorage.setItem("username", uname.value);
    localStorage.setItem("password", psw.value);
}

getInformation = function () {
    var storedName = localStorage.getItem("name");
    var storedPsw = localStorage.getItem("pw");

    var userName = document.getElementById("userName");
    var userPsw = document.getElementById("userPw");

    if(userName.value == storedName && userPsw.value == storedPsw) {
        window.location.href = "announcements.html";
    }else {
        alert("Incorrect Information");
    }
}