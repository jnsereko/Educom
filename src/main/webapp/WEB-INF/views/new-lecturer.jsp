<%@ page import="java.util.Date" %>
<%@ include file="templates/header.jsp" %>
	<h1>Register New Person</h1>
		
		<form:form action="saveLecturer" method="post" modelAttribute="lecturer">
	
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
						<label for="lastName">Last Name(Sir Name):</label>
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
						<div class="form-group col-sm-4">
							<label for="workingHours">Working Hours:</label>
							<form:input onchange="weeklySalary()" path="workingHours" id="workingHours" type="number" class="educom-form" placeholder="Enter hours worked" required="true" />
						</div>
						<div class="form-group col-sm-4">
							<label for="salary">Salary (per week)</label>
							<form:input onchange="weeklySalary()" id="salary" path="salary" type="number" class="educom-form" placeholder="Enter hours worked" required="true" />
						</div>
						<div class="form-group col-sm-4">
							<label style="xolor: #72fff2" >Weekly Salary</label>
							<p class="educom-form-disabled" id="showBaseSalary"></p>							
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
							<label for="userContact">First Contact:</label>
							<form:input path="userContact" type="number" class="educom-form" placeholder="Enter First Contact" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userContact">Second Contact:</label>
							<form:input path="userContact" type="number" class="educom-form" placeholder="Enter Second Contact" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userContact">Third Contact:</label>
							<form:input path="userContact" type="number" class="educom-form" placeholder="Enter Third Contacts" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userAddress">First Address:</label>
							<form:input path="userAddress" type="text" class="educom-form" placeholder="Enter First Address" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userAddress">Second Address:</label>
							<form:input path="userAddress" type="text" class="educom-form" placeholder="Enter Second Address" required="true" />							
						</div>
						<div class="form-group col-sm-4">
							<label for="userAddress">Third Address:</label>
							<form:input path="userAddress" type="text" class="educom-form" placeholder="Enter Third Address" required="true" />							
						</div>
					</div>
			
					<br><legend>Roles and Relationships</legend><br>
					
					<div class ="container row">
						<div class ="selective-label col-sm-6">
							<div class="subjects" align="center">
						      	<label onmouseover="openTable('subjects', 'roles', 'classes')">Subjects</label>
						      	<label onmouseover="openTable('roles','subjects', 'classes')">Roles</label>
						      	<label onmouseover="openTable('classes', 'roles', 'subjects')" style="margin-bottom: auto">Classes</label>
						    </div>
						</div>
						 <div id="subjects" class="educom-div-select col-sm-6">
					    	<label style="zoom: 1.2">Tick All <mark>Course Units</mark> Conducted by Lecturer</label>
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
					      
					      <div id="roles" style="display: none" class="educom-div-select col-sm-6">
					    	<label style="zoom: 1.2">Tick All <mark>Roles</mark> Conducted by Lecturer</label>
					        <table class="table table-hover educom-table-select">
						   		<c:forEach var="tempRole" items="${lecturerRoles}">
									<tr>
							        	<td style="font-weight: 600;font-size: 18px">${String.format("%03d", tempRole.roleId)}</td>
							        	<td style="font-weight: 600;font-size: 18px">${tempRole.roleName}</td>
							        	<td><input type="checkbox" name="roleUUID" style="zoom: 1.5;" value="${tempRole.roleUUID}"/></td>
							        </tr>
						        </c:forEach>
					      	</table>
					      </div>
					      
					      <div id="classes" style="display: none" class="educom-div-select col-sm-6">
					    	<label style="zoom: 1.2">Tick All <mark>Classes</mark> Taught by Lecturer</label>
					        <table class="table table-hover educom-table-select">
						   		<c:forEach var="tempClasses" items="${classesTaught}">
									<tr>
							        	<td style="font-weight: 600;font-size: 18px">${tempClasses.studentClassName}</td>
							        	<td style="font-weight: 600;font-size: 18px">${tempClasses.courseCode}</td>
							        	<td><input type="checkbox" name="courseUUID" style="zoom: 1.5;" value="${tempClasses.courseUUID}"/></td>
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

<%@ include file="templates/footer.jsp" %>

















