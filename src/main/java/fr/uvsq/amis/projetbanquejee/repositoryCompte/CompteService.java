package fr.uvsq.amis.projetbanquejee.repositoryCompte;

import java.util.Calendar;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Compte;

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
	
	
	public Compte depot(String idd, String mon) {

		int id = Integer.parseInt(idd);
		Compte compte = repository.findById(id);

		double montant = Double.parseDouble(mon);

		if (compte == null) {
			System.out.println("Compte non trouvée");
		} else {
			System.out.println("Compte.montant=" + compte.getMontant());
			compte.setMontant(compte.getMontant() + montant);
			repository.save(compte);
		}
		System.out.println("Depot ok : " + compte.getIdCompte() + " " + compte.getMontant());
		
		return compte;

	}

	public Compte retrait(String idd, String mon) {

		int id = Integer.parseInt(idd);
		Compte compte = repository.findById(id);
		double montant = Double.parseDouble(mon);

		if (compte == null) {
			System.out.println("Compte non trouvée");
			return null;
		} else if (compte.getMontant() < montant) {
			return null;
		} else {
			compte.setMontant(compte.getMontant() - montant);
			repository.save(compte);
			System.out.println("Retrait ok : " + compte.getIdCompte() + " " + compte.getMontant());
		}
		
		return compte;

	}

	public boolean virement(String idd1, String idd2, String mon) {
		int id1 = Integer.parseInt(idd1);
		int id2 = Integer.parseInt(idd2);
		Compte compte1 = new Compte();
		Compte compte2 = new Compte();
		compte1 = null;
		compte1 = repository.findById(id1);
		compte2 = null;
		compte2 = repository.findById(id2);
		double montant = Double.parseDouble(mon);

		if (compte1 == null && compte2 == null) {
			System.out.println("Compte non trouvée");
			return false;
		} else
			if(compte1.getIdCompte()==compte2.getIdCompte()) {
				return false;
		}else		
			if (compte1.getMontant() < montant) {
				return false;
		} else		
			if (montant ==0) {
				return false;
		} 
			else {

			compte1 = retrait(idd1, mon);
			compte2 = depot(idd2,mon);
			repository.save(compte1);
			repository.save(compte2);
			return true;
		}
		
		//return false;

	}



}
