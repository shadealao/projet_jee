<!DOCTYPE html>
<html>
<head>
	<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");
	if(c != null){
		%>
		<jsp:include page="menu.jsp" />
	<%} else {%>
		<jsp:include page="inclusions.jsp" />	
		<jsp:forward page="seconnecter.jsp"></jsp:forward>
	<%} %>
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	
	</head> 

	<body>
		<div class="col-md-8 offset-md-2 hauteur">
			<h2>Ajout Compte</h2>
			<div class="row">
				<div class="col-md-11">
					
<<<<<<< HEAD
					
       
            		<form method="post" action="./depot" >
            		
            		<div class="modal-body" >
            		
                    		<div class="form-group row">
                    		<label for="compte" class="col-sm-4 col-3 col-form-label" name="id">Choisir un compte</label>
                       			
                       			<div class="col-sm-8 col">
                       			
                    			
                    			
                    		<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example" name="elementSelecte" >
  							<option selected>Select compte</option>
  							<% java.util.List<fr.uvsq.amis.projetbanquejee.entity.Compte> ce = (java.util.List) session.getAttribute("listeCompte");
            		for( fr.uvsq.amis.projetbanquejee.entity.Compte cc : ce ) {
						
								%>
  									
 									<option value=" <%= cc.getIdCompte() %>"><%= cc.getIdCompte() %></option>
  								<%}%>	
								</select>
								  
							</div>
								
=======
					<form method="post" action="./Depot" >
            		
            			<div class="modal-body" >
                    		<div class="form-group row">
                    			<label for="compte" class="col-sm-4 col-3 col-form-label" name="Compte">Choisir un compte</label>
                       			<div class="col-sm-8 col">
	                    			<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example">
	  									<option selected>Select compte</option>
	 									<option value="1">One</option>
	  									<option value="2">Two</option>
	 									<option value="3">Three</option>
									</select>
								</div>
>>>>>>> 736c18f57f8e3e0b4ec1e235e115c60c0f48d592
							</div>
	               			 <div class="modal-body" >
	                    		<div class="form-group row">
	                        		<label for="montant" class="col-sm-4 col-3 col-form-label" name="Montant">Montant</label>
	                       			<div class="col-sm-8 col">
	                            	<input type="text" required="required" class="form-control" id="Montant" placeholder="100000.0" name="Montant">
	                       			</div>
	                    		</div>
	                    	</div>
                    		
                    		<div class="modal-footer">
<<<<<<< HEAD
		                    <button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
		                   
		                    <button type="submit"  class="btn btn-success">Valider</button>
		              
		                </div>
		              
=======
			                    <button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
			                    <button type="submit"  class="btn btn-success" >Valider</button>
			                </div>
>>>>>>> 736c18f57f8e3e0b4ec1e235e115c60c0f48d592
                    	</div>
              		</form>
              	</div>
              </div>
              <jsp:include page="foot.jsp" />	
			<jsp:include page="inclusions_foot.jsp" />	
       </div>
		
	</body>
</html>
