module gui {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.swing;
	requires org.junit.jupiter.api;
	opens gui to javafx.graphics, javafx.fxml;
	opens main to javafx.graphics, javafx.fxml;
	opens testen to org.junit.jupiter.api, javafx.swing;
}