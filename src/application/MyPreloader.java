package application;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreloader extends Preloader {

	private Stage preloaderStage;
	private Scene scene;

	public MyPreloader() {

	}

	@Override
	public void init() throws Exception {
		Parent root1 = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
		scene = new Scene(root1);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("In the Preloader Class...");
		
		this.preloaderStage = primaryStage;

		// Set preloader scene and show stage
		preloaderStage.setScene(scene);
		preloaderStage.initStyle(StageStyle.UNDECORATED);
		preloaderStage.show();
	}

	@Override
	public void handleApplicationNotification(PreloaderNotification info) {
		super.handleApplicationNotification(info);

		if (info instanceof ProgressNotification) {
			SplashScreenController.label.setText("Loading " + ((ProgressNotification) info).getProgress() + " %");
		}

	}

	@Override
	public void handleStateChangeNotification(StateChangeNotification info) {
		super.handleStateChangeNotification(info);

		StateChangeNotification.Type type = info.getType();

		switch (type) {
		case BEFORE_START:
			System.out.print("before...");
			// preloaderStage.hide();
			break;
		}
	}

}
