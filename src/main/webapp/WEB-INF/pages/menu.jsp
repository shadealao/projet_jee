<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="inclusions.jsp" />	
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	
		<title>Gestion compte</title>
	</head>
	
	<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-link" href="./Logout">Se déconnecter</a>
      <a class="nav-link" href="./Client">Gestion Client</a>
      <a class="nav-link" href="./AjoutCompte">Ajouter un compte</a>
      <a class="nav-link active" href="./depot">Effectuer Depot</a>
      <a class="nav-link" href="./retrait">Effectuer Retrait</a>
      <a class="nav-link" href="./Compte">Faire Versement</a>
    </div>
  </div>
</nav>
	
	</body>
</html>
