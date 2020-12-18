package gui;

import domein.DomeinController;
import domein.Observer;
import domein.Soort;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DetailPanelController extends AnchorPane implements Observer {

    @FXML
    private TextField txtStageId;

    @FXML
    private TextField txtBedrijfId;

    private final DomeinController domeinController;

    public DetailPanelController(DomeinController domeinController) {

        this.domeinController = domeinController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Voor JUnit
    public String getStageId() {
        return txtStageId.getText();
    }

    public String getBedrijfId() {
        return txtBedrijfId.getText();
    }

	@Override
	public void update(Soort soort) {
		switch (soort) {
			case BEDRIJF -> txtBedrijfId.setText(domeinController.getBedrijfId());
			case STAGE -> txtStageId.setText(domeinController.getStageId());
		}
		
	}
}
