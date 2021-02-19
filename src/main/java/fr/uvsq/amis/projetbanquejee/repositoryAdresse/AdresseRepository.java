package fr.uvsq.amis.projetbanquejee.repositoryAdresse;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;

@Repository
public interface AdresseRepository  extends CrudRepository<Adresse, Integer>{
	List<Adresse> findByRueAndVilleAllIgnoreCase(String rue, String ville);
	Adresse findByIdAdresse(int i);
	void deleteByIdAdresse(int id);
}
