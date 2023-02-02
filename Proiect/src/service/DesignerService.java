package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.DesignerDao;
import model.Designer;
import model.User;

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
}
