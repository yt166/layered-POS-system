import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Home Page");
        stage.setResizable(false);
        stage.show();
    }
}
