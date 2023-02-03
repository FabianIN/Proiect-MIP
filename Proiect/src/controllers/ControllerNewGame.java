package controllers;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Artist;
import model.Designer;
import model.Game;
import model.Publisher;
import service.ArtistService;
import service.DesignerService;
import service.GameService;
import service.PublisherService;

public class ControllerNewGame {

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtartist;

	@FXML
	private TextField txtdescriere;

	@FXML
	private TextField txtdesigner;

	@FXML
	private TextField txtnume;

	@FXML
	private TextField txtplayers;

	@FXML
	private TextField txtpret;

	@FXML
	private TextField txtpublisher;

	@FXML
	private TextField txtstoc;

	@FXML
	void register(ActionEvent event) throws Exception {

		String gameName = txtnume.getText();
		String gameDesignerName = txtdesigner.getText();
		String gameArtistName = txtartist.getText();
		String gamePublisherName = txtpublisher.getText();
		String gamePriceStr = txtpret.getText();
		int gamePrice = Integer.parseInt(gamePriceStr);
		String gamePlayers = txtplayers.getText();
		String gameStocStr = txtstoc.getText();
		int gameStoc = Integer.parseInt(gameStocStr);
		String gameDescription = txtdescriere.getText();
		int gamePublisherId = 0;
		int gameArtistId = 0;
		int gameDesignerId = 0;

		if (gameName.equals("")) {

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/UsernameExistView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		else {

			GameService userService = new GameService();
			Game user = new Game();
			user = userService.findGame(gameName);
			if (user != null) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(
							getClass().getResource("/resourceView/UsernameExistView.fxml"));
					Parent root = (Parent) fxmlLoader.load();
					Stage newStage = new Stage();
					newStage.setScene(new Scene(root));
					newStage.setResizable(false);
					newStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else

			{
				//// verificare si adaugare, daca e cazul, publisher

				int publisher;

				PublisherService publisherService = new PublisherService();
				publisher = publisherService.findPublisher(gamePublisherName);

				if (publisher == 0) {

					EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BoardGameShop");
					EntityManager entitymanager = emfactory.createEntityManager();
					entitymanager.getTransaction().begin();

					Publisher publisherAdd = new Publisher();
					publisherAdd.setPublishername(gamePublisherName);

					entitymanager.persist(publisherAdd);
					entitymanager.getTransaction().commit();

					entitymanager.close();
					emfactory.close();

					PublisherService publisherSearch = new PublisherService();
					gamePublisherId = publisherSearch.findPublisher(gamePublisherName);

				} else {

					gamePublisherId = publisher;

				}
				// System.out.println("Id-ul ptr publisher este:" + gamePublisherId);
				//// verificare si adaugare, daca e cazul, designer

				int designer;

				DesignerService designerService = new DesignerService();
				designer = designerService.findDesigner(gameDesignerName);

				if (designer == 0) {

					EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BoardGameShop");
					EntityManager entitymanager = emfactory.createEntityManager();
					entitymanager.getTransaction().begin();

					Designer designerAdd = new Designer();
					designerAdd.setName(gameDesignerName);

					entitymanager.persist(designerAdd);
					entitymanager.getTransaction().commit();

					entitymanager.close();
					emfactory.close();

					DesignerService designerSearch = new DesignerService();
					gameDesignerId = designerSearch.findDesigner(gameDesignerName);

				} else {

					gameDesignerId = designer;

				}
				// System.out.println("Id-ul ptr designer este:" + gameDesignerId);
				//// verificare si adaugare, daca e cazul, designer

				int artist;

				ArtistService artistService = new ArtistService();
				artist = artistService.findArtist(gameArtistName);

				if (artist == 0) {

					EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BoardGameShop");
					EntityManager entitymanager = emfactory.createEntityManager();
					entitymanager.getTransaction().begin();

					Artist artistAdd = new Artist();
					artistAdd.setName(gameArtistName);

					entitymanager.persist(artistAdd);
					entitymanager.getTransaction().commit();

					entitymanager.close();
					emfactory.close();

					ArtistService artistSearch = new ArtistService();
					gameArtistId = artistSearch.findArtist(gameArtistName);

				} else {

					gameArtistId = artist;

				}
				// System.out.println("Id-ul ptr artist este:" + gameArtistId);

				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BoardGameShop");
				EntityManager entitymanager = emfactory.createEntityManager();
				entitymanager.getTransaction().begin();

				Game newGame = new Game();
				newGame.setGamename(gameName);
				newGame.setPublisherid(gamePublisherId);
				newGame.setArtistid(gameArtistId);
				newGame.setDesignerid(gameDesignerId);
				newGame.setDescription(gameDescription);
				newGame.setPlayers(gamePlayers);
				newGame.setStoc(gameStoc);
				newGame.setPret(gamePrice);
				entitymanager.persist(newGame);
				entitymanager.getTransaction().commit();

				entitymanager.close();
				emfactory.close();

				try {
					Stage currentStage = (Stage) btnRegister.getScene().getWindow();
					currentStage.close();
					FXMLLoader fxmlLoader = new FXMLLoader(
							getClass().getResource("/resourceView/EntityAdaugatView.fxml"));
					Parent root = (Parent) fxmlLoader.load();
					Stage newStage = new Stage();
					newStage.setScene(new Scene(root));
					newStage.setResizable(false);
					newStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}

	@FXML
	void reset(ActionEvent event) {

		txtdescriere.setText("");
		txtdesigner.setText("");
		txtartist.setText("");
		txtnume.setText("");
		txtplayers.setText("");
		txtpret.setText("");
		txtpublisher.setText("");
		txtstoc.setText("");

	}

}
