<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear noticia</title>

<spring:url value="/" var="urlRoot" />
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/users/update" var="urlPublicUpdate" />
<spring:url value="/users/delete" var="urlPublicDelete" />

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
	<c:if test="${msg != null }">
		<div class='alert alert-success text-center' role="alert">${ msg }
			<i class="fas fa-check-circle"></i>
		</div>
	</c:if>
	<c:if test="${msg_error != null }">
		<div class='alert alert-success text-center' role="alert">${ msg_error }
			<i class="fas fa-exclamation-circle"></i>
		</div>
	</c:if>
	
	<div class="container">
		
<div class="form-row">
			<div class="col-md-11">
				<h2>
					<i class="fas fa-users"></i> Usuarios
				</h2>
			</div>
			<div class="col-md-1 text-right">

				<a class="btn btn-success" href="${urlRoot}users/create"><i
					class="fas fa-plus-circle" title="Agregar usuario"
					data-toggle="modal" data-target="#exampleModal"></i></a>
			</div>
		</div>
		<hr />

		<table class="table table-over table-striped">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre(s)</th>
					<th scope="col">usuario</th>
					<th scope="col">Role</th>
					<th scope="col">email</th>
					<th scope="col">Fecha Registro</th>
					<th scope="col">Status</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ usuariosList }" var="user" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${user.nombre} ${user.apellidos}</td>
						<td>${user.username}</td>
						<td>${user.role}</td>
						<td>${user.email}</td>
						<td><fmt:formatDate value="${ user.fechacreacion }"	pattern="dd-MM-yyyy" /></td>
						<td>
							<c:if test="${user.status == 1 }">
								<i class="fas fa-toggle-on fa-lg"></i>
							</c:if>
							<c:if test="${user.status == 0 }">
								<i class="fas fa-toggle-off fa-lg"></i>
							</c:if>
						</td>
						<td>
							<a class="btn btn-warning" href="${urlPublicUpdate}/${user.id}"><i	class="fas fa-edit" title="Actualizar"></i></a>&nbsp;&nbsp; 
							<a class="btn btn-danger" href="#" onclick="confirmacion('${urlPublicDelete}/${user.id}')"><i class="fas fa-trash-alt" title="Eliminar"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
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
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
		function confirmacion(urlEliminar){
			swal({
				  title: "¿Deseas eliminar al usuario?",
				  text: "Una vez eliminado no se puede recuperar el registro!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
				    window.location.href = urlEliminar;
				  }
				});
		}
		
		function presionado(){
			console.log('se ha presionado el boton...');
		}
	</script>
</body>
</html>