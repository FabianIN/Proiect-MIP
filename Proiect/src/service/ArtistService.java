package service;

import java.util.List;
import javax.persistence.Persistence;
import dao.ArtistDao;
import model.Artist;
import model.Designer;

public class ArtistService {
	private ArtistDao artistDao;

	public ArtistService() {
		try {
			artistDao = new ArtistDao(Persistence.createEntityManagerFactory("BoardGameShop"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addUser(Artist newUser) {
		artistDao.create(newUser);
	}

	public void updateUser(Artist updatedUser) {
		artistDao.update(updatedUser);
	}

	public List<Artist> getAllUsers() {
		return artistDao.findAll();
	}

	public Artist find(int id) {
		return artistDao.find(id);
	}

	public int findArtist(String artistNume) {
		List<Artist> artist = artistDao.find(artistNume);
		if (artist.size() == 0) {

			return 0;
		} else {
			return artist.get(0).getArtistid();
		}
	}

	public void deleteUsers(Artist entity, int entityId) {
		artistDao.remove(entity, entityId);
	}

	public Boolean findUserX(String user) throws Exception {
		List<Artist> users = artistDao.find(user);
		if (users.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}