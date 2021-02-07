package fr.uvsq.amis.projetbanquejee.repositoryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.entity.Individu;

@Service("CompteService")
public class GestionCompte {
	
	@Autowired
	private CompteRepository repository;
	
	public void test(){
		Compte compte = new Compte();
		compte.setMontant(10000000.0);
		repository.save(compte);
	}

}
