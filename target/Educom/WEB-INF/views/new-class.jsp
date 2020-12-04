<%@ include file="templates/header.jsp" %>
 <h1>${message}</h1>
 <form:form action="saveClass" cssClass="form-horizontal"
      method="post" modelAttribute="course">

      <!-- need to associate this data with customer id -->
      <form:hidden path="studentclassId" />
	<div class="container">
	<br><legend>class Details</legend><br>
      <div class="form-group">
       <label for="studentClassName">Class Name</label>
        <form:input path="studentClassName"  type="text" class="educom-form" placeholder="Enter class name" required="true" />
      </div>
      <div class="row">
      	<div class="form-group col-sm-6">
	       <label for="studentclassId">Class id</label>
	        <form:input path="studentclassId" type="number" class="educom-form" placeholder="Enter class id" required="true" />
	      </div>
      	 <div class="form-group col-sm-6">
	       <label for="studentclassId">Class id</label>
	        <form:input path="studentclassId" type="number" class="educom-form" placeholder="Enter class id" required="true" />
	      </div>
      </div>
			<br><legend>Relationship</legend><br>
			<div class ="container row">
				<div class ="selective-label col-sm-6">
					<div class="subjects" align="center">
					     <label onmouseover="openTable('subjects', 'lecturers', 'students')">Subjects</label>
					     <label onmouseover="openTable('lecturers', 'students' , 'subjects')">Lecturers</label>
						 <label onmouseover="openTable('students', 'lecturers', 'subjects')" style="margin-bottom: auto">Students</label>					</div>
				</div>
				
				<div id="subjects" class="educom-div-select col-sm-6">
					<label style="zoom: 1.2">Tick All <mark>Course Units</mark> Conducted by Lecturer</label>
			        <table class="table table-hover educom-table-select">
				   		<c:forEach var="tempCourseUnit" items="${courseUnit}">
							<tr>
					        	<td style="font-weight: 600;font-size: 18px">${tempCourseUnit.unitCode}</td>
					        	<td style="font-weight: 600;font-size: 18px">${tempCourseUnit.unitName}</td>
					        	<td><input type="checkbox" name="unitUUID" style="zoom: 1.5;" value="${tempCourseUnit.unitUUID}"/></td>
					        </tr>
				        </c:forEach>
			      	</table>
			    </div>
					      
				<div id="lecturers" style="display: none" class="educom-div-select col-sm-6">
					<label style="zoom: 1.2">Tick All <mark>Lecturers</mark> teaching Class</label>
			        <table class="table table-hover educom-table-select">
			   			<c:forEach var="tempLecturer" items="${lecturers}">
							<tr>
				        		<td style="font-weight: 600;font-size: 18px">${tempLecturer.lecturerId}</td>
					       		<td style="font-weight: 600;font-size: 18px">${tempLecturer.firstName} ${tempLecturer.lastName}</td>
				        		<td><input type="checkbox" name="lecturerUUID" style="zoom: 1.5;" value="${tempLecturer.userUUID}"/></td>
				        	</tr>
			        	</c:forEach>
		      		</table>		
		      	</div>
		      							
			    <div id="students"  style="display: none" class="educom-div-select col-sm-6">
					<label style="zoom: 1.2">Tick <mark>Students</mark> Contained in Class</label>
					<table class="table table-hover educom-table-select">
						<c:forEach var="tempStudent" items="${students}">
							<tr>
							   	<td style="font-weight: 600;font-size: 18px">${tempStudent.studentId}</td>
							    <td style="font-weight: 600;font-size: 18px">${tempStudent.firstName} ${tempStudent.lastName}</td>
								<td><input type="checkbox" name="studentUUID" style="zoom: 1.5;" value="${tempStudent.userUUID}"/></td>
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
	
	</div>
</form:form>
<%@ include file="templates/footer.jsp" %>

