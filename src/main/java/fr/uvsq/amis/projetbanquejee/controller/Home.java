package fr.uvsq.amis.projetbanquejee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.uvsq.amis.projetbanquejee.entity.Message;

@WebServlet("/")
public class Home extends HttpServlet {
	private static AnnotationConfigApplicationContext appContext = null;
	
	
	
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

			m.setChaine("Vous etes deja connecte, deconectez-vous avant de revenir a la page principale.");
			m.setValeur("non");
			req.setAttribute("message", m);
			resp.sendRedirect("/Projet_Banque_JEE/Client?valeur="+m.getValeur()+"&msg="+m.getChaine());
		}
		else {
		
		/*m.setChaine(msg);
		m.setValeur(valeur);
		*/
		req.setAttribute("message", m);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

}