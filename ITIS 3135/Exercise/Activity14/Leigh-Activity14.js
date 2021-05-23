$(document).ready(function() {
    $.ajax({
        type: "get",
        url: "team.json",
        dataType: "json",
        success: function(data) {
            $("#team").html("");
            $.each(data, function (){
                $.each(this, function (key, value){
                    $("#team").append(
                        "<h3>" + value.name + "</h3>"
                        + value.title + "<br>"
                        + value.bio + "<br>"
                    );
                });
            });
        }
    });
}); // end ready