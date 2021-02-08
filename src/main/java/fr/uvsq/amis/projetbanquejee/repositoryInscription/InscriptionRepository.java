package fr.uvsq.amis.projetbanquejee.repositoryInscription;

import org.springframework.data.repository.CrudRepository;

import fr.uvsq.amis.projetbanquejee.entity.Inscription;


public interface InscriptionRepository  extends CrudRepository<Inscription, Long>{
	Inscription findByEmail(String email);
	
	

}
