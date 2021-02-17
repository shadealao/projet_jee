<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
	<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");
	if(c != null){
		%>
		<jsp:include page="menu.jsp" />
	<%} else {%>
		<jsp:include page="inclusions.jsp" />	
		<jsp:forward page="se_connecter.jsp"></jsp:forward>
	<%} %>
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	
	</head>

	<body>
		<c:if test="${message.valeur == 'ok' }" >
			<div class="fixed-top alert alert-success alert-dismissible fade show" role="alert">
				<a id="message">${message.chaine}</a>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${message.valeur == 'non' }" >
			<div class="fixed-top alert alert-danger alert-dismissible fade show" role="alert">
				<a id="message">${message.chaine}</a>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<div class="hauteur">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link" href="./Compte">Retour</a>
					</div>
				</div>
			</nav>
			<div class="alert alert-success" role="alert">Compte ajouté avec
				succès!!!!</div>
			<jsp:include page="foot.jsp" />
			<jsp:include page="inclusions_foot.jsp" />
		</div>
	</body>
</html>