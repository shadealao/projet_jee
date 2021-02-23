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
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/Connection")
public class Conection extends HttpServlet {
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
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		
		Message m = new Message();
		String login = req.getParameter("login");
		String email = req.getParameter("EmailCo");
		String mdp = req.getParameter("MdpCo");
		
		
		try {
			if(login != null) {
				if(login.equals("seconnecter")) {
					if(!email.isEmpty() & !mdp.isEmpty()) {
						Inscription inscr = iService.idClient(email, mdp);
						if(inscr != null ) {
							HttpSession session = req.getSession();
							Client c = new Client();
							c.setIdClient(inscr.getClient().getIdClient());
							c = cService.enregistrerClient(c.getIdClient());
							c.setEmail(email);
							session.setAttribute("leClient", c);
							
							m.setValeur("ok");
							m.setChaine("Connection reussie");
						}
						else{
							m.setValeur("non");
							m.setChaine("Connection echouee");
							
						}
					}
				}
			
			}
		} catch (Exception e) {
			m.setValeur("non");
			m.setChaine("erreur inconnue");
			e.printStackTrace();
		}
		
		req.setAttribute("message", m);
		if((m.getValeur() == "non")||(m.getValeur() == "rien")) {
			resp.sendRedirect("/Projet_Banque_JEE/?valeur="+m.getValeur()+"&msg="+m.getChaine());
		}else if(m.getValeur() == "ok") {
			resp.sendRedirect("/Projet_Banque_JEE/Client?valeur="+m.getValeur()+"&msg="+m.getChaine());
		}
			
		
	}
}
