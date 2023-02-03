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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Artist;
import model.Designer;
import model.Game;
import model.Publisher;
import model.User;
import service.ArtistService;
import service.DesignerService;
import service.GameService;
import service.PublisherService;
import service.UserService;

public class ControllerAdmin {

	@FXML
	private TextField txtGdescriereHidd;

	@FXML
	private TextField txtGidHidd;

	@FXML
	private TextField txtGnumeHidd;

	@FXML
	private TextField txtGplayerHidd;

	@FXML
	private TextField txtGpretHidd;

	@FXML
	private TextField txtGstocHidd;

	@FXML
	private TextField txtAnumeHidd;

	@FXML
	private TextField txtDnumeHidd;

	@FXML
	private TextField txtPnumeHidd;

	@FXML
	private TextField txtAdminHidd;

	@FXML
	private TextField txtEmailHidd;

	@FXML
	private TextField txtIdHidd;

	@FXML
	private TextField txtNumeHidd;

	@FXML
	private TextField txtPassHidd;

	@FXML
	private TextField txtUnumeHidd;

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
	private TableColumn<User, String> userCol6;

	@FXML
	private TableView<User> userTabel;

	@FXML
	private Button userManagement;
	
    @FXML
    private Text txtuserColt;
    
    @FXML
    private Button userlogout;
	
