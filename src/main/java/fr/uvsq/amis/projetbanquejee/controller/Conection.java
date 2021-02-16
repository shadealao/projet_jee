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

import fr.uvsq.amis.projetbanquejee.entity.*;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Connection")
public class Conection extends HttpServlet {
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
	
		Message m = new Message();
		String login = req.getParameter("login");
		String email = req.getParameter("EmailCo");
		String mdp = req.getParameter("MdpCo");
		
<<<<<<< HEAD
		
		if(!email.isEmpty() & !mdp.isEmpty()) {
			Inscription inscr = iService.idClient(email, mdp);
			if(inscr != null ) {
				System.out.println(inscr.toString());
				HttpSession session = req.getSession();
				Client c = new Client();
				c.setIdClient(inscr.getClient().getIdClient());
				c.setEmail(email);
				session.setAttribute("leClient", c);
				
				m.setValeur("ok");
				m.setChaine("Connection réussie");
=======
		if(login != null) {
			if(login.equals("seconnecter")) {
				if(!email.isEmpty() & !mdp.isEmpty()) {
					Inscription inscr = iService.idClient(email, mdp);
					if(inscr != null ) {
						System.out.println(inscr.toString());
						HttpSession session = req.getSession();
						Client c = new Client();
						c.setId(inscr.getIdclient());
						c.setEmail(email);
						session.setAttribute("leClient", c);
						session.setAttribute("Email", email);
						
						m.setValeur("ok");
						m.setChaine("Connection réussie");
					}
					else{
						m.setValeur("non");
						m.setChaine("Connection échouée");
						
					}
				}
>>>>>>> 736c18f57f8e3e0b4ec1e235e115c60c0f48d592
			}
			else if (login.equals("annuler")) {
				m.setValeur("rien");
				m.setChaine("");
			}
		}
		
		
		req.setAttribute("message", m);
		if((m.getValeur() == "non")||(m.getValeur() == "rien")) {
			//req.getRequestDispatcher("/Home").forward(req,resp);
			resp.sendRedirect("/Projet_Banque_JEE/Home?valeur="+m.getValeur()+"&msg="+m.getChaine());
			//resp.sendRedirect("/Projet_Banque_JEE/Home?valeur=non&msg=okokok");
			//getServletContext().getRequestDispatcher("/Home").forward(req, resp);
		}else if(m.getValeur() == "ok") {
			resp.sendRedirect("/Projet_Banque_JEE/Client?valeur="+m.getValeur()+"&msg="+m.getChaine());
			//getServletContext().getRequestDispatcher("/Client").forward(req, resp);
		}
			
		
		
		//getServletContext().getRequestDispatcher(suite).forward(req, resp);
	}
}
