package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerUserAdaugat {

	@FXML
	private Button btnOk;

	@FXML
	void ok(ActionEvent event) {
		try {
			Stage currentStage = (Stage) btnOk.getScene().getWindow();
			currentStage.close();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/LoginView.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage newStage = new Stage();
			newStage.setTitle("Board Games Shop Login");
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
