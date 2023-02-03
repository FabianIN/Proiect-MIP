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
import model.User;
import service.UserService;

public class ControllerUserUpdate {

	@FXML
	private Button btnUpdate;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtadmin;

	@FXML
	private TextField txtemail;

	@FXML
	private TextField txtid;

	@FXML
	private TextField txtnume;

	@FXML
	private TextField txtpass;

	@FXML
	private TextField txtuname;

	public void displayUserInfo(TextField txtIdHidd, TextField txtUnumeHidd, TextField txtNumeHidd,
			TextField txtPassHidd, TextField txtEmailHidd, TextField txtAdminHidd) {
		String unameInfo = txtUnumeHidd.getText();
		txtuname.setText(unameInfo);
		String numeInfo = txtNumeHidd.getText();
		txtnume.setText(numeInfo);
		String passInfo = txtPassHidd.getText();
		txtpass.setText(passInfo);
		String emailInfo = txtEmailHidd.getText();
		txtemail.setText(emailInfo);
		String idInfo = txtIdHidd.getText();
		txtid.setText(idInfo);
		String adminInfo = txtAdminHidd.getText();
		txtadmin.setText(adminInfo);
	}

	@FXML
	void update(ActionEvent event) {

		UserService userService = new UserService();

		String idStr = txtid.getText();
		int id = Integer.parseInt(idStr);

		User newObj = userService.find(id);
		System.out.println(newObj);

		String name = txtnume.getText();
		String adminS = txtadmin.getText();
		String user = txtuname.getText();
		String passw = txtpass.getText();
		String email = txtemail.getText();

		newObj.setName(name);
		newObj.setUsername(user);
		newObj.setPassword(passw);
		newObj.setEmail(email);
		newObj.setFunction(adminS);

		try {
			userService.updateUser(newObj);
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

		txtuname.setText("");
		txtpass.setText("");
		txtemail.setText("");
		txtnume.setText("");
		txtadmin.setText("");

	}

}
