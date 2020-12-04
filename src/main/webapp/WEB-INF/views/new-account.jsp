<%@ include file="templates/header.jsp" %>
		<h1>Register New Person</h1>
		
		<form:form action="saveUser" cssClass="form-horizontal"
	      method="post" modelAttribute="user">
	
	      <!-- need to associate this data with customer id -->
	      <form:hidden path="userId" />
	
			<div class="container">
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
						<label for="userName">User Name:</label>
						<form:input path="userName" type="text" class="educom-form" placeholder="Enter User Name" required="true" />
						<a href="#" class="forgot-password" style="padding: 10px">Use default username</a>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
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
						<div class="form-group col-sm-6">
							<label for="userBirthDate">birthdate:</label>
							<form:input path="userBirthDate" type="date" class="educom-form" placeholder="Enter Birthdate" required="true" />

						</div>
						<div class="form-group col-sm-6">
							<label for="userAge">Age:</label>
							<form:input path="userBirthDate" type="number" class="educom-form" placeholder="age" required="true" disabled="true" />							
						</div>
					</div>
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
					<div class="row">
						<div class="form-group col-sm-6">
							<label for="userImage">User Image:</label>
							<form:input path="userImage" type="file" class="educom-form" required="true" />							
						</div><div class="form-group p col-sm-6">
							<label for="userBio">Uplaod Bio:</label>
							<form:input path="userBio" type="file" class="educom-form" required="true" />							
						</div>
					</div>
					<div class="form-group">
				      <label for="educomtype">Educom Type</label>
				        <select id="educomtype" name="educomtype" class="educom-form">
				          <option value="teacher">Teacher</option>
				          <option value="student">Student</option>
				          <option value="applicant">Applicant</option>
				          <option value="other">Other</option>
				        </select>
				    </div>
					<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" name="remember"
							onclick="showCreateAccountButton()" required> Agree on <a
							href="#" style="color: darkgreen">Terms and Conditions </a> of
							Educom.
						</label>
					</div>
					<div class="text-center">
	        			<form:button type="submit" id="createaccount" style="display: none" class="btn educom-submit btn-success">Submit</form:button>
					</div>
				</div>
		</form:form>
		<button type="submit" class="btn btn-primary btn-danger shadow" onclick="window.location.href='/Educom'">Cancel</button>
<script>
				function showCreateAccountButton() {
					var x = document.getElementById("createaccount");
					if (x.style.display === "none") {
						x.style.display = "block";
						x.style.transition = "0.8 ease-in-out"
					} else {
						x.style.transition = "0.8 ease-in-out"
						x.style.display = "none";						
					}
				};
			</script>
<%@ include file="templates/footer.jsp" %>
			