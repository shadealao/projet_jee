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
	
	public void test(){
		Client person = new Client();
		person.setNom("DIALLO");
		person.setPrenom("Aminata");
		repository.save(person);
	}

	public void updateClient(int id, Client c) {
		Client modif =  repository.findById(id);
		modif.setNom(c.getNom());
		modif.setPrenom(c.getPrenom());
		//modif.setEmail(Email);
	
		repository.save(c);
	}
	
	public void updateAdresse(int id, Adresse adresse) {
		Client modif =  repository.findById(id);
		modif.setAdresse(adresse);
	
		repository.save(modif);
	}
	
	
}
