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

public class ControllerUserUpdate {

    @FXML
    private Button btnRegister;

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
    private PasswordField txtpass;

    @FXML
    private TextField txtuname;

    @FXML
    void register(ActionEvent event) {
    	
    	UserService userService = new UserService();
		
		String idStr =txtid.getText();
		int id = Integer.parseInt(idStr);
		
		User newObj=userService.find(id);
		System.out.println(newObj);
		
		String name=txtnume.getText();
		String adminS=txtid.getText();
		int adminI = Integer.parseInt(adminS);
		String user=txtuname.getText();
		String passw=txtpass.getText();
		String email=txtemail.getText();
		
		newObj.setName(name);
		newObj.setUsername(user);
		newObj.setPassword(passw);
    	newObj.setEmail(email);
    	newObj.setFuncion(adminI);
    	
		try {
			userService.updateUser(newObj);
		} catch (Exception e) {
			e.printStackTrace();
			}

    	try {
    	    Stage currentStage = (Stage) btnRegister.getScene().getWindow();
    	    currentStage.close();
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/entityAdaugatView.fxml"));
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
    	txtuname.setText("");
    	txtpass.setText("");
    	txtemail.setText("");
    	txtnume.setText("");
    	txtadmin.setText("");

    }

}