    @FXML
    void logout(ActionEvent event) {
    	
    	try {
    		Stage currentStage = (Stage) userlogout.getScene().getWindow();
    		currentStage.close();
    		Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/LoginView.fxml"));
			root = loader.load();
			Stage newStage = new Stage();
			newStage.setTitle("Board Games Shop Login");
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
	public void displayUserInfo(TextField txtuname)
	{
		String userNameInfo = txtuname.getText();
		txtuserColt.setText(userNameInfo);
	}

	//// Artist

	@FXML
	void transferDateArtist(MouseEvent event) {

		TablePosition pos = artistTable.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();

		txtIdHidd.setText(Integer.toString(artistCol1.getCellData(pos.getRow())));
		txtNumeHidd.setText(artistCol2.getCellData(pos.getRow()));

	}

	@FXML
	void artistAdd(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/NewArtistView.fxml"));
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
	void artistRemove(ActionEvent event) {

		ArtistService newObj = new ArtistService();
		String idStr = txtIdHidd.getText();
		int id = Integer.parseInt(idStr);
		Artist newUser = new Artist();
		newObj.deleteUsers(newUser, id);

		ArtistService user = new ArtistService();
		List<Artist> allUsers = user.getAllUsers();

		ObservableList<Artist> listOffUsers = FXCollections.observableArrayList(new ArrayList<Artist>(allUsers));
		artistCol1.setCellValueFactory(new PropertyValueFactory<Artist, Integer>("artistid"));
		artistCol2.setCellValueFactory(new PropertyValueFactory<Artist, String>("name"));
		artistTable.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

	@FXML
	void artistUpdate(ActionEvent event) {
		try {
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/ArtistUpdateView.fxml"));
			root = loader.load();
			ControllerArtistUpdate controllerArtistUpdate = loader.getController();
			controllerArtistUpdate.displayArtistInfo(txtIdHidd, txtNumeHidd);
			Stage newStage = new Stage();
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void managementArtist(ActionEvent event) {

		currentMan.setText("Artist Management");

		// tabelele nefolosite se ascund. se face vizibil cel utilizat.
		userTabel.setVisible(false);
		publisherTable.setVisible(false);
		gameTabel.setVisible(false);
		designerTable.setVisible(false);
		artistTable.setVisible(true);

		// se fac vizibile doar butoanele folosite. restul se fac invizibile.
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

		ArtistService newUser = new ArtistService();
		List<Artist> allUsers = newUser.getAllUsers();

		ObservableList<Artist> listOffUsers = FXCollections.observableArrayList(new ArrayList<Artist>(allUsers));
		artistCol1.setCellValueFactory(new PropertyValueFactory<Artist, Integer>("artistid"));
		artistCol2.setCellValueFactory(new PropertyValueFactory<Artist, String>("name"));
		artistTable.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

	////Designer

	@FXML
	void transferDateDesigner(MouseEvent event) {

		TablePosition pos = designerTable.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();

		txtIdHidd.setText(Integer.toString(designerCol1.getCellData(pos.getRow())));
		txtNumeHidd.setText(designerCol2.getCellData(pos.getRow()));

	}

	@FXML
	void designerAdd(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/NewDesignerView.fxml"));
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

		DesignerService newObj = new DesignerService();
		String idStr = txtIdHidd.getText();
		int id = Integer.parseInt(idStr);
		Designer newUser = new Designer();
		newObj.deleteUsers(newUser, id);

		DesignerService User = new DesignerService();
		List<Designer> allUsers = User.getAllUsers();

		ObservableList<Designer> listOffUsers = FXCollections.observableArrayList(new ArrayList<Designer>(allUsers));
		designerCol1.setCellValueFactory(new PropertyValueFactory<Designer, Integer>("designerid"));
		designerCol2.setCellValueFactory(new PropertyValueFactory<Designer, String>("name"));
		designerTable.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

	@FXML
	void designerUpdate(ActionEvent event) {

		try {
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/DesignerUpdateView.fxml"));
			root = loader.load();
			ControllerDesignerUpdate controllerDesignerUpdate = loader.getController();
			controllerDesignerUpdate.displayDesignerInfo(txtIdHidd, txtNumeHidd);
			Stage newStage = new Stage();
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void managementDesigner(ActionEvent event) {

		currentMan.setText("Designer Management");

		// tabelele nefolosite se ascund. se face vizibil cel utilizat.
		userTabel.setVisible(false);
		publisherTable.setVisible(false);
		gameTabel.setVisible(false);
		designerTable.setVisible(true);
		artistTable.setVisible(false);

		// se fac vizibile doar butoanele folosite. restul se fac invizibile.
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

		DesignerService newUser = new DesignerService();
		List<Designer> allUsers = newUser.getAllUsers();

		ObservableList<Designer> listOffUsers = FXCollections.observableArrayList(new ArrayList<Designer>(allUsers));
		designerCol1.setCellValueFactory(new PropertyValueFactory<Designer, Integer>("designerid"));
		designerCol2.setCellValueFactory(new PropertyValueFactory<Designer, String>("name"));
		designerTable.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

	////Game ////Game

	@FXML
	void transferDateGame(MouseEvent event) {

		TablePosition pos = gameTabel.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();

		txtGdescriereHidd.setText(gameCol9.getCellData(pos.getRow()));
		txtGidHidd.setText(Integer.toString(gameCol1.getCellData(pos.getRow())));
		txtGnumeHidd.setText(gameCol2.getCellData(pos.getRow()));
		txtGplayerHidd.setText(gameCol8.getCellData(pos.getRow()));
		txtGpretHidd.setText(Integer.toString(gameCol6.getCellData(pos.getRow())));
		txtGstocHidd.setText(Integer.toString(gameCol7.getCellData(pos.getRow())));
		txtAnumeHidd.setText(Integer.toString(gameCol4.getCellData(pos.getRow())));
		txtDnumeHidd.setText(Integer.toString(gameCol5.getCellData(pos.getRow())));
		txtPnumeHidd.setText(Integer.toString(gameCol3.getCellData(pos.getRow())));

	}

	@FXML
	void gameAdd(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/NewGameView.fxml"));
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
	void gameRemove(ActionEvent event) {

		GameService newObj = new GameService();
		String idStr = txtGidHidd.getText();
		int id = Integer.parseInt(idStr);
		Game newUser = new Game();
		newObj.deleteUsers(newUser, id);

	}

	@FXML
	void gameUpdate(ActionEvent event) {
		try {
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/GameUpdateView.fxml"));
			root = loader.load();
			ControllerGameUpdate controllerGameUpdate = loader.getController();
			controllerGameUpdate.displayGameInfo(txtGidHidd, txtGnumeHidd, txtPnumeHidd, txtAnumeHidd, txtDnumeHidd, txtGplayerHidd, txtGpretHidd, txtGstocHidd, txtGdescriereHidd);
			Stage newStage = new Stage();
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@FXML
	void managementGame(ActionEvent event) {

		currentMan.setText("Game Management");

		// tabelele nefolosite se ascund. se face vizibil cel utilizat.
		userTabel.setVisible(false);
		publisherTable.setVisible(false);
		gameTabel.setVisible(true);
		designerTable.setVisible(false);
		artistTable.setVisible(false);

		// se fac vizibile doar butoanele folosite. restul se fac invizibile.
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

		GameService newGame = new GameService();
		List<Game> allGames = newGame.getAllGames();

		ObservableList<Game> listOffGames = FXCollections.observableArrayList(new ArrayList<Game>(allGames));
		gameCol1.setCellValueFactory(new PropertyValueFactory<Game, Integer>("gameid"));
		gameCol2.setCellValueFactory(new PropertyValueFactory<Game, String>("gamename"));
		gameCol3.setCellValueFactory(new PropertyValueFactory<Game, Integer>("publisherid"));
		gameCol4.setCellValueFactory(new PropertyValueFactory<Game, Integer>("artistid"));
		gameCol5.setCellValueFactory(new PropertyValueFactory<Game, Integer>("designerid"));
		gameCol6.setCellValueFactory(new PropertyValueFactory<Game, Integer>("pret"));
		gameCol7.setCellValueFactory(new PropertyValueFactory<Game, Integer>("stoc"));
		gameCol8.setCellValueFactory(new PropertyValueFactory<Game, String>("players"));
		gameCol9.setCellValueFactory(new PropertyValueFactory<Game, String>("description"));
		gameTabel.setItems(listOffGames);
		System.out.println(listOffGames);

	}

	////Publisher
	
	//// Publisher

	@FXML
	void transferDatePublisher(MouseEvent event) {

		TablePosition pos = publisherTable.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();

		txtIdHidd.setText(Integer.toString(publisherCol1.getCellData(pos.getRow())));
		txtNumeHidd.setText(publisherCol2.getCellData(pos.getRow()));

	}

@FXML
	void publisherAdd(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/NewPublisherView.fxml"));
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
	void publisherRemove(ActionEvent event) {

		PublisherService newObj = new PublisherService();
		String idStr = txtIdHidd.getText();
		int id = Integer.parseInt(idStr);
		Publisher newUser = new Publisher();
		newObj.deleteUsers(newUser, id);

		PublisherService User = new PublisherService();
		List<Publisher> allUsers = User.getAllUsers();

		ObservableList<Publisher> listOffUsers = FXCollections.observableArrayList(new ArrayList<Publisher>(allUsers));
		publisherCol1.setCellValueFactory(new PropertyValueFactory<Publisher, Integer>("publisherid"));
		publisherCol2.setCellValueFactory(new PropertyValueFactory<Publisher, String>("publishername"));
		publisherTable.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

	@FXML
	void publisherUpdate(ActionEvent event) {
		try {
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/PublisherUpdateView.fxml"));
			root = loader.load();
			ControllerPublisherUpdate controllerPublisherUpdate = loader.getController();
			controllerPublisherUpdate.displayPublisherInfo(txtIdHidd, txtNumeHidd);
			Stage newStage = new Stage();
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void managementPublisher(ActionEvent event) {

		currentMan.setText("Publisher Management");

		// tabelele nefolosite se ascund. se face vizibil cel utilizat.
		userTabel.setVisible(false);
		publisherTable.setVisible(true);
		gameTabel.setVisible(false);
		designerTable.setVisible(false);
		artistTable.setVisible(false);

		// se fac vizibile doar butoanele folosite. restul se fac invizibile.
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

		PublisherService newUser = new PublisherService();
		List<Publisher> allUsers = newUser.getAllUsers();

		ObservableList<Publisher> listOffUsers = FXCollections.observableArrayList(new ArrayList<Publisher>(allUsers));
		publisherCol1.setCellValueFactory(new PropertyValueFactory<Publisher, Integer>("publisherid"));
		publisherCol2.setCellValueFactory(new PropertyValueFactory<Publisher, String>("publishername"));
		publisherTable.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

	//// User

	@FXML
	void userAdd(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/NewUserAdminAddView.fxml"));
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

		UserService newObj = new UserService();
		String idStr = txtIdHidd.getText();
		int id = Integer.parseInt(idStr);
		User newUser = new User();
		newObj.deleteUsers(newUser, id);

		UserService newList = new UserService();
		List<User> allUsers = newList.getAllUsers();

		ObservableList<User> listOffUsers = FXCollections.observableArrayList(new ArrayList<User>(allUsers));
		userCol1.setCellValueFactory(new PropertyValueFactory<User, Integer>("uid"));
		userCol2.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		userCol3.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
		userCol4.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		userCol6.setCellValueFactory(new PropertyValueFactory<User, String>("function"));
		userCol5.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
		userTabel.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

	@FXML
	void userUpdate(ActionEvent event) {

		try {
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resourceView/UserUpdateView.fxml"));
			root = loader.load();
			ControllerUserUpdate controllerUserUpdate = loader.getController();
			controllerUserUpdate.displayUserInfo(txtIdHidd, txtUnumeHidd, txtNumeHidd, txtPassHidd, txtEmailHidd,
					txtAdminHidd);
			Stage newStage = new Stage();
			newStage.setScene(new Scene(root));
			newStage.setResizable(false);
			newStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void transferDateUser(MouseEvent event) {

		TablePosition pos = userTabel.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();

		txtAdminHidd.setText(userCol6.getCellData(pos.getRow()));
		txtEmailHidd.setText(userCol4.getCellData(pos.getRow()));
		txtIdHidd.setText(Integer.toString(userCol1.getCellData(pos.getRow())));
		txtNumeHidd.setText(userCol2.getCellData(pos.getRow()));
		txtPassHidd.setText(userCol5.getCellData(pos.getRow()));
		txtUnumeHidd.setText(userCol3.getCellData(pos.getRow()));

	}

	@FXML
	void managementUser(ActionEvent event) {

		currentMan.setText("User Management");

		// tabelele nefolosite se ascund. se face vizibil cel utilizat.
		userTabel.setVisible(true);
		publisherTable.setVisible(false);
		gameTabel.setVisible(false);
		designerTable.setVisible(false);
		artistTable.setVisible(false);

		// se fac vizibile doar butoanele folosite. restul se fac invizibile.
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

		UserService newUser = new UserService();
		List<User> allUsers = newUser.getAllUsers();

		ObservableList<User> listOffUsers = FXCollections.observableArrayList(new ArrayList<User>(allUsers));
		userCol1.setCellValueFactory(new PropertyValueFactory<User, Integer>("uid"));
		userCol2.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		userCol3.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
		userCol4.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		userCol6.setCellValueFactory(new PropertyValueFactory<User, String>("function"));
		userCol5.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
		userTabel.setItems(listOffUsers);
		System.out.println(listOffUsers);

	}

}

