<!-- <div class="modal fade" id="modalOperation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!-- <div class="container"> -->
   
    <div class="modal fade" id="formulaire">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Vos infos :</h4>              
            <button type="button" class="close" data-dismiss="modal">
              <span>&times;</span>
            </button>
          </div>
          <div class="modal-body row">
            <form class="col" action="test.php">
              <div class="form-group">
                <label for="nom" class="form-control-label">Nom</label>
                <input type="text" class="form-control" name ="nom" id="nom" placeholder="Votre nom">
              </div>
              <div class="form-group">
                <label for="email" class="form-control-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Votre Email">
              </div>
              <button type="submit" class="btn btn-primary pull-right">Envoyer</button>
            </form>
          </div>
        </div>
      </div>
    </div>
<!-- </div> -->
<!-- </div> -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.0/umd/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
  $(function(){
    $('form').submit(function(e) {
      e.preventDefault()
      var $form = $(this)
      $.post($form.attr('action'), $form.serialize())
      .done(function(data) {
        $('#html').html(data)
        $('#formulaire').modal('hide')
      })
      .fail(function() {
        alert('ça ne marche pas...')
      })
    })
    $('.modal').on('shown.bs.modal', function(){
      $('input:first').focus()
    })
  })
