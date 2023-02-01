package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Artist;

public class ArtistDao extends GenericDao <Artist> {

	public ArtistDao(Class<Artist> eClass) {
		super(eClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Artist entity) {
		// TODO Auto-generated method stub
		super.create(entity);
	}

	@Override
	public void update(Artist entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public void remove(Artist entity, int entityId) {
		// TODO Auto-generated method stub
		super.remove(entity, entityId);
	}

	@Override
	public Artist find(int id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

	@Override
	public List<Artist> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}


}
