<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<c:import url="../include/header.jsp" />
<h3>Gestion des salles <small> > détail de l'salle "${salleFromDb.prenom} ${salleFromDb.nom}" </small></h3>
<ul>
	<li>Id: ${salleFromDb.id}</li>
	<li>Prenom: ${salleFromDb.prenom}</li>
	<li>Nom: ${salleFromDb.nom}</li> 
</ul>
	
	<h4>Liste des Matieres</h4>
	<ul>
	<c:forEach items="${salleFromDb.Matieres}" var="salle">
		<li><a href="<c:url value="/salle/${salle.id}" />">${salle.nom}( ${salle.anneeProduction}, ${salle.nombrePistes} pistes )</a></li>		
	</c:forEach>
	</ul>
<c:import url="../include/footer.jsp" />