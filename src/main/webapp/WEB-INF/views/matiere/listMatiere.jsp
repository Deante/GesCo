<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col"></div>
			<div class="col-8">
				<div class="card">
					<div class="card-header">Liste des Matieres</div>

					<div class="card-body">
						<table id="tableHorse"
							class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th scope="col">Identifiant</th>
									<th scope="col">Nom</th>
									<th scope="col">Couleur</th>
									<th scope="col">Salles</th>
									<th scope="col">Profs</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${matieres}" var="matieres">
									<tr>
										<td>${matieres.id}</td>
										<td>${matieres.nom}</td>
										<td><form:select path="couleur" items="${couleurs}" /></td>
										<td>${matieres.salles.id}:${horse.centreEquestre.nom}</td>
										<td>${matieres.profs.id}</td>
										<td><a class="btn btn-info" href="edit/${matieres.id}"><span
												class="fa fa-edit"></span></a> <a class="btn btn-danger"
											href="del/${matieres.id}"><span class="fa fa-trash-o"></span></a>
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<h4>Ajouter cheval:</h4>
						<form:form method="post" action="add/" modelAttribute="matiere">
							Nom<form:input path="nom" />
							Couleur<form:input path="couleur" />
							Salles<form:input path="salles.id" />
							Profs<form:input path="profs.id" />
							<button type="submit" value="ajouter" class="btn btn-info">
								<span class="fa fa-plus-circle"></span>
							</button>
							<span> <form:errors path="nom" cssClass="errorblock"
									element="div" /> <form:errors path="remarque"
									cssClass="errorblock" element="div" />
							</span>
						</form:form>
					</div>
				</div>
			</div>
			<div class="col"></div>
		</div>
	</div>
</body>
</html>