package fr.uvsq.amis.projetbanquejee.repositoryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uvsq.amis.projetbanquejee.entity.Individu;

@Service("CustomerService")   // = @component
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	
	public void test(){
		Individu person = new Individu();
		person.setNom("DIALLO");
		person.setPrenom("Aminata");
		repository.save(person);
	}
}
