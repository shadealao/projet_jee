package fr.uvsq.projetbanquejee.exception;

public class NouveauCompteEchoueException extends Exception{
	public NouveauCompteEchoueException(String nom) {
		super("La création du compte : "+nom+ " a échoué, veuillez recommencer");
	}
}
