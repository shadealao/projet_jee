package fr.uvsq.amis.projetbanquejee.repositoryInscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Inscription;

@Service("InscriptionService")
public class InscriptionService {
	
	
	@Autowired
	private InscriptionRepository repository;
	
	private static InscriptionService inscription= null;
	
	static public InscriptionService getInstance() {
		if(inscription == null)
			inscription = new InscriptionService();
		return inscription;
	}
	
	public boolean idInscription(String email) {	
		Inscription inscr = repository.findByEmail(email);
		if (inscr == null) return true;
		return false;
	}
	/* A
	 * public Inscription addInscription(String email, String mdp) {
		Inscription inscr = new Inscription();
		inscr.setEmail(email);
		inscr.setMdp(mdp);
		return inscr;
	}
	*/
	public Inscription addInscription(String email, String mdp) {
		Inscription inscr = new Inscription();
		inscr.setEmail(email);
		inscr.setMdp(mdp);
		repository.save(inscr);
		return inscr;
	}
	
	public Inscription updateClient(String email, Client c) {
		Inscription inscr = repository.findByEmail(email);
		inscr.setClient(c);
		repository.save(inscr);
		return inscr;
	}
	
	public void ajout(Inscription i) {	
		repository.save(i);
	}
	
	public Inscription idClient(String email, String mdp) {
		Inscription i = null;
		i = repository.findByEmailAndMdp(email, mdp);
		//System.out.println("\nidentifiant client : '"+ i.getId_client() + "'");
				
		return i;
	}
	
	
	public void deleteInscription(String email) {
		Inscription modif =  repository.findByEmail(email);
		System.out.println("je dois supprimer : "+ modif.toString());
		if(modif != null)
			repository.delete(modif);
	}
	/*
	
	
	
	
	
	public void setIdClient(String email, Client client) {
		Inscription i = repository.findByEmail(email);
		i.setClient(client);
		repository.save(i);
	}
	
	/*public void updateEmail(String email, int id) {
		Inscription i = repository.findByIdclient(id);
		i.setEmail(email);
		repository.save(i);
	}*/
	

	/*
	public Inscription addInscription(String email, String mdp) {
		
		Inscription inscr = new Inscription();
		inscr.setEmail(email);
		inscr.setMdp(mdp);
		return inscr;
		
	}
	
	public void ajout(Inscription i) {
		
		repository.save(i);
	}
	public boolean idInscription(String email) {	
		Inscription i = repository.findByEmail(email);
		if (i == null) return true;
		return false;
	}
	
	public Inscription idClient(String email, String mdp) {
		Inscription i = null;
		i = repository.findByEmailAndMdp(email, mdp);
		//System.out.println("\nidentifiant client : '"+ i.getId_client() + "'");
				
		return i;
	}
	
	public void setIdClient(String email, Client client) {
		Inscription i = repository.findByEmail(email);
		i.setClient(client);
		repository.save(i);
	}*/
	
	/*public void updateEmail(String email, int id) {
		Inscription i = repository.findByIdclient(id);
		i.setEmail(email);
		repository.save(i);
	}*/
	

}
