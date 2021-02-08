package fr.uvsq.amis.projetbanquejee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Inscription {

	@Id
	private String email; 
	
	private String mdp;
	
	private int id_client;

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

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	@Override
	public String toString() {
		return "Inscription [email=" + email + ", id_client=" + id_client + "]";
	}
	
	
	
	
}
