<?php  
require_once 'dbConnect.php';  
session_start();  
    class dbFunction {  
            
        function __construct() {  
              
            // connecting to database  
            $db = new dbConnect();;  
               
        }  
        // destructor  
        function __destruct() {  
              
        }  
        public function InsertVideo($name,$label,$yol,$video_url,$email,$comment,$date){    
                $qr = mysql_query("INSERT INTO video_submittion(name, label, year_of_learning,email,video_url,comment,dateof_submittion) values('".$name."','".$label."','".$yol."','".$video_url."','".$email."','".$comment."','".$date."')") or die(mysql_error());  
                return $qr;  
               
        }
		
		public function MailVideo($to,$subject,$message,$headers)
		{
			$mailvideo = mail($to,$subject,$message,$headers);
			return $mailvideo;	
		}
		
	}