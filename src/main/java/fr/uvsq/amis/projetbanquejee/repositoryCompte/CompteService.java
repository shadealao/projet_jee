package fr.uvsq.amis.projetbanquejee.repositoryCompte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Sort;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.entity.Individu;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;

@Service("CompteService")
public class CompteService {

	@Autowired
	private CompteRepository repository;

	private static CompteService compte = null;

	static public CompteService getInstance() {
		if (compte == null)
			compte = new CompteService();
		return compte;
	}

	public void save(String montant, Compte compte) {

		double mont = Double.parseDouble(montant);
		compte.setMontant(mont);

		repository.save(compte);
	}

	public void updateCompte(int id, String montant) {
		Compte compte = new Compte();
		double mont = Double.parseDouble(montant);
		compte.setMontant(mont);
		repository.save(compte);
	}

	public void addCompte(int id, double montant, String identifiant) {
		Compte compte = new Compte();
		compte.setIdClient(id);
		compte.setIdentifiant(identifiant);
		compte.setMontant(montant);
		repository.save(compte);
	}

	public List<Compte> findAllCompteClient(int idClient) {

		List<Compte> comptes = (List<Compte>) repository.findByIdClient(idClient);

		for (Compte c : comptes)
			System.out.println("Compte : " + c.getIdCompte() + " " + c.getMontant());

		return comptes;
	}

	public Set<Compte> findAllAutreCompte(int idClient) {

		List<Compte> comptes = (List<Compte>) repository.findAll();

		Set<Compte> compte = new HashSet<Compte>(0);
		for (Compte c : comptes)
			if (c.getIdClient() != idClient) {
				System.out.println("Compte : " + c.getIdCompte() + " " + c.getMontant());

				compte.add(c);
			}
		System.out.println(compte);
		return compte;
	}

	public List<Compte> findAll() {

		List<Compte> comptes = (List<Compte>) repository.findAll();

		for (Compte c : comptes)
			System.out.println("Compte : " + c.getIdCompte() + " " + c.getMontant());

		return comptes;
	}

	// @DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	public void deleteCompte(@PathVariable int id) {
		//repository.deleteByIdClient(id);
		repository.deleteAll(findAllCompteClient(id));
	}
	
	
	public void depot(String idd, String mon) {

		int id = Integer.parseInt(idd);
		Compte compte = new Compte();
		compte = repository.findById(id);

		double montant = Double.parseDouble(mon);

		if (compte == null) {
			System.out.println("Compte non trouvée");
		} else {
			System.out.println("Compte.montant=" + compte.getMontant());
			compte.setMontant(compte.getMontant() + montant);
			repository.save(compte);
		}
		System.out.println("Depot ok : " + compte.getIdCompte() + " " + compte.getMontant());

	}

	public void retrait(String idd, String mon) {

		int id = Integer.parseInt(idd);
		Compte compte = new Compte();
		compte = repository.findById(id);
		double montant = Double.parseDouble(mon);

		if (compte == null) {
			System.out.println("Compte non trouvée");
		} else if (compte.getMontant() < montant) {
			System.out.println("Solde Insuffisant votre solde est:" + compte.getMontant());
		} else {

			compte.setMontant(compte.getMontant() - montant);
			repository.save(compte);
			System.out.println("Retrait ok : " + compte.getIdCompte() + " " + compte.getMontant());
		}

	}

	public void virement(String idd1, String idd2, String mon) {

		int id1 = Integer.parseInt(idd1);
		int id2 = Integer.parseInt(idd1);
		Compte compte1 = new Compte();
		Compte compte2 = new Compte();
		compte1 = repository.findById(id1);
		compte2 = repository.findById(id2);
		double montant = Double.parseDouble(mon);

		if (compte1 == null && compte2 == null) {
			System.out.println("Compte non trouvée");
		} else if (compte1.getMontant() < montant) {
			System.out.println("Solde Insuffisant votre solde est:" + compte1.getMontant());
		} else {

			compte1.setMontant(compte1.getMontant() - montant);
			compte2.setMontant(compte2.getMontant() + montant);
			repository.save(compte1);
			repository.save(compte2);
			System.out.println("virement ok : " + compte1.getIdCompte() + " " + compte1.getMontant());
		}

	}

	public Compte idCompte(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
