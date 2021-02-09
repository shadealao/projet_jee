<!DOCTYPE html>
<html>
<head>
		<jsp:include page="menu_compte.jsp" />
		
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
	</head> 
<body>

	<div class="col-md-8 offset-md-2">
			<h2>Ajout Compte</h2>
			<div class="row">
				
				<div class="col-md-11">
					
					
       
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
