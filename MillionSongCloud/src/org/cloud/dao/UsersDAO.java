package org.cloud.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.cloud.pojo.Users;
import org.cloud.utilities.ApplicationLibrary;
import org.cloud.utilities.BaseException;
import org.hibernate.service.spi.ServiceException;

public class UsersDAO implements IUsersDAO {

	private EntityManagerFactory emf;
	private EntityManager entityManager;

	public UsersDAO() {
		super();
		emf = Persistence.createEntityManagerFactory("MillionSongCloud");
		entityManager = emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void saveUser(Users userObj) {
		final String methodName = "saveUser";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(userObj);
			entityManager.getTransaction().commit();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SAVE_USERS_QUERY, this.getClass(),
					methodName);
			System.out.println(exception.toString());
		}
	}

}
