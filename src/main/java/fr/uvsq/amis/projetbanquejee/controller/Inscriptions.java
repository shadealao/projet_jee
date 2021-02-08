package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.*;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.CustomerService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Inscription")
public class Inscriptions extends HttpServlet {
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
		String email = request.getParameter("EmailInscr");
		String mdp1 = request.getParameter("Mdp1Inscr");
		String mdp2 = request.getParameter("Mdp2Inscr");
		String suite; 
		suite = "/WEB-INF/pages/home.jsp"; 
		
		
		if(!email.isEmpty() & !mdp1.isEmpty()) {
			/*Inscription inscr = new Inscription();
			inscr.setEmail(email);
			inscr.setMdp(mdp);
			*/
			
			if((mdp1.equals(mdp2)) &&iService.idInscription(email))
				iService.addInscription(email, mdp1);
		}
		modifications = true;
		if(!modifications)
			suite = "/WEB-INF/pages/erreurModif.jsp"; 
		
		
		getServletContext().getRequestDispatcher(suite).forward(request, response);
	}
}
