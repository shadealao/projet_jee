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
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	
	@Override
	public void init() throws ServletException {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		appContext.refresh();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Message m = new Message();
		
		
		try {
			HttpSession session = req.getSession();
			session.removeAttribute("leClient");
			session.removeAttribute("Compte");
			
			m.setValeur("ok");
			m.setChaine("Vous êtes bien déconnectés");
		} catch (Exception e) {
			m.setValeur("non");
			m.setChaine("Oups !! Il y a eût un soucis lors de la déconnection...");
		}
		req.setAttribute("message", m);
		resp.sendRedirect("/Projet_Banque_JEE/Home");
		
		
		
		
		appContext.close();
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("leClient");
		session.removeAttribute("Compte");
		resp.sendRedirect("/Projet_Banque_JEE/Home");
		appContext.close();
		
		
		
		//getServletContext().getRequestDispatcher(suite).forward(req, resp);
	}
}
