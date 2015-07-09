package Service;

import DAO.IuserDAO;
import DAO.userDAOImpl;
import Entity.user;

public class userServiceImpl implements IuserService{

	public IuserDAO DAO= new userDAOImpl();
	
	@Override
	public String authorize(user u) {
		DAO.findByLogin(u.getLogin());
		DAO.persist(u);
		return "ok";
	}

	@Override
	public String authorize(String nom, String prenom, String login, String pswd) {
		user u = new user();
		u.setLogin(login);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setPswd(pswd);
		DAO.persist(u);
		return "ok";
	}

}
