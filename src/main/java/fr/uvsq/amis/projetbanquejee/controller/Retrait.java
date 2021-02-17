package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/retrait")
public class Retrait extends  HttpServlet {
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


		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/retrait.jsp").forward(req, resp);
	}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		
		Message m = new Message();
		String idd = req.getParameter("elementSelecte");
		String id = idd.trim() ;
		String montant = req.getParameter("Montant");
		System.out.println("Compte à observer : "+ id +" " +montant);
		
		if(id!=null && montant!=null) {
			System.out.println("Compte à observer : "+ id +" " +montant);
			
			compteService.retrait(id, montant);
			
			m.setValeur("ok");
			m.setChaine("Opération effectué!!! Vouliez vous faire un autre retrait?");
		}
		else{
			m.setValeur("non");
			m.setChaine("Opération échoué");
			
		}
	
	
	req.setAttribute("message", m);
	if(m.getValeur() == "non") {
		//resp.sendRedirect("/Projet_Banque_JEE/Home");
		getServletContext().getRequestDispatcher("/WEB-INF/pages/retrait.jsp").forward(req, resp);
	}else if(m.getValeur() == "ok") {
		//resp.sendRedirect("/Projet_Banque_JEE/Client");
		getServletContext().getRequestDispatcher("/WEB-INF/pages/retrait.jsp").forward(req, resp);
	}		
	

		
	}

}


