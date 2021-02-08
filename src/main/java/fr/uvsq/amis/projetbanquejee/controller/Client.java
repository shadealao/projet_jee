package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;

@WebServlet("/Client")
public class Client extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	private void initAppContext() {
		this.appContext = new AnnotationConfigApplicationContext();
		//appContext.scan("");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryAdresse");
		appContext.scan("fr.uvsq.amis.projetbanquejee.controller");
		appContext.scan("fr.uvsq.amis.projetbanquejee.entity");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryClient");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryCompte");
		appContext.refresh();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();
		AdresseService aService = (AdresseService)appContext.getBean("AdresseService");
		Adresse adr = aService.idAdresse(2);
		
		System.out.println(adr.toString());
		req.setAttribute("adresse", adr);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/client.jsp").forward(req, resp);
		
		
		/*

		String paramAuteur = req.getParameter("auteur");

		String message = "Kransmission de var : Yes !!" ;//+ paramAuteur;
String mm ="Aminiata tu peux pull";
		String k = "Modif sur gits";
		Individu i = new Individu();
		i.setNom("DIALLO");
		i.setPrenom("Ami");

		req.setAttribute("test", message);
		req.setAttribute("individu", i);

		//this.getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
		*/
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean modifications = false; 
		String prenom = request.getParameter("PrenomClient");
		String nom = request.getParameter("NomClient");
		String email = request.getParameter("EmailClient");
		String rue = request.getParameter("RueClient");
		String ville = request.getParameter("VilleClient");
		
		String suite; 
		suite = "/WEB-INF/pages/client.jsp"; 
		
		AdresseService adrS = new AdresseService();
		if(!ville.isEmpty() & !rue.isEmpty()) {
			Adresse adr = new Adresse();
			adr.setId(2);
			adr.setRue(rue);
			adr.setVille(ville);
			adrS.modifierAdresse(adr);
		}
		modifications = true;
		if(!modifications)
			suite = "/WEB-INF/pages/erreurModif.jsp"; 
		
		
		getServletContext().getRequestDispatcher(suite).forward(request, response);
	}

}
