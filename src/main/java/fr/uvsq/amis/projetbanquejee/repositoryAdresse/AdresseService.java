package fr.uvsq.amis.projetbanquejee.repositoryAdresse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;


@Service("AdresseService") 
public class AdresseService {
	
	
	@Autowired
	private AdresseRepository repository;
	
	private static AdresseService adr= null;
	
	static public AdresseService getInstance() {
		if(adr == null)
			adr = new AdresseService();
		return adr;
	}
	
	public Adresse addAdresse( String rue, String ville) {
		Adresse adr = new Adresse();
		
		adr.setRue(rue);
		adr.setVille(ville);
		repository.save(adr);
		return adr;
	}
	
	public void update(int id) {
		Adresse modif =  repository.findByIdAdresse(id);
		
		repository.save(modif);
		
	}
	public Adresse getIdAdresse(int id) {
		Adresse adr =  repository.findByIdAdresse(id);
		
		return adr;
		
	}
	public void updateAdresse(int id,String rue, String ville) {
		Adresse modif = repository.findByIdAdresse(id);
		modif.setRue(rue);
		modif.setVille(ville);
		repository.save(modif);
	}
	
	
	public Adresse idAdresse(int id) {	
		return repository.findByIdAdresse(id);
	}
	
	public void test () {
		Adresse adr = new Adresse();
		adr.setRue("Leonard de Vinci");
		adr.setVille("Massy");
		
		repository.save(adr);
		
		List<Adresse> listeadr = repository.findByRueAndVilleAllIgnoreCase("Leonard de Vinci", "Massy");
		
		System.out.println("Recherche par adresse ayant : Leonard de Vinci Massy");
		System.out.println(listeadr.toString());

		
	}


}
