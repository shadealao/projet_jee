package fr.uvsq.amis.projetbanquejee.entity;

public class LoginBean {

	private String login;
	private String pass;
	
	
	public LoginBean(String login, String mdp) {
		// TODO Auto-generated constructor stub
		this.login = login;
		this.pass = mdp;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
