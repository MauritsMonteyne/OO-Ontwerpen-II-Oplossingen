package gui;

import domein.DomeinController;
import domein.Soort;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class BedrijfStageFrameController extends HBox {

    private final DomeinController domeinController;

    private final FormPanelController formPanel;
    private final DetailPanelController detailPanel;

    public BedrijfStageFrameController(DomeinController domeinController) {

        this.domeinController = domeinController;

        formPanel = new FormPanelController(domeinController);
        detailPanel = new DetailPanelController(domeinController);
        
        // Add observers
        domeinController.addObserver(Soort.BEDRIJF, detailPanel);
        domeinController.addObserver(Soort.STAGE, detailPanel);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BedrijfStageFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        getChildren().addAll(formPanel, detailPanel);
    }

}
