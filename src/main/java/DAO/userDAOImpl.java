package DAO;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity.user;

@Stateless 
public class userDAOImpl implements IuserDAO{

	protected EntityManager em;

	public userDAOImpl() {
	}
	
	@Override
	public user findByLogin(String login) {
		user u = em.find(user.class, login);
		System.out.println(u.getNom());
		return u;
	}

	@Override
	public ArrayList<user> findAll() {
		
		return null;
	}

	@Override
	public void persist(user u) {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		em.persist(u);
		System.out.println("blabla");
	}

}
