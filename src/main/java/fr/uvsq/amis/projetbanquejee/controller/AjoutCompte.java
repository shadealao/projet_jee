package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.Compte;
import fr.uvsq.amis.projetbanquejee.entity.Client;

import fr.uvsq.amis.projetbanquejee.repositoryClient.ClientService;
import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;
import fr.uvsq.amis.projetbanquejee.repositoryInscription.InscriptionService;

@WebServlet("/AjoutCompte")
public class AjoutCompte extends HttpServlet {
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
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		
		HttpSession session = req.getSession();
		if(session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			//c = cService.enregistrerClient(c.getIdClient());
			//c.setCompte(compteService.idCompte(c.getId()));
			session.setAttribute("leClient", c);
		}
			
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClientService cService = (ClientService)appContext.getBean("ClientService");
		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		
		
		
		
		boolean modifications = false; 
		String montant = req.getParameter("Montant");
		double mont = Double.parseDouble(montant);
        
        System.out.println(montant);

       /* HttpSession ses = req.getSession();
        Compte cp = (Compte) ses.getAttribute("compte");*/
        
       
        Compte compte = new Compte(); 
       HttpSession session = req.getSession();
		if(session.getAttribute("leClient") != null) {
			Client c = (Client) session.getAttribute("leClient");
			c = cService.enregistrerClient(c.getIdClient());
			
			session.setAttribute("leClient", c);
       
        
			if( c!= null) {
			if(!montant.isEmpty()) {
				System.out.println(c);
				compte.setIdClient(c.getIdClient());
			
				compteService.save(montant, compte);
				
				
				//c = cService.enregistrerClient(c.getId());
				//c = cService.updateIdcompte(c.getId());
				//c.setCompte(compte);
				//c.setIdCompte(compte.getIdCompte());
				//cService.updateClient(c.getIdClient());			
				
			}
			}}
			
			/*if(session!=null) {
				
				//c.setEmail(email);
				cService.updateClient(c.getId(),nom, prenom);
				iService.updateEmail(email, c.getId());
			}*/
        
			modifications = true;
			if(modifications) {
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte_succes.jsp").forward(req, resp);
			}
			
							
			if(!modifications) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte_echec.jsp").forward(req, resp);
	
				System.out.println("Erreur de saisie");}
	
		
		
		
		
        }

}
