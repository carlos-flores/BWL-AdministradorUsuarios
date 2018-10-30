<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a CineAPP</title>
<spring:url value="/" var="urlRoot" />
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/css/tempusdominus-bootstrap-4.min.css" />
<link rel="stylesheet" href="${urlPublic}/css/styles.css">
</head>
<body>
	<jsp:include page="include/head.jsp"></jsp:include>
	<c:if test="${param.error != null }">
		<div class='alert alert-success text-center' role="alert">
			Acceso denegado	<i class="fas fa-exclamation-triangle"></i>
		</div>
	</c:if>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">Login</div>
					<div class="card-body">
						<form name="form" action="${urlRoot}login" method="POST">
							<div class="form-group row">
								<label for="email" class="col-sm-4 col-form-label text-md-right"><i	class="fas fa-at"></i> Usuario</label>
								<div class="col-md-6">
									<input type="text" class="form-control" name="username">
								</div>
							</div>

							<div class="form-group row">
								<label for="password" class="col-md-4 col-form-label text-md-right"><i class="fas fa-key"></i> Password</label>
								<div class="col-md-6">
									<input type="password" class="form-control" name="password">
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<div class="form-group row mb-0">
								<div class="col-md-12 ">
									<button name="submit" type="submit" class="btn btn-primary btn-block"><i class="fas fa-sign-in-alt"></i> Ingresar</button>
<!-- 									<input name ="submit" type="submit" class="btn btn-primary btn-block fas fa-sign-in-alt" value="Ingresar"> -->
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="include/footer.jsp"></jsp:include>

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