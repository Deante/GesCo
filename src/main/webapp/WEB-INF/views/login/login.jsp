<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>GesCo</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col"></div>

			<div class="col-10">
				<div class="d-2">
					<a href="?language=en">EN</a> | <a href="?language=fr">FR</a>
				</div>
				<sec:authorize access="hasRole('ROLE_USER')">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
                logged as : ${pageContext.request.userPrincipal.name}|
                 <a href="/logout">Logout</a>
					</c:if>
				</sec:authorize>

				<div class="row">
					<div class="col"></div>
					<div class="col">
						<form method="POST" action="">
							<table id="logint"
								class="table table-bordered table-hover table-striped">
								<tr>
									<th scope="col">User</th>
									<th scope="col">Password</th>
								</tr>
								<tr>
									<td><input type="text" name="username" /></td>
									<td><input type="password" name="password" /></td>
								</tr>
								<tr>
									<td colspan="2"><button type="submit" value="connect"
											class="btn btn-info">
											<span class="fa fa-check-square-o"></span>
										</button></td>
								</tr>
							</table>
						</form>
					</div>
					<div class="col"></div>
				</div>

			</div>
			<div class="col"></div>
		</div>
	</div>
</body>
</html>
