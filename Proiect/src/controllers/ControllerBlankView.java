package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerBlankView {

	@FXML
	private Button btnOk;

	@FXML
	void ok(ActionEvent event) {
		Stage currentStage = (Stage) btnOk.getScene().getWindow();
		currentStage.close();
	}
}
