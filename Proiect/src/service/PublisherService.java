package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.PublisherDao;
import model.Publisher;

public class PublisherService {
	private PublisherDao publisherDao;

	public PublisherService() {
		try {
			publisherDao = new PublisherDao(Persistence.createEntityManagerFactory("BoardGameShop"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Publisher newUser) {
		publisherDao.create(newUser);
	}

	public void updateUser(Publisher updatedUser) {
		publisherDao.update(updatedUser);
	}

	public Publisher find(int id) {
		return publisherDao.find(id);
	}

	public List<Publisher> getAllUsers() {
		return publisherDao.findAll();
	}

	public void deleteUsers(Publisher entity, int entityId) {
		publisherDao.remove(entity, entityId);
	}

	public int findPublisher(String publisherNume) {
		List<Publisher> publisher = publisherDao.find(publisherNume);
		if (publisher.size() == 0) {

			return 0;
		} else {
			return publisher.get(0).getPublisherid();
		}
	}

//	public List<Publisher> findPublisher(String publisherNume) {
//		List<Publisher> publisher = publisherDao.find(publisherNume);
//		if (publisher.size() == 0) {
//
//			return null;
//	}
//		else {
//			return publisher;
//		}
//	}

	public Boolean findUserX(String user) throws Exception {
		List<Publisher> users = publisherDao.find(user);
		if (users.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}