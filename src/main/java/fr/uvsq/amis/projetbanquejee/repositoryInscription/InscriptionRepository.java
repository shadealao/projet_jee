package fr.uvsq.amis.projetbanquejee.repositoryInscription;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.uvsq.amis.projetbanquejee.entity.Inscription;

@Repository
public interface InscriptionRepository  extends CrudRepository<Inscription, Integer>{
	Inscription findByEmail(String email);
	Inscription findByEmailAndMdp(String email, String mdp);
	
	
	/*@Query("SELECT * from inscription i where i.id_client = :id")
	@Modifying
	Inscription findById_client(@Param("id")int id);
	*/
	//Inscription findByIdclient(int id);
	
}
