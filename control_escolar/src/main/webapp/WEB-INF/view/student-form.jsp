<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Alumno</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-student-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Control Escolar</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Alumno</h3>
	
		<form:form action="saveStudent" modelAttribute="student" method="POST">

			<!-- need to associate this data with student id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="firstName" />	
						<form:errors path="firstName" cssClass="error"/></td>
						
						
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="lastName" />
						<form:errors path="lastName" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" />
						<form:errors path="email" cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><label>Telefono:</label></td>
						<td><form:input path="phone" />
						<form:errors path="phone" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/student/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










