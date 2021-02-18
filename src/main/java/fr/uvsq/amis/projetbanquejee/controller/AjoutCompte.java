package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.entity.Client;

import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/AjoutCompte")
public class AjoutCompte extends HttpServlet {
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
		ClientService cService = (ClientService) appContext.getBean("ClientService");
		CompteService compteService = (CompteService) appContext.getBean("CompteService");

		HttpSession session = req.getSession();
		if (session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			// c = cService.enregistrerClient(c.getIdClient());
			// c.setCompte(compteService.idCompte(c.getId()));
			session.setAttribute("leClient", c);
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClientService cService = (ClientService) appContext.getBean("ClientService");
		CompteService compteService = (CompteService) appContext.getBean("CompteService");

		Message m = new Message();
		String montant = req.getParameter("Montant");
		double mont = Double.parseDouble(montant);

		//System.out.println(montant);

		/*
		 * HttpSession ses = req.getSession(); Compte cp = (Compte)
		 * ses.getAttribute("compte");
		 */

		//Compte compte = new Compte();
		HttpSession session = req.getSession();
		if (session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			//c = cService.enregistrerClient(c.getIdClient());
			
			if (c != null) {
				if (!montant.isEmpty()) {
					System.out.println(c);
					compteService.addCompte(c.getIdClient(), mont);

					//compte.setIdClient(c.getIdClient());

					//compteService.save(montant, compte);

					m.setValeur("ok");
					m.setChaine("Compte ajouté avec Succès!!!");
				} else {
					m.setValeur("non");
					m.setChaine("Opération échoué");

				}
			}
			
			session.setAttribute("leClient", c);
			req.setAttribute("message", m);
			
			if (m.getValeur() == "non") {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
			} else if (m.getValeur() == "ok") {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
			}

		}
	}

}
