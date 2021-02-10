package fr.uvsq.amis.projetbanquejee.repositoryInscription;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.uvsq.amis.projetbanquejee.entity.Inscription;

@Repository
public interface InscriptionRepository  extends CrudRepository<Inscription, Long>{
	Inscription findByEmail(String email);
	Inscription findByEmailAndMdp(String email, String mdp);
	//Inscription findById_client(int id);
	
	

}
