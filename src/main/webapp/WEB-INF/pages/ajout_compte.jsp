<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
		<jsp:useBean id="adresse" class="fr.uvsq.amis.projetbanquejee.entity.Adresse" scope="request"></jsp:useBean>
		<jsp:useBean id="client" class="fr.uvsq.amis.projetbanquejee.entity.Client" scope="session"></jsp:useBean>
		
		<div class="hauteur">
			<div class="col-md-8 offset-md-2">
				<h2>Ajout Compte</h2>
				<div class="row">
					<div class="col-md-11">
						
						<form method="post" action="./AjoutCompte" >
		           			 <div class="modal-body" >
		                   		<div class="form-group row">
		                       		<label for="montant" class="col-sm-4 col-3 col-form-label" name="Montant">Montant</label>
		                   			<div class="col-sm-8 col">
		                   				<input type="search" class="form-control " id="adr-depart-input" placeholder="100000.0" name="Montant" value="${leClient.compte.montant }">
		                           	</div>
		                   		</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
									<button type="submit"  class="btn btn-success" >Valider</button>
								</div>
		                    </div>
		              	</form>
		              	
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp" />	
		<jsp:include page="inclusions_foot.jsp" />	
</body>
</html>