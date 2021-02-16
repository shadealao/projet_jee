package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sun.xml.bind.v2.model.core.ID;

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/versement")
public class Versement extends HttpServlet{
	
private static AnnotationConfigApplicationContext appContext = null;
	
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
			session.setAttribute("listeCompte2",compteService.findAllAutreCompte( c.getIdClient()));
			
			
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/versement.jsp").forward(req, resp);
	}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		
		
		String idd1 = req.getParameter("elementSelecte");
		String idd2 = req.getParameter("elementSelecte2");
		String id1 = idd1.trim() ;
		String id2 = idd2.trim() ;
		String montant = req.getParameter("Montant");
		System.out.println("Compte à observer : "+ id1 +" " +montant);
		
		if(id1!=null && id2 != null && montant!=null) {
			System.out.println("Compte à observer : "+ id1 +" "+id2+ " " +montant);
			
			compteService.virement(id1, id2, montant);
			
			
		}


		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/versementOK.jsp").forward(req, resp);
	}

	
}