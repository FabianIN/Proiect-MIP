package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Game;
import model.User;

public class GameDao extends GenericDao<Game> {

	private EntityManagerFactory factory;

	public GameDao(EntityManagerFactory factory) {
		super(Game.class);
		this.factory = factory;
	}
	
	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The game cannot be created!");
			return null;
		}
	}
	
	public List<Game> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Game> q = cb.createQuery(Game.class);

		Root<Game> c = q.from(Game.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("gamename"), paramName));
		TypedQuery<Game> query = em.createQuery(q);
		query.setParameter(paramName, name);

		List<Game> results = query.getResultList();
		return results;
	}
}

