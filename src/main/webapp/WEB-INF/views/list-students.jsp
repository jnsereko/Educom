<%@ include file="templates/header.jsp" %>
 <h1>${message}</h1>
 <div class="row">
		<div class="col-sm-4">
			<button class="educom-button" onclick="window.location.href='/Educom/home/students/createNewStudent'">Add new Student</button>
		</div>
		<div class="col-sm-2">
				<button onclick="window.location.href='/Educom/home/students'" class="educom-button">Clear</button>
		</div>		
		<form class="col-sm-6" style="width: -webkit-fill-available" action="/Educom/home/students/search">
			<div class="row">

				<div class="col-sm-7">
				    <input type="text" class="educom-form" placeholder="Enter Role Name or Id" name="keyword" value="${keyword}" required>
				</div>
				<div class="col-sm-3">
					<button type="submit" class="educom-button">Search</button>
				</div>
			</div>
		</form>
	</div>
   <div class="container">
      <table class="table table-dark table-striped table-bordered">
      <tr style="background: #243d3d">
       <th>Student Id</th>
       <th>Student Name</th>
       <th>Student Course</th>
       <th>Student Gender</th>
       <th>Action</th>
      </tr>

      <c:forEach var="tempStudent" items="${students}">

       <c:url var="updateLink" value="/home/students/updateStudent">
        <c:param name="studentId" value="${tempStudent.userId}" />
       </c:url>

       <c:url var="deleteLink" value="/home/students/deleteStudent">
        <c:param name="studentId" value="${tempStudent.userId}" />
       </c:url>

       <tr>
        <td>${tempStudent.studentId}</td>
        <td>${tempStudent.firstName}  ${tempStudent.lastName}</td>
        <td>${tempStudent.studentClass.studentClassName}</td>
        <td>${tempStudent.gender}</td>
        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}" onclick="return displayDeleteModal('${tempStudent.studentId}', '${tempStudent.firstName}  ${tempStudent.lastName}', '${deleteLink}')">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>
   </div>

<%@ include file="templates/footer.jsp"%>