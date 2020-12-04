<%@ page import="java.util.Date"  %>
<%@ include file="templates/header.jsp" %>
	<h1>Register New Person</h1>
		
		<form:form action="saveStudent" method="post" modelAttribute="student">
	
	      <!-- need to associate this data with customer id -->
	      <form:hidden path="userId" />
	    
			<div class="container">
				<br><legend>Personal Information</legend><br>
			
				<div class="row">
					<div class="form-group col-sm-6">
						<label for="firstName" >First Name:</label>
						<form:input path="firstName" type="text" class="educom-form" placeholder="Enter First Name" required="true" />
					</div>
					<div class="form-group col-sm-6">
						<label for="lastName">Last Name:</label>
						<form:input path="lastName" type="text" class="educom-form" placeholder="Enter Last Name" required="true" />							
					</div>
				</div>

				<div class="form-group">
						<label for="email">Email</label>
						<form:input path="email" type="text" class="educom-form" placeholder="Enter Email" required="true" />
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
				</div>
				<div class="row">
						<div class="form-group col-sm-6">
							<label for="pwd">Password:</label>
								<input type="password" class="educom-form" id="fpwd" placeholder="Enter password" name="fswd" required>
						</div>
						<div class="form-group col-sm-6">
							<label for="userPassword">Confirm:</label>
						    <form:input path="userPassword" type="password" class="educom-form" placeholder="Re-enter Password" required="true" />
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
					</div>
				<div class="row">
					<div class="form-group col-sm-4">
						<label for="userBirthDate">birthdate:</label>
						<form:input onchange="calcAge()" path="userBirthDate" max="2020" type="date" id="dateOfBirth" class="educom-form" placeholder="Enter Birthdate" required="true"/>
					</div>
					<div class="form-group col-sm-4">
						<label for="userAge" style="xolor: #72fff2">Age:</label>
						<p class="educom-form-disabled"id="showAge"></p>
					</div>
					<div class="form-group col-sm-4">
				      	<label for="gender">Gender</label>
				        <form:select path="gender" name="gender" class="educom-form">
				          <form:option value="M">Male</form:option>
				          <form:option value="F">Female</form:option>
				        </form:select>
				    </div>
				</div>
				<div class="row">
						<div class="form-group col-sm-6">
							<label for="basary">Bursary:</label>
							<form:input path="basary" id="basary" type="number" class="educom-form" placeholder="Enter basary" required="true" />
						</div>
						
						<div class="form-group col-sm-6">
							<label style="xolor: #72fff2" >Tution</label>
							<p class="educom-form-disabled" id="tutionChange"></p>							
						</div>
				</div>
				<div class="row">
						<div class="form-group col-sm-6">
							<label for="userImage">User Image:</label>
							<form:input path="userImage" type="file" class="educom-form" required="true" />							
						</div><div class="form-group p col-sm-6">
							<label for="userBio">Uplaod Bio:</label>
							<form:input path="userBio" type="file" class="educom-form" required="true" />							
						</div>
					</div>
				
				<br><legend>Contact Information</legend><br>

				<div class="row">
						<div class="form-group col-sm-4">
							<label for="userContact">Personal Contact:</label>
							<form:input path="userContact" type="tel" minlength="10" maxlength="10" class="educom-form" placeholder="Enter Personal Contact" required="true" />							
						</div>						
						<div class="form-group col-sm-4">
							<label for="userContact">Home Contact:</label>
							<form:input path="userContact" type="tel" minlength="10" maxlength="10" class="educom-form" placeholder="Enter Personal Contact" required="true" />							
						</div>						
						<div class="form-group col-sm-4">
							<label for="userContact">Referee Contact:</label>
							<form:input path="userContact" type="tel" minlength="10" maxlength="10" class="educom-form" placeholder="Enter Personal Contact" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userAddress">Personal Address:</label>
							<form:input path="userAddress" type="text" class="educom-form" placeholder="Enter Personal Address" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userAddress">Home Address:</label>
							<form:input path="userAddress" type="text" class="educom-form" placeholder="Enter Home Address" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userAddress">Referee Address:</label>
							<form:input path="userAddress" type="text" class="educom-form" placeholder="Enter Referee Address" required="true" />							
						</div>
				</div>
				
				<br><legend>Relationship</legend><br>
				
				<div class ="container row">
						<div class ="selective-label col-sm-6">
							<div class="subjects" align="center">
						      	<label onmouseover="openTable('classes', 'subjects')">Class</label>
						      	<label onmouseover="openTable('subjects', 'classes')" style="margin-bottom: auto">Subjects</label>
						    </div>
						</div>
						
					      <div id="classes" class="educom-div-select col-sm-6">
					    	<label style="zoom: 1.2">Tick a <mark>Class</mark> the Student Belongs</label>
					        <table class="table table-hover educom-table-select">
						   		<c:forEach var="tempClasses" items="${allClasses}">
									<tr>
							        	<td style="font-weight: 600;font-size: 18px">${tempClasses.studentClassName}</td>
							        	<td style="font-weight: 600;font-size: 18px">${tempClasses.courseCode}</td>
							        	<td><input type="checkbox" name="courseUUID" style="zoom: 1.5;" value="${tempClasses.courseUUID}"/></td>
							        </tr>
						        </c:forEach>
					      	</table>
					      </div>
					      
					      <div id="subjects" style="display: none" class="educom-div-select col-sm-6">
					    	<label style="zoom: 1.2">Tick All <mark>Course Units</mark> attended by Student</label>
					        <table class="table table-hover educom-table-select">
						   		<c:forEach var="tempCourseUnit" items="${courseUnits}">
									<tr>
							        	<td style="font-weight: 600;font-size: 18px">${tempCourseUnit.unitCode}</td>
							        	<td style="font-weight: 600;font-size: 18px">${tempCourseUnit.unitName}</td>
							        	<td><input type="checkbox" name="unitUUID" style="zoom: 1.5;" value="${tempCourseUnit.unitUUID}"/></td>
							        </tr>
						        </c:forEach>
					      	</table>
					      </div>
					      
					</div>
				<div class="text-center">
	        		<form:button type="submit" id="createaccount" class="btn educom-submit btn-success">Submit</form:button>
				</div>
			</div>
		</form:form>
<script>
 function weeklySalary(){
	var hours = document.getElementById("workingHours").value;
	var perHour = document.getElementById("salary").value;
	if(hours!==NaN || perHour!==Nan){
		document.getElementById("showBaseSalary").innerHTML = hours*perHour; 
	}
 };
 
 function openTable(idName, idName1){
		var id = document.getElementById(idName);
		var id1 = document.getElementById(idName1);
	 
	if (id.style.display === "none") {
		id.style.display = "block";
		id1.style.display = "none";
	}else if (id.style.display === "block") {
		id.style.display = "block";
		id1.style.display = "none";
	}
 };
</script>
<%@ include file="templates/footer.jsp" %>