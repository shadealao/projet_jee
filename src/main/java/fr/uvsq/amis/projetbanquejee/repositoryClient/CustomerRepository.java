package fr.uvsq.amis.projetbanquejee.repositoryClient;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.uvsq.amis.projetbanquejee.entity.Individu;

@Repository
public interface CustomerRepository extends CrudRepository<Individu, Long>{
	List<Individu> findByNom(String nom);
}
