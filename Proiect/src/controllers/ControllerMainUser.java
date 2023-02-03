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
import model.Game;
import service.GameService;

public class ControllerMainUser {

	@FXML
	private Button btnAdaugaCos;

	@FXML
	private Button btnRefreshCos;

	@FXML
	private Button btnSearch;

	@FXML
	private Button userlogout;

	@FXML
	private TableColumn<Game, String> displayDescriere;

	@FXML
	private TableColumn<Game, String> displayName;

	@FXML
	private TableColumn<Game, Integer> displayPret;

	@FXML
	private TableColumn<Game, Integer> displayStoc;

	@FXML
	private TableView<Game> gameTable;

	@FXML
	private TextField textSearch;

	@FXML
	private TextField txtJoc;

	@FXML
	private TextField txtPret;

	@FXML
	private Text txtuserColt;

	@FXML
	private TableColumn<Game, Integer> pretProdusCOs;

	@FXML
	private TableColumn<Game, String> produsCos;

	@FXML
	private TableView<Game> tabelCos;

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

	public void displayUserInfo(TextField txtuname) {
		String userNameInfo = txtuname.getText();
		txtuserColt.setText(userNameInfo);
	}

	@FXML
	void cumpara(ActionEvent event) {

	}

	@FXML
	void getDetalii(MouseEvent event) {

		TablePosition pos = gameTable.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		txtJoc.setText(displayName.getCellData(pos.getRow()));
		txtPret.setText(Integer.toString(displayPret.getCellData(pos.getRow())));

	}

	@FXML
	void Search(ActionEvent event) throws Exception {

		String searchName = textSearch.getText();

		if (searchName.equals("")) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/WrongSearchView.fxml"));
				Parent root = (Parent) fxmlLoader.load();
				Stage newStage = new Stage();
				newStage.setScene(new Scene(root));
				newStage.setResizable(false);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			GameService userService = new GameService();
			Game user = new Game();
			user = userService.findGame(searchName);

			if (user == null) {
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resourceView/NotFoundView.fxml"));
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

				GameService newGame = new GameService();
				List<Game> allGames = newGame.getGame(searchName);

				ObservableList<Game> listOffGames = FXCollections.observableArrayList(new ArrayList<Game>(allGames));
				displayName.setCellValueFactory(new PropertyValueFactory<Game, String>("gamename"));
				displayPret.setCellValueFactory(new PropertyValueFactory<Game, Integer>("pret"));
				displayStoc.setCellValueFactory(new PropertyValueFactory<Game, Integer>("stoc"));
				displayDescriere.setCellValueFactory(new PropertyValueFactory<Game, String>("descriere"));
				gameTable.setItems(listOffGames);

			}

		}

	}

}
