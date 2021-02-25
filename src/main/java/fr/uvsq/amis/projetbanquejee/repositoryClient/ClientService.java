package fr.uvsq.amis.projetbanquejee.repositoryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;

@Service("ClientService")   // = @component
public class ClientService {
	@Autowired
	private ClientRepository repository;
		
	public Client enregistrerClient(int id) {
		return repository.findByIdClient(id);
	}
	
	public void updateClient(int id, String nom, String prenom) {
		Client modif =  repository.findByIdClient(id);
		modif.setNom(nom);
		modif.setPrenom(prenom);
		repository.save(modif);
	}
		
	public Client addClient(String nom, String prenom) {
		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		repository.save(c);
		return c;
	}
	
	public Client updateAdresse(int id, Adresse adresse) {
		Client modif =  repository.findByIdClient(id);
		modif.setIdAdresse(adresse);
		repository.save(modif);
		return modif;
	}

	public void deleteClient(int id) {
		Client modif =  repository.findByIdClient(id);
		if(modif != null)
			repository.delete(modif);
	}
	
	
}
