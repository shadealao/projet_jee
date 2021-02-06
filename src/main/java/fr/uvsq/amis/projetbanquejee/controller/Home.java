package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.repositoryClient.CustomerService;

@WebServlet("/Home")
public class Home extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee.controller");
		appContext.scan("fr.uvsq.amis.projetbanquejee.entity");
		appContext.scan("fr.uvsq.amis.projetbanquejee.repositoryClient");
		appContext.refresh();

		CustomerService customerService = (CustomerService)appContext.getBean("CustomerService");
		customerService.test();

		appContext.close();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/page2.jsp").forward(req, resp);
		
		
		/*

		String paramAuteur = req.getParameter("auteur");

		String message = "Kransmission de var : Yes !!" ;//+ paramAuteur;
String mm ="Aminiata tu peux pull";
		String k = "Modif sur gits";
		Individu i = new Individu();
		i.setNom("DIALLO");
		i.setPrenom("Ami");

		req.setAttribute("test", message);
		req.setAttribute("individu", i);

		//this.getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
		*/
	}

}
