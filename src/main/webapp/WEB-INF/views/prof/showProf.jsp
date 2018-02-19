<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<c:import url="../include/header.jsp" />
<h3>Gestion des profs <small> > détail de l'prof "${profFromDb.prenom} ${profFromDb.nom}" </small></h3>
<ul>
	<li>Id: ${profFromDb.id}</li>
	<li>Prenom: ${profFromDb.prenom}</li>
	<li>Nom: ${profFromDb.nom}</li> 
</ul>
	
	<h4>Liste des Matieres</h4>
	<ul>
	<c:forEach items="${profFromDb.Matieres}" var="matiere">
		<li><a href="<c:url value="/matiere/${matiere.id}" />">${matiere.nom}( ${matiere.anneeProduction}, ${matiere.nombrePistes} pistes )</a></li>		
	</c:forEach>
	</ul>
<c:import url="../include/footer.jsp" />