<?php

require_once "vendor/autoload.php";
if(array_key_exists('sub', $_POST)) {
	  
  $name = $_POST['name'];
  $emailAdd = $_POST['email'];
  $message = $_POST['message'];

    $mail = new PHPMailer;

    //Enable SMTP debugging. 
    $mail->SMTPDebug = 0;                               
    //Set PHPMailer to use SMTP.
    $mail->IsSMTP();            
    //Set SMTP host name                          
    $mail->Host = "smtp.gmail.com";
    //Set this to true if SMTP host requires authentication to send email
    $mail->SMTPAuth = true;                          
    //Provide username and password     
    $mail->Username = "liangbill2006@gmail.com";                 
    $mail->Password = "DKlichking007!";                           
    //If SMTP requires TLS encryption then set it
    $mail->SMTPSecure = "tls";                           
    //Set TCP port to connect to 
    $mail->Port = 587;                 

    $mail->SetFrom = "poopy@fukoff.com";
    $mail->FromName = "LIFE IS A GAME, REMEMBER THIS";
    $mail->AddAddress("liangbill2006@gmail.com", "Bill Liang");

    $mail->Subject = "Contact from Personal Website";
    $mail->Body = "Name: ".$name. "</br>
    Email Address: ".$emailAdd. "</br>
    Message: " .$message. " ";
    $mail->AltBody = "This is the plain text version of the email content";
    $mail->IsHTML(true);
    if(!$mail->Send()) 
    {
        echo "Mailer Error: " . $mail->ErrorInfo;
    } 
    else 
    {
        $alart = "Email sent succesful, we will be in touch soon!";
        echo '<script type="text/javascript">'; 
        echo 'alert("Email sent successfully");'; 
        echo 'window.location.href = "index.html";';
        echo '</script>';
    }
	  
} 

?>
