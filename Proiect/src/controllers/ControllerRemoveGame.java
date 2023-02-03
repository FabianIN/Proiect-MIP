package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Game;
import service.GameService;

public class ControllerRemoveGame {

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtid;

	@FXML
	void delete(ActionEvent event) {

		GameService newObj = new GameService();

		String idStr = txtid.getText();
		int id = Integer.parseInt(idStr);
		Game newGame = new Game();
		try {
			newObj.deleteUsers(newGame, id);
			Stage currentStage = (Stage) btnDelete.getScene().getWindow();
			currentStage.close();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/EntityRemovedView.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage newStage = new Stage();
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@FXML
	void reset(ActionEvent event) {

		txtid.setText("");
	}
}
