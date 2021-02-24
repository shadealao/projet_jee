package fr.uvsq.amis.projetbanquejee.repositoryCompte;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
import fr.uvsq.amis.projetbanquejee.entity.Inscription;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientRepository;

@Service("CompteService")
public class CompteService {

	@Autowired
	private CompteRepository repository;
	
	@Autowired
	private ClientRepository repo;

	private static CompteService compte = null;

	static public CompteService getInstance() {
		if (compte == null)
			compte = new CompteService();
		return compte;
	}

	public Compte addCompte(double montant, String type, Client c) {
		Compte compte = new Compte();
		compte.setType(type);
		compte.setMontant(montant);
		compte.setDate(Calendar.getInstance().getTime());
		compte.setIdClient(c);
		System.out.println(compte);
		repository.save(compte);;
		return compte;
	}
	
	
	public List<Compte> findAllCompteClient(Client c) {
		List<Compte> comptes = (List<Compte>) repository.findByIdClient(c);
		return comptes;
	}

	public Set<Compte> findAllAutreCompte(Client client) {
		List<Compte> comptes = (List<Compte>) repository.findAll();
		Set<Compte> compte = new HashSet<Compte>(0);
		for (Compte c : comptes)
			if (c.getIdClient() != client) {
				compte.add(c);
			}
		return compte;
		
	}

	// @DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	public void deleteCompte(@PathVariable Client c) {
		repository.deleteAll(findAllCompteClient(c));
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
		Compte compte = repository.findById(id);
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
		} else
			if(compte1.getIdCompte()==compte2.getIdCompte()) {
			System.out.println("Vous pouviez pas faire un virement sur le même compte");
		}else		
			if (compte1.getMontant() < montant) {
			System.out.println("Solde Insuffisant votre solde est:" + compte1.getMontant());
		} else {

			
			retrait(idd1, mon);
			depot(idd2,mon);
			repository.save(compte1);
			repository.save(compte2);
			System.out.println("virement ok : " + compte1.getIdCompte() + " " + compte1.getMontant());
		}

	}



}
