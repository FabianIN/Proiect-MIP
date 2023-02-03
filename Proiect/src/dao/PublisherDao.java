package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Publisher;

public class PublisherDao extends GenericDao<Publisher> {

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
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	}

	public void remove(Publisher entity, int entityId) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove((Publisher) em.find(Publisher.class, entityId));
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

	public List<Publisher> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Publisher> q = cb.createQuery(Publisher.class);

		Root<Publisher> c = q.from(Publisher.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("publishername"), paramName));
		TypedQuery<Publisher> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Publisher> results = query.getResultList();
		return results;
	}
}
