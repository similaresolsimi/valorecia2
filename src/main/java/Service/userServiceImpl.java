package Service;

import javax.inject.Inject;

import DAO.IuserDAO;
import Entity.userEntity;

public class userServiceImpl implements IuserService{

	@Inject
	public IuserDAO DAO;
	
	@Override
	public String authorize(userEntity u) {
		
		return null;
	}

	@Override
	public String authorize(String nom, String prenom, String login, String pswd) {
		userEntity u = new userEntity();
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setLogin(login);
		u.setPswd(pswd);
		DAO.persist(u);
		return "ok";
	}

}
