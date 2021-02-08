package fr.uvsq.amis.projetbanquejee.repositoryCompte;



import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.entity.Individu;

@Service("CompteService")
public class CompteService {
	
	@Autowired
	private CompteRepository repository;
	
	public void save(String montant){
		Compte compte = new Compte();
		double mont = Double.parseDouble(montant);
		compte.setMontant(mont);
		repository.save(compte);
	}

	
	
	
	public List<Compte> findAll() {

       List<Compte> comptes = (List<Compte>) repository.findAll();

       for (Compte c : comptes) 
			System.out.println("Compte : " + c.getId() +" "+ c.getMontant());

        return comptes;
    }

	 //@DeleteMapping("/users/{id}")
	    public void delete(@PathVariable String id) {

	        Long CompteId = Long.parseLong(id);
	        repository.deleteById(CompteId);
	    }


}
