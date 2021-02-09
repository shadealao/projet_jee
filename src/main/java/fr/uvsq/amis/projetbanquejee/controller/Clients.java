package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;

@WebServlet("/Client")
public class Clients extends HttpServlet {
	
	
	
	private static AnnotationConfigApplicationContext appContext = null;
	private void initAppContext() {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		appContext.refresh();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();
		
		AdresseService aService = (AdresseService)appContext.getBean("AdresseService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		
		
		HttpSession session = req.getSession();
		if(session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
		
			System.out.println(c.getId());
			c = cService.enregistrerClient(c.getId());
			c.setAdresse(aService.idAdresse(c.getId()));
			
			System.out.println(c.toString());
			
			session.setAttribute("leClient", c);
		}
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/client.jsp").forward(req, resp);
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();
		
		AdresseService aService = (AdresseService)appContext.getBean("AdresseService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		
		boolean modifications = false; 
		String prenom = req.getParameter("PrenomClient");
		String nom = req.getParameter("NomClient");
		String email = req.getParameter("EmailClient");
		String rue = req.getParameter("RueClient");
		String ville = req.getParameter("VilleClient");
		
		String suite; 
		suite = "/WEB-INF/pages/client.jsp"; 
		
		HttpSession session = req.getSession();
		Client c = (Client) session.getAttribute("leClient");
		
		
		if( c!= null) {
			if(!ville.isEmpty() & !rue.isEmpty()) {
				Adresse adr = new Adresse();
				adr.setId(c.getId()); //Id du client 
				adr.setRue(rue);
				adr.setVille(ville);
				c.setAdresse(adr);
				aService.updateAdresse(c.getId(),adr);
				cService.updateAdresse(c.getId(), adr);
			}
			
			if(!prenom.isEmpty() & !nom.isEmpty() & !email.isEmpty()) {
				c.setNom(nom);
				c.setPrenom(prenom);
				//c.setEmail(email);
				cService.updateClient(c.getId(),c);
			}
			
			//System.out.println("\nModif client :  "+c.toString());
		}
		modifications = true;
		if(!modifications)
			suite = "/WEB-INF/pages/erreur_modif.jsp"; 
		
		
		getServletContext().getRequestDispatcher(suite).forward(req, resp);
	}

}
