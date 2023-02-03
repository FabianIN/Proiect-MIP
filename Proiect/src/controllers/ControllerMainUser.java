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
import javafx.stage.Stage;
import model.Game;
import service.GameService;

public class ControllerMainUser {

	@FXML
	private Button btnSearch;

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
	private TextField txt1;

	@FXML
	private TextField txt2;

	@FXML
	private TextField txt3;

	@FXML
	void proba(MouseEvent event) {

		TablePosition pos = gameTable.getSelectionModel().getSelectedCells().get(0);
		int row = pos.getRow();
		txt1.setText(displayName.getCellData(pos.getRow()));
		txt2.setText(Integer.toString(displayPret.getCellData(pos.getRow())));
		txt3.setText(Integer.toString(displayStoc.getCellData(pos.getRow())));

	}

	@FXML
	void Search(ActionEvent event) throws Exception {

		String searchName = textSearch.getText();

		if (searchName.equals("")) {
			try {
				GameService newGame = new GameService();
				List<Game> allGames = newGame.getAllGames();

				ObservableList<Game> listOffGames = FXCollections.observableArrayList(new ArrayList<Game>(allGames));
				displayName.setCellValueFactory(new PropertyValueFactory<Game, String>("gamename"));
				displayPret.setCellValueFactory(new PropertyValueFactory<Game, Integer>("pret"));
				displayStoc.setCellValueFactory(new PropertyValueFactory<Game, Integer>("stoc"));
				gameTable.setItems(listOffGames);
				System.out.println(listOffGames);

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
			GameService newGame = new GameService();
			List<Game> sGame = (List<Game>) newGame.findGame(searchName);

			if (sGame == null) {
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
				ObservableList<Game> listOffGames = FXCollections.observableArrayList(new ArrayList<Game>(sGame));
				displayName.setCellValueFactory(new PropertyValueFactory<Game, String>("gamename"));
				displayPret.setCellValueFactory(new PropertyValueFactory<Game, Integer>("pret"));
				displayStoc.setCellValueFactory(new PropertyValueFactory<Game, Integer>("stoc"));
				gameTable.setItems(listOffGames);
				System.out.println(listOffGames);
			}

		}

	}

}