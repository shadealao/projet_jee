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

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;

@WebServlet("/Compte")
public class Compte extends HttpServlet {
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
		CompteService compteService = (CompteService) appContext.getBean("CompteService");
		HttpSession session = req.getSession();
		if (session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			session.setAttribute("leClient", c);
			session.setAttribute("listeCompte", compteService.findAllCompteClient(c.getIdClient()));
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompteService compteService = (CompteService) appContext.getBean("CompteService");
		HttpSession session = req.getSession();
		Client c = (Client) session.getAttribute("leClient");
		String detail = req.getParameter("numero");
		String suppr = req.getParameter("suppr");

		if (detail != null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/detailCompte.jsp").forward(req, resp);

		} else if (suppr != null) {
			try {
				compteService.delete(Integer.parseInt(suppr));
				session.setAttribute("listeCompte", compteService.findAllCompteClient(c.getIdClient()));
			} catch (NumberFormatException e) {
				Message m = new Message();
				m.setValeur("non");
				m.setChaine("Erreur Inconnue");
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);
		}


	}

}
