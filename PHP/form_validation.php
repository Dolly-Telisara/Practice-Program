<!doctype html>
<html>

<head>
<title> Form Validation  </title>
<h2> PHP Form Validation </h2> <br>

<style>
.error {
	color : #FF0000;
	}
</style>
</head>
------------------------------------------------------------------------------------------------------------------------------------------------------------------
<body>
 
<!-- FORM VALIDATION IN PHP => -->

<?php

//define variables and set to empty values
$name = $email = $website = $comment = $gender = "";
$nameErr = $emailErr = $websiteErr = $commentErr = $genderErr = "";

if($_SERVER["REQUEST_METHOD"]=="POST")
{
	if(empty($_POST["name"]))
	{
		$nameErr="Name is required";
	}
	else
	{
		$name=test_input($_POST["name"]);
		
		if(!preg_match("/^[a-zA-Z]*$/",$name))
		{
			$nameErr="Only letters and whitespaces allowed";
		}
	}
	
	if(empty($_POST["email"]))
	{
		$emailErr="Email is required";
	}
	else
	{
		$email=test_input($_POST["email"]);
		
		if(!filter_var($email,FILTER_VALIDATE_EMAIL))
		{
			$emailErr="Invalid email format";
		}
	}
	
	if(empty($_POST["website"]))
	{
		$websiteErr="";   //Website is optional
	}
	else
	{
		$website=test_input($_POST["website"]);
		
		if(!preg_match("/\b(?:(?:http?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%?=~_|]/i",$website))
		{
			$websiteErr="Invalid URL";
		}
	}
	
	if(empty($_POST["comment"]))
	{
		$commentErr="";   //Comment is optional
	}
	else
	{
		$comment=test_input($_POST["comment"]);
	}
	
	if(empty($_POST["gender"]))
	{
		$genderErr="Gender is required";
	}
	else
	{
		$gender=test_input($_POST["gender"]);
	}
}

function test_input($data)
{
	$data=trim($data); //remove extra space,tab,newline
	$data=stripslashes($data); //removes backslashes
	$data=htmlspecialchars($data); // prevents injection of html or JS code
	return $data;
}
?>

---------------------------------------------------------------------------------------------------------

<!-- INPUT DATA IN FORM => -->

<p> <span class="error">* required field </span> </p> 
<form method = "post"  action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  <!-- If you want php in another file , action="form.php"--> 

Name : <input type="text" name="name" value="<?php echo $name;?>" > <!-- Here php tag Prevents the form from emptying all the input fields when the user submits the form-->
<span class="error">* <?php echo $nameErr;?> </span> <br> <br>          <!--If form action = form.php remove $nameErr from here -->

E-mail : <input type="text" name="email" value="<?php echo $email;?>"> 
<span class="error">* <?php echo $emailErr;?> </span> <br> <br>

Website : <input type="text" name="website" value="<?php echo $website;?>"> 
<span class="error"><?php echo $websiteErr;?> </span> <br> <br>

Comment :<br> <textarea rows="5" cols="40" name="comment" value="<?php echo $comment;?>"> </textarea> <br><br>

Gender : <input type="radio" name="gender"  <?php if(isset($gender) && $gender=="female") echo "checked"; ?>  value="female" >Female 
		 <input type="radio" name="gender"  <?php if(isset($gender) && $gender=="male") echo "checked"; ?> value="male">Male  
		 <input type="radio" name="gender"  <?php if(isset($gender) && $gender=="other") echo "checked"; ?> value="other">Other 
<span class="error">* <?php echo $genderErr;?> </span> <br> <br>

<input type="submit" name="submit" value="Submit">

</form>

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<!-- Dispaly Inputed Data =>  -->

<?php

echo "<h2> Your Input : </h2>";
if($nameErr=="")
{
echo $name;
}

echo "<br>";
if($emailErr==""){
echo $email;
}
echo "<br>";
if($websiteErr==""){
echo $website;
}
echo "<br>";

echo $comment;
echo "<br>";
if($genderErr==""){
echo $gender;
}
echo "<br>";
?> 

</body>
</html>