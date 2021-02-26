<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
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
		
		<jsp:useBean id="compte"
		class="fr.uvsq.amis.projetbanquejee.entity.Compte" scope="session"></jsp:useBean>
	
		<div class="col-md-8 offset-md-2 hauteur" >
			<h2>Ajout Compte</h2>
			<div class="row">
				<div class="col-md-12">
					<form method="post" action="./AjoutCompte">
						<div class="modal-body">
							<div class="form-group row">
								<label for="montant" class="col-sm-4 col-3 col-form-label" id="Montant">Type</label>
								<div class="col-sm-8 col">
									<select class="form-select form-select-lg mb-3 form-control" aria-label=".form-select-lg example" name="elementSelect">
										<option value ="Compte Courant"> Compte courant</option>
										<option value ="Compte Epargne">Compte épargne</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="montant" class="col-sm-4 col-3 col-form-label" id="Montant">Montant</label>
								<div class="col-sm-8 col">
									<input type="search" class="form-control " id="adr-depart-input" placeholder="100000.0" name="Montant" value="${compte.montant }">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-dark" data-dismiss="modal">Annuler</button>
								<button type="submit" class="btn btn-success">Valider</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	

		<jsp:include page="foot.jsp" />
		<jsp:include page="inclusions_foot.jsp" />
	
	</body>
</html>