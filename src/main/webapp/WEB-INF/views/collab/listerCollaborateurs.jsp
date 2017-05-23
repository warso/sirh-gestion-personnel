<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>

<body>

	<h1>Les collaborateurs</h1>

	<!-- Liste des noms -->

	<ul>

		<%
			List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("collab");

			for (Collaborateur collabo : listeNoms) {
		%>

		<li><%=collabo.getMatricule()%></li>
		<li><%=collabo.getNom()%></li>
		<li><%=collabo.getPrenom()%></li>
		<li><%=collabo.getDateDeNaissance()%></li>
		<li><%=collabo.getAdresse()%></li>
		<li><%=collabo.getNumeroDeSecu()%></li>
		<li><%=collabo.getEmailPro()%></li>
		

		<%
			}
		%>

	</ul>
</body>

</html>