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
import fr.uvsq.amis.projetbanquejee.repositoryClient.CustomerService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Connection")
public class Conection extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	
	private void initAppContext() {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		appContext.refresh();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();
		
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
		boolean modifications = false; 
		String email = request.getParameter("EmailCo");
		String mdp = request.getParameter("MdpCo");
		String suite; 
		suite = "/WEB-INF/pages/home.jsp"; 
		
		
		if(!email.isEmpty() & !mdp.isEmpty()) {
			Inscription inscr = iService.idClient(email, mdp);
			if(inscr != null ) {
				System.out.println(inscr.toString());
				HttpSession session = request.getSession();
				Client c = new Client();
				c.setId(inscr.getId_client());
				session.setAttribute("leClient", c);
			}
			else{
				System.out.println("Connection échouée");
				
			}
		}
		modifications = true;
		if(!modifications)
			suite = "/WEB-INF/pages/erreurModif.jsp"; 
		
		
		getServletContext().getRequestDispatcher(suite).forward(request, response);
	}
}
