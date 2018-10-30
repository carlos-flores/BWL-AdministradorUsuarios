<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<spring:url value="/" var="urlRoot" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="${urlRoot }"><i class="fas fa-home fa-2x"></i> Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			
			<sec:authorize access="hasAnyAuthority('ADMIN')">
				<li class="nav-item"><a class="nav-link" href="${urlRoot }users/index"><i class="fas fa-users"></i> Usuarios</a></li>
			</sec:authorize>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<ul class="navbar-nav mr-auto">
				<sec:authorize access="hasAnyAuthority('ADMIN')">
					<li class="nav-item"><a class="nav-link" href="${urlRoot }logout"><i class="fas fa-sign-out-alt"></i> Salir</a></li>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="${urlRoot }formLogin"><i class="fas fa-sign-in-alt"></i> Login</a></li>
				</sec:authorize>
			</ul>
		</form>
	</div>
</nav>