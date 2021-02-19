package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.*;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Inscription")
public class Inscriptions extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	/*
	 * @Autowired private AnnotationConfigApplicationContext appContext;
	 */
	@Override
	public void init() throws ServletException {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		appContext.refresh();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InscriptionService iService = (InscriptionService) appContext.getBean("InscriptionService");
		ClientService cService = (ClientService) appContext.getBean("ClientService");
		AdresseService aService = (AdresseService) appContext.getBean("AdresseService");
		Message m = new Message();

		String prenom = req.getParameter("PrenomInscr");
		String nom = req.getParameter("NomInscr");
		String rue = req.getParameter("RueInscr");
		String ville = req.getParameter("VilleInscr");
		String email = req.getParameter("EmailInscr");
		String mdp1 = req.getParameter("Mdp1Inscr");
		String mdp2 = req.getParameter("Mdp2Inscr");
		String suite = "/WEB-INF/pages/home.jsp";

		HttpSession session = req.getSession();
		
		try {
			if (!email.isEmpty() & !mdp1.isEmpty()) {
				if ((mdp1.equals(mdp2)) & iService.idInscription(email)) {
					System.out.println("Je peux m'inscrire : ");
					try {
						iService.addInscription(email, mdp1);
						Client c = cService.addClient(nom, prenom);
						iService.updateClient(email, c);
						Adresse adresse = aService.addAdresse(rue, ville);
						c = cService.updateAdresse(c.getIdClient(), adresse);
						m.setValeur("ok");
						m.setChaine("Inscription réussie");
						
					} catch (Exception e) {
						m.setValeur("non");
						m.setChaine("Inscription échouée");
					}
				}
			}
		} catch (Exception e) {
			m.setValeur("non");
			m.setChaine("Erreur Inconnue");
			e.printStackTrace();
		}

		req.setAttribute("message", m);
		getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
	}
}
