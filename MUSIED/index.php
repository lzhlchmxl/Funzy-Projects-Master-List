<?php
include('header.php');
?>
<div class="boxbackground">
<img class="background" src="images/beijing.png" alt='Welcome to musied'/>
<img class="blur-background" src="images/blurybeijing.png" alt='Welcome to musied'/>
<div class="middle-box">
<button type="button" ID="our-adventage">Our adventage</button>
<button type="button" ID="our-adventage-arrow"><i class='glyphicon glyphicon-menu-left'></i></button>
<a href="upload.php"  style="color:#FFF;"><button type="button" id="take-your-step">Take your step</button></a>
<button type="button" ID="take-your-step-arrow"><i class='glyphicon glyphicon-menu-right'></i></button>
<button type="button" ID="watch-a-video" data-toggle="modal" data-target="#myModal">Watch a video</button>
<button type="button" ID="watch-a-video-arrow" data-toggle="modal" data-target="#myModal"><i class='glyphicon glyphicon-menu-down'></i></button>
<img class="logo" src="images/logo.png" alt='logo'/>
<div class="welcome_txt">
<h1 ID="header-title"> WELCOME TO MUSIED </h1>
<h3> Self-learning music platform designed for self-learners<br />
 "Follow me, step by step"</h3>
 </div>
<a href='upload.php' ID="upload-now">Submit Video</a>
<div class="modal custom fade" id="myModal" role="dialog">
<div class="modal-dialog modal-lg">
<div class="modal-content">
<div class="modal-body">
<div align="center" class="embed-responsive embed-responsive-16by9">
<video id="myVideo" loop controls class="embed-responsive-item" src="http://techslides.com/demos/sample-videos/small.mp4"></video>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="left-box">
<button type="button" ID="home-to-right">Home</button>
<button type="button" ID="home-to-right-arrow"><i class='glyphicon glyphicon-menu-right'></i></button>
<div class=convenient>
<img src="images/Convenient.png" alt='Convenient'/>
<h4>Convenient</h4>
</div>
<p ID=convenient>Learn at your own pace and schedule. </p>
<div class=easy>
<img src="images/Easy.png" alt='Easy'/>
<h4>Easy</h4>
</div>
<p ID=easy>Designed for adult self-learner with short and clear video instructions</p>
<div class=efficient>
<img src="images/efficient.png" alt='Efficient'/>
<h4>Efficient</h4>
</div>
<p ID=efficient> Deliver the core skill values and avoid redundant materials.</p>
<div class=self-validate>
<img src="images/self-validate.png" alt='Self-validate'/>
<h4>Self-validate</h4>
</div>
<p ID=self-validate>Upload your play and have professional teacher to validate.</p>
</div>
<div class="right-box">
<button type="button" ID="home-to-left">Home</button>
<button type="button" ID="home-to-left-arrow"><i class='glyphicon glyphicon-menu-left'></i></button>
</div>
</div>
<?php
include('footer.php');
?>