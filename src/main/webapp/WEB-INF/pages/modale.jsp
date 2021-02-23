<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");%>
	

<!--Modal: modalOperations-->
<div class="modal fade" id="modalOperation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
		<div class="modal-content text-center">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Retrait</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form method="post" action="./retrait" >
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Montant:</label>
						<input type="text"  required="required"class="form-control" id="Montant" name="Montant">
					</div>
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
				<button type="button" class="btn btn-primary">Valider</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="modalOperation1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
		<div class="modal-content text-center">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Virement</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form method="post" action="./versement">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Beneficiaire:</label>
						<input type="text" required="required" class="form-control" id="idCompte" name="idCompte">
					</div>

					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Montant:</label>
						<input type="text" required="required" class="form-control" id="Montant" name="Montant">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
				<button type="button" class="btn btn-primary">Valider</button>
			</div>
		</div>
	</div>
</div>

<!--Modal: modalOperations-->
<div class="modal fade" id="modalOperation2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
		<div class="modal-content text-center">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Depot</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form method="post" action="./depot">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Montant:</label>
						<input type="text" required="required" class="form-control" id="Montant" name="Montant"> 
					</div>
				</form>
			</div>
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
				<p>Vouliez vous supprimé ce compte IdCompte?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
				<button type="button" class="btn btn-danger">Supprimer</button>
			</div>
		</div>
	</div>
</div>

<!--Modal: modalOperations-->
<script>
	$('.operation').click(function(event) {
		event.preventDefault();
		var e = $(this);
		var title = e.data('title');
		var body = e.data('value');
		$('.modal-title').html(title);
		$('.modal-body').html(body);
		$('#modalOperation').modal('show');
		
		$('#modalOperation').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  var name = button.data('name') // Extract info from data-* attributes
			  var id = buton.data('value')
			  alert('id : '+ name)
			  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			  var modal = $(this)
			  modal.find('.modal-title').text('Operation ' + name + " depuis le compte N°"+id)
			  modal.find('.modal-body input').val(recipient)
			  
			})
	});
	
</script>