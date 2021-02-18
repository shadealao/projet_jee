<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<% fr.uvsq.amis.projetbanquejee.entity.Client c = (fr.uvsq.amis.projetbanquejee.entity.Client) session.getAttribute("leClient");%>
	

<!--Modal: modalOperations-->
<div class="modal fade" id="modalOperation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-sm modal-notify modal-danger"
role="document">
<div class="modal-content text-center">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Retrait</h5>
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
        <button type="button" class="btn btn-primary">Valider</button>
      </div>
    </div>
</div>
</div>

<div class="modal fade" id="modalOperation1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-sm modal-notify modal-danger"
role="document">
<div class="modal-content text-center">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Virement</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <form method="post" action="./versement" >
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Beneficiaire:</label>
            <input type="text"  required="required"class="form-control" id="idCompte" name="idCompte">
            
          </div>
          
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

<!--Modal: modalOperations-->
<div class="modal fade" id="modalOperation2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-sm modal-notify modal-danger"
role="document">
<div class="modal-content text-center">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Depot</h5>
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

<!--Modal: modalOperations-->

<div class="modal fade" id="modalOperation3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-sm modal-notify modal-danger"
role="document">
<div class="modal-content text-center">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Suppression</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <p>Vouliez vous supprimé  ce compte IdCompte?</p>
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
$('.modalShow').click(function(event){
    event.preventDefault();
    var e = $(this);
    var title = e.data('title');
    var body = e.data('value');
    $('.modal-title').html(title);
    $('.modal-body').html(body);
    $('#modalOperation').modal('show');
});
</script>