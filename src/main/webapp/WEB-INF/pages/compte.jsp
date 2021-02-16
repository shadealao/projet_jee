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
	
		<link th:rel="stylesheet" th:href="@{webjars/bootstrap/4.0.0-2/css/bootstrap.min.css} "/>
		<c:url var="edit" value="./Compte" />
		</head>
	
	<body>
	
		<div class="container">
			<div class="hauteur">
				<h1>Vos Comptes</h1>
	
				<table class="table">
					<thead>
						<tr>
							<th>NUMERO COMPTE</th>
							<th>MONTANT</th>
							<th>ACTION</th>
						</tr>
					</thead>
					<tbody>
	
						<tr>
							<td>1</td>
							<td>200.0</td>
							<td>
								<button type="button" class="btn btn-primary">
									<i class="far fa-eye">Detail</i>
								</button>
								<button type="button" class="btn btn-danger">
									<i class="far fa-trash-alt">Supprimer</i>
								</button>
	
							</td>
						</tr>
	
					</tbody>
				</table>
			</div>
	
	
			<jsp:include page="foot.jsp" />
			<jsp:include page="inclusions_foot.jsp" />
		</div>
	</body>
</html>
