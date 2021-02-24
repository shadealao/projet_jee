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

import fr.uvsq.amis.projetbanquejee.entity.Adresse;
import fr.uvsq.amis.projetbanquejee.entity.Client;
import fr.uvsq.amis.projetbanquejee.entity.Inscription;
import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.repositoryAdresse.AdresseService;
import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/")
public class Home extends HttpServlet {
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
		String valeur = req.getParameter("valeur");
		String msg = req.getParameter("msg");
		Message m = new Message(valeur, msg);
		
		if(session.getAttribute("leClient") != null) {

			/*m.setChaine("Vous etes deja connecte, deconectez-vous avant de revenir a la page principale.");
			m.setValeur("non");
			req.setAttribute("message", m);
			resp.sendRedirect("/Projet_Banque_JEE/Client?valeur="+m.getValeur()+"&msg="+m.getChaine());
			*/
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/accueil.jsp").forward(req, resp);
		}
		else {
		
		req.setAttribute("message", m);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		InscriptionService iService = (InscriptionService)appContext.getBean("InscriptionService");
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		AdresseService aService = (AdresseService) appContext.getBean("AdresseService");
		
			
		Message m = new Message();
		
		String prenom = req.getParameter("PrenomInscr");
		String nom = req.getParameter("NomInscr");
		String rue = req.getParameter("RueInscr");
		String ville = req.getParameter("VilleInscr");
		String email = req.getParameter("EmailInscr");
		String mdp1 = req.getParameter("Mdp1Inscr");
		String mdp2 = req.getParameter("Mdp2Inscr");
		
		String login = req.getParameter("login");
		String email2 = req.getParameter("EmailCo");
		String mdp = req.getParameter("MdpCo");
		String logout = null;
		logout = req.getParameter("logout");
		String inscription = null;
		inscription = req.getParameter("inscription");
			
		
		//PARTIE INSCRIPTION
		try {
			if(inscription != null) {
				if (!email.isEmpty() & !mdp1.isEmpty()) {
					if ((mdp1.equals(mdp2)) & iService.idInscription(email)) {
						iService.addInscription(email, mdp1);
						Client c = cService.addClient(nom, prenom);
						iService.updateClient(email, c);
						Adresse adresse = aService.addAdresse(rue, ville);
						c = cService.updateAdresse(c.getIdClient(), adresse);
						m.setValeur("ok");
						m.setChaine("Inscription réussie");
					}
				}
				inscription = null ;
			}
		} catch (Exception e) {
			m.setValeur("non");
			m.setChaine("Erreur Inconnue");
			e.printStackTrace();
		}
		
		//PARTIE CONNECTION
		try {
			if(login != null) {
				if(login.equals("seconnecter")) {
					if(!email2.isEmpty() & !mdp.isEmpty()) {
						Inscription inscr = iService.idClient(email2, mdp);
						if(inscr != null ) {
							Client c = new Client();
							c.setIdClient(inscr.getClient().getIdClient());
							c = cService.enregistrerClient(c.getIdClient());
							c.setEmail(email2);
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
				login = null;
			
			}
		} catch (Exception e) {
			m.setValeur("non");
			m.setChaine("erreur inconnue");
			e.printStackTrace();
		}
		
		
		//PARTIE DECONNECTION
		
		try {
			if(logout != null) {
				session.removeAttribute("leClient");
				session.removeAttribute("Compte"); 
				logout = null;
				m.setValeur("deco");
				m.setChaine("");
				//appContext.close();
			}
		} catch (Exception e) {
		
		}
		
		
		
		try {
			req.setAttribute("message", m);
			if((m.getChaine().equals("Connection echouee")) || (m.getValeur().equals("deco")) ||  (m.getChaine().equals("Inscription réussie")) ) {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
			}
			else {
				getServletContext().getRequestDispatcher("/WEB-INF/pages/accueil.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
	}
	
	

}