<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="menu.jsp" />
		
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	</head> 
	
	<body>
		<jsp:useBean id="adresse" class="fr.uvsq.amis.projetbanquejee.entity.Adresse" scope="request"></jsp:useBean>
		<jsp:useBean id="client" class="fr.uvsq.amis.projetbanquejee.entity.Client" scope="session"></jsp:useBean>
		
		<div class="col-md-8 offset-md-2">
			<h2>Profil Client :   </h2>
			<div class="row">
				
				<div class="col-md-11">
					
       
            <form method="post" action="Client" >
                <div class="modal-body" >
                    <div class="form-group row">
                        <label for="prenom" class="col-sm-4 col-3 col-form-label" name="PrenomClient">Pr�nom</label>
                        <div class="col-sm-8 col">
                            <input type="text" required="required" class="form-control" id="prenom" placeholder="Jules" name="PrenomClient" value="${leClient.prenom }">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="nom" class="col-sm-4 col-3 col-form-label" name="NomClient">Nom</label>
                        <div class="col-sm-8 col">
                            <input type="text" required="required" class="form-control" id="nom" placeholder="Dupont" name="NomClient" value="${leClient.nom }">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="EmailClient" class="col-sm-4 col-3 col-form-label">Email</label>
                        <div class="col-sm-8 col">

                            <input type="email" required="required" class="form-control" id="email" placeholder="Email" name="EmailClient" value="acompleter@gm.co">

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
                    <button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
                    <button type="submit"  class="btn btn-success" >Modifier</button>
                </div>
            </form>
       
				</div>
			</div>
		</div>
		
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	
	</body>
</html>
