 <%@ include file="templates/header.jsp" %>
	<h1>Welcome to Educom Companies</h1>
	<div class ="row" align="center">
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/students/createNewStudent'"> 
			<i class="fa fa-graduation-cap" aria-hidden="true"></i>
			<h4>New Student</h4>
		</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/students'">
				<i class="fa fa-graduation-cap" aria-hidden="true"></i>
				<h4>Find Student</h4>
			</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/lecturers/createNewLecturer'">
				<i class="fa fa-male" aria-hidden="true"></i>
				<h4>New Lecture</h4>
			</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/lecturers'">		
				<i class="fa fa-male" aria-hidden="true"></i>
				<h4>Find lecturer</h4>
			</button>
		</div>
		
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/classes/createNewClass'">
				<i class="fa fa-group" aria-hidden="true"></i>
				<h4>New Class</h4>
			</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/classes'">
				<i class="fa fa-group" aria-hidden="true"></i>
				<h4>Find Class</h4>
			</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light"  onclick="window.location.href='/Educom/home/courseUnits/createNewCourseUnit'">
				<i class="fa fa-address-book" aria-hidden="true"></i>		
				<h4>New Subject</h4>
			</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/courseUnits'">
				<i class="fa fa-address-book" aria-hidden="true"></i>		
				<h4>Find Subject</h4>
			</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light"  onclick="window.location.href='/Educom/home/roles/createNewRole'">
				<i class="fa fa-address-book" aria-hidden="true"></i>		
				<h4>New role</h4>
			</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn shadow btn-light" onclick="window.location.href='/Educom/home/roles'">
				<i class="fa fa-address-book" aria-hidden="true"></i>		
				<h4>Find Role</h4>
			</button>
		</div>
		<div class="col-sm-3">		
			<button type="button" class="btn shadow btn-light">
				<i class="fa fa-cogs" aria-hidden="true"></i>
				<h4>Other</h4>
			</button>
		</div>
	</div>

<style>
	.btn-light{
		width: 100%;
    	height: 150px;
    	margin-bottom: 30px;
    	background: -webkit-linear-gradient(top, #ebfffc, #273028);
    	border: none;
	}
	.btn-light:hover{
    	transition: 0.6s ease-out;
		background: -webkit-linear-gradient(top, #273028, #ebfffc);
	}
	
	.btn-light:hover h4{
		color: #05351f;
    	font-weight: 700;
    	transition: 0.4s ease-out;
	    font-size: 190%;
	}
	
	.btn-light:hover i{
	    color: #d2e5e1;
	    transition: 0.4s ease-out;
	    font-size: 260%;	
	}
	.btn i{
		font-size: xx-large;
    	font-weight: 900;
    	color: #05351f;
	}
	h4{
		color: snow;
	}
	
	.shadow {
    	box-shadow: 0 .5rem 1rem rgba(0,0,0,0.55)!important;
	}
</style>
<%@ include file="templates/footer.jsp" %>