package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.DesignerDao;
import model.Designer;

public class DesignerService {
	private DesignerDao designerDao;

	public DesignerService() {
		try {
			designerDao = new DesignerDao(Persistence.createEntityManagerFactory("BoardGameShop"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Designer newUser) {
		designerDao.create(newUser);
	}

	public void updateUser(Designer updatedUser) {
		designerDao.update(updatedUser);
	}

	public List<Designer> getAllUsers() {
		return designerDao.findAll();
	}

	public void deleteUsers(Designer entity, int entityId) {
		designerDao.remove(entity, entityId);
	}

	public Designer find(int id) {
		return designerDao.find(id);
	}

	public int findDesigner(String publisherNume) {
		List<Designer> designer = designerDao.find(publisherNume);
		if (designer.size() == 0) {

			return 0;
		} else {
			return designer.get(0).getDesignerid();
		}
	}

	public Boolean findUserX(String user) throws Exception {
		List<Designer> users = designerDao.find(user);
		if (users.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
