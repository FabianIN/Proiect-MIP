package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Publisher;
import model.User;

public class PublisherDao extends GenericDao <Publisher> {

	private EntityManagerFactory factory;

	public PublisherDao(EntityManagerFactory factory) {
		super(Publisher.class);
		this.factory = factory;
	}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The entity publisher cannot be created!");
			return null;
		}
	}




}
