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

	public List<Game> getAllGames() {
		return gameDao.findAll();
	}
	
	public List<Game> findGame(String gameNume) {
		List<Game> game = gameDao.find(gameNume);
		if (game.size() == 0) {

			return null;
	}
		else {
			return game;
		}
	}
		
}
