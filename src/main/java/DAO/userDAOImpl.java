package DAO;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import Entity.user;

@Stateless 
public class userDAOImpl implements IuserDAO{

	private EntityManager em;

	public userDAOImpl() {
	}
	
	@Override
	public user findByLogin(String login) {
		user u = em.find(user.class, login);
		return u;
	}

	@Override
	public ArrayList<user> findAll() {
		
		return null;
	}

}
