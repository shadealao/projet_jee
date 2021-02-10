package fr.uvsq.amis.projetbanquejee.repositoryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Individu;

@Service("ClientService")   // = @component
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public Client enregistrerClient(int id) {
		return repository.findById(id);
	}
	
	public void updateClient(int id, String nom, String prenom, String email) {
		Client modif =  repository.findById(id);
		modif.setNom(nom);
		modif.setPrenom(prenom);
		//modif.setEmail(email);
	
		repository.save(modif);
	}
	
	public Client addClient(/*email*/) {
		Client c = new Client();
		c.setNom("Inconnu");
		c.setPrenom("Inconnu");
		//c.setEmail(email);
		repository.save(c);
		return c;
	}
	
	/*public void updateAdresse(int id, Adresse adresse) {
		Client modif =  repository.findById(id);
		modif.setAdresse(adresse);
	
		repository.save(modif);
	}*/
	
	
}
