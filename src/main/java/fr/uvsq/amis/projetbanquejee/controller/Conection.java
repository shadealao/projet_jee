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
		
		boolean modifications = false; 
		String email = req.getParameter("EmailCo");
		String mdp = req.getParameter("MdpCo");
		String suite; 
		suite = "/WEB-INF/pages/home.jsp"; 
		
		
		if(!email.isEmpty() & !mdp.isEmpty()) {
			Inscription inscr = iService.idClient(email, mdp);
			if(inscr != null ) {
				System.out.println(inscr.toString());
				HttpSession session = req.getSession();
				Client c = new Client();
				c.setId(inscr.getId_client());
				//c.setEmail(email);
				session.setAttribute("leClient", c);
				
			}
			else{
				System.out.println("Connection échouée");
				
			}
		}
		modifications = true;
		if(!modifications)
			suite = "/WEB-INF/pages/erreurModif.jsp"; 
		
		resp.sendRedirect("/Projet_Banque_JEE/Client");
		//getServletContext().getRequestDispatcher(suite).forward(req, resp);
	}
}
