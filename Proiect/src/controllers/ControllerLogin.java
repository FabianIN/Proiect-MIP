package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.UserService;

public class ControllerLogin {

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnReset;

	@FXML
	private PasswordField txtpass;

	@FXML
	private TextField txtuname;

	@FXML
	void login(ActionEvent event) throws Exception {

		String uname = txtuname.getText();
		String pass = txtpass.getText();

		if (uname.equals("") || pass.contentEquals("")) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/BlankView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			UserService userService = new UserService();
			User user = new User();
			user = userService.findUser(uname, pass);
			int isAdmin = Integer.parseInt(user.getFunction());

			if (user != null) {
				if (isAdmin == 1) {
					try {
						Stage currentStage = (Stage) btnRegister.getScene().getWindow();
						currentStage.close();
						Parent root;
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/AdminView.fxml"));
						root = loader.load();
						ControllerAdmin controllerAdmin = loader.getController();
						controllerAdmin.displayUserInfo(txtuname);
						Stage newStage = new Stage();
						newStage.setTitle("Board Games Shop - Admin Mode");
						newStage.setScene(new Scene(root));
						newStage.setResizable(false);
						newStage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {

					try {
						Stage currentStage = (Stage) btnRegister.getScene().getWindow();
						currentStage.close();
						Parent root;
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/UserView.fxml"));
						root = loader.load();
						ControllerMainUser controllerMainUser = loader.getController();
						controllerMainUser.displayUserInfo(txtuname);
						Stage newStage = new Stage();
						newStage.setTitle("Board Games Shop");
						newStage.setScene(new Scene(root));
						newStage.setResizable(false);
						newStage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@FXML
	void register(ActionEvent event) {
		try {
			Stage currentStage = (Stage) btnRegister.getScene().getWindow();
			currentStage.close();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/NewUserView.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage newStage = new Stage();
			newStage.setTitle("Add New User");
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

	}

}
