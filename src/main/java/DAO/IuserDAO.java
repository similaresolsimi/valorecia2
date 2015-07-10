package DAO;

import java.util.ArrayList;

import Entity.userEntity;

public interface IuserDAO {

	public userEntity findByLogin(String name);
	public ArrayList<userEntity> findAll();
	public void persist(userEntity u);
}
