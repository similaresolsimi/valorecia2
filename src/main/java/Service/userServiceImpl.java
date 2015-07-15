package Service;

import java.util.ArrayList;

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
	public String authorize(String login, String pswd) {
		userEntity u = new userEntity();
		u.setLogin(login);
		u.setPswd(pswd);
		if(DAO.findByLogin(login, pswd) != null){
			return "console.xhtml";
		}
		return "non";
	}

	@Override
	public ArrayList<userEntity> finAll() {
		if(DAO.findAll().size() >0){
			return DAO.findAll();
		}
		else return new ArrayList<userEntity>();
	}

}
