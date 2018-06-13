<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src='https://www.google.com/recaptcha/api.js'></script>
 <link rel="stylesheet" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Form</h1>
<hr>
  <div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">Log in</h2>

  <form class="login-container" action="login" method = "post">
  
  <p style="color:red">${error}</p>
  
  
  
    <p><input type="text" placeholder="username" name = "username"></p>
    <p><input type="password" placeholder="Password" name="password"></p>
    <div class="g-recaptcha" data-sitekey="6Lf4xl0UAAAAADS3M6Bhdj3EQID3Z9eFuRfHYUnG"></div>
    <p><input type="submit" value="log in"></p>
    <a href="facebook">LoginWithFacebook</a>
    
  </form>
</div>

</body>
</html>