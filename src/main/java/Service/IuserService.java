package Service;

import Entity.user;

public interface IuserService {
	
	public String authorize(user u);
	public String authorize(String nom,String prenom,String login,String pswd);
}
