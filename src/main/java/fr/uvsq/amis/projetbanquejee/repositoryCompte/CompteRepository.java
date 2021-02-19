package fr.uvsq.amis.projetbanquejee.repositoryCompte;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Compte;



public interface CompteRepository extends CrudRepository<Compte, Integer>{
	List<Compte> findByMontant(double montant);
	List<Compte> findByIdClient(Client c);
	List<Compte> findAll();
	
	@Query("SELECT c FROM Compte c WHERE c.id = ?1")
	Compte findById(int id);
	
	void deleteByIdClient(int id);
	
	@Query("SELECT c FROM Compte c WHERE c.idClient = ?1")
	Compte findByIdC(int idClient);

}
