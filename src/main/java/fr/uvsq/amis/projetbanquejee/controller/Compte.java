package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteRepository;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;


@WebServlet("/Compte")
public class Compte extends HttpServlet {
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
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		
		HttpSession session = req.getSession();
		if(session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			c = cService.enregistrerClient(c.getIdClient());
			//c.setCompte(compteService.idCompte(c.getId()));
			session.setAttribute("leClient", c);
			session.setAttribute("listeCompte",compteService.findAllCompteClient(c.getIdClient()));
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);
		
	}

			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				ClientService cService = (ClientService)appContext.getBean("ClientService");
				CompteService  compteService = (CompteService)appContext.getBean("CompteService");
				
				
				String detail = req.getParameter("numero");
				String suppr = req.getParameter("suppr");
				
				if(detail!=null) {
					System.out.println("Compte à observer : "+ detail);
					this.getServletContext().getRequestDispatcher("/WEB-INF/pages/detailCompte.jsp").forward(req, resp);
					
				}
				else if(suppr != null) {
					
					compteService.delete(suppr);
					System.out.println("Compte à supprimer : "+ suppr);
					this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);
				}
				
				
						//compteService.delete(id);
						
						
						//c = cService.enregistrerClient(c.getId());
						//c = cService.updateIdcompte(c.getId());
						//c.setCompte(compte);
						//c.setIdCompte(compte.getIdCompte());
						//cService.updateClient(c.getIdClient());			
						
					}
					

}
