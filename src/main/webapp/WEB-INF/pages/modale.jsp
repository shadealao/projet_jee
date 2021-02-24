<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");

%>
	


<!--Modal: modalOperations-->
<div class="modal fade" id="modalOperation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-md modal-notify modal-danger" role="document">
		<div class="modal-content text-center">
			<div class="modal-header">


				<h5 class="modal-title" id="exampleModalLabel"></h5>

				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div id="formulaire">
				<form method="post" action="./Compte" id="titreModal">
					<div class="modal-body">
						<div class="form-group row" id="retrait_depot">
							<input type="text" class="form-control" name="elementSelecte" id="compte" value="">
						</div>
						<div class="form-group row" id="somme">
							<label for="Montant" class="col-sm-4 col-3 col-form-label" id="montant">Montant</label>
							<div class="col-sm-8 col" >
								<input type="text" required="required" class="form-control" id="Montant" placeholder="100000.0" name="Montant">
							</div>
						</div>
						
						<div class="form-group row" id="virement">
							<label for="elementSelecte3" class="col-sm-4 col-3 col-form-label" id="Compte">Vers un de mes comptes</label>
                       		<div class="col-sm-8 col">
	                    		<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example" name="elementSelecte3">
	                    		<option value="">Sélectionner un compte</option>
								<% 
								java.util.List<fr.uvsq.amis.projetbanquejee.entity.Compte> cee = (java.util.List) session.getAttribute("listeCompte");
								for( fr.uvsq.amis.projetbanquejee.entity.Compte cc : cee ) {
								%>
								<option value=" <%= cc.getIdCompte() %>"><%= cc.getIdCompte() %></option>
		  						<%}%>	
								</select>
							</div>
							<label for="elementSelecte4" class="col-sm-4 col-3 col-form-label" id="Compte2">vers un autre béneficiaire</label>
							<div class="col-sm-8 col">
								<input type="text" class="form-control" id="elementSelecte4" placeholder="numero de compte" name="elementSelecte4">
							</div>
							
						</div>
					</div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
						<button type="submit" class="btn btn-primary">Valider</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div> 

<!--Modal: modalOperations-->
