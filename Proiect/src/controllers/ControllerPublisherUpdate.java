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
import model.Publisher;
import service.PublisherService;

public class ControllerPublisherUpdate {

	@FXML
	private Button btnUpdate;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtid;

	@FXML
	private TextField txtname;

	public void displayPublisherInfo(TextField txtIdHidd, TextField txtNumeHidd) {
		String numeInfo = txtNumeHidd.getText();
		txtname.setText(numeInfo);
		String idInfo = txtIdHidd.getText();
		txtid.setText(idInfo);

	}

	@FXML
	void update(ActionEvent event) {

		PublisherService userService = new PublisherService();

		String idStr = txtid.getText();
		int id = Integer.parseInt(idStr);

		Publisher updatePublisher = userService.find(id);
		System.out.println(updatePublisher);
		String name = txtname.getText();

		updatePublisher.setPublishername(name);

		try {
			userService.updateUser(updatePublisher);
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

		txtname.setText("");

	}

}
