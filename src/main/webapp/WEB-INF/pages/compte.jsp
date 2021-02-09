<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="menu_compte.jsp" />
		
		<style type="text/css">
		    <%@include file="../css/home.css" %>
		</style>
		<link th:rel="stylesheet" th:href="@{webjars/bootstrap/4.0.0-2/css/bootstrap.min.css} "/>
		<c:url var="edit" value="./Compte" />
	</head> 
	
	<body>
	
	<div class="container">
      <h1>Vos Comptes</h1>
      
      <table class="table">
        <thead>
          <tr>
            <th>NUMERO COMPTE</th>
            <th>MONTANT</th>
            <th>ACTION</th>
          </tr>
        </thead>
        <tbody>
        
          <tr>
            <td>1</td>
            <td>200.0</td>
            <td>
            <button type="button" class="btn btn-primary"><i class="far fa-eye">Detail</i></button>
            <button type="button" class="btn btn-danger"><i class="far fa-trash-alt">Supprimer</i></button>
            
            </td>
          </tr>
          
        </tbody>
      </table>
    </div>

<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>

<script>


</script>
		
	</body>
</html>
