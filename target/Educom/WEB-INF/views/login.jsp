<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Educom Companies</title>
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="js\cand.js" type="text\javascript"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%@ page isELIgnored="false"%>
</head>
<body>
 <div class="account-display" id="login" style="display: block">
		<h1 class="text-center">"${message}"</h1>
		<legend>Please Login</legend>
		<form action="login" class="needs-validation" novalidate>
			<div class="form-group">
				<label for="uname">Username:</label>
				<div class="input-group">
					<span><i class="fa fa-user"></i></span> 
					<input type="text" class="form-control" id="uname" placeholder="Enter username"
						name="uname" required>
				</div>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<div class="input-group">
					<span><i class="fa fa-lock"></i></span> <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" required>
				</div>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember" required>
					Remember Me.
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Check this checkbox to continue.</div>
				</label> <a href="#" class="forgot-password">fogot password</a>
			</div>
			<div class="text-center">
				<button type="submit"
					class="btn btn-primary btn-success educom-submit">Login</button>
			</div>
		</form>
		<p>
			Are you new to Educom? <a class="new-account" href="newAccount">Create New Account</a> instead
		</p>
	</div>
</body>
<style>
* {
	margin: 0px;
	padding: 0px;
}

body {
	background-image: url("images/login.jpg");
	background-attachment: fixed;
	background-size: cover;
	font-family: new time, OpenSans, Arial, roman;
}

h1 {
	font-size: -webkit-xxx-large;
	color: white;
	margin-bottom: 40px;
}

p {
	margin-top: 3%;
	color: ghostwhite;
	font-family: cursive;
	font-style: italic;
	font-size: 110%;
}

legend {
	font-family: "OpenSans", Arial, sans-serif;
	-webkit-font-smoothing: subpixel-antialiased;
	color: #d2e4d4;
	font-size: 16px;
	text-align: center;
	padding: 0 10px;
	font-weight: 300;
	text-transform: uppercase;
}

.fa {
	font-size: 22px;
	color: #565050;
	padding: 8px;
}

.account-display {
	background: rgba(0, 0, 0, 0.5);
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 50%;
	padding: 3%;
	border-radius: 10%;
	margin-top: 5%;
}

.educom-submit, .btn-success {
	font-size: x-large;
	width: 40%;
	margin: 3%;
	border-color: #21e860;
	border-radius: 3%;
	color: #3ba02e;
	background: ghostwhite;
	vertical-align: initial;
	margin-left: auto;
	font-weight: bold;
	margin-right: auto;
	}

.new-account {
	color: #63efef;
	color: #63efef;
	text-decoration: none;
	font-size: 120%;
	font-family: monospace;
	font-weight: 600;
	font-style: normal;
}

.forgot-password {
	color: #63efef;
	text-decoration: none;
	float: right;
	font-size: 20px;
	font-family: monospace;
	font-weight: 600;
	font-style: italic;
}

.forgot-password:hover, .new-account:hover {
	color: #1cf31c;
	text-decoration: none;
	transition: 0.5s ease-in-out;
	transition: 0.8s ease-in-out;
	transition-delay: 0.08s;
}

.educom-submit:hover {
	color: #fff;
	background-color: #218838;
	border-color: #1e7e34;
	font-family: sans-serif;
	box-shadow: 1px 1px 15px 5px #bfbfbf;
	transition: 0.4s ease-in-out;
}

label {
	font-size: larger;
	font-weight: 600;
	font-family: "OpenSans", sans-serif;
	color: #ffffffc7;
}

.form-control{
    background-color: #dcdcdc;
 }

</style>
</html>
