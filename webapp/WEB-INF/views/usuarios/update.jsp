<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear noticia</title>

<spring:url value="/resources" var="urlPublic" />
<spring:url value="/users/update" var="urlPublicUpdate" />

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
<link rel="stylesheet" href="${urlPublic}/css/styles.css">
</head>
<body>
	<jsp:include page="../include/head.jsp"></jsp:include>

	<spring:hasBindErrors name="usuario">
		<div class="alert alert-danger" role="alert">
			Se encontrarón los siguientes errores:
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li><spring:message message="${error}" /></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>
	<c:if test="${msg_error != null }">
		<div class='alert alert-success text-center' role="alert">
			${ msg_error } <i class="fas fa-exclamation-circle"></i>
		</div>
	</c:if>

	<div class="container">

		<h3 class="blog-title">
			<span class="label label-success">Actualizar Usuario</span>
		</h3>

		<form:form class="form" action="${urlPublicUpdate}" method="post" modelAttribute="usuario">
			<form:hidden path="id"/>
			<form:hidden path="username"/>
			<form:hidden path="fechacreacion"/>
			<div class="form-group">
				<label >Nombre(s)</label> 
				<form:input type="text" class="form-control" path="nombre" required="required" />
			</div>
			<div class="form-group">
				<label >Apellido(s)</label> 
				<form:input type="text" class="form-control" path="apellidos" required="required" />
			</div>
			<div class="form-group">
				<label >Usuario</label>
				 <input type="text" class="form-control" disabled="true" value="${usuario.username}"/>
<%-- 				<form:input type="text" class="form-control" path="username" required="required" disabled="true"/> --%>
			</div>
			<div class="form-group">
				<label >Email</label> 
				<form:input type="text" class="form-control" path="email" required="required" />
			</div>
			<div class="form-group">
				<label >Role</label> 
				<form:select path="role" class="form-control">
					<form:option value="ADMIN">Administrador</form:option>
					<form:option value="USER">Usuario</form:option>
				</form:select>	
			</div>
			<div class="form-group">
				<label >Status</label> 
				<form:select path="status" class="form-control">
					<form:option value="1">Activo</form:option>
					<form:option value="0">Inactivo</form:option>
				</form:select>	
			</div>
			
			<div class="form-group">
				<label >Password</label> 
				<form:input type="password" class="form-control" path="pwd" required="required" />
			</div>
			<div class="form-group">
				<label >Confirmación</label> 
				<input type="password" class="form-control" name="confirmacion" value="${confirmacion}" required="required" />
			</div>

			<hr />

			<div class="row">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-danger"><i class="fas fa-save"></i> Guardar</button>
				</div>
			</div>


		</form:form>



	</div>
	<jsp:include page="../include/footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>