<%@ include file="templates/header.jsp" %>

 <h1>${message}</h1>
 <div class="row">
		<div class="col-sm-4">
			<button class="educom-button" onclick="window.location.href='/Educom/home/classes/createNewClass'">Add new Class</button>
		</div>
		<div class="col-sm-2">
				<button onclick="window.location.href='/Educom/home/classes'" class="educom-button">Clear</button>
		</div>	
		<form class="col-sm-6" style="width: -webkit-fill-available" action="/Educom/home/classes/search">
			<div class="row">
				<div class="col-sm-7">
				    <input type="text" class="educom-form" placeholder="Enter Class Name, Code or Id" name="keyword" value="${keyword}" required>
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
       <th>Class Id</th>
       <th>Class Name</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our Studentclasses -->
      <c:forEach var="tempCourse" items="${studentCourses}">

       <!-- construct an "update" link with StudentClass id -->
       <c:url var="updateLink" value="/home/classes/updateClass">
        <c:param name="studentClassId" value="${tempCourse.studentclassId}" />
       </c:url>

       <!-- construct an "delete" link with StudentClass id -->
       <c:url var="deleteLink" value="/home/classes/deleteClass">
        <c:param name="studentClassId" value="${tempCourse.studentclassId}" />
       </c:url>

       <tr>
        <td>${tempCourse.studentclassId}</td>
        <td>${tempCourse.studentClassName}</td>
        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"href="${deleteLink}" id="onDelete" 
         	onclick="return displayDeleteModal('${tempCourse.studentclassId}', '${tempCourse.studentClassName}', '${deleteLink}')">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>
   </div>
<%@ include file="templates/footer.jsp" %>





