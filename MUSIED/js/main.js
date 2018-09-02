//Stop Video
jQuery('#myModal').on('hidden.bs.modal', function (e) {
    jQuery('#myModal video').attr("src", jQuery("#myModal video").attr("src"));
});


jQuery('#myModal').on('shown.bs.modal', function (e) {
    vid = document.getElementById("myVideo");
    vid.play();
});



//Show-left-box
$(document).ready(function(){
    $("#our-adventage").click(function(){
        $("body").addClass("show-left-box");
        $(this).css("color","rgba(0,0,0,0)");
        $("#our-adventage-arrow").css("color","rgba(0,0,0,0)");
        $("#home-to-right").css("color","rgba(255,255,255,1)");
        $("#home-to-right-arrow").css("color","rgba(255,255,255,1)");
        $(".blur-background").css("opacity","1");
        $(".convenient").css("opacity","1");
        $(".efficient").css("opacity","1");
        $(".easy").css("opacity","1");
        $(".self-validate").css("opacity","1");
        
    });
});

$(document).ready(function(){
    $("#our-adventage-arrow").click(function(){
        $("body").addClass("show-left-box");
        $(this).css("color","rgba(0,0,0,0)");
        $("#our-adventage").css("color","rgba(0,0,0,0)");
        $("#home-to-right").css("color","rgba(255,255,255,1)");
        $("#home-to-right-arrow").css("color","rgba(255,255,255,1)");
        $(".blur-background").css("opacity","1");
        $(".convenient").css("opacity","1");
        $(".efficient").css("opacity","1");
        $(".easy").css("opacity","1");
        $(".self-validate").css("opacity","1");
    });
});

//back-to-middle-box-from-left
$("#home-to-right").click(function(){
    $("body").removeClass("show-left-box");
    $(this).css("color","rgba(0,0,0,0)");
    $("#home-to-right-arrow").css("color","rgba(0,0,0,0)");
    $("#our-adventage").css("color","rgba(255,255,255,1)");
    $("#our-adventage-arrow").css("color","rgba(255,255,255,1)");
    $(".blur-background").css("opacity","0");
    $(".convenient").css("opacity","0");
    $(".efficient").css("opacity","0");
    $(".easy").css("opacity","0");
    $(".self-validate").css("opacity","0");
});

$("#home-to-right-arrow").click(function(){
    $("body").removeClass("show-left-box");
    $(this).css("color","rgba(0,0,0,0)");
    $("#home-to-right").css("color","rgba(0,0,0,0)");
    $("#our-adventage").css("color","rgba(255,255,255,1)");
    $("#our-adventage-arrow").css("color","rgba(255,255,255,1)");
    $(".blur-background").css("opacity","0");
    $(".convenient").css("opacity","0");
    $(".efficient").css("opacity","0");
    $(".easy").css("opacity","0");
    $(".self-validate").css("opacity","0");
});



//show-right-box
$(document).ready(function(){
    $("#take-your-step").click(function(){
        $("body").addClass("show-right-box");
         $(this).css("color","rgba(0,0,0,0)");
         $("#take-your-step-arrow").css("color","rgba(0,0,0,0)");
        $("#home-to-left").css("color","rgba(255,255,255,1)");
        $("#home-to-left-arrow").css("color","rgba(255,255,255,1)");
          $(".blur-background").css("opacity","1");
    });
});

$(document).ready(function(){
    $("#take-your-step-arrow").click(function(){
        $("body").addClass("show-right-box");
         $(this).css("color","rgba(0,0,0,0)");
         $("#take-your-step").css("color","rgba(0,0,0,0)");
        $("#home-to-left").css("color","rgba(255,255,255,1)");
        $("#home-to-left-arrow").css("color","rgba(255,255,255,1)");
          $(".blur-background").css("opacity","1");
    });
});

//back-to-midlle-box-from-right

$("#home-to-left").click(function(){
    $("body").removeClass("show-right-box");
     $(this).css("color","rgba(0,0,0,0)");
    $("#home-to-left-arrow").css("color","rgba(0,0,0,0)");
    $("#take-your-step").css("color","rgba(255,255,255,1)");
    $("#take-your-step-arrow").css("color","rgba(255,255,255,1)");
      $(".blur-background").css("opacity","0");
});

$("#home-to-left-arrow").click(function(){
    $("body").removeClass("show-right-box");
     $(this).css("color","rgba(0,0,0,0)");
    $("#home-to-left").css("color","rgba(0,0,0,0)");
    $("#take-your-step").css("color","rgba(255,255,255,1)");
    $("#take-your-step-arrow").css("color","rgba(255,255,255,1)");
      $(".blur-background").css("opacity","0");
});



$(document).ready(function(){
    $('.convenient').hover(function(){
        $(".left-box").toggleClass("show-convenient-text");
        $(this).toggleClass('special');
    });
});

$(document).ready(function(){
    $('.easy').hover(function(){
        $(".left-box").toggleClass("show-easy-text");
        $(this).toggleClass('special');
    });
});

$(document).ready(function(){
    $('.efficient').hover(function(){
        $(".left-box").toggleClass("show-efficient-text");
        $(this).toggleClass('special');
    });
});

$(document).ready(function(){
    $('.self-validate').hover(function(){
        $(".left-box").toggleClass("show-self-validate-text");
        $(this).toggleClass('special');
    });
});


$(document).ready(function(){
    $('.footer').hover(function(){
        $(this).toggleClass('special');
    });
});

$(document).ready(function(){
    $('.footer').hover(function(){
        $('.boxbackground').toggleClass('special');
    });
});
