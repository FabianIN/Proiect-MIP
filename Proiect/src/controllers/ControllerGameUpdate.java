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
import model.Game;
import service.GameService;

public class ControllerGameUpdate {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtartist;

    @FXML
    private TextField txtdescriere;

    @FXML
    private TextField txtdesigner;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtnume;

    @FXML
    private TextField txtplayers;

    @FXML
    private TextField txtpret;

    @FXML
    private TextField txtpublisher;

    @FXML
    private TextField txtstoc;

	public void displayGameInfo(TextField txtGidHidd, TextField txtGnumeHidd, TextField txtPnumeHidd,
		TextField txtAnumeHidd, TextField txtDnumeHidd, TextField txtGplayerHidd,TextField txtGpretHidd, TextField txtGstocHidd,TextField txtGdescriereHidd) {
		String idInfo = txtGidHidd.getText();
		txtid.setText(idInfo);
		String numeInfo = txtGnumeHidd.getText();
		txtnume.setText(numeInfo);
		String publisherInfo = txtPnumeHidd.getText();
		txtpublisher.setText(publisherInfo);
		String artistInfo = txtAnumeHidd.getText();
		txtartist.setText(artistInfo);
		String designerInfo = txtDnumeHidd.getText();
		txtdesigner.setText(designerInfo);
		String playerInfo = txtGplayerHidd.getText();
		txtplayers.setText(playerInfo);
		String stocInfo = txtGstocHidd.getText();
		txtstoc.setText(stocInfo);
		String pretInfo = txtGpretHidd.getText();
		txtpret.setText(pretInfo);
		String descriereInfo = txtGdescriereHidd.getText();
		txtdescriere.setText(descriereInfo);
	}

	@FXML
	void update(ActionEvent event) {

		GameService gameService = new GameService();

		String idStr = txtid.getText();
		int id = Integer.parseInt(idStr);

		Game newObj = gameService.find(id);
		System.out.println(newObj);

		String name = txtnume.getText();
		int publisher = Integer.parseInt(txtpublisher.getText());
		int designer = Integer.parseInt(txtdesigner.getText());
		int artist = Integer.parseInt(txtartist.getText());
		int pret = Integer.parseInt(txtpret.getText());
		String descriere = txtdescriere.getText();
		int stoc = Integer.parseInt(txtstoc.getText());
		String players = txtplayers.getText();

		newObj.setGamename(name);
		newObj.setArtistid(artist);
		newObj.setDesignerid(designer);
		newObj.setPublisherid(publisher);
		newObj.setStoc(stoc);
		newObj.setPret(pret);
		newObj.setPlayers(players);
		newObj.setDescription(descriere);
		
		try {
			gameService.updateUser(newObj);
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

		txtnume.setText("");
		txtpublisher.setText("");
		txtdesigner.setText("");
		txtartist.setText("");
		txtpret.setText("");
		txtdescriere.setText("");
		txtstoc.setText("");
		txtplayers.setText("");

	}

}
