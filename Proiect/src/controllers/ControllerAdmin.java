package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artist;
import model.Designer;
import model.Game;
import model.Publisher;
import model.User;
import service.DesignerService;
import service.GameService;
import service.UserService;

public class ControllerAdmin {

    @FXML
    private Button addArtist;

    @FXML
    private Button addDesigner;

    @FXML
    private Button addGame;

    @FXML
    private Button addPublisher;

    @FXML
    private Button addUser;

    @FXML
    private Button artistManagement;

    @FXML
    private TableColumn<Artist, Integer> artistCol1;

    @FXML
    private TableColumn<Artist, String> artistCol2;

    @FXML
    private TableView<Artist> artistTable;

    @FXML
    private Text currentMan;

    @FXML
    private Button designerManagement;

    @FXML
    private TableColumn<Designer, Integer> designerCol1;

    @FXML
    private TableColumn<Designer, String> designerCol2;

    @FXML
    private TableView<Designer> designerTable;

    @FXML
    private Button gameManagement;

    @FXML
    private TableColumn<Game, Integer> gameCol1;

    @FXML
    private TableColumn<Game, String> gameCol2;

    @FXML
    private TableColumn<Game, Integer> gameCol3;

    @FXML
    private TableColumn<Game, Integer> gameCol4;

    @FXML
    private TableColumn<Game, Integer> gameCol5;

    @FXML
    private TableColumn<Game, Integer> gameCol6;

    @FXML
    private TableColumn<Game, Integer> gameCol7;

    @FXML
    private TableColumn<Game, String> gameCol8;

    @FXML
    private TableColumn<Game, String> gameCol9;

    @FXML
    private TableView<Game> gameTabel;

    @FXML
    private Button publisherManagement;

    @FXML
    private TableColumn<Publisher, Integer> publisherCol1;

    @FXML
    private TableColumn<Publisher, String> publisherCol2;

    @FXML
    private TableView<Publisher> publisherTable;

    @FXML
    private Button removArtist;

    @FXML
    private Button removeDesigner;

    @FXML
    private Button removeGame;

    @FXML
    private Button removePublisher;

    @FXML
    private Button removeUser;

    @FXML
    private Button updateArtist;

    @FXML
    private Button updateDesigner;

    @FXML
    private Button updateGame;

    @FXML
    private Button updatePublisher;

    @FXML
    private Button updateUser;

    @FXML
    private TableColumn<User, Integer> userCol1;

    @FXML
    private TableColumn<User, String> userCol2;

    @FXML
    private TableColumn<User, String> userCol3;

    @FXML
    private TableColumn<User, String> userCol4;

    @FXML
    private TableColumn<User, String> userCol5;

    @FXML
    private TableColumn<User, Integer> userCol6;

    @FXML
    private TableView<User> userTabel;

    @FXML
    private Button userManagement;

    @FXML
    void artistAdd(ActionEvent event) {

    }

    @FXML
    void artistRemove(ActionEvent event) {

    }

    @FXML
    void artistUpdate(ActionEvent event) {

    }

