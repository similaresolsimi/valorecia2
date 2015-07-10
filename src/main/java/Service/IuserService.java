package Service;

import Entity.userEntity;

public interface IuserService {
	
	public String authorize(userEntity u);
	public String authorize(String nom,String prenom,String login,String pswd);
}
