package Service;

import java.util.ArrayList;

import EJB.userBean;
import Entity.userEntity;

public interface IuserService {
	
	public String authorize(userEntity u);
	public String authorize(String login,String pswd);
	public void persist(String nom,String prenom,String login,String pswd);
	public ArrayList<userBean> finAll();
	public void remove(userBean ub);
}
