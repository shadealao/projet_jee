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

import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;

@WebServlet("/AjoutCompte")
public class AjoutCompte extends HttpServlet {
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
		HttpSession session = req.getSession();
		if (session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			session.setAttribute("leClient", c);
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompteService compteService = (CompteService) appContext.getBean("CompteService");

		Message m = new Message();
		String montant = req.getParameter("Montant");
		String type = req.getParameter("elementSelect");
		double mont = Double.parseDouble(montant);

		HttpSession session = req.getSession();
		try {
			if (session.getAttribute("leClient") != null) {
				Client c = (Client) session.getAttribute("leClient");
			
				if (c != null) {
				if (!montant.isEmpty()) {
					System.out.println(c);
					 
					 compteService.addCompte(mont, type,c);
					 m.setValeur("ok");
					 m.setChaine("Compte ajouté avec Succès!!!");
				} else {
					m.setValeur("non");
					m.setChaine("Opération échoué");

				}
				session.setAttribute("leClient", c);
				}
			}
		}
		 catch (Exception e) {
			m.setValeur("non");
			m.setChaine("Erreur Inconnue");
			e.printStackTrace();
		}
		
		req.setAttribute("message", m);
		
		if (m.getValeur() == "non") {
			getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
		} else if (m.getValeur() == "ok") {
			getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
		}
	}

}
