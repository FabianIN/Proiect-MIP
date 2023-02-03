package controllers;

import java.io.IOException;

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

public class ControllerArtistUpdate {

	@FXML
	private Button btnReset;

	@FXML
	private Button btnUpdate;

	@FXML
	private TextField txtid;

	@FXML
	private TextField txtname;

	public void displayArtistInfo(TextField txtIdHidd, TextField txtNumeHidd) {
		String numeInfo = txtNumeHidd.getText();
		txtname.setText(numeInfo);
		String idInfo = txtIdHidd.getText();
		txtid.setText(idInfo);

	}

	@FXML
	void update(ActionEvent event) {

		ArtistService userService = new ArtistService();

		String idStr = txtid.getText();
		int id = Integer.parseInt(idStr);

		Artist updateArtist = userService.find(id);
		System.out.println(updateArtist);
		String name = txtname.getText();

		updateArtist.setName(name);

		try {
			userService.updateUser(updateArtist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Stage currentStage = (Stage) btnUpdate.getScene().getWindow();
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

	@FXML
	void reset(ActionEvent event) {

		txtid.setText("");
		txtname.setText("");

	}

}
