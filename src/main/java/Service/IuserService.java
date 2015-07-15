package Service;

import java.util.ArrayList;

import EJB.userBean;
import Entity.userEntity;

public interface IuserService {
	
	public String authorize(userEntity u);
	public String authorize(String login,String pswd);
	public ArrayList<userBean> finAll();
}
