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
	
	<% fr.uvsq.amis.projetbanquejee.entity.Message msg = (fr.uvsq.amis.projetbanquejee.entity.Message) request.getAttribute("message"); 
				if((msg != null) && (msg.getValeur() =="ok")){
				
			%>
			<div class="fixed-top alert alert-success alert-dismissible fade show" role="alert">
				<a name="message">${message.chaine}</a>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<%} else if((msg != null) && (msg.getValeur() =="non")){ %>
			<div class="fixed-top alert alert-danger alert-dismissible fade show" role="alert">
				<a name="message">${message.chaine}</a>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			
			<%}%>
		<jsp:useBean id="client" class="fr.uvsq.amis.projetbanquejee.entity.Client" scope="session"></jsp:useBean>
		
		<div class="col-md-8 offset-md-2">
			<h2>Profil Client :   </h2>
			<div class="row">
				
				<div class="col-md-11">
					
       
            <form method="post" action="Client" >
                <div class="modal-body" >
                    <div class="form-group row">
                        <label for="prenom" class="col-sm-4 col-3 col-form-label">Prénom</label>
                        <div class="col-sm-8 col">
                            <input type="text" required="required" class="form-control" id="prenom" placeholder="Jules" name="PrenomClient" value="${leClient.prenom }">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="nom" class="col-sm-4 col-3 col-form-label" >Nom</label>
                        <div class="col-sm-8 col">
                            <input type="text" required="required" class="form-control" id="nom" placeholder="Dupont" name="NomClient" value="${leClient.nom }">
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <label for="RueClient" class="col-sm-4 col-3 col-form-label">Adresse</label>
                        <div class="col-sm-4 col">
                            <input type="search" class="form-control " id="adr-depart-input" placeholder="Rue" name="RueClient" value="${leClient.adresse.rue }">
                        </div>
                        <div class="col-sm-4 col">
                            <input type="search" class="form-control " id="adr-depart-input" placeholder="Ville" name="VilleClient" value="${leClient.adresse.ville }">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                	<button type="submit"  class="btn btn-danger col-4" name="modifier" value="supprimer">Supprimer le profil</button>
                    <button type="submit" class="btn btn-dark offset-3" data-dismiss="modal" name="modifier" value="annuler">Annuler</button>
                    <button type="submit"  class="btn btn-success" name="modifier" value="modifier" >Modifier</button>
                </div>
            </form>
				</div>
				
			</div>
		</div>
		
	
	
	<jsp:include page="inclusions_foot.jsp" />	
	</body>
</html>
