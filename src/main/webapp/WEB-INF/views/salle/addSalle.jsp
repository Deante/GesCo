<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="../include/header.jsp" />

<spring:url value="/salle/add" var="salleAdd" />
<spring:url value="/salle/list" var="salleList" />

<section class="container">

	<h3>
		Gestion des salles <small> > ${action} </small>
	</h3>
	<p>
		<a href="${salleList}">Retour à la liste des salles</a>


		<form:form method="POST" action="${salleAdd}"
			modelAttribute="salle">
			<form:hidden path="id" /> 
			
			<div class="form-group">
				<label for="nom"></label>
				<form:input path="nom" class="form-control"
					placeholder="Entrez le nom ici" />
			</div>
			
			<div class="form-group">
				<label for="capacite"></label>
				<form:input path="capacite" class="form-control"
					placeholder="Entrez la capacité ici" />
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
</section>
<c:import url="../include/footer.jsp" />