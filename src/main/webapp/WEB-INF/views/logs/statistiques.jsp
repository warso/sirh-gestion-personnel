<%@page import="dev.sgp.entite.VisiteWeb"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>

<body>
<a href="../collaborateurs/lister" class="btn btn-lg btn-primary"><span class="glyphicon glyphicon-user"></span> lister</a>
<a href="../collaborateurs/nouveau" class="btn btn-lg btn-primary"><span class="glyphicon glyphicon-user"></span>nouveau</a>
<a href="../collab/activites" class="btn btn-lg btn-primary"><span class="glyphicon glyphicon-user"></span> statistiques</a>
	<h1 style="text-align: center; margin: 20px 0 30px 0">Les visites</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Chemin</th>
				<th>Nombre de visites</th>
				<th>Min</th>
				<th>Max</th>
				<th>Moyenne</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="visite" items="${visites}">
				<tr>
					<td>${visite.chemin}</td>
					<td>${visite.nbVisites}</td>
					<td>${visite.min}</td>
					<td>${visite.max}</td>
					<td>${visite.moyenne}</td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
</body>
</html>