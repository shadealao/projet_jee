package fr.uvsq.amis.projetbanquejee.repositoryadresse;

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
	
	public void modifierAdresse(Adresse adr) {
		Adresse modif = repository.findById(2);
		modif.setRue(adr.getRue());
		modif.setVille(adr.getVille());
		//repository.save(adr);
	}
	
	public void test () {
		Adresse adr = new Adresse();
		adr.setRue("Leonard de Vinci");
		adr.setVille("Massy");
		
		repository.save(adr);
		
		List<Adresse> listeadr = repository.findByRueAndVilleAllIgnoreCase("Leonard de Vinci", "Massy");
		
		System.out.println("Recherche par adresse ayant : Leonard de Vinci Massy");
		System.out.println(listeadr.toString());
//		
//		
		
	}
	
	public Adresse idAdresse(int id) {
		
		return repository.findById( id);
	}

}
