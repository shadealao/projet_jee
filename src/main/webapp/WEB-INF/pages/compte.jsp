
<!DOCTYPE html>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<html >
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
	
		<link th:rel="stylesheet" th:href="@{webjars/bootstrap/4.0.0-2/css/bootstrap.min.css} "/>
		<c:url var="edit" value="./Compte" />
		</head>
	
	<body>
<<<<<<< HEAD
	<jsp:useBean id="compte" class="fr.uvsq.amis.projetbanquejee.entity.Compte" scope="session"></jsp:useBean>

	<div class="container">
      <h1>Vos Comptes </h1>
      
      <form method="post" action="./Compte" >
       <table class="table">
        <thead>
          <tr>
            <th>NUMERO COMPTE</th>
            <th>MONTANT</th>
            <th>ACTION</th>
          </tr>
        </thead>
        <tbody>
       
       <% java.util.List<fr.uvsq.amis.projetbanquejee.entity.Compte> ce = (java.util.List) session.getAttribute("listeCompte");
	
	for( fr.uvsq.amis.projetbanquejee.entity.Compte cc : ce ) {
		%>
        <tr >
        	
           		<td><%= cc.getIdCompte() %></td>
            	<td><%= cc.getMontant() %></td>
          
            <td><button type="submit" class="btn btn-primary" name="numero" value="<%= cc.getIdCompte() %>"><i class="far fa-eye">Detail</i></button>
            <button type="submit" class="btn btn-danger" name="suppr" value="<%= cc.getIdCompte() %>"><i class="far fa-trash-alt">Supprimer</i></button></td>
       	
          </tr>
          <%}%>	  
        </tbody>
     
      </table>
      </form>
      
    </div>

<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>

<script>


</script>
		
=======
	
		<div class="container">
			<div class="hauteur">
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
								<button type="button" class="btn btn-primary">
									<i class="far fa-eye">Detail</i>
								</button>
								<button type="button" class="btn btn-danger">
									<i class="far fa-trash-alt">Supprimer</i>
								</button>
	
							</td>
						</tr>
	
					</tbody>
				</table>
			</div>
	
	
			<jsp:include page="foot.jsp" />
			<jsp:include page="inclusions_foot.jsp" />
		</div>
>>>>>>> 736c18f57f8e3e0b4ec1e235e115c60c0f48d592
	</body>
</html>
