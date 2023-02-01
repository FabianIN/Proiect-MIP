package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Designer;
import model.User;

public class DesignerDao extends GenericDao <Designer> {

	private EntityManagerFactory factory;

	public DesignerDao(EntityManagerFactory factory) {
		super(Designer.class);
		this.factory = factory;
	}

	@Override
	public void create(Designer entity) {
		// TODO Auto-generated method stub
		super.create(entity);
	}

	@Override
	public void update(Designer entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public void remove(Designer entity, int entityId) {
		// TODO Auto-generated method stub
		super.remove(entity, entityId);
	}

	@Override
	public Designer find(int id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

	@Override
	public List<Designer> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
}
