<%@ include file="templates/header.jsp" %>
 <h1>${message}</h1>
 <div class="row">
		<div class="col-sm-4">
			<button class="educom-button" onclick="window.location.href='/Educom/home/lecturers/createNewLecturer'">Add new Lecturer</button>
		</div>
		<div class="col-sm-2">
				<button onclick="window.location.href='/Educom/home/lecturers'" class="educom-button">Clear</button>
		</div>		
		<form class="col-sm-6" style="width: -webkit-fill-available" action="/Educom/home/lecturers/search">
			<div class="row">

				<div class="col-sm-7">
				    <input type="text" class="educom-form" placeholder="Enter lecturers Name or Id" name="keyword" value="${keyword}" required>
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
       <th>Lecturer Id</th>
       <th>Name</th>
       <th>Contact</th>
       <th>Age</th>
       <th>Gender</th>
       <th>Salary</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempLecturer" items="${lecturers}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/home/lecturers/updateLecturer">
        <c:param name="userId" value="${tempLecturer.userId}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/home/lecturers/deleteLecturer">
        <c:param name="userId" value="${tempLecturer.userId}" />
       </c:url>

       <tr>
        <td>${tempLecturer.lecturerId}</td>
        <td>${tempLecturer.firstName} ${tempLecturer.lastName}</td>
        <td>${tempLecturer.userContact[0]}</td>
        <td>${tempLecturer.userAge}</td>
        <td>${tempLecturer.gender}</td>
        <td>${tempLecturer.salary}</td>
        <td>
        <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}" onclick="return displayDeleteModal('${tempLecturer.lecturerId}', '${tempLecturer.firstName}  ${tempLecturer.lastName}', '${deleteLink}')">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>
   </div>
<%@ include file="templates/footer.jsp"%>