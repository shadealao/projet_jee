package fr.uvsq.amis.projetbanquejee.repositoryClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.entity.Individu;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteRepository;

@Service("ClientService")   // = @component
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private CompteRepository repo;
	
	public Client enregistrerClient(int id) {
		
		return repository.findByIdClient(id);
	}
	
	public void updateClient(int id, String nom, String prenom) {
		Client modif =  repository.findByIdClient(id);
		modif.setNom(nom);
		modif.setPrenom(prenom);
	
		repository.save(modif);
	}
	

	public void updateClient(int id) {
		Client modif =  repository.findByIdClient(id);
		
		repository.save(modif);
	}
	
	public void updateC(int id, Adresse adr) {
		
		Client c = new Client();
		c.setIdAdresse( adr );
		
		repository.save(c);
		
	}
	
	

	public Client addClient(String nom, String prenom) {
		
		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		//c.setIdAdresse(adresse);
		repository.save(c);
		return c;
		
	}
	
	/*public Client updateIdadresse(int id) {
		Client modif =  repository.findById(id);
		modif.setIdadresse(modif.getId());
		repository.save(modif);
		return modif;
	}*/
/*
	public Client updateIdcompte(int id) {
		Compte c =  repo.findById(id);
		Client modif = repository.findById(id);
		modif.setIdcompte(c.getId());
		repository.save(modif);
		return modif;
	}*/
	
	public void deleteClient(int id) {
		Client modif =  repository.findByIdClient(id);
		if(modif != null)
			repository.delete(modif);
	}
	
	
}
