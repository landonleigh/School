$(document).ready(function() {
    $("#accordion").accordion({heightStyle: "content"});

    var id = '#dialog';
    var maskHeight = $(document).height();
    var maskWidth = $(window).width();
    $('#mask').css({'width':maskWidth,'height':maskHeight});
    $('#mask').fadeIn(500);
    $('#mask').fadeTo("slow",0.9);
    var winH = $(window).height();
    var winW = $(window).width();
    $(id).css('top',  winH/2-$(id).height()/2);
    $(id).css('left', winW/2-$(id).width()/2);
    $(id).fadeIn(2000);
    $('.window .close').click(function (e) {
        e.preventDefault();
        $('#mask').hide();
        $('.window').hide();
    });
    $('#mask').click(function () {
        $(this).hide();
        $('.window').hide();
    });

    $.ajax({
        type: "get",
        url: "tasks.json",
        beforeSend: function() {
            $("#tasks").html("Loading...");
        },
        timeout: 10000,
        error: function(xhr, status, error) {
            alert("Error: " + xhr.status + " - " + error);
        },
        dataType: "json",
        success: function(data) {
            $("#tasks").html("");
            $.each(data, function (){
                $.each(this, function (key, value){
                    $("#tasks").append(
                        "<h3>" + value.name + "</h3>"
                        + value.desc + "<br><strong>Time: </strong>"
                        + value.time + "<br>"
                    );
                });
            });
        }
    });

    $.ajax({
        type: "get",
        url: "ADL.json",
        beforeSend: function() {
            $("#tabs-2").html("Loading...");
        },
        timeout: 10000,
        error: function(xhr, status, error) {
            alert("Error: " + xhr.status + " - " + error);
        },
        dataType: "json",
        success: function(data) {
            $("#tabs-2").html("");
            $.each(data, function (){
                $.each(this, function (key, value){
                    $("#tabs-2").append(
                        "<p>" + value.name + "</p>"
                    );
                });
            });
        }
    });

});


