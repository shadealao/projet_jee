<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="inclusions.jsp" />
		
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
		<!-- <script src="js/register.js"></script> -->
		<title>Gestion compte</title>
	</head>
	
	<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-link active" href="./Home">Accueil</a>
       <a class="nav-link" href="./AjoutCompte">Ajouter un compte</a>
      <a class="nav-link active" href="./Home">Effectuer Depot</a>
      <a class="nav-link" href="./Client">Effectuer Retrait</a>
      <a class="nav-link" href="./Compte">Faire Versement</a>
    </div>
  </div>
</nav>
	
	</body>
</html>
