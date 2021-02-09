package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.repositoryCompte.CompteService;

@WebServlet("/depot")
public class Depot extends   HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	private void initAppContext() {
		this.appContext = new AnnotationConfigApplicationContext();
		//appContext.scan("");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryadresse");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryCompte");
		appContext.scan("fr.uvsq.amis.projetbanquejee.controller");
		appContext.scan("fr.uvsq.amis.projetbanquejee.entity");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryClient");
	
		appContext.refresh();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(this.appContext == null)
			initAppContext();
		
		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		compteService.depot(23,100.0);

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/depot.jsp").forward(req, resp);
	}

}
