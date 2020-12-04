<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Educom Companies</title>
<%@ page isELIgnored="false"%>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="js\cand.js" type="text\javascript"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body style="font-family: new time, OpenSans, Arial, roman; width: 97%; border-radius: 15%; margin: auto; background: rgba(0, 0, 0, 0.5)">

	<div class="header">
		<div class="img-logo" align="center">
			<a href="#">Educom<i class="fa fa-envelope-open-o" aria-hidden="true"></i></a>
			
		</div>	
		<div class="dropdown">
			<button class="dropbtn">
				<i style="color: #243d3d; font-size: x-large " class="fa fa-user"></i>
			</button>
			
			<div class="dropdown-content">
				<a href="#">My Account</a>
			</div>
		</div>
	</div>

	<style>
		/* Popup container */
		.header {
		  background: darkslategray; 
		  height: 65px; 
		  margin-top: 20px; 
		  overflow: hidden;
		}
		
.img-logo a{
	color: #fff;
    display: flex;
    align-items: center;
    text-decoration: none;
    padding: 0.5rem 1rem;
    outline: none;
    font-size: 30px;
    position: relative;
    left: 10px;
}		
.img-logo a i{
	color: #fff;
    margin-left: 10px;
 	font-size: initial;
}
.img-logo a:hover {
	border-bottom: 4px solid #fff;
	font-size: 27px;
    transition: all 0.2s ease-out;
    left: 20px;
}

		
		.dropdown{
		
		}
		.img-logo{
		    position: absolute;
		}
		
		.dropdown .dropbtn {
		  	border: none;
		  	outline: none;
		 	float: right; 
    		height: 45px;
    		border-radius: 30%; 
		 	margin-right: 10px; 
		 	margin-top: 10px; 
		 	width: 5%;
		}
		
		.dropdown .dropbtn.onfocus{
			outline: none;
		}
		.dropdown-content {
		  display: none;
		  margin: 4px;
		  background: initial;		  
		  min-width: 122px;
		  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		  z-index: 1;
		  margin-top: 55px;
		  position: fixed;
		    background: #efefef;
		    right: 27px;
		    border-radius: 5%;
		}
		
		.dropdown-content a {
		  float: none;
		  color: #243d3d;;
		  padding: 12px 16px;
		  text-decoration: none;
		  display: block;
		  text-align: center;
		}
		
		.dropdown-content a:hover {
		  background-color: #619999;
		  color: #ededed;
		  border-radius: 16%;
		}
		
		.dropdown:hover .dropdown-content {
		  display: block;
		}
	</style>

