package fr.uvsq.projetbanquejee.exception;

public class InscriptionEchoueeException extends Exception{
	public InscriptionEchoueeException() {
		super("Votre Inscription a échouée, veuillez recommencer");
	}
}
