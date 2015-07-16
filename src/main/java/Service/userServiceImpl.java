package Service;

import java.util.ArrayList;

import javax.inject.Inject;

import DAO.IuserDAO;
import EJB.userBean;
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
	public ArrayList<userBean> finAll() {
		if(DAO.findAll().size() >0){
			return toUserBean(DAO.findAll());
		}
		else return toUserBean(new ArrayList<userEntity>());
	}
	
	public ArrayList<userBean> toUserBean(ArrayList<userEntity> lst){
		ArrayList<userBean> beans = new ArrayList<userBean>();
		for(userEntity ue : lst){
			userBean b = new userBean();
			b.setId(ue.getId());
			b.setLogin(ue.getLogin());
			b.setNom(ue.getNom());
			b.setPrenom(ue.getPrenom());
			b.setPswd(ue.getPswd());
			beans.add(b);
		}
		return beans;
	}

	@Override
	public void remove(userBean ub) {
		userEntity ue = new userEntity();
		ue.setLogin(ub.getLogin());
		ue.setNom(ub.getNom());
		ue.setPrenom(ub.getPrenom());
		ue.setPswd(ub.getPswd());
		ue.setId(ub.getId());
	    DAO.remove(ue);
	}

	@Override
	public void persist(userBean ub) {
		userEntity ue = new userEntity();
		ue.setLogin(ub.getLogin());
		ue.setNom(ub.getNom());
		ue.setPrenom(ub.getPrenom());
		ue.setPswd(ub.getPswd());
		DAO.persist(ue);	
	}

}
