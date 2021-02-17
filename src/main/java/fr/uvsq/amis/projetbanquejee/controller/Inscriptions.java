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
		InscriptionService iService = (InscriptionService) appContext.getBean("InscriptionService");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InscriptionService iService = (InscriptionService) appContext.getBean("InscriptionService");
		ClientService cService = (ClientService) appContext.getBean("ClientService");
		AdresseService aService = (AdresseService) appContext.getBean("AdresseService");
		CompteService cpService = (CompteService) appContext.getBean("CompteService");
		Message m = new Message();

		String prenom = req.getParameter("PrenomInscr");
		String nom = req.getParameter("NomInscr");
		String rue = req.getParameter("RueInscr");
		String ville = req.getParameter("VilleInscr");
		String email = req.getParameter("EmailInscr");
		String mdp1 = req.getParameter("Mdp1Inscr");
		String mdp2 = req.getParameter("Mdp2Inscr");
		String suite;
		suite = "/WEB-INF/pages/home.jsp";

		HttpSession session = req.getSession();
		
		/*if (session.getAttribute("ins") != null) {
			Inscription ins = (Inscription) session.getAttribute("ins");
			session.setAttribute("ins", ins);
			System.out.println("ICI : "+ ins.toString());
		}*/
		if (!email.isEmpty() & !mdp1.isEmpty()) {
			if ((mdp1.equals(mdp2)) & iService.idInscription(email)) {
				System.out.println("Je peux m'inscrire : ");
				try {
					Inscription inscription = new Inscription();
					Client c = new Client();
					Adresse adresse = aService.addAdresse(rue, ville);
					c.setIdAdresse(adresse);
					c = cService.addClient(nom, prenom);
					
					
					inscription = iService.addInscription(email, mdp1);
					inscription.setClient(c);
					iService.ajout(inscription);
					
					m.setValeur("ok");
					m.setChaine("Inscription réussie");
					
					

				} catch (Exception e) {
					// e.printStackTrace();
					m.setValeur("non");
					m.setChaine("Inscription échouée");
				}

			}

		}

		// Faire un msg pour inscription ok ou échouée
		System.out.println(m.toString());
		req.setAttribute("message", m);
		getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
	}
}
