<%@ include file="templates/header.jsp" %>
 <h1>Roles</h1>
 <div class="row">
		<div class="col-sm-4">
			<button class="educom-button" onclick="window.location.href='/Educom/home/roles/createNewRole'">Add new Role</button>
		</div>
		<div class="col-sm-2">
				<button onclick="window.location.href='/Educom/home/roles'" class="educom-button">Clear</button>
		</div>		
		<form class="col-sm-6" style="width: -webkit-fill-available" action="/Educom/home/roles/search">
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
       <th>Role Id</th>
       <th>Role Name</th>
       <th>Lecturer</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempRole" items="${roles}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/home/roles/updateRole">
        <c:param name="roleId" value="${tempRole.roleId}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/home/roles/deleteRole">
        <c:param name="roleId" value="${tempRole.roleId}" />
       </c:url>

       <tr>
        <td>${tempRole.roleId}</td>
        <td>${tempRole.roleName}</td>
        <td>${tempRole.lecturer.firstName} ${tempRole.lecturer.lastName}</td>
        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}" id="onDelete" onclick="return displayDeleteModal('${tempRole.roleId}', '${tempRole.roleName}', '${deleteLink}')">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>
   </div>

<%@ include file="templates/footer.jsp"%>