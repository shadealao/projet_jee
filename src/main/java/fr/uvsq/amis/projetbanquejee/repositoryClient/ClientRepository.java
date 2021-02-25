package fr.uvsq.amis.projetbanquejee.repositoryClient;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import fr.uvsq.amis.projetbanquejee.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{
	List<Client> findByNom(String nom);
	Client findByIdClient(int id);
	void deleteByIdClient(int id);
}
