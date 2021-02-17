<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<jsp:include page="inclusions.jsp" />
<style type="text/css">
<%@ include file="../css/home.css" %>
</style>

<title>Gestion compte</title>
</head>

<body>
	<%
		String p = request.getServletPath().toString();
		p = p.substring(15);
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">

				<a class="nav-link" href="./Logout">Se déconnecter</a>

				<%
					if (p.equals("client.jsp")) {
				%>
				<a class="nav-link active" href="./Client">Gestion Client</a>
				<%
					} else {
				%>
				<a class="nav-link" href="./Client">Gestion Client</a>
				<%
					}
				
					if (p.equals("ajout_compte.jsp")) {
				%>
				<a class="nav-link active" href="./AjoutCompte">Ajouter un
					compte</a>
				<%
					} else {
				%>
				<a class="nav-link" href="./AjoutCompte">Ajouter un compte</a>
				<%
					}
					
					if (p.equals("depot.jsp")) {
				%>
				<a class="nav-link active" href="./depot">Effectuer Depot</a>
				<%
					} else {
				%>
				<a class="nav-link" href="./depot">Effectuer Depot</a>
				<%
					}
				
					if (p.equals("retrait.jsp")) {
				%>
				<a class="nav-link active" href="./retrait">Effectuer Retrait</a>
				<%
					} else {
				%>
				<a class="nav-link" href="./retrait">Effectuer Retrait</a>
				<%
					}
				
					if (p.equals("compte.jsp")) {
				%>
				<a class="nav-link active" href="./Compte">Faire Versement</a>
				<%
					} else {
				%>
				<a class="nav-link" href="./Compte">Faire Versement</a>
				<%
					}
				%>

			</div>
		</div>
	</nav>

</body>
</html>
