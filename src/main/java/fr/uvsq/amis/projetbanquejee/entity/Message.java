package fr.uvsq.amis.projetbanquejee.entity;

public class Message {
	private String valeur; 
	private String chaine;
	
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public String getChaine() {
		return chaine;
	}
	public void setChaine(String chaine) {
		this.chaine = chaine;
	}
	public Message(String valeur, String chaine) {
		super();
		this.valeur = valeur;
		this.chaine = chaine;
	}
	
	public Message() {
		
	}
	
	@Override
	public String toString() {
		return "Message [valeur=" + valeur + ", chaine=" + chaine + "]";
	}
	
	

}
