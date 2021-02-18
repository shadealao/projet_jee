<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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

		<jsp:useBean id="compte" class="fr.uvsq.amis.projetbanquejee.entity.Compte" scope="session"></jsp:useBean>

		<div class="container hauteur">
      		<h1>Comptes </h1>

			<form method="post" action="./Compte" >
	       		<table class="table">
	        		<thead>
	          			<tr>
	            			<th>NUMERO COMPTE</th>
				            <th>MONTANT</th>
				            <th class="text-center">ACTION</th>
				        </tr>
				    </thead>
				 	
				 	<tbody>
		       
						<% 
				      	java.util.List<fr.uvsq.amis.projetbanquejee.entity.Compte> ce = (java.util.List) session.getAttribute("listeCompte");
						for( fr.uvsq.amis.projetbanquejee.entity.Compte cc : ce ) {
						%>
				        <tr>
							<td><%= cc.getIdCompte() %></td>
				            <td><%= cc.getMontant() %></td>  
				            <td>
				           
				            	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#modalOperation" name="retrait" value="<%= cc.getIdCompte() %>" ><i class="far fa-eye">Retrait</i></button>
				            	<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#virement" name="virement" value="<%= cc.getIdCompte() %>"><i class="far fa-eye">Virement</i></button>
				            	<button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalOperation3" name="depot" value="<%= cc.getIdCompte() %>"><i class="far fa-eye">Effectuer un Dépot</i></button>
				            	<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalOperation4" name="suppr" value="<%= cc.getIdCompte() %>"><i class="far fa-trash-alt">Supprimer</i></button>
				            </td>
						</tr>
				        <%
				        }
				        %>	  
			        </tbody>
	      		</table>
	      	</form>
		</div>
		<jsp:include page="modale.jsp" />
		<jsp:include page="foot.jsp" />
		<jsp:include page="inclusions_foot.jsp" />
	</body>
</html>
