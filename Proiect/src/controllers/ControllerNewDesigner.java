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
import model.Designer;
import service.UserService;

public class ControllerNewDesigner {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtname;

    @FXML
    void register(ActionEvent event) throws Exception {
    	
    	String name = txtname.getText();

    	if(name.equals("")) {
    	   	try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/wrongCredentialsView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}	
    	}
    	
    	UserService userX = new UserService( );
		Boolean verifyE = userX.findUserX(name);

		if (!verifyE) {
			try {
	    		Stage currentStage = (Stage) btnRegister.getScene().getWindow();
	    		currentStage.close();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/usernameExistView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
				}
		}	else {
    		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "BoardGameShop" );
    	      EntityManager entitymanager = emfactory.createEntityManager( );
    	      entitymanager.getTransaction( ).begin( );

    	      Designer designer = new Designer( ); 
    	      designer.setName(name);

    	      entitymanager.persist( designer );
    	      entitymanager.getTransaction( ).commit( );

    	      entitymanager.close( );
    	      emfactory.close( );
    	      
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

    }

    @FXML
    void reset(ActionEvent event) {
    	
    	txtname.setText("");

    }

}
