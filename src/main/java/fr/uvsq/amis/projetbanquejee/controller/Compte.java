package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.repositoryClient.CustomerService;
import fr.uvsq.amis.projetbanquejee.repositoryadresse.AdresseService;

@WebServlet("/Compte")
public class Compte extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req, resp);
		
		
		
	}

}
