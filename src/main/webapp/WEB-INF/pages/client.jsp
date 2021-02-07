<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="menu.jsp" />
		
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	</head> 
	
	<body>
		
		
		<div class="col-md-8 offset-md-2">
			<h2>Profil Client</h2>
			<div class="row">
				
				<div class="col-md-11">
					
       
            <form method="post" action="./register" >
                <div class="modal-body" >
                    <div class="form-group row">
                        <label for="prenom" class="col-sm-4 col-3 col-form-label" name="PrenomReg">Prénom</label>
                        <div class="col-sm-8 col">
                            <input type="text" required="required" class="form-control" id="prenom" placeholder="Jules" name="PrenomReg">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="nom" class="col-sm-4 col-3 col-form-label" name="NomReg">Nom</label>
                        <div class="col-sm-8 col">
                            <input type="text" required="required" class="form-control" id="nom" placeholder="Dupont" name="NomReg">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="email" class="col-sm-4 col-3 col-form-label">Email</label>
                        <div class="col-sm-8 col">

                            <input type="email" required="required" class="form-control" id="emailreg" placeholder="Email" name="EmailReg">

                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="adress" class="col-sm-4 col-3 col-form-label">Adresse</label>
                        <div class="col-sm-4 col">
                            <input type="search" class="form-control " id="adr-depart-input" placeholder="Rue" name="rue">
                        </div>
                        <div class="col-sm-4 col">
                            <input type="search" class="form-control " id="adr-depart-input" placeholder="Ville" name="ville">
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
