package gui;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import domain.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AccountTextViewPanelController extends HBox implements Observer {

    @FXML
    private TextField txtBalance;

    // NumberFormat for US dollars
    private NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public AccountTextViewPanelController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountTextViewPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

	@Override
	public void update(double balance) {
		txtBalance.setText(moneyFormat.format(balance));
	}
}
