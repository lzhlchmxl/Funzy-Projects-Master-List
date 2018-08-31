 jQuery(document).ready(function($) {
 
    $(".scroll a, .navbar-brand, .gototop,.explore").click(function(event){   
    event.preventDefault();
    $('html,body').animate({scrollTop:$(this.hash).offset().top}, 600,'swing');
    $(".scroll li").removeClass('active');
    $(this).parents('li').toggleClass('active');
    });
    });






var wow = new WOW(
  {
    boxClass:     'wowload',      // animated element css class (default is wow)
    animateClass: 'animated', // animation css class (default is animated)
    offset:       0,          // distance to the element when triggering the animation (default is 0)
    mobile:       true,       // trigger animations on mobile devices (default is true)
    live:         true        // act on asynchronously loaded content (default is true)
  }
);
wow.init();




$('.carousel').swipe( {
     swipeLeft: function() {
         $(this).carousel('next');
     },
     swipeRight: function() {
         $(this).carousel('prev');
     },
     allowPageScroll: 'vertical'
 });

// Input Lock
$("textarea").blur(function() {
  $("#hire textarea").each(function() {
    $this = $(this);
    if (this.value != "") {
      $this.addClass("focused");
      $("textarea + label + span").css({ opacity: 1 });
    } else {
      $this.removeClass("focused");
      $("textarea + label + span").css({ opacity: 0 });
    }
  });
});

$("#hire .field:first-child input").blur(function() {
  $("#hire .field:first-child input").each(function() {
    $this = $(this);
    if (this.value != "") {
      $this.addClass("focused");
      $(".field:first-child input + label + span").css({ opacity: 1 });
    } else {
      $this.removeClass("focused");
      $(".field:first-child input + label + span").css({ opacity: 0 });
    }
  });
});

$("#hire .field:nth-child(2) input").blur(function() {
  $("#hire .field:nth-child(2) input").each(function() {
    $this = $(this);
    if (this.value != "") {
      $this.addClass("focused");
      $(".field:nth-child(2) input + label + span").css({ opacity: 1 });
    } else {
      $this.removeClass("focused");
      $(".field:nth-child(2) input + label + span").css({ opacity: 0 });
    }
  });
});



