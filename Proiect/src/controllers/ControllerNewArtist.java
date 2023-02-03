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
import service.ArtistService;

public class ControllerNewArtist {

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtname;

	@FXML
	void register(ActionEvent event) throws Exception {

		String name = txtname.getText();

		if (name.equals("")) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(
						getClass().getResource("/resourceView/WrongCredentialsView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ArtistService userX = new ArtistService();
		Boolean verifyE = userX.findUserX(name);

		if (!verifyE) {
			try {
				Stage currentStage = (Stage) btnRegister.getScene().getWindow();
				currentStage.close();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/UsernameExistView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BoardGameShop");
			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();

			Artist artist = new Artist();
			artist.setName(name);

			entitymanager.persist(artist);
			entitymanager.getTransaction().commit();

			entitymanager.close();
			emfactory.close();

			try {
				Stage currentStage = (Stage) btnRegister.getScene().getWindow();
				currentStage.close();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/EntityAdaugatView.fxml"));
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

	@FXML
	void reset(ActionEvent event) {

		txtname.setText("");

	}

}