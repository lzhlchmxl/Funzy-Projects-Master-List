<?php
include('header.php');
include_once('function/functions.php');  
$funObj = new dbFunction();
$sucess = '';
$error = '';
if(isset($_POST['upload']) && $_POST['upload'] == 'Submit' && $_POST['upload'] != '')
{
	$name = $_POST['name'];
	$label = $_POST['label'];
	$yol = $_POST['optradio'];
	$video_url = $_POST['video_link'];
	$email = $_POST['email'];
	$comment = $_POST['comment'];
	$date = date('mm/dd/yy');
	
	$insert_video = $funObj->InsertVideo($name,$label,$yol,$video_url,$email,$comment,$date);
	if($insert_video)
	{
		$sucess = "Thanks for submitting your video. We will get back to you soon.";	
	}
	else{
			$error = "not submitted";
		}
		
	//mail video here
	
	$to = 'liangbill2006@gmail.com,jeetmm.sharma37@gmail.com';
	$subject = 'One Learner Submitted video';
	 $message = '<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center"><h3>Video Submmition for Feedback</h3></td>
      </tr>
      <tr>
        <td><table width="800" border="0" cellspacing="0" cellpadding="20">
          <tr>
            <td>Name</td>
            <td>'.$name.'</td>
          </tr>
          <tr>
            <td>Level</td>
            <td>'.$label.'</td>
          </tr>
          <tr>
            <td>Year of learning</td>
            <td>'.$yol.'</td>
          </tr>
          <tr>
            <td>Video</td>
            <td>'.$video_url.'</td>
          </tr>
          <tr>
            <td>Email</td>
            <td>'.$email.'</td>
          </tr>
          <tr>
            <td>Comment</td>
            <td>'.$comment.'</td>
          </tr>
          <tr>
            <td colspan="2" align="right" style="font-size:10px;">Thank You for using musied.com</td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

';
$headers = "MIME-Version: 1.0" . "\r\n";
$headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
$headers .= 'From: <'.$email.'>' . "\r\n";
$mailvideo = $funObj->MailVideo($to,$subject,$message,$headers);
if(!$mailvideo)
{
	$error = 'your video is not submitted';	
}
		
}

?>
<div class="boxbackground">
<img class="background" src="images/beijing.png" alt='Welcome to musied'/>
<img class="blur-background" src="images/blurybeijing.png" alt='Welcome to musied'/>
 <span style="color:#F00;"><?php echo $error; ?></span>
<div class="middle-box">
<img ID="uploadLogo" src="images/upload-logo.png" alt='upload logo'/>
<div class="form">
<span style="color:rgba(169, 211, 75, 1);"> <?php echo $sucess; ?></span>
<form action="" method="post" name="video_submittion">
<label for="name"> Name: &nbsp&nbsp&nbsp </label>
<input class="input-box" type="text" name="name" size="15" required="required">
<label for="lavel"> &nbsp&nbsp&nbsp&nbsp Level (if applicable): &nbsp&nbsp&nbsp </label>
<input class="input-box" type="text" name="label" size="8"><br><br>
<label for="learning">Year of learning:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </label>
<label class="radio-inline"><input type="radio" name="optradio" value="< 1 year"> < 1 year </label>         
                                <label class="radio-inline"><input type="radio" name="optradio" value="1 year"> > 1 year </label>
                                <label class="radio-inline"><input type="radio" name="optradio" value="> 3 years" >> 3 years</label>
                            <BR> <BR>
                            
                            
                           <label for="video"> Video Link: &nbsp&nbsp&nbsp&nbsp&nbsp </label>
                            <input class="input-box" type="text" name="video_link" size="50" required="required"><br>
                            <BR>
                                                           <label for="email" style="float:left;margin-right:5px;"> Email address:&nbsp&nbsp&nbsp&nbsp&nbsp     </label>
   
                            <input class="input-box" ID="email"type="email" name="email" size="47" required="required"><br>
                         
                                <div class ="form-group">
                                <label for="text" >Comment:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp   </label>
                            <textarea class="form-control input-box" rows="4"   ID= "comment"type="text" name="comment" ></textarea><br>
                                     </div>   
                            <button type="button" ID="watch-a-video" data-toggle="modal" data-target="#myModal" style="font-size:13px;margin-right: 8px;margin-top: 45px;">How to Submit?</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="input-box" ID="submit" type="submit" name="upload" value="Submit">
                        </form>
                        
                       
            </div>
            
           
            
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
      
  
<?php
include('footer.php');
?>