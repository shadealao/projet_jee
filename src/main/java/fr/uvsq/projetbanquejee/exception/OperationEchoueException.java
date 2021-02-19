package fr.uvsq.projetbanquejee.exception;

public class OperationEchoueException extends Exception{
	public OperationEchoueException(String nom) {
			super("L'opération : "+nom+ " a échoué, veuillez recommencer");
	}
}
