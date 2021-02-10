package fr.uvsq.amis.projetbanquejee.repositoryInscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
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
	
	public void addInscription(String email, String mdp) {
		Inscription inscr = new Inscription();
		inscr.setEmail(email);
		inscr.setMdp(mdp);
		repository.save(inscr);
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
	
	

}
