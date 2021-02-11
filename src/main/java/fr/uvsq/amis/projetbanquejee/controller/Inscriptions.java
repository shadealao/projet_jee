package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.*;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Inscription")
public class Inscriptions extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	
	
	@Override
	public void init() throws ServletException {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
	
		appContext.refresh();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		AdresseService aService = (AdresseService)appContext.getBean("AdresseService");
		
		boolean modifications = false; 
		String prenom = req.getParameter("PrenomClient");
		String nom = req.getParameter("NomClient");
		String rue = req.getParameter("RueClient");
		String ville = req.getParameter("VilleClient");
		String email = req.getParameter("EmailInscr");
		String mdp1 = req.getParameter("Mdp1Inscr");
		String mdp2 = req.getParameter("Mdp2Inscr");
		String suite; 
		suite = "/WEB-INF/pages/home.jsp"; 
		
		
		if(!email.isEmpty() & !mdp1.isEmpty()) {
			if((mdp1.equals(mdp2)) & iService.idInscription(email)) {
				try {
					iService.addInscription(email, mdp1);
					Client c = cService.addClient(nom, prenom);
					c.setEmail(email);
					c = cService.updateIdadresse(c.getId());
					aService.addAdresse(c.getId(), rue, ville);
					iService.setIdClient(email, c.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
				
		}
		modifications = true;
		if(!modifications)
			suite = "/WEB-INF/pages/erreur_modif.jsp"; 
		
		//resp.sendRedirect(req.getContextPath()+"/Client");
		//getServletContext().getRequestDispatcher("/Home").forward(req, resp);
		
		//Faire un msg pour inscription ok ou échouée
		resp.sendRedirect("/Projet_Banque_JEE/Home");
	}
}
