package application;

import com.sun.javafx.application.LauncherImpl;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	private static final int COUNT_LIMIT = 500000;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			
			JMetro jMetro = new JMetro(Style.LIGHT);
			jMetro.setScene(scene);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void init() throws Exception {
		super.init();
		
		for (int i = 0; i < COUNT_LIMIT; i++) {
			double progress = (100 * i) / COUNT_LIMIT;
			LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress)); // Not working on java 9 and above
		}
	}


	public static void main(String[] args) {
		System.out.println("aaa");
		System.setProperty("javafx.preloader", MyPreloader.class.getCanonicalName());
		launch(args);
	}
}
