package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Artist;

public class ArtistDao extends GenericDao<Artist> {

	private EntityManagerFactory factory;

	public ArtistDao(EntityManagerFactory factory) {
		super(Artist.class);
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

	public void remove(Artist entity, int entityId) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove((Artist) em.find(Artist.class, entityId));
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

	public List<Artist> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Artist> q = cb.createQuery(Artist.class);

		Root<Artist> c = q.from(Artist.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Artist> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Artist> results = query.getResultList();
		return results;
	}
}
