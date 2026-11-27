import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX application shell for Weather On The Way.
 *
 * <p>This class only builds the initial window. Trip creation and stop
 * editing are not wired yet. When the domain classes are available, a single
 * Coordinator instance will be created here and passed to the UI views.</p>
 */
public class WeatherOnTheWayApp extends Application {

    private static final String APP_TITLE = "Weather On The Way";
    private static final int WINDOW_WIDTH = 1040;
    private static final int WINDOW_HEIGHT = 720;
    private static final int MIN_WIDTH = 880;
    private static final int MIN_HEIGHT = 660;

    @Override
    public void start(Stage stage) {
        HomeView homeView = new HomeView();
        Scene scene = new Scene(homeView, WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setTitle(APP_TITLE);
        stage.setScene(scene);
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);
        stage.show();
    }
}
