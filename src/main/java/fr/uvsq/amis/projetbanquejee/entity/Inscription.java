package fr.uvsq.amis.projetbanquejee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inscription {
	@Id
	private String email; 
	
	private String mdp;
	
	@ManyToOne(targetEntity = Client.class, cascade = CascadeType.ALL) 
	@JoinColumn( name="idClient", referencedColumnName = "idClient" )
	private Client client;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Inscription [email=" + email + ", mdp=" + mdp + ", client=" + client + "]";
	}

	
}
