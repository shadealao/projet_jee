package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;

@WebServlet("/AjoutCompte")
public class AjoutCompte extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	private void initAppContext() {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		/*appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryadresse");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryCompte");
		appContext.scan("fr.uvsq.amis.projetbanquejee.controller");
		appContext.scan("fr.uvsq.amis.projetbanquejee.entity");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryClient");
	*/
		appContext.refresh();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();
		
		System.out.println("Suis dans AjoutCompte");
		String montant = req.getParameter("Montant");
        
        System.out.println(montant);
        CompteService  compteService = (CompteService)appContext.getBean("CompteService");
        

		
		HttpSession session =req.getSession();
		compteService.save(montant);
		session.setAttribute("Compte", montant);
	
		System.out.println("Erreur de saisie");
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajout_compte_succes.jsp").forward(req, resp);
		
		
		
	}

}
