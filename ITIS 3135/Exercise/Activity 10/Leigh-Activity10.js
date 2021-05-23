$(document).ready(function() {
    $("#image_list a").each(function(){
        //preload the image for each link
        var imageLink = $(this).attr("href");
        var caption = $(this).attr("title");
        var image = new Image();
        image.src = imageLink;

        // set up the event handlers for each link
        $(this).click(function(event){
            $("#caption, #image").fadeOut(3000,
                function() {
                    // get the image URL and caption for each image and animate the caption
                    $("#image").attr("src", imageLink);
                    $("#caption").text(caption);
                    $("#caption, #image").fadeIn(3000);
                    $("#caption").animate({fontSize: "2em"}, 3000);
                });
            // cancel the default action of each link
            event.preventDefault();
        });
    });
    // move the focus to the first link
    $("li:first-child a").focus();
}); // end ready