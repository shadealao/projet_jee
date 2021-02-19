package fr.uvsq.amis.projetbanquejee.entity;




import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompte;
	
	private String identifiant;
	
	private double montant;

	@ManyToOne(targetEntity = Client.class) 
	@JoinColumn( name="idClient", referencedColumnName = "idClient")
	private Client idClient;
	

	public Compte() {
		super();
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", montant=" + montant + "]";
	}
	
}
