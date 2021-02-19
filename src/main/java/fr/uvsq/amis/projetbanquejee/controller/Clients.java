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
import org.springframework.web.bind.annotation.RestController;

//import fr.uvsq.amis.projetbanquejee.config.ApplicationContext;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Inscription;
import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@RestController
@WebServlet("/Client")
public class Clients extends HttpServlet {
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
		
		if(session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			session.setAttribute("leClient", c);
		}
			
		if( req.getAttribute("message") != null) {
			String m = (String) req.getAttribute("message");
			req.setAttribute("message", m);
			
		}
		
		if( req.getParameter("valeur") != null) 
			req.setAttribute("message", new Message(req.getParameter("valeur"), req.getParameter("msg")));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/client.jsp").forward(req, resp);
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
		AdresseService aService = (AdresseService)appContext.getBean("AdresseService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		CompteService compteService = (CompteService) appContext.getBean("CompteService");
		
		Message m = new Message();
		String bouton = req.getParameter("modifier");
		String login = req.getParameter("login");

		String suite = "/WEB-INF/pages/client.jsp"; 
		
		HttpSession session = req.getSession();
		Client c = (Client) session.getAttribute("leClient");
		if(bouton != null) {
			try {
				if(bouton.equals("modifier")) {


					String prenom = req.getParameter("PrenomClient");
					String nom = req.getParameter("NomClient");
					String rue = req.getParameter("RueClient");
					String ville = req.getParameter("VilleClient");
					
					if( c!= null) {
						if(!ville.isEmpty() & !rue.isEmpty()) {
							aService.updateAdresse(c.getIdAdresse().getIdAdresse(),rue, ville);
							c.getIdAdresse().setRue(rue);
							c.getIdAdresse().setVille(ville);
							m.setValeur("ok");
							m.setChaine("Modifications réussies");
						}
						
						if(!prenom.isEmpty() & !nom.isEmpty() ) {
							c.setNom(nom);
							c.setPrenom(prenom);
							cService.updateClient(c.getIdClient(),nom, prenom);
							m.setValeur("ok");
							m.setChaine("Modifications réussies");
						}
						else{
							m.setValeur("non");
							m.setChaine("Modification échouée");
						}
						
					}
				}else if(bouton.equals("supprimer")) {
					iService.deleteInscription(c.getEmail());
					compteService.deleteCompte(c.getIdClient());
					cService.deleteClient(c.getIdClient());
					aService.deleteAdresse(c.getIdClient());
					suite = "/Logout"; 
				}
				else if (bouton.equals("annuler")) {
					
				}
			} catch (Exception e) {
				m.setValeur("non");
				m.setChaine("Erreur Inconnue");
				e.printStackTrace();
			}
		}
		
		
		
		
		else if(login != null) {
			try {
				if(login.equals("seconnecter")) {
					String email = req.getParameter("EmailCo");
					String mdp = req.getParameter("MdpCo");
					
					
					if(!email.isEmpty() & !mdp.isEmpty()) {
						Inscription inscr = iService.idClient(email, mdp);
						if(inscr != null ) {
							session = req.getSession();
							c = new Client();
							c.setIdClient(inscr.getClient().getIdClient());
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
				}
				else if (login.equals("annuler")) {
					
				}
			} catch (Exception e) {
				m.setValeur("non");
				m.setChaine("Erreur Inconnue");
				e.printStackTrace();
			}
		}
		
		req.setAttribute("message", m);
		getServletContext().getRequestDispatcher(suite).forward(req, resp);
	}

}
