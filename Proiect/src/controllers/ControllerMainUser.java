package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Game;
import service.GameService;

public class ControllerMainUser {

    @FXML
    private Button btnSearch;

    @FXML
    private TableColumn<?, ?> display;

    @FXML
    private TextField textSearch;

    @FXML
    void Search(ActionEvent event) throws Exception {
    	
    	String searchName = textSearch.getText();

    	if(searchName.equals("")) {
    	   	try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/wrongSearch.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}	
    	}
    	else {
    		GameService gameService = new GameService();
    		Game game = new Game();
    		game = gameService.findGame( searchName );
    		display.setText(searchName);
    	}
    	
    }

}