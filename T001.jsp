<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login - Training</title>
<link href="https://fonts.googleapis.com/css?family=Volkhov" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css/style.css">

<script language="JavaScript">
	var myFunction = function () {
		var txtUserID = document.getElementById("txtUserID").value;
	    var txtPassword = document.getElementById("txtPassword").value;
		if(txtUserID == 0){
			document.getElementById("error").innerHTML = ('ユーザーIDを入力してください。');
			return false;
		}else if(txtPassword == 0){
			document.getElementById("error").innerHTML = ('パスワードを入力してください。');
			return false;
		}
	    return true;
	}

</script>
<style>
	.content1 {
	text-align: center;
    width: 97%;
    height: 400px;
    position: relative;
	}
	#error {
    font-weight: lighter;
    font-size: 14px;
    text-align: center;
    color: red;
    position: fixed;
    left: 43%;
    top: 33%;
}
</style>
</head>
<body>
<div class="contentpage">
	<h1 id="title1">Training</h1>
	<hr />
	<a href="T001_LoginServlet">Login</a>

	<h3 id="title2">LOGIN</h3>
	<div class="content1" style="posision:relative !important;">
		<form action="T001_LoginServlet" method="post" onsubmit="return myFunction();">
			<h2 id="error" style="posision:relative;"><%= request.getAttribute("message") != null ? request.getAttribute("message"): " "  %></h2>
			<h2 id="error" style="posision:relative;"></h2>
			User Id:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="txtUserID" maxlength="8" id="txtUserID" class="inputdata" /> 
			<br />
			 <br /> 
			Password: <input type="password" name="txtPassword" maxlength="8" id="txtPassword"  class="inputdata"  /> 
			<br />
			 <br /> 
			<div class="container">
				 
				  <div class="bottomleft"><input type="submit" value="Login" class="button" id="btnLogin"/></div>
				  <input class="button bottomright" type="reset" value="Clear" onclick="document.getElementById('error').innerHTML = ''" id="btnClear"/>
				</div>
		</form>
	</div>

	<div class="fixed">
		<hr />
		<p >&nbsp;&nbsp;&nbsp;&nbsp;Copyright(c) 2000-2008 FUJINET, All Rights Reserved.</p>
	</div>
	</div>
</body>
</html>
