package service;

import java.io.IOException;
import java.util.List;
import javax.persistence.Persistence;
import dao.GameDao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.User;

public class GameService {
	private GameDao gameDao;
	
	public GameService() {
		try {
			gameDao = new GameDao(Persistence.createEntityManagerFactory("BoardGameShop"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addGame(Game newGame) {
		gameDao.create(newGame);
	}

	public void updateUser(Game updatedGame) {
		gameDao.update(updatedGame);
	}

	public List<Game> getAllUsers() {
		return gameDao.findAll();
	}
	
	public Game findGame(String games) {
		List<Game> game = gameDao.find(games);
		if (game.size() == 0) {
		Game u = game.get(0);
		return u;
	}
		return null;
	}
}
