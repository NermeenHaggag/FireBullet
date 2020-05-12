
<?php
require("DBS.php");
$msg = "";
if(isset($_POST['login'])){
  $username= $_POST['username'];
  $password = $_POST['password'];
  $remember = false;
  if(isset($_POST['remember'])){
    $remember = true;
  }
  $res=DB::query('SELECT username FROM users WHERE username=:username',array(':username'=>$username));
  print_r($res);
  if(DB::query('SELECT username FROM users WHERE username=:username',array(':username'=>$username))){
	  echo 'here';
    $userId = DB::query('SELECT id FROM users WHERE username=:username',array(':username'=>$username))[0]["id"];
	print_r(DB::query('SELECT password FROM users WHERE username=:username',array(':username'=>$username))[0]['password']);
    if($password == DB::query('SELECT password FROM users WHERE username=:username',array(':username'=>$username))[0]["password"]){
		$type=DB::query('SELECT usertype FROM users  WHERE username=:username',array(':username'=>$username))[0]["usertype"];
        //Fun::addLoginToken($userId,$remember);
        $msg = "Login";
		echo $type;
        if($type=='admin'){
          header("Location: sidebaradmin.php");
          exit;
        }
		else if($type=='engineer'){
          header("Location: sidebarengineer.php");
          exit;
        }
        //header("Location: ./");
        //exit;
    }else{
      $msg = "Username or Password are incorrect";
    }
  }else{
    // Password Verify for someRandomText to ensure that the process take the Same Time if the username is correct for security reasons...
    password_verify($password, 'someRandomText');
    $msg = "Username or Password are incorrect";
  }
}
?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>LOG IN</title>
    <meta name="keywords" content="Example, Example2"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="reset.css">
    <link rel="stylesheet" href="master.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

    <script>
      document.addEventListener("touchstart", function() {},false);

      var mobileHover = function () {
    $('*').on('touchstart', function () {
        $(this).trigger('hover');
    }).on('touchend', function () {
        $(this).trigger('hover');
        });
    };
    mobileHover();
    </script>
  </head>
  <body>
    <div class="login-form">
      <p style="color:red;"><?php echo $msg; ?></p>
      <form class="main-form" method="post">
        <p>Username</p>
        <input type="text" name="username" required placeholder="username"><br>
        <p>Password</p>
        <input type="password" name="password" required placeholder="password"><br>
        <input type="checkbox" name="remember" value="remember" id="remember"> <label for="remember">Remember me </label>
        <br>
        <input type="submit" name="login" value="login">
      </form>
    </div>
  </body>
<html>
