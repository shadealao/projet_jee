package fr.uvsq.amis.projetbanquejee.repositoryAdresse;

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
	
	public Adresse addAdresse( String rue, String ville) {
		Adresse adr = new Adresse();
		adr.setRue(rue);
		adr.setVille(ville);
		repository.save(adr);
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

	public void deleteAdresse(int id) {
		Adresse modif = repository.findByIdAdresse(id);
		if (modif != null)
			repository.delete(modif);
	}

}
