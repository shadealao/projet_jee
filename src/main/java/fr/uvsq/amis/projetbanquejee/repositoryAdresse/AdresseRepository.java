package fr.uvsq.amis.projetbanquejee.repositoryAdresse;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;


public interface AdresseRepository  extends CrudRepository<Adresse, Long>{
	List<Adresse> findByRueAndVilleAllIgnoreCase(String rue, String ville);
	Adresse findById(int i);
	
	

}
