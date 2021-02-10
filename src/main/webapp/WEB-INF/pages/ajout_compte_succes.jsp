<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
	<head>
	<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) request.getAttribute("leClient");
// 	if(c != null){
		%>
		<jsp:include page="menu.jsp" />
<%-- 	<%} else {%> --%>
<%-- 		<jsp:include page="inclusions.jsp" />	 --%>
<%-- 		<jsp:forward page="se_connecter.jsp"></jsp:forward> --%>
<%-- 	<%} %> --%>
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	
		<title>AjoutCompte</title>
	</head>
	
	<body>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
 		 <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    		<div class="navbar-nav">
      			<a class="nav-link" href="./Compte">Retour</a>
   			</div>
 		 </div>
	</nav>
	<div class="alert alert-success" role="alert">
  		Compte ajouté avec succès!!!!
   </div>
	</body>
</html>