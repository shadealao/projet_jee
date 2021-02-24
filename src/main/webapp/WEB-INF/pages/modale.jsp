<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ page import="java.util.Set" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");

%>
	


<!--Modal: modalOperations-->
<div class="modal fade" id="modalOperation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
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
							<label for="elementSelecte3" class="col-sm-4 col-3 col-form-label" id="Compte">Beneficiaire</label>
                       		<div class="col-sm-8 col">
	                    		<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example" name="elementSelecte3">
								<% 
								java.util.Set<fr.uvsq.amis.projetbanquejee.entity.Compte> cee = (java.util.Set) session.getAttribute("listeCompte2");
								for( fr.uvsq.amis.projetbanquejee.entity.Compte cc : cee ) {
								%>
								<option value=" <%= cc.getIdCompte() %>"><%= cc.getIdCompte() %></option>
		  						<%}%>	
								</select>
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
<script>
	$('.operation').click(function(event) {
		event.preventDefault();
		var e = $(this);
		var title = e.data('title').charAt(0).toUpperCase() + e.data('title').slice(1);
		var compte = e.data('value');
		$('.modal-title').html(title +" du compte N°"+compte);
		if((e.data('title') == 'retrait')) {
			$("#retrait_depot #compte").attr('value', e.data('value'));
			$("#retrait_depot #compte").attr('name', 'elementSelecte1');
			$("#retrait_depot").show();
			$("#virement").hide();
		}
		if((e.data('title') == 'depot')) {
			$("#retrait_depot #compte").attr('value', e.data('value'));
			$("#retrait_depot #compte").attr('name', 'elementSelecte2');
			$("#retrait_depot").show();
			$("#virement").hide();
		}
		
		if((e.data('title') == 'virement')){
			$("#retrait_depot #compte").attr('value', e.data('value'));
			$("#retrait_depot #compte").attr('name', 'elementSelecte');
			$("#virement").show();
		}
			
		$('#modalOperation').modal('show');
	});
	
		
</script>