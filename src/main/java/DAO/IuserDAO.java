package DAO;

import java.util.ArrayList;

import Entity.user;

public interface IuserDAO {

	public user findByLogin(String name);
	public ArrayList<user> findAll();
	public void persist(user u);
}
