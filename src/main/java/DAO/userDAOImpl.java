package DAO;

import java.util.ArrayList;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Entity.user;

public class userDAOImpl implements IuserDAO{
@Produces
	@PersistenceContext(unitName = "primary") 
	
	private EntityManager em;

	
	@Override
	public user findByLogin(String login) {
		user u = em.find(user.class, login);
		System.out.println(u.getNom());
		return u;
	}

	@Override
	public ArrayList<user> findAll() {
		
		return new ArrayList<user>();
	}

	@Override
	public void persist(user u) {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("jdbc:postgresql://localhost:5434/valorecia;create");
	
			em = fact.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		
		System.out.println("blabla");
	}

}
