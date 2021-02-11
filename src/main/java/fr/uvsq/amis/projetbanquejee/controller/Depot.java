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

	@Override
	public void init() throws ServletException {
		this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		
		appContext.refresh();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CompteService  compteService = (CompteService)appContext.getBean("CompteService");
		compteService.depot(2,100.0);

		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/depot.jsp").forward(req, resp);
	}

}
