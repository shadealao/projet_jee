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
import fr.uvsq.amis.projetbanquejee.entity.Message;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;

@WebServlet("/Compte")
public class Compte extends HttpServlet {
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
		CompteService compteService = (CompteService) appContext.getBean("CompteService");
		HttpSession session = req.getSession();
		
		if (session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			session.setAttribute("leClient", c);
			session.setAttribute("listeCompte", compteService.findAllCompteClient(c));
			session.setAttribute("listeCompte2",compteService.findAllAutreCompte(c));
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		CompteService compteService = (CompteService) appContext.getBean("CompteService");
		
		Message m = new Message();
		Client c = (Client) session.getAttribute("leClient");
		String suppr = null;
		String idd = null;
		String id = null;
		String montant = null;
		String choix = req.getParameter("choix");
		
		
		//PARTIE SUPPRIMER COMPTE
		try {
			suppr = req.getParameter("suppr");
			if (suppr != null) {
				try {
					m.setChaine("Suppression du compte N°"+ suppr+" bien effectue.");
					m.setValeur("ok");
					compteService.delete(Integer.parseInt(suppr));
					session.setAttribute("listeCompte", compteService.findAllCompteClient(c));
				} catch (NumberFormatException e) { 
					m.setValeur("non");
					m.setChaine("Erreur Inconnue");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			m.setValeur("non");
			m.setChaine("erreur inconnue");
			e.printStackTrace();
		}
		
		
		//PARTIE RETRAIT D'UN COMPTE
		try {
			idd = req.getParameter("elementSelecte1");
			id = idd.trim() ;
			montant = req.getParameter("Montant");
			
			if((id!=null )& (montant!=null)) {	
				if((compteService.retrait(id, montant)) != null) {			
					session.setAttribute("listeCompte", compteService.findAllCompteClient(c));
					m.setValeur("ok");
					m.setChaine("Operation effectuee!!! Voulez-vous faire un autre retrait?");
				}
				else {
					m.setValeur("non");
					m.setChaine("Vous ne disposez pas d'assez de fond pour effectuer se retrait");
				}
			}
			else{
				m.setValeur("non");
				m.setChaine("Opération echoue");	
			}
		} catch (Exception e) {
		}
	
		
		
		// PARTIE DEPOT SUR UN COMPTE
		try {
			idd = req.getParameter("elementSelecte2");
			id = idd.trim() ;
			montant = req.getParameter("Montant");
			
			if((id!=null )& (montant!=null)) {	
				compteService.depot(id, montant);	
				session.setAttribute("listeCompte", compteService.findAllCompteClient(c));
				m.setValeur("ok");
				m.setChaine("Operation effectuee!!! Voulez-vous faire un autre dépot ?");
			}
			else{
				m.setValeur("non");
				m.setChaine("Opération echoue");	
			}
		} catch (Exception e) {
		}
	
			
		
		
		//PARTIE VIREMENT
		try {
			idd = req.getParameter("elementSelecte");
			id = idd.trim() ;
			
			montant = req.getParameter("Montant");	
			String idd2 = null;
			if(choix.equals("choix1")){
				try {
					idd2 = req.getParameter("elementSelecte3");
					String id2 = idd2.trim() ;
					if(id!=null && id2 != null && montant!=null) { 
						if( compteService.virement(id, id2, montant)) {
							m.setValeur("ok");
							m.setChaine("Operation effectuee!!! Voulez-vous faire un autre virement ?");
						}
						else {
							m.setValeur("non");
							m.setChaine("Virement échoué");
						}
						session.setAttribute("listeCompte", compteService.findAllCompteClient(c));
					}
					else{
						m.setValeur("non");
						m.setChaine("Opération echoue");	
					}
				} 
				catch (Exception e) {
				}
			}
			else if(choix.equals("choix2")) {
			
			
				try {
					
					idd2 = req.getParameter("elementSelecte4");
					String id2 = idd2.trim() ;
					if(id!=null && id2 != null && montant!=null) { 
						if( compteService.virement(id, id2, montant)) {
							m.setValeur("ok");
							m.setChaine("Operation effectuee!!! Voulez-vous faire un autre virement ?");
						}
						else {
							m.setValeur("non");
							m.setChaine("Virement échoué");
						}
						session.setAttribute("listeCompte", compteService.findAllCompteClient(c));
					}
					else{
						m.setValeur("non");
						m.setChaine("Opération echoue");	
					}
				}
				catch (Exception e) {
					m.setValeur("non");
					m.setChaine("Virement échoué");
				}
			}
		} catch (Exception e) {
		}

		
		
		
		req.setAttribute("message", m);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);

	}

}
