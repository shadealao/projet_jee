package fr.uvsq.amis.projetbanquejee.repositoryadresse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;


@Service("AdresseService") 
public class AdresseService {
	
	
	@Autowired
	private AdresseRepository repository;
	
	
	public void test () {
		Adresse adr = new Adresse();
		adr.setRue("Leonard de Vinci");
		adr.setVille("Massy");
		
		repository.save(adr);
		
		List<Adresse> listeadr = repository.findByRueVille("Leonard de Vinci", "Massy");
		
		System.out.println("Recherche par adresse ayant : Leonard de Vinci Massy");
		System.out.println(listeadr.toString());
		
		
		
	}

}
