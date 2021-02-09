package fr.uvsq.amis.projetbanquejee.repositoryCompte;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.uvsq.amis.projetbanquejee.entity.Compte;



public interface CompteRepository extends CrudRepository<Compte, Long>{
	List<Compte> findByMontant(double montant);
	
	@Query("SELECT c FROM Compte c WHERE c.id = ?1")
	Compte findById(long id);

}
