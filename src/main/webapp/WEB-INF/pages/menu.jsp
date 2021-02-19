<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="inclusions.jsp" />
		<style type="text/css">
			<%@ include file="../css/home.css" %>
		</style>
	</head>

	<body>
		<%
		String p = request.getServletPath().toString();
		p = p.substring(15);
		%>
		<nav class="navbar navbar-expand-lg navbar-light bg-light col-md-12">
			<a class="navbar-brand col-md-1 col-2" href="#">Menu</a>
			<button class="navbar-toggler col-md-1 col-2" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse col-md" id="navbarNav">
				<div class="navbar-nav">
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
					if (p.equals("compte.jsp")) {
					%>
					<a class="nav-link active" href="./Compte">Mes Comptes</a>
					<%
					} else {
					%>
					<a class="nav-link" href="./Compte">Mes Comptes</a>
					<% 
					}
					if (p.equals("ajout_compte.jsp")) {
					%>
					<a class="nav-link active" href="./AjoutCompte">Ajouter un compte</a>
					<%
					} else {
					%>
					<a class="nav-link" href="./AjoutCompte">Ajouter un compte</a>
					<%
					}
					%>
				</div>
			</div>
			
			<jsp:useBean id="client" class="fr.uvsq.amis.projetbanquejee.entity.Client" scope="session"></jsp:useBean>
			<div class="d-flex align-items-end flex-column m-0 p-0 logout col-12 col-md-3" >
  				<a class="nav-link m-0 p-0" href="./Logout"><i class="logouticon bi bi-box-arrow-in-right"></i></a>
  				<div class="mt-auto m-0 p-0">Bonjour ${leClient.prenom} ${leClient.nom}</div>
			</div>
		</nav>
	</body>
</html>
