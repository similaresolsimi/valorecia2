package DAO;

import java.util.ArrayList;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entity.userEntity;


public class userDAOImpl implements IuserDAO{
	
	@Produces
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public userEntity findByLogin(String login, String pswd) {
		Query q = em.createQuery("SELECT * FROM  userentity e WHERE login = :login AND pswd = :pswd");       
		q.setParameter("login", login);  
		q.setParameter("pswd", pswd); 
		return (userEntity) q.getSingleResult();
	}

	@Override
	public ArrayList<userEntity> findAll() {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		Query q = em.createQuery("SELECT * FROM  userentity");    
		@SuppressWarnings("unchecked")
		ArrayList<userEntity> lst = (ArrayList<userEntity>) q.getResultList();
		return lst;
	}

	@Override
	public void persist(userEntity u) {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}

	@Override
	public void remove(userEntity u) {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();		
	}

}
