package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.*;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
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
		CompteService cpService = (CompteService)appContext.getBean("CompteService");
		Message m = new Message();

		
			
		String prenom = req.getParameter("PrenomClient");
		String nom = req.getParameter("NomClient");
		String rue = req.getParameter("RueClient");
		String ville = req.getParameter("VilleClient");
		String email = req.getParameter("EmailInscr");
		String mdp1 = req.getParameter("Mdp1Inscr");
		String mdp2 = req.getParameter("Mdp2Inscr");
		String suite; 
		suite = "/WEB-INF/pages/home.jsp"; 
		
		HttpSession session = req.getSession();
		if(session.getAttribute("ins") != null) {
			Inscription ins = (Inscription) session.getAttribute("ins");
			session.setAttribute("ins", ins);}
			if(!email.isEmpty() & !mdp1.isEmpty()) {
				if((mdp1.equals(mdp2)) & iService.idInscription(email)) {
					try {
						Inscription ins = (Inscription) session.getAttribute("ins");
					Client c = new Client();
					//c = cService.updateIdadresse(c.getId());
					Adresse adresse = new Adresse();
					adresse = aService.addAdresse(rue, ville);
					//adresse.setRue(rue);
					//adresse.setVille(ville);
					//aService.update(adresse.getIdAdresse());
				
					//aService.addAdresse( rue, ville);
					
					
					c.setIdAdresse(adresse);
					//c.setCompte(null);
					c.setEmail(email);
					c.setNom(nom);
					c.setPrenom(prenom);
					//c.setEmail(email);
					//c.setAdresse(adresse);
					//cpService.addCompte(c.getId(), 0.0);
					
					
					//cService.addClient(nom, prenom, c);
					//iService.setIdClient(email, c);
					//cService.updateClient(c.getIdClient());
					
					
					ins =iService.addInscription(email, mdp1);
					ins.setClient(c);
					iService.ajout(ins);
					
					m.setValeur("ok");
					m.setChaine("Inscription réussie");
					
					
					
				} catch (Exception e) {
					//e.printStackTrace();
					m.setValeur("non");
					m.setChaine("Inscription échouée");
				}
					
			}
				
			}
		
		
//		if(!modifications)
//			suite = "/WEB-INF/pages/erreur_modif.jsp"; 
//		
		//resp.sendRedirect(req.getContextPath()+"/Client");
		//getServletContext().getRequestDispatcher("/Home").forward(req, resp);
		
		//Faire un msg pour inscription ok ou échouée
		System.out.println(m.toString());
		req.setAttribute("message", m);
		//resp.sendRedirect("/Projet_Banque_JEE/Home");
		getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
			}
}
