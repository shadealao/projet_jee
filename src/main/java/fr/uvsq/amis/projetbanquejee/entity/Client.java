package fr.uvsq.amis.projetbanquejee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idClient", unique = true, nullable = false)
	private int idClient;
	
	private String nom;
	private String prenom;
	
	@Embedded
	@ManyToOne(targetEntity = Adresse.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdresse" , referencedColumnName = "idAdresse" )
	private Adresse idAdresse;
	
	
	@Transient
	@Embedded
	@ManyToOne(targetEntity = Compte.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idCompte" , referencedColumnName = "idCompte" )
	private Compte idCompte;
	
	
	
	@Transient
	private String email;

	

	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Adresse getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Adresse idAdresse) {
		this.idAdresse = idAdresse;
	}
	
	
	public String getEmail() {

		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Client [id=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + idAdresse + ", email=" + email
				+ "]";
	}
	
	
	
	
	
	

}
