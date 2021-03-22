<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<c:if test="${leClient != null }">
			<jsp:include page="menu.jsp" />
		</c:if>
		<c:if test="${leClient == null }">
			<jsp:include page="inclusions.jsp" />	
			<jsp:forward page="se_connecter.jsp"></jsp:forward>

		</c:if>
		<link rel="stylesheet" type="file/image" href="images/Guichet-banque.jpg"
				th:href="@{images/Guichet-banque.jpg}" />
	</head>

	
	<body  >

		<img src=" http://localhost:8080/static/Guichet-banque.jpg" />

		<div class="col-md-8 offset-md-2 hauteur">
			<div class="row">
				<h2 class="col-md-12 text-center mt-2">Bienvenue dans votre espace personnel</h2>
				<div class="col-md-8 offset-md-2 mt-3 card mb-3  bg-light shadow rounded">
					<div class="card-body">
						<p>Cet espace personnel vous servira à faire diverses opérations</p>
						<p>En effet, vous pourrez modifiez vos coordonées personnelles en allant sur l'onglet "Mes informations"</p>
						<p>De plus, vous pourrez vous créer un compte en banque, y retirer de l'argent, faire un dépot et un retrait vers le compte de votre choix</p>
						<p>Pour finir, la suppression d'un compte et de votre espace personnel est égalemmenbt faisable, toute fois avant de les réaliser n'oubliez pas de retirer votre solde sinon ils ne vous sera plus possible de récupérer vos bien. Ceux-ci seront perdu.</p>
					</div>	
				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp" />	
		<jsp:include page="inclusions_foot.jsp" />	
	</body>
</html>
