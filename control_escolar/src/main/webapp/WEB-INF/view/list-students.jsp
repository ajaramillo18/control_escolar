<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Alumnos</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Control Escolar</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
		
			<input type="button" value="Nuevo Estudiante"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			
			<br/>
			<br/>
			<form:form action="search" method="GET">
				Busqueda por apellido:
				<br/>
				<input  id="name" name="name" size="50"/>
				<input type="submit" value="Buscar" class="save" />		
				
			<a href="${pageContext.request.contextPath}/student/list">    Reset</a>
		
			
			
			</form:form>
			
			<br/>
			<br/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Email</th>
					<th>Telefono</th>
					<th>Accion</th>
				</tr>
				
				<!-- loop over and print our students -->
				<c:forEach var="tempStudent" items="${students}">
				
					<!-- construct an "update" link with student id -->
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>					

					<!-- construct an "delete" link with student id -->
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>	
					
					<!-- construct an "payment" link with student id -->
					<c:url var="paymentLink" value="/student/payment">
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>				
					
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
						<td> ${tempStudent.phone} </td>
						
						<td>
						
							<!-- display the payment link -->
							
							<c:choose> 
							  <c:when test="${tempStudent.status == 'P'}">
							   Pagar
							  </c:when>
							  <c:otherwise>
							    <a href="${paymentLink}">Pagar</a>
							  </c:otherwise>
							</c:choose>
							
							
							|
							<!-- display the update link -->
							<a href="${updateLink}">Modificar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Esta seguro que desea eliminar a este alumno?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









