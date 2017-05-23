<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/js/bootstrap.js">
<title>SGP - visite web</title>
</head>

<body class="container">
	<h1>Statisques</h1>

	<br>
	<div class="jumbotron row ">

	<%-- 	<%
			List<VisiteWeb> visitWeb = (List<VisiteWeb>) request.getAttribute("visiteWeb");

			for (VisiteWeb v : visitWeb) {
		%> --%>

		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">

			<table>
				<thead>
					<tr>
						<td>Chemin</td>
						<td>Nombre de visites</td>
						<td>Min(ms)</td>
						<td>Max(ms)</td>
						<td>Moyenne(ms)</td>
					</tr>
				</thead>
				<tbody>

					<tr>
			
					</tr>
				</tbody>
			</table>

		</div>

	</div>
</body>
</html> 