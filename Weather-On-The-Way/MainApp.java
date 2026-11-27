import javafx.application.Application;

/**
 * BlueJ-friendly launcher for the JavaFX application.
 *
 * <p>The launcher is kept separate from the class that extends
 * {@link Application}. This is the standard non-modular JavaFX setup and lets
 * BlueJ start the project by running {@code MainApp.main(String[])}.</p>
 */
public final class MainApp {

    private MainApp() {
        // Utility class: only the static entry point is used.
    }

    public static void main(String[] args) {
        Application.launch(WeatherOnTheWayApp.class, args);
    }
}
