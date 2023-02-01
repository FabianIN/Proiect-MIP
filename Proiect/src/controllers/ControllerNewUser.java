package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

public class ControllerNewUser {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtnume;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtuname;

	    @FXML
	    void register(ActionEvent event) throws SQLException {
	    	
	    	String uname = txtuname.getText();
	    	String pass = txtpass.getText();
	    	String email = txtemail.getText();
	    	String nume = txtnume.getText();
	    	
	    	if(uname.equals("") || pass.contentEquals("") || email.contentEquals("") || nume.contentEquals("")) {
	    	   	try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/wrongCredentials.fxml"));
					Parent root = (Parent) fxmlLoader.load();
					Stage newStage = new Stage();
					newStage.setScene(new Scene(root));
					newStage.setResizable(false);
					newStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}	
	    	}
	    //TODO - in caz ca userul este deja utilizat.
	    	
//	    	if(uname.equals("") || pass.contentEquals("") || email.contentEquals("") || nume.contentEquals("")) {
//	    	   	try {
//					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/wrongCredentials.fxml"));
//					Parent root = (Parent) fxmlLoader.load();
//					Stage newStage = new Stage();
//					newStage.setScene(new Scene(root));
//					newStage.setResizable(false);
//					newStage.show();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}	
//	    	}
	    	
	    	else {
	    		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "BoardGameShop" );
	    	      EntityManager entitymanager = emfactory.createEntityManager( );
	    	      entitymanager.getTransaction( ).begin( );

	    	      User user = new User( ); 
	    	      user.setName(nume);
	    	      user.setUsername(uname);
	    	      user.setEmail(email);
	    	      user.setPassword(pass);
	    	      entitymanager.persist( user );
	    	      entitymanager.getTransaction( ).commit( );

	    	      entitymanager.close( );
	    	      emfactory.close( );
	    	      
	    	      try {
	  	    		Stage currentStage = (Stage) btnRegister.getScene().getWindow();
	  	    		currentStage.close();
	  				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/userAdaugat.fxml"));
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
	    	
	    	txtuname.setText("");
	    	txtpass.setText("");
	    	txtemail.setText("");
	    	txtnume.setText("");
	    }

	}




