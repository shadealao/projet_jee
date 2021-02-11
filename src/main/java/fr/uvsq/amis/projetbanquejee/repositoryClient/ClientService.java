package fr.uvsq.amis.projetbanquejee.repositoryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.entity.Individu;

@Service("ClientService")   // = @component
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public Client enregistrerClient(int id) {
		return repository.findById(id);
	}
	
	public void updateClient(int id, String nom, String prenom) {
		Client modif =  repository.findById(id);
		modif.setNom(nom);
		modif.setPrenom(prenom);
	
		repository.save(modif);
	}
	

	public void updateClient(int id) {
		Client modif =  repository.findById(id);
		
		repository.save(modif);
	}
	
	

	public Client addClient(String nom, String prenom) {

		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		repository.save(c);
		return c;
	}
	
	public Client updateIdadresse(int id) {
		Client modif =  repository.findById(id);
		modif.setIdadresse(modif.getId());
		repository.save(modif);
		return modif;
	}
	
	/*public void updateAdresse(int id, Adresse adresse) {
		Client modif =  repository.findById(id);
		modif.setAdresse(adresse);
	
		repository.save(modif);
	}*/
	
	
}
