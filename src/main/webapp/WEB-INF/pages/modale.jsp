<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ page import="java.util.Set" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<<<<<<< HEAD

<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");%>
<% 
				      	java.util.List<fr.uvsq.amis.projetbanquejee.entity.Compte> ce = (java.util.List) session.getAttribute("listeCompte");
						for	( fr.uvsq.amis.projetbanquejee.entity.Compte cc : ce ) {
						%>
=======
<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");

%>
	
>>>>>>> e1393ab5094a15e40c1199bdbfa29f946c6358aa

<!--Modal: modalOperations-->
<div class="modal fade" id="modalOperation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
		<div class="modal-content text-center">
			<div class="modal-header">
<<<<<<< HEAD
				<h5 class="modal-title" id="exampleModalLabel">Retrait</h5>
				<h6 class="modal-i"> Compte: </h6>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:if test="${message.valeur == 'ok' }" >
					<div class="fixed-top alert alert-success alert-dismissible fade show" role="alert">
						<a id="message">${message.chaine}</a>
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<c:if test="${message.valeur == 'non' }" >
					<div class="fixed-top alert alert-danger alert-dismissible fade show" role="alert">
						<a id="message">${message.chaine}</a>
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
	
				<form method="post" action="./retrait" >
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Montant:</label>
						<input type="text"  required="required"class="form-control" id="Montant" name="Montant">
					</div>
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
				<button type="submit" class="btn btn-primary">Valider</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="modalOperation1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
		<div class="modal-content text-center">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Virement</h5>
=======
				<h5 class="modal-title" id="exampleModalLabel"></h5>
>>>>>>> e1393ab5094a15e40c1199bdbfa29f946c6358aa
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div id="formulaire">
				<form method="post" action="" id="titreModal">
					<div class="modal-body">
						<div class="form-group row" id="retrait_depot">
							<label for="Montant" class="col-sm-4 col-3 col-form-label" id="montant">Montant</label>
							<div class="col-sm-8 col">
								<input type="text" required="required" class="form-control" id="Montant" placeholder="100000.0" name="Montant">
							</div>
						</div>
						
						<div class="form-group row" id="virement">
							<label for="elementSelecte2" class="col-sm-4 col-3 col-form-label" id="Compte">Beneficiaire</label>
                       		<div class="col-sm-8 col">
	                    		<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example" name="elementSelecte2">
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
						<button type="button" class="btn btn-primary">Valider</button>
					</div>
				</form>
			</div>
<<<<<<< HEAD
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
				<button type="button" class="btn btn-primary">Valider</button>
			</div>
		</div>
	</div>
</div>

<!--Modal: modalOperations-->

<div class="modal fade" id="modalOperation3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
		<div class="modal-content text-center">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Suppression</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action=""></form>
				<p>Vouliez vous supprimé ce compte IdCompte?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
				<button type="submit" class="btn btn-danger" data-value="<%= cc.getIdCompte() %>" name ="test">Supprimer</button>
			</div>
		</div>
	</div>
</div>
<%} %>
<!--Modal: modalOperations-->
<script>
	$('.modalShow' > tr > td).click(function(event) {
		event.preventDefault();
		var e = $(this);
		var title = e.data('title');
		var body = e.data('value');
		var id = $(this).attr('id');
	    console.log('Identifiant : ' + id);
		$('.modal-title').html(title);
		$('.modal-body').html(body);
=======
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
		$('.modal-title').html(title +" du compte NÂ°"+compte);
		$('form').attr('action', './'+e.data('title'));
		if((e.data('title') == 'retrait') || (e.data('title') == 'depot')) {
			$("#retrait_depot").show();
			$("#virement").hide();
		}
		
		if((e.data('title') == 'virement')){
			$("#retrait_depot").hide();
			$("#virement").show();
		}
			
>>>>>>> e1393ab5094a15e40c1199bdbfa29f946c6358aa
		$('#modalOperation').modal('show');
	});
	
		
</script>