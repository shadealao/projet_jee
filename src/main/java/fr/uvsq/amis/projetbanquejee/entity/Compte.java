package fr.uvsq.amis.projetbanquejee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {

	@Id
	@GeneratedValue
	private int idCompte;
	
	private double montant;

	/*@Embedded
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Client.class) 
	@JoinColumn( name="idClient",insertable = false, updatable = false)*/
	private int idClient;
	
	

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
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




	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", montant=" + montant + "]";
	}


	
	
}
