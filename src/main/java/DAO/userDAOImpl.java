package DAO;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entity.userEntity;

@Stateless
public class userDAOImpl implements IuserDAO, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory fact= Persistence.createEntityManagerFactory("primary");

	@Produces
	@PersistenceContext
	private static EntityManager em =fact.createEntityManager();;
	
	@Override
	public userEntity findByLogin(String login, String pswd) {
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
		Query q = em.createQuery("FROM  userEntity");    
		@SuppressWarnings("unchecked")
		ArrayList<userEntity> lst = (ArrayList<userEntity>) q.getResultList();
		return lst;
	}

	@Override
	public boolean persist(userEntity u) {
		em.getTransaction().begin();
		em.persist(em.contains(u) ? u : em.merge(u));
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean remove(userEntity u) {
		em.getTransaction().begin();
		em.remove(em.contains(u) ? u : em.merge(u));
		em.getTransaction().commit();	
		return true;
	}

}
