package service;

import java.io.IOException;
import java.util.List;
import javax.persistence.Persistence;
import dao.UserDao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

public class UserService {
	private UserDao userDao;

	public UserService() {
		try {
			userDao = new UserDao(Persistence.createEntityManagerFactory("BoardGameShop"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(User newUser) {
		userDao.create(newUser);
	}

	public void updateUser(User updatedUser) {
		userDao.update(updatedUser);
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public User find(int id) {
		return userDao.find(id);
	}

	public void deleteUsers(User entity, int entityId) {
		userDao.remove(entity, entityId);
	}

	/// for login
//	public User findUser(String user, String pass) throws Exception {
//		List<User> users = userDao.find(user);
//		if (users.size() == 0) {
//			try {
//				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/WrongUser.fxml"));
//				Parent root = (Parent) fxmlLoader.load();
//				Stage newStage = new Stage();
//				newStage.setScene(new Scene(root));
//				newStage.setResizable(false);
//				newStage.show();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		User u = users.get(0);
//
//		if (pass == u.getPassword()) {
//			return u;
//
//		} else {
//
//			try {
//				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/WrongPassword.fxml"));
//				Parent root = (Parent) fxmlLoader.load();
//				Stage newStage = new Stage();
//				newStage.setScene(new Scene(root));
//				newStage.setResizable(false);
//				newStage.show();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			return null;
//		}
//	}

	public Boolean findUserX(String user) throws Exception {
		List<User> users = userDao.find(user);
		if (users.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public User findUser(String user, String pass) throws Exception {
		List<User> users = userDao.find(user);
		if (users.size() == 0) {
			throw new Exception("User not found!");
		}
		User u = users.get(0);

		if (pass.compareTo(u.getPassword()) != 0) {
			throw new Exception("Password does not match");
		}
		return u;
	}

}
