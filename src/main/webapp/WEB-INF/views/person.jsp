<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<style type="text/css">
.TFtable {
	width: 50%;
	border-collapse: collapse;
}

.TFtable td {
	padding: 7px;
	border: #4e95f4 1px solid;
}
/* provide some minimal visual accomodation for IE8 and below */
.TFtable tr {
	background: #b8d1f3;
}
/*  Define the background color for all the ODD background rows  */
.TFtable tr:nth-child(odd) {
	background: #b8d1f3;
}
/*  Define the background color for all the EVEN background rows  */
.TFtable tr:nth-child(even) {
	background: #dae5f4;
}
</style>



</head>
<body>

	<div class="container">

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h4>
				Welcome ${pageContext.request.userPrincipal.name} ! <a
					onclick="document.forms['logoutForm'].submit()">| Logout</a> <a
					href="${pageContext.request.contextPath}/exportToExcel">| Excel
					Report</a>
			</h4>

		</c:if>

	</div>


	<h4 class="form-signin-heading">
		<c:if test="${!empty person.name}">Edit Person :</c:if>
		<c:if test="${empty person.name}">Add a Person :</c:if>
	</h4>

	<c:url var="addAction" value="/person/add"></c:url>

	<form:form action="${addAction}" commandName="person">
		<table class="TFtable">
			<c:if test="${!empty person.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" disabled="true" />
						<form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label> :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="email" />
					</form:label> :</td>
				<td><form:input path="email" />
					<form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">
						<spring:message text="phone" />
					</form:label> :</td>
				<td><form:input path="phone" />
					<form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="address" />
					</form:label> :</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="zipcode">
						<spring:message text="zipcode" />
					</form:label> :</td>
				<td><form:input path="zipcode" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty person.name}">
						<input type="submit"
							value="<spring:message text="Update Person"/>"
							class="form-control" placeholder="Update Person" />
					</c:if> <c:if test="${empty person.name}">
						<input type="submit" value="<spring:message text="Add Person"/>"
							class="form-control" placeholder="Add Person" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h4>Persons List</h4>
	<c:if test="${!empty listPersons}">
		<table class="TFtable">
			<tr>
				<th width="80"><u>Id</u></th>
				<th width="120"><u>Name<u></th>
				<th width="120"><u>email<u></th>
				<th width="120"><u>Phone<u></th>
				<th width="120"><u>Address<u></th>
				<th width="120"><u>Zip Code<u></th>
				<th width="60"><u>Edit</u></th>
				<th width="60"><u>Delete</u></th>
			</tr>
			<c:forEach items="${listPersons}" var="person">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td>${person.email}</td>
					<td>${person.phone}</td>
					<td>${person.address}</td>
					<td>${person.zipcode}</td>

					<td><a href="<c:url value='/edit/${person.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${person.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>
