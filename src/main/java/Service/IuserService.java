package Service;

import java.util.ArrayList;

import Entity.userEntity;

public interface IuserService {
	
	public String authorize(userEntity u);
	public String authorize(String login,String pswd);
	public ArrayList<userEntity> finAll();
}
