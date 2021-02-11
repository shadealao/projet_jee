package fr.uvsq.amis.projetbanquejee.repositoryAdresse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;


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
	
	public void addAdresse(int id, String rue, String ville) {
		Adresse adr = new Adresse();
		adr.setId(id);
		adr.setRue(rue);
		adr.setVille(ville);
		repository.save(adr);
	}
	
	
	public void updateAdresse(int id,String rue, String ville) {
		Adresse modif = repository.findById(id);
		modif.setRue(rue);
		modif.setVille(ville);
		repository.save(modif);
	}
	
	
	public Adresse idAdresse(int id) {	
		return repository.findById(id);
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
