<%@ include file="templates/header.jsp" %>
 <h1>"${message}"</h1>
 <div class="container">
	  <form:form action="saveCourseUnit" cssClass="form-horizontal"
	      method="post" modelAttribute="courseUnit">
	
	      <!-- need to associate this data with customer id -->
	      <form:hidden path="unitId" />
	
	      <div class="form-group">
	       <label for="unitCode">Subject Code</label>
	        <form:input path="unitCode" type="text" class="educom-form" placeholder="Enter Subject Code" required="true" />
	      </div>
	      <div class="form-group">
	       <label for="unitName">Subject Name</label>
	        <form:input path="unitName"  type="text" class="educom-form" placeholder="Enter Subject name" required="true" />
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