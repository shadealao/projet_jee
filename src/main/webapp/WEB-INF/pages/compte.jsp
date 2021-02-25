<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<html >
	<head>
		<c:if test="${leClient != null }">
			<jsp:include page="menu.jsp" />
		</c:if>
		<c:if test="${leClient == null }">
			<jsp:include page="inclusions.jsp" />	
			<jsp:forward page="se_connecter.jsp"></jsp:forward>
		</c:if>
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
	            			<th>IDENTIFIANT COMPTE</th>
				            <th>SOLDE</th>
				            <th class="text-center">ACTION</th>
				        </tr>
				    </thead>
				    
				 	<tbody>
						<% 
				      	java.util.List<fr.uvsq.amis.projetbanquejee.entity.Compte> ce = (java.util.List) session.getAttribute("listeCompte");
						for	( fr.uvsq.amis.projetbanquejee.entity.Compte cc : ce ) {
						%>
						<tr id=".modalShow">
							<td><%= cc.getIdCompte() %></td>
				            <td><%= cc.getMontant() %></td>  
				            <td>
                                <button type="button" class="btn btn-info operation" data-toggle="modal" data-target="#modalOperation" data-title="retrait" data-value="<%= cc.getIdCompte() %>" ><i class="far fa-eye">Retrait</i></button>
                                <button type="button" class="btn btn-warning operation" data-toggle="modal" data-target="#modalOperation" data-title="virement" data-value="<%= cc.getIdCompte() %>"><i class="far fa-eye">Virement</i></button>
                                <button type="button" class="btn btn-success operation" data-toggle="modal" data-target="#modalOperation" data-title="depot" data-value="<%= cc.getIdCompte() %>"><i class="far fa-eye">Effectuer un Dépot</i></button>
                                <button type="submit" class="btn btn-danger" name="suppr" value="<%= cc.getIdCompte() %>"><i class="far fa-trash-alt">Supprimer</i></button>
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
