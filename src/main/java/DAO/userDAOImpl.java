package DAO;

import java.util.ArrayList;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entity.userEntity;


public class userDAOImpl implements IuserDAO{
	
	@Produces
	@PersistenceContext
	private static EntityManager em;

	
	@Override
	public userEntity findByLogin(String login, String pswd) {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		userEntity result = null;
		Query q = em.createNativeQuery("SELECT id,login,nom,prenom,pswd FROM userEntity WHERE login =:login AND pswd =:pswd",userEntity.class);       
		q.setParameter("login", login);  
		q.setParameter("pswd", pswd); 
		try{
		result = (userEntity) q.getSingleResult();
		}
		catch(NoResultException exc){}
		if(result == null){return null;}
		else return result;
	}

	@Override
	public ArrayList<userEntity> findAll() {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		Query q = em.createQuery("FROM  userEntity");    
		@SuppressWarnings("unchecked")
		ArrayList<userEntity> lst = (ArrayList<userEntity>) q.getResultList();
		return lst;
	}

	@Override
	public boolean persist(userEntity u) {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean remove(userEntity u) {
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");
		em = fact.createEntityManager();
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();	
		return true;
	}

}
