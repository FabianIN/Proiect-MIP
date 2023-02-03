package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.CosDao;
import model.Cos;

public class CosService {
	private CosDao cosDao;

	public CosService() {
		try {
			cosDao = new CosDao(Persistence.createEntityManagerFactory("BoardGameShop"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Cos newUser) {
		cosDao.create(newUser);
	}

	public void updateUser(Cos updatedUser) {
		cosDao.update(updatedUser);
	}

	public List<Cos> getAllUsers() {
		return cosDao.findAll();
	}

	public void deleteUsers(Cos entity, int entityId) {
		cosDao.remove(entity, entityId);
	}

	public Cos find(int id) {
		return cosDao.find(id);
	}

}
