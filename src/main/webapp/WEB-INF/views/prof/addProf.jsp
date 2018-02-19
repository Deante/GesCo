<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="../include/header.jsp" />

<spring:url value="/prof/add" var="profAdd" />
<spring:url value="/prof/list" var="profList" />

<section class="container">

	<h3>
		Gestion des profs <small> > ${action} </small>
	</h3>
	<p>
		<a href="${profList}">Retour à la liste des profs</a>



		<form:form method="POST" action="${profAdd}"
			modelAttribute="prof">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="prenom">
<%-- 				<spring:message --%>
<%-- 						code="views.prof.addprof.form.label.prenom" /> --%>
						</label>
				<form:input path="prenom" class="form-control"
					placeholder="Entrez le prénom ici" />
				<%--Show errors for firstnamefield --%>
				<p> <form:errors path="prenom"/></p>
			</div>
			<div class="form-group">
				<label for="nom">
<%-- 				<spring:message --%>
<%-- 						code="views.prof.addprof.form.label.nom" /> --%>
<!-- 						</label> -->
				<form:input path="nom" class="form-control"
					placeholder="Entrez le nom ici" />
					<%--Show errors for lastnamefield --%>
				<p> -- <form:errors path="nom"/>--</p>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
</section>
<c:import url="../include/footer.jsp" />