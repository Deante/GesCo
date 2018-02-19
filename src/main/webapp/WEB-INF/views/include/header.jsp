<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Le super site de Thomas</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8 ">
			<section>
			<div class="d-flex justify-content-between">
				<div class="d-6">
					<sec:authorize access="hasRole('ROLE_USER')">
						<c:if test="${pageContext.request.userPrincipal.name != null}">
				logged as : ${pageContext.request.userPrincipal.name}|
				 <a href="/j_spring_security_logout">Logout</a>
						</c:if>

					</sec:authorize>


				</div>
				<div class="d-2">
					<a href="?language=en">En</a> | <a href="?language=fr">FR</a>
				</div>
			</div>
			</section>
			<section>
			<div class="jumbotron">
				<h1>GesCO.com</h1>
				<p style="color: orange;">
<%-- 					<spring:message code="welcomemessage" /> --%>
					GesCo => pour une gestion scolaire plus facile !!
				</p>
			</div>
			</section>