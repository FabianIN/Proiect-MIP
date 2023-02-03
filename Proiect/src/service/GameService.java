package service;

import java.util.List;
import javax.persistence.Persistence;
import dao.GameDao;
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

	public List<Game> getGame(String gameNume) {
		return gameDao.find(gameNume);
	}
	
	public void deleteUsers(Game entity, int entityId) {
		gameDao.remove(entity, entityId);
	}

	public Game find(int id) {
		return gameDao.find(id);
	}

	public Game findEntity(String gameNume) {
		Game game = (Game) gameDao.find(gameNume);
		if (game == null) {

			return null;
		} else {
			return game;
		}
	}

	public Game findGame(String user) throws Exception {
		List<Game> game = gameDao.find(user);
		if (game.size() == 0) {
			return null;
		}
		Game u = game.get(0);

		return u;
	}

}
