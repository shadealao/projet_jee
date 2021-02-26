package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import fr.uvsq.amis.projetbanquejee.entity.Client;
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
		HttpSession session = req.getSession();
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
		AdresseService aService = (AdresseService)appContext.getBean("AdresseService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		CompteService compteService = (CompteService) appContext.getBean("CompteService");
		
		Message m = new Message();
		String bouton = req.getParameter("modifier");
		String login = req.getParameter("login");
		String suite = "/WEB-INF/pages/client.jsp"; 
		Client c = (Client) session.getAttribute("leClient");
		
		
		if(bouton != null) {
			try {
				if(bouton.equals("modifier")) {
					//MODIFICATIONS INFORMATIONS PERSONNELLES CLIENT
					String prenom = req.getParameter("PrenomClient");
					String nom = req.getParameter("NomClient");
					String rue = req.getParameter("RueClient");
					String ville = req.getParameter("VilleClient");
					
					if( c!= null) {
						if(!ville.isEmpty() & !rue.isEmpty() & !prenom.isEmpty() & !nom.isEmpty() ) {
							aService.updateAdresse(c.getIdAdresse().getIdAdresse(),rue, ville);
							c.getIdAdresse().setRue(rue);
							c.getIdAdresse().setVille(ville);
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
					//SUPPRESION ESPACE PERSONNEL CLIENT
					compteService.deleteCompte(c);
					iService.deleteInscription(c.getEmail());
					
					session.removeAttribute("leClient");
					session.removeAttribute("Compte");
					m.setValeur("ok");
					m.setChaine("Profil supprimé");
					System.out.println("SUPPRIMER LE PROFIL");
					req.setAttribute("message", m);
					//appContext.close();
				}
			} catch (Exception e) {
				m.setValeur("non");
				m.setChaine("Erreur Inconnue");
				e.printStackTrace();
			}
		}
		

		
		req.setAttribute("message", m);
		if(m.getChaine().equals("Profil supprimé")) {
			resp.sendRedirect("/Projet_Banque_JEE/");
		}else {
			getServletContext().getRequestDispatcher(suite).forward(req, resp);
		}
	}

}
