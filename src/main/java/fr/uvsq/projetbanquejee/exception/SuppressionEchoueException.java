package fr.uvsq.projetbanquejee.exception;

public class SuppressionEchoueException extends Exception{
	public SuppressionEchoueException(String nom) {
			super("La suppresion de  : "+nom+ " a échoué");
	}
}
