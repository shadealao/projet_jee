package fr.uvsq.amis.projetbanquejee.repositoryClient;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.uvsq.amis.projetbanquejee.entity.Compte;



public interface CompteRepository extends CrudRepository<Compte, Long>{
	List<Compte> findByMontant(double montant);

}
