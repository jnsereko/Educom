<%@ include file="templates/header.jsp" %>
	<h1>${message}</h1>
 <div class="row">
		<div class="col-sm-4">
			<button class="educom-button" onclick="window.location.href='/Educom/home/courseUnits/createNewCourseUnit'">Add new Course Unit</button>
		</div>
		<div class="col-sm-2">
				<button onclick="window.location.href='/Educom/home/courseUnits'" class="educom-button">Clear</button>
		</div>		
		<form class="col-sm-6" style="width: -webkit-fill-available" action="/Educom/home/courseUnits/search">
			<div class="row">

				<div class="col-sm-7">
				    <input type="text" class="educom-form" placeholder="Enter Course Unit Name or Id" name="keyword" value="${keyword}" required>
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
       <th>Subject Code</th>
       <th>Subject Name</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempCourseUnit" items="${courseUnits}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/home/courseUnits/updateCourseUnit">
        <c:param name="unitId" value="${tempCourseUnit.unitId}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/home/courseUnits/deleteCourseUnit">
        <c:param name="unitId" value="${tempCourseUnit.unitId}" />
       </c:url>

       <tr>
        <td>${tempCourseUnit.unitCode}</td>
        <td>${tempCourseUnit.unitName}</td>
        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"  onclick="return displayDeleteModal('${tempCourseUnit.unitCode}', '${tempCourseUnit.unitName}', '${deleteLink}')">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>
   </div>

<%@ include file="templates/footer.jsp" %>




