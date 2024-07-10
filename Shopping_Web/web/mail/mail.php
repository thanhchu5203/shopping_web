<?
$name = $_POST{'name'};
$email = $_POST{'email'};
$address = $_POST{'address'};
$message = $_POST['message'];

$email_message = "

Name: ".$name."
Email: ".$email."
Address: ".$address."
Message: ".$message."

";

mail ("thahiostream@gmail.com" , "New Message", $email_message);
header("location: gmail.com/mail-send.html");
?>


