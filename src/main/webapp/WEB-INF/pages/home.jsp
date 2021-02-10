<!DOCTYPE html>
<html>
	<head>
	
		<jsp:include page="inclusions.jsp" />	
	
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	</head> 
	
	<body>
		<div class="col-md-8 offset-md-2">
			<p>1</p><%= request.getServletContext().getServlets() %>
			<p>2</p><% String pa = request.getServletPath().toString();%>
			
			
			<h2>Accueil</h2>
			<div class="row">
				<div class="col-md-6">
					<h3>Inscription</h3>
					<form class="col-md-12" method="post" action="Inscription" >
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
		                    <div class="form-group row">
		                        <label for="EmailInscr" class="col-sm-4 col-3 col-form-label">Email</label>
		                        <div class="col-sm-8 col">
		
		                            <input type="email" required="required" class="form-control" id="emailreg" placeholder="Email" name="EmailInscr">
		                        </div>
		                    </div>
		                    <div class="form-group row">
		                        <label for="Mdp1Inscr" class="col-sm-4 col-3 col-form-label">Mot de passe</label>
		                        <div class="col-sm-4 col">
		                            <input type="password" required="required" class="form-control" id="mdp1" placeholder="*******" name="Mdp1Inscr">
		                        </div>
		                        <div class="col-sm-4 col">
		                            <input type="password" required="required" class="form-control" id="mdp2" name="Mdp2Inscr" placeholder="*******">
		                        </div>
		                    </div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
		                    <button type="submit"  class="btn btn-success" >Valider</button>
		                </div>
		            </form>
				</div>
				
				<div class="col-md-6">
					<h3>Connection</h3>
					<form class="col-md-12" method="post" action="Connection" >
		                <div class="modal-body" >
		                    <div class="form-group row">
		                        <label for="EmailCo" class="col-sm-4 col-3 col-form-label">Email</label>
		                        <div class="col-sm-8 col">
		
		                            <input type="email" required="required" class="form-control" id="emailreg" placeholder="Email" name="EmailCo">
		
		                        </div>
		                    </div>
		                    <div class="form-group row">
		                        <label for="MdpCo" class="col-sm-4 col-3 col-form-label">Mot de passe</label>
		                        <div class="col-sm col">
		                            <input type="password" required="required" class="form-control" id="mdp3" placeholder="*******" name="MdpCo">
		                        </div>
		                    </div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
		                    <button type="submit"  class="btn btn-success" >Valider</button>
		                </div>
		            </form>
				</div>
			</div>
		</div>
		
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	
	</body>
</html>
