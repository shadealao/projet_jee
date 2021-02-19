package fr.uvsq.projetbanquejee.exception;

public class ClientNonEnregistreException extends Exception{
	public ClientNonEnregistreException() {
		super("Email et ou Mot de passe non connu");
	}
}
