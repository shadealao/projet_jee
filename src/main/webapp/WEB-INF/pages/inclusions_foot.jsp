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
	
      $(document).ready(function(){
        $('input[type="radio"]').click(function(){
          var val = $(this).attr("value");
          var target = $("." + val);
          $(".msg").not(target).hide();
//           $(".msg").not(target).display()
          $(target).show();
        });
      });
    </script>
	
<!-- 	<script th:src="@{/webjars/jquery/jquery.min.js}"></script> -->
<!-- 	<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script> -->
<!-- 	<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script> -->
		
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	