package DAO;

import java.util.ArrayList;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Entity.userEntity;

public class userDAOImpl implements IuserDAO{
	@Produces
		@PersistenceContext 
	
	private EntityManager em;

	
	@Override
	public userEntity findByLogin(String login) {
		userEntity u = em.find(userEntity.class, login);
		System.out.println(u.getNom());
		return u;
	}

	@Override
	public ArrayList<userEntity> findAll() {
		
		return new ArrayList<userEntity>();
	}

	@Override
	public void persist(userEntity u) {
//		try {
//			Class.forName("postgresql");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
	
			em = fact.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		
		System.out.println("blabla");
	}

}
