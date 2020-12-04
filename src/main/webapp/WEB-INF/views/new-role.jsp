<%@ include file="templates/header.jsp" %>
 <h1>${message}</h1>
 <div class="container">
	  <form:form action="saveRole" cssClass="form-horizontal"
	      method="post" modelAttribute="role">
	
	      <!-- need to associate this data with roleId -->
	      <form:hidden path="roleId" />

	      <div class="form-group">
	       <label for="roleName">Role Name</label>
	        <form:input path="roleName"  type="text" class="educom-form" placeholder="Enter Role name" required="true" />
	      </div>
	 	  <div class ="container row">
			<div class ="selective-label col-sm-6">
				<div class="subjects" align="center">
					<label style="margin-bottom: auto">Lecturer</label>
				</div>
			</div>
			<div id="lecturers" class="educom-div-select col-sm-6">
				<label style="zoom: 1.2">Select a <mark>Lecturer</mark> To Conducted the Role</label>
				<table class="table table-hover educom-table-select">
					<c:forEach var="tempLecturer" items="${lecturers}">
						<tr>
							<td style="font-weight: 600;font-size: 18px">${tempLecturer.lecturerId}</td>
							<td style="font-weight: 600;font-size: 18px">${tempLecturer.firstName} ${tempLecturer.lastName}</td>
							<td><input type="checkbox" name="userUUID" style="zoom: 1.5;" value="${tempLecturer.userUUID}"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
					   
		</div>
	 	
	      <div class="form-group">
	       <!-- Button -->
	       <div align="center">
	        <form:button type="submit" class="btn educom-submit btn-success">Submit</form:button>
	       </div>
	      </div>
	
	    </form:form>
     </div>
     <%@ include file="templates/footer.jsp" %>