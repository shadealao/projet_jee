package fr.uvsq.amis.projetbanquejee.repositoryClient;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Individu;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{
	List<Client> findByNom(String nom);
	
<<<<<<< HEAD
	@Query("SELECT c FROM Client c WHERE c.id = ?1")
	Client findByIdClient(int id);
	
	
=======
	Client findById(int id);
	void deleteById(int id);
>>>>>>> 736c18f57f8e3e0b4ec1e235e115c60c0f48d592
}
