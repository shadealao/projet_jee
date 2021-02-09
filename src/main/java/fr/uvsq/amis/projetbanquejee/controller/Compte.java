package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;

@WebServlet("/Compte")
public class Compte extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	
	private void initAppContext() {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		/*appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryadresse");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryCompte");
		appContext.scan("fr.uvsq.amis.projetbanquejee.controller");
		appContext.scan("fr.uvsq.amis.projetbanquejee.entity");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryClient");
	*/
		appContext.refresh();
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(this.appContext == null)
			initAppContext();

	

		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		//compteService.test();
		
		//compteService.delete("14");
		
		List<fr.uvsq.amis.projetbanquejee.entity.Compte> comptes = compteService.findAll();
		
		//A réactiver si on ferme l'application
		//this.appContext.close();
		
	
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);
		
		
		
	}

}
