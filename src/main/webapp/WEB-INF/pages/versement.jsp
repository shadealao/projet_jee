<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="col-md-8 offset-md-2">
			<h2>Ajout Compte</h2>
			<div class="row">
				
				<div class="col-md-11">
					
					
       
            		<form method="post" action="./versement" >
            		
            		<div class="modal-body" >
                    		<div class="form-group row">
                    		<label for="compte" class="col-sm-4 col-3 col-form-label" name="Compte">Choisir votre compte</label>
                       			<div class="col-sm-8 col">
                    			<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example" name="elementSelecte">
								  <% java.util.List<fr.uvsq.amis.projetbanquejee.entity.Compte> ce = (java.util.List) session.getAttribute("listeCompte");
            		for( fr.uvsq.amis.projetbanquejee.entity.Compte cc : ce ) {
						
								%>
  									
 									<option value=" <%= cc.getIdCompte() %>"><%= cc.getIdCompte() %></option>
  								<%}%>
								</select>
								</div>
							</div>
							</div>
							
							<div class="modal-body" >
                    		<div class="form-group row">
                    		<label for="compte" class="col-sm-4 col-3 col-form-label" name="Compte">Beneficiaire</label>
                       			<div class="col-sm-8 col">
                    			<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example" name="elementSelecte2">
								  <% java.util.Set<fr.uvsq.amis.projetbanquejee.entity.Compte> cee = (java.util.Set) session.getAttribute("listeCompte2");
            		for( fr.uvsq.amis.projetbanquejee.entity.Compte cc : cee ) {
						
								%>
  									
 									<option value=" <%= cc.getIdCompte() %>"><%= cc.getIdCompte() %></option>
  								<%}%>
								</select>
								</div>
							</div>
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
		                    <button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
		                    <button type="submit"  class="btn btn-success" >Valider</button>
		                </div>
                    	</div>
              		</form>
              	</div>
              </div>
       </div>




<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>

<script>


</script>
</body>
</html>