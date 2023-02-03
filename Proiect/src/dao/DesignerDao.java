package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Designer;

public class DesignerDao extends GenericDao<Designer> {

	private EntityManagerFactory factory;

	public DesignerDao(EntityManagerFactory factory) {
		super(Designer.class);
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

	public void remove(Designer entity, int entityId) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove((Designer) em.find(Designer.class, entityId));
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			em.getTransaction().rollback();

		} finally {
			em.close();
		}
	}

	public List<Designer> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Designer> q = cb.createQuery(Designer.class);

		Root<Designer> c = q.from(Designer.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Designer> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Designer> results = query.getResultList();
		return results;
	}
}
