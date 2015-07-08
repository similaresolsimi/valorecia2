package Service;

import DAO.IuserDAO;
import DAO.userDAOImpl;
import Entity.user;

public class userServiceImpl implements IuserService{

	public IuserDAO DAO= new userDAOImpl();
	
	@Override
	public String authorize(user u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String authorize(String nom, String prenom, String login, String pswd) {
		// TODO Auto-generated method stub
		return null;
	}

}
