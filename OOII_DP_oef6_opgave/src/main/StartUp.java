package main;

import domein.DomeinController;
import gui.BedrijfStageFrameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartUp extends Application {

    @Override
    public void start(Stage stage) {
        DomeinController domeinController = new DomeinController();
        Scene scene = new Scene(new BedrijfStageFrameController(domeinController), 600, 400);
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        
        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(StartUp.class, args);
    }
}
