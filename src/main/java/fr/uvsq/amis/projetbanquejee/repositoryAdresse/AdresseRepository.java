package fr.uvsq.amis.projetbanquejee.repositoryAdresse;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;

@Repository
public interface AdresseRepository  extends CrudRepository<Adresse, Integer>{
	List<Adresse> findByRueAndVilleAllIgnoreCase(String rue, String ville);
<<<<<<< HEAD
	Adresse findByIdAdresse(int i);
	
=======
	Adresse findById(int i);
	void deleteById(int id);
>>>>>>> 736c18f57f8e3e0b4ec1e235e115c60c0f48d592
	

}
