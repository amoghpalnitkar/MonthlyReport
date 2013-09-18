<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<?xml version="1.0" encoding="utf-8"?>
<html>
<head></head>

<style type="text/css">
    <%@include file="css/style.css" %>
</style>
<body class="mid1" bgcolor=#000029>

<img src="Images/blank.PNG" class="mr" align="top" >

  <form class="userlogin" action = "LoginServlet" method = "POST">
<b class="head">Sign In</b>
<br>
<br>
<input type="radio" name="userType" value="Staff" checked="checked" />Staff
<input type="radio" name="userType" value="Student" />Student<br>
<br>
<b>Username</b> <input type="text" name="uname" value="" id="uname">
<b>Password</b> <input type="password" name="password" value="" id="password">


<input class="login" type="submit" value="Login" id="login">
<br>
<a  href ="forgotpassword.jsp"><b>Forgot Password?</b></a><br>
<a  href ="register.jsp"><b>Register</b></a>
</form>

</body>
</html>
