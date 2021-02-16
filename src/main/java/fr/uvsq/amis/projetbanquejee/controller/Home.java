package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Inscription;
import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Home")
public class Home extends HttpServlet {
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
		
		String valeur = req.getParameter("valeur");
		String msg = req.getParameter("msg");
		Message m = new Message(valeur, msg);
		m.setChaine(msg);
		m.setValeur(valeur);
		req.setAttribute("message", m);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		AdresseService aService = (AdresseService)appContext.getBean("AdresseService");
		
		
		
	}
}