    @FXML
    void designerAdd(ActionEvent event) {
    	
   	 try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/newDesignerView.fxml"));
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
    void designerRemove(ActionEvent event) {

    }

    @FXML
    void designerUpdate(ActionEvent event) {

    }

    @FXML
    void gameAdd(ActionEvent event) {

    }

    @FXML
    void gameRemove(ActionEvent event) {

    }

    @FXML
    void gameUpdate(ActionEvent event) {

    }

    @FXML
    void publisherAdd(ActionEvent event) {

    }

    @FXML
    void publisherRemove(ActionEvent event) {

    }

    @FXML
    void publisherUpdate(ActionEvent event) {

    }

    @FXML
    void userAdd(ActionEvent event) {
    	
    	 try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/newUserAdminAddView.fxml"));
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
    void userRemove(ActionEvent event) {

    }

    @FXML
    void userUpdate(ActionEvent event) {
    	
   	 try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/userUpdateView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

    //Partea de management!!
    
    @FXML
    void managementArtist(ActionEvent event) {
    	
    	currentMan.setText("Artist Management");
    	
    	//tabelele nefolosite se ascund. se face vizibil cel utilizat.
    	userTabel.setVisible(false);
    	publisherTable.setVisible(false);
    	gameTabel.setVisible(false);
    	designerTable.setVisible(false);
    	artistTable.setVisible(true);
    	
    	//se fac vizibile doar butoanele folosite. restul se fac invizibile.    	
    	addPublisher.setVisible(false);
    	removePublisher.setVisible(false);
    	updatePublisher.setVisible(false);
    	addGame.setVisible(false);
    	removeGame.setVisible(false);
    	updateGame.setVisible(false);
    	addArtist.setVisible(true);
    	removArtist.setVisible(true);
    	updateArtist.setVisible(true);
    	addDesigner.setVisible(false);
    	removeDesigner.setVisible(false);
    	updateDesigner.setVisible(false);
    	addUser.setVisible(false);
    	removeUser.setVisible(false);
    	updateUser.setVisible(false);
    	
    }

    @FXML
    void managementDesigner(ActionEvent event) {
    	
    	currentMan.setText("Designer Management");
    	
    	//tabelele nefolosite se ascund. se face vizibil cel utilizat.
    	userTabel.setVisible(false);
    	publisherTable.setVisible(false);
    	gameTabel.setVisible(false);
    	designerTable.setVisible(true);
    	artistTable.setVisible(false);
    	
    	//se fac vizibile doar butoanele folosite. restul se fac invizibile.    	
    	addPublisher.setVisible(false);
    	removePublisher.setVisible(false);
    	updatePublisher.setVisible(false);
    	addGame.setVisible(false);
    	removeGame.setVisible(false);
    	updateGame.setVisible(false);
    	addArtist.setVisible(false);
    	removArtist.setVisible(false);
    	updateArtist.setVisible(false);
    	addDesigner.setVisible(true);
    	removeDesigner.setVisible(true);
    	updateDesigner.setVisible(true);
    	addUser.setVisible(false);
    	removeUser.setVisible(false);
    	updateUser.setVisible(false);
    	
    	DesignerService  newUser=new DesignerService();
		List<Designer> allUsers = newUser.getAllUsers();
		
		ObservableList<Designer> listOffUsers= FXCollections.observableArrayList(new ArrayList<Designer>(allUsers));
		designerCol1.setCellValueFactory(new PropertyValueFactory<Designer,Integer>("designerid"));
		designerCol2.setCellValueFactory(new PropertyValueFactory<Designer,String>("name"));
		designerTable.setItems(listOffUsers);
		System.out.println(listOffUsers);
    	
    }

    @FXML
    void managementGame(ActionEvent event) {

    	currentMan.setText("Game Management");
    	
    	//tabelele nefolosite se ascund. se face vizibil cel utilizat.
    	userTabel.setVisible(false);
    	publisherTable.setVisible(false);
    	gameTabel.setVisible(true);
    	designerTable.setVisible(false);
    	artistTable.setVisible(false);
    	
    	//se fac vizibile doar butoanele folosite. restul se fac invizibile.    	
    	addPublisher.setVisible(false);
    	removePublisher.setVisible(false);
    	updatePublisher.setVisible(false);
    	addGame.setVisible(true);
    	removeGame.setVisible(true);
    	updateGame.setVisible(true);
    	addArtist.setVisible(false);
    	removArtist.setVisible(false);
    	updateArtist.setVisible(false);
    	addDesigner.setVisible(false);
    	removeDesigner.setVisible(false);
    	updateDesigner.setVisible(false);
    	addUser.setVisible(false);
    	removeUser.setVisible(false);
    	updateUser.setVisible(false);
    	
    	GameService  newGame=new GameService();
		List<Game> allGames = newGame.getAllGames();
		
		ObservableList<Game> listOffGames= FXCollections.observableArrayList(new ArrayList<Game>(allGames));
		gameCol1.setCellValueFactory(new PropertyValueFactory<Game,Integer>("gameid"));
		gameCol2.setCellValueFactory(new PropertyValueFactory<Game,String>("gamename"));
		gameCol3.setCellValueFactory(new PropertyValueFactory<Game,Integer>("publisherid"));
		gameCol4.setCellValueFactory(new PropertyValueFactory<Game,Integer>("artistid"));
		gameCol5.setCellValueFactory(new PropertyValueFactory<Game,Integer>("designerid"));
		gameCol6.setCellValueFactory(new PropertyValueFactory<Game,Integer>("pret"));
		gameCol7.setCellValueFactory(new PropertyValueFactory<Game,Integer>("stoc"));
		gameCol8.setCellValueFactory(new PropertyValueFactory<Game,String>("players"));
		gameCol9.setCellValueFactory(new PropertyValueFactory<Game,String>("description"));
		gameTabel.setItems(listOffGames);
		System.out.println(listOffGames);

    	
    }

    @FXML
    void managementPublisher(ActionEvent event) {
    	
    	currentMan.setText("Publisher Management");
    	
    	//tabelele nefolosite se ascund. se face vizibil cel utilizat.
    	userTabel.setVisible(false);
    	publisherTable.setVisible(true);
    	gameTabel.setVisible(false);
    	designerTable.setVisible(false);
    	artistTable.setVisible(false);
    	
    	//se fac vizibile doar butoanele folosite. restul se fac invizibile.    	
    	addPublisher.setVisible(true);
    	removePublisher.setVisible(true);
    	updatePublisher.setVisible(true);
    	addGame.setVisible(false);
    	removeGame.setVisible(false);
    	updateGame.setVisible(false);
    	addArtist.setVisible(false);
    	removArtist.setVisible(false);
    	updateArtist.setVisible(false);
    	addDesigner.setVisible(false);
    	removeDesigner.setVisible(false);
    	updateDesigner.setVisible(false);
    	addUser.setVisible(false);
    	removeUser.setVisible(false);
    	updateUser.setVisible(false);

    }

    @FXML
    void managementUser(ActionEvent event) {

    	currentMan.setText("User Management");
    	
    	//tabelele nefolosite se ascund. se face vizibil cel utilizat.
    	userTabel.setVisible(true);
    	publisherTable.setVisible(false);
    	gameTabel.setVisible(false);
    	designerTable.setVisible(false);
    	artistTable.setVisible(false);
    	
    	//se fac vizibile doar butoanele folosite. restul se fac invizibile.    	
    	addPublisher.setVisible(false);
    	removePublisher.setVisible(false);
    	updatePublisher.setVisible(false);
    	addGame.setVisible(false);
    	removeGame.setVisible(false);
    	updateGame.setVisible(false);
    	addArtist.setVisible(false);
    	removArtist.setVisible(false);
    	updateArtist.setVisible(false);
    	addDesigner.setVisible(false);
    	removeDesigner.setVisible(false);
    	updateDesigner.setVisible(false);
    	addUser.setVisible(true);
    	removeUser.setVisible(true);
    	updateUser.setVisible(true);
    	
    	UserService  newUser=new UserService();
		List<User> allUsers = newUser.getAllUsers();
		
		ObservableList<User> listOffUsers= FXCollections.observableArrayList(new ArrayList<User>(allUsers));
		userCol1.setCellValueFactory(new PropertyValueFactory<User,Integer>("uid"));
		userCol2.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
		userCol3.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
		userCol4.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
		userCol5.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
		userCol6.setCellValueFactory(new PropertyValueFactory<User,Integer>("isadmin"));
		userTabel.setItems(listOffUsers);
		System.out.println(listOffUsers);
    	
    }
    
}




//addPublisher
//removePublisher
//updatePublisher
//addGame
//removeGame
//updateGame
//addArtist
//removArtist
//updateArtist
//addDesigner
//removeDesigner
//updateDesigner
//addUser
//removeUser
//updateUser
