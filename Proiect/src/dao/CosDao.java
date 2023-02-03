package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Cos;

public class CosDao extends GenericDao<Cos> {

	private EntityManagerFactory factory;

	public CosDao(EntityManagerFactory factory) {
		super(Cos.class);
		this.factory = factory;
	}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	}

	public void remove(Cos entity, int entityId) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove((Cos) em.find(Cos.class, entityId));
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

}
