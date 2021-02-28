package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SplashScreenController implements Initializable {

	@FXML
    private Label progress;
	
	public static Label label;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		label = progress;
	}
}
