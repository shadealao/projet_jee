package fr.uvsq.amis.projetbanquejee.repositoryadresse;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;


public interface AdresseRepository  extends CrudRepository<Adresse, Long>{
	List<Adresse> findByRueVille(String rue, String ville);

}
