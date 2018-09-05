/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function ($) {

    Scrollbar.init(document.getElementById('smoothie'), {});

    var scrollbar = Scrollbar.get(document.getElementById('smoothie'));
    
    var topCenter=0,
    mouse= 0, hoverSolution= 0, contH=0;
    
    var x = document.getElementById("lista").getBoundingClientRect();
    topCenter = x.top, contH = x.height, document.getElementById("lista").addEventListener("mousemove", function(t){
        
        mouse = t.clientY - topCenter;
        //console.log(mouse + ' :: ' + contH);
        var e = $('.row_work').parent().height() - contH;
        
        this.transform = -mouse * e / contH, TweenMax.to($('.row_work').parent(), .5, {
            y: this.transform
        });
    });
    
    $( '.work_list' ).scroll(function() {
        console.log('here');
        var t = document.getElementById("lista").getBoundingClientRect().height;
        var e = document.getElementById("lista").getElementsByTagName( 'div' )[0].getBoundingClientRect().height;
        var total = document.getElementById("lista").getElementsByTagName( 'div' )[0].children.length;
        var n = $(this).scrollTop() * ( (t + window.innerHeight) / total ) / e;
        hoverSolution = Math.ceil(n);
        if (hoverSolution < total ){
            $('.row_work').eq(hoverSolution).addClass('work_active');
            if ($('.row_work').hasClass('work_active')) {
                $('.row_work').removeClass('work_active');
                $('.imagenes div').removeClass('hero_active');
            }
            //$(this).addClass('work_active');
            $('.row_work').eq(hoverSolution).addClass('work_active');
            $('.imagenes div.row_hero').eq(hoverSolution).addClass('hero_active');
        }
        
        console.log('n='+ Math.ceil(n) +' t='+Math.ceil(t) + ' e=' +e + ' scrollTop=' + $('#lista').scrollTop() + ' total='+total);
    });
    
    
    $("#lista div .row_work")
    .mouseenter(function () {
        if ($('.row_work').hasClass('work_active')) {
            $('.row_work').removeClass('work_active');
            $('.imagenes div').removeClass('hero_active');
        }
        $(this).addClass('work_active');
        $('.imagenes div.row_hero').eq($(this).index()).addClass('hero_active');
        //console.log($(this).index());
    });
    
    $(".work_title")
    .mouseenter(function () {
        $('.raxo_pointer').addClass('pointer_on')
    }).mouseleave(function (){
        $('.raxo_pointer').removeClass('pointer_on')
    });
    
    //pointer_on
    
    window.addEventListener( "pageshow", function ( event ) {
      var historyTraversal = event.persisted || 
                             ( typeof window.performance != "undefined" && 
                                  window.performance.navigation.type === 2 );
      if ( historyTraversal ) {
        // Handle page restore.
        window.location.reload();
      }
    });
    
    $('.herobg').each(function(index, el) {
        (new Image).src = $(this).css('background-image').replace(/^url\(['"](.+)['"]\)/, '$1');
    })
    
    $(window).on('load', function(){
        var tl = new TimelineMax({
                                //repeat: -1,
                                delay: 1
                            });

        $('#smoothie').removeAttr("cloak");
        tl.add("start").staggerFrom("[data-slide]", 1.2, {
                        autoAlpha: 0,
                        ease: Expo.easeInOut,
                        height: 0,
                        clearProps: "all"
                    }, .07, "start").staggerFrom("[data-title]", .6, {
                        autoAlpha: 0,
                        y: 20
                    }, .05, "start");           
    });
    
    $(document).on('click','.link_work', function(e) {
        e.preventDefault();
        var tl = new TimelineMax({onCompleteParams:[$(this).attr('href')], onComplete:redirect });
        tl.add("start").add(TweenMax.to("[data-slide]", 1.2, {
                            autoAlpha: 0,
                            ease: Expo.easeInOut,
                            height: 0
                        }, "start")).set("[data-title]", {
                    pointerEvents: "none"
                }).staggerTo("[data-title]", .4, {
                    autoAlpha: 0,
                    y: -20
                }, .03, "start")
    });
    
    function redirect(redirect){
        location.href = redirect;
        //window.location.replace(redirect);
    }
    
    
   
    var t = $('.raxo_pointer');
    var mouseX = 0, mouseY = 0; 
    window.addEventListener("mousemove", function(e) {
        t.mouse = {
            x: e.clientX,
            y: e.clientY
        }
        mouseX = e.clientX;
        mouseY = e.clientY;
    }, !1);
    
    function render() {
        setPos();
        window.requestAnimationFrame(render);
    };
    render();
    
    var isLerp = !0;
    var interMouseX = 0,
        interMouseY = 0;
        
    function E(t, e, n) {
        return (1 - n) * t + n * e
    }
    
    function setPos() {
        var z = E(mouseX, interMouseX, .85),
            e = E(mouseY, interMouseY, .85);
        interMouseX = isLerp ? z : mouseX, interMouseY = isLerp ? e : mouseY, TweenMax.set($('.raxo_pointer'), {
            x: interMouseX,
            y: interMouseY
        });
    }
    var tl, position = 0;
            tl = new TimelineMax( {paused:true} );
            tl.to($('.all-menu'), 0.1, { autoAlpha:1 });
            tl.set($('.all-menu a'), {x:20});
            //.staggerTo($('.all-menu a'), 0.3, {autoAlpha:1, x:'+=-60px', ease: Back.easeOut}, 0.1)
    
    $(".all-menu a").each(function(index, element){
        position = (index == 0) ? -45 : position - 55;
        tl.add(TweenMax.fromTo(element, 0.5, { autoAlpha:0, x: 20}, {autoAlpha:1, x: position, ease: Back.easeOut}), 0.2);
    });
            
    $(document).on('click', '.desktop #menu-btnx', function(){        
            tl.reversed() ? tl.play() : tl.reverse();
            if (!$('.all-menu').hasClass('menu-circle-active')){
                $('.all-menu').addClass('menu-circle-active');
                tl.play();
            }else{
                $('.all-menu').removeClass('menu-circle-active');
            }
    })
    
    var tl2, position = 0, firstime = true;
            tl2 = new TimelineMax( {paused:true} );
            TweenMax.set($('.mmmenu'), { display: 'none'});
            tl2.to($('.mmmenu'),0,{display: 'block'});
            tl2.to($('.mmmenu'),0.5, {height : '100%'});
            tl2.set(".main-menu li",{y:-100});
            tl2.staggerTo(".main-menu li", 0.3, {opacity:1, y: 0,  ease:Back.easeOut}, 0.01);
    $(document).on('touchend', '.mobile #menu-btnx', function(){
            console.log('heyysoman '+tl2.reversed());
            if (firstime){
                tl2.reverse()
                firstime = false;
            }
            tl2.reversed() ? tl2.play() : tl2.reverse();
    })
    
    var body    = $( 'body' ),
		_window = $( window );
    
    function onResizeARIA() {
            console.log('resize check');
        if (_window.width() > 992) {
            if (!body.hasClass('desktop'))
                body.addClass('desktop');
            if (body.hasClass('mobile'))
                body.removeClass('mobile');
        }else{
            if (!body.hasClass('mobile'))
                body.addClass('mobile');
            if (body.hasClass('desktop'))
                body.removeClass('desktop');
        }
        $('.loader').fadeOut();
    }

    _window
            .on( 'load.raxo', onResizeARIA )
            .on( 'resize.raxo', function() {
                    onResizeARIA();
    } );
                 
}(jQuery))