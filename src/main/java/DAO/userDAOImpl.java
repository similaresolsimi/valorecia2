package DAO;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Entity.user;

public class userDAOImpl implements IuserDAO{

	@PersistenceContext(unitName = "primary") 
	protected EntityManager em;

	
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
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		if(fact.isOpen()){
			em = fact.createEntityManager();
			
	//		em.getTransaction().begin();
	//		em.persist(u);
	//		em.getTransaction().commit();
			}
		System.out.println("blabla");
	}

}
