<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="fr.uvsq.amis.projetbanquejee.entity.Message" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<jsp:include page="inclusions.jsp" />	
	</head> 
	
	<body >
		<div class="col-md-8 offset-md-2 hauteur">
	
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
			
			<jsp:useBean id="client" class="fr.uvsq.amis.projetbanquejee.entity.Client" scope="session"></jsp:useBean>
			<jsp:useBean id="adresse" class="fr.uvsq.amis.projetbanquejee.entity.Adresse" scope="session"></jsp:useBean>
			
			<div class="row">
				<h2 class="col-md-12 text-center mt-2">Accueil</h2>
				<h4 class="col-md-12 text-center mt-2">Site gestion de compte banquaire</h4>
				<div class="col-md-8 offset-md-2 mt-3 card mb-3  bg-light shadow rounded">
					<div class="card-body">
					<h3 class="card-title">Connection</h3>
						<form class="col-md-12 card-text" method="post" action="Home" >
			                <div class="modal-body" >
			                    <div class="form-group row">
			                        <label for="EmailCo" class="col-sm-4 col-3 col-form-label">Email</label>
			                        <div class="col-sm-8 col">
			                            <input type="email" required="required" class="form-control" id="emailreg" placeholder="Email" name="EmailCo">
			                        </div>
			                    </div>
			                    <div class="form-group row">
			                        <label for="MdpCo" class="col-sm-4 col-3 col-form-label">Mot de passe</label>
			                        <div class="col-sm col">
			                            <input type="password" required="required" class="form-control" id="mdp3" placeholder="*******" name="MdpCo">
			                        </div>
			                    </div>
			                </div>
			                <div class="modal-footer">
			                	<button type="submit"  class="btn btn-success" name="login" value="seconnecter" >Valider</button>
			                </div>
			            </form>
			    	</div>
				</div>	
				
				
				<div class="accordion col-md-8 offset-2 pt-1 pb-1 card  bg-light" id="accordionExample">
					<div class="card-header" id="headingOne">
						<h2 class="mb-0">
							<button class="btn btn-link btn-block text-center" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> S'inscrire </button>
						</h2>
					</div>
					
					<div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
						<div class="card-body">
							<form class="col-md-12" method="post" action="Home" >
		                		<div class="modal-body" >
				                	<div class="form-group row">
				                        <label for="prenom" class="col-sm-4 col-3 col-form-label">Prénom</label>
				                        <div class="col-sm-8 col">
				                            <input type="text" required="required" class="form-control" id="prenom" placeholder="Jules" name="PrenomInscr">
				                        </div>
				                    </div>
				                    <div class="form-group row">
				                        <label for="nom" class="col-sm-4 col-3 col-form-label" >Nom</label>
				                        <div class="col-sm-8 col">
				                            <input type="text" required="required" class="form-control" id="nom" placeholder="Dupont" name="NomInscr" >
				                        </div>
				                    </div>
				                    <div class="form-group row">
				                        <label for="RueClient" class="col-sm-4 col-3 col-form-label">Adresse</label>
				                        <div class="col-sm-4 col">
				                            <input type="search" class="form-control " id="adr-depart-input" placeholder="Rue" name="RueInscr" >
				                        </div>
				                        <div class="col-sm-4 col">
				                            <input type="search" class="form-control " id="adr-depart-input" placeholder="Ville" name="VilleInscr" >
				                        </div>
				                    </div>
				                    <div class="form-group row">
				                        <label for="EmailInscr" class="col-sm-4 col-3 col-form-label">Email</label>
				                        <div class="col-sm-8 col">
				
				                            <input type="email" required="required" class="form-control" id="emailreg" placeholder="Email" name="EmailInscr">
				                        </div>
				                    </div>
				                    <div class="form-group row">
				                        <label for="Mdp1Inscr" class="col-sm-4 col-3 col-form-label">Mot de passe</label>
				                        <div class="col-sm-4 col">
				                            <input type="password" required="required" class="form-control" id="mdp1" placeholder="*******" name="Mdp1Inscr">
				                        </div>
				                        <div class="col-sm-4 col">
				                            <input type="password" required="required" class="form-control" id="mdp2" name="Mdp2Inscr" placeholder="*******">
				                        </div>
				                    </div>
				                </div>
				                <div class="modal-footer">
				                    <button type="button" class="btn btn-dark" data-dismiss="modal" >Annuler</button>
				                    <button type="submit"  name="inscription" value="ok" class="btn btn-success" >Valider</button>
				                </div>
				            </form>
						</div> 
					</div>	
				</div>
			</div>
				
		</div>
		<jsp:include page="foot.jsp" />	
		<jsp:include page="inclusions_foot.jsp" />	
	</body>
</html>
