import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Initial window of the application.
 *
 * <p>The view reserves space for the trip-creation and stop-editing areas.
 * Those areas are placeholders for now; no trip data is collected or passed
 * to the domain layer.</p>
 */
public class HomeView extends StackPane {

    private static final String FONT_FAMILY = "Segoe UI";
    private static final String COLOR_INK = "#102a43";
    private static final String COLOR_MUTED = "#627d98";
    private static final String COLOR_ACCENT = "#2563eb";
    private static final String COLOR_FAINT = "#8aa0b4";

    private static final String CARD_STYLE =
            "-fx-background-color: rgba(255,255,255,0.94);"
                    + "-fx-background-radius: 20;"
                    + "-fx-border-color: rgba(148,163,184,0.28);"
                    + "-fx-border-radius: 20;"
                    + "-fx-effect: dropshadow(gaussian, rgba(15,42,71,0.12), 30, 0.08, 0, 12);";

    public HomeView() {
        setStyle("-fx-background-color: linear-gradient(to bottom right, "
                + "#f9fcff 0%, #eef5fc 55%, #e6f0fb 100%);");

        Region topGlow = createGlow(440, "rgba(56,189,248,0.24)");
        StackPane.setAlignment(topGlow, Pos.TOP_RIGHT);
        topGlow.setTranslateX(175);
        topGlow.setTranslateY(-210);

        Region bottomGlow = createGlow(360, "rgba(37,99,235,0.14)");
        StackPane.setAlignment(bottomGlow, Pos.BOTTOM_LEFT);
        bottomGlow.setTranslateX(-150);
        bottomGlow.setTranslateY(170);

        BorderPane shell = new BorderPane();
        shell.setPadding(new Insets(26, 36, 20, 36));

        VBox header = createHeader();
        VBox content = createContent();
        HBox footer = createFooter();

        shell.setTop(header);
        shell.setCenter(content);
        shell.setBottom(footer);

        BorderPane.setMargin(content, new Insets(22, 0, 18, 0));
        BorderPane.setMargin(footer, new Insets(14, 2, 0, 2));

        getChildren().addAll(topGlow, bottomGlow, shell);
    }

    private Region createGlow(double size, String color) {
        Region glow = new Region();
        glow.setPrefSize(size, size);
        glow.setMinSize(size, size);
        glow.setMaxSize(size, size);
        glow.setMouseTransparent(true);
        glow.setStyle("-fx-background-radius: 50%;"
                + "-fx-background-color: radial-gradient(center 50% 50%, radius 50%, "
                + color + ", rgba(255,255,255,0));");
        return glow;
    }

    private VBox createHeader() {
        StackPane mark = new StackPane();
        mark.setMinSize(46, 46);
        mark.setPrefSize(46, 46);
        mark.setMaxSize(46, 46);
        mark.setStyle("-fx-background-color: linear-gradient(to bottom right, #0ea5e9, #2563eb);"
                + "-fx-background-radius: 14;"
                + "-fx-effect: dropshadow(gaussian, rgba(37,99,235,0.30), 16, 0.10, 0, 5);");

        Label markLetter = new Label("W");
        markLetter.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 24));
        markLetter.setStyle("-fx-text-fill: white;");
        mark.getChildren().add(markLetter);

        Label appName = new Label("Weather On The Way");
        appName.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 19));
        appName.setStyle("-fx-text-fill: " + COLOR_INK + ";");

        Label tagline = new Label("Route-aware weather planning");
        tagline.setFont(Font.font(FONT_FAMILY, 12));
        tagline.setStyle("-fx-text-fill: " + COLOR_MUTED + ";");

        VBox brandText = new VBox(1, appName, tagline);
        brandText.setAlignment(Pos.CENTER_LEFT);

        HBox brand = new HBox(12, mark, brandText);
        brand.setAlignment(Pos.CENTER_LEFT);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox status = createStatusBadge();

        HBox headerRow = new HBox(16, brand, spacer, status);
        headerRow.setAlignment(Pos.CENTER_LEFT);

        Region divider = new Region();
        divider.setPrefHeight(1);
        divider.setStyle("-fx-background-color: rgba(16,42,67,0.08);");

        VBox header = new VBox(18, headerRow, divider);
        return header;
    }

    private HBox createStatusBadge() {
        Region dot = new Region();
        dot.setMinSize(6, 6);
        dot.setPrefSize(6, 6);
        dot.setMaxSize(6, 6);
        dot.setStyle("-fx-background-color: #38bdf8; -fx-background-radius: 50%;");

        Label text = new Label("EARLY PREVIEW");
        text.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 10));
        text.setStyle("-fx-text-fill: " + COLOR_ACCENT + ";");

        HBox badge = new HBox(7, dot, text);
        badge.setAlignment(Pos.CENTER);
        badge.setPadding(new Insets(6, 12, 6, 12));
        badge.setStyle("-fx-background-color: rgba(37,99,235,0.08);"
                + "-fx-background-radius: 999;"
                + "-fx-border-color: rgba(37,99,235,0.14);"
                + "-fx-border-radius: 999;");
        return badge;
    }

    private VBox createContent() {
        VBox hero = createHero();
        GridPane workspace = createWorkspace();

        VBox content = new VBox(22, hero, workspace);
        VBox.setVgrow(workspace, Priority.ALWAYS);
        return content;
    }

    private VBox createHero() {
        Region accentLine = new Region();
        accentLine.setMinSize(24, 3);
        accentLine.setPrefSize(24, 3);
        accentLine.setMaxSize(24, 3);
        accentLine.setStyle("-fx-background-color: linear-gradient(to right, #0ea5e9, #2563eb);"
                + "-fx-background-radius: 2;");

        Label eyebrow = new Label("TRIP PLANNING WORKSPACE");
        eyebrow.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 10));
        eyebrow.setStyle("-fx-text-fill: " + COLOR_ACCENT + ";");

        HBox eyebrowRow = new HBox(9, accentLine, eyebrow);
        eyebrowRow.setAlignment(Pos.CENTER_LEFT);

        Label headline = new Label("Plan the route. Know the weather.");
        headline.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 34));
        headline.setStyle("-fx-text-fill: " + COLOR_INK + ";");
        headline.setWrapText(true);
        headline.setMaxWidth(780);

        Label supporting = new Label(
                "Set up a trip, arrange intermediate stops, and see the forecast "
                        + "for every leg of the journey.");
        supporting.setFont(Font.font(FONT_FAMILY, 14));
        supporting.setStyle("-fx-text-fill: " + COLOR_MUTED + ";");
        supporting.setWrapText(true);
        supporting.setMaxWidth(680);

        HBox chips = new HBox(8,
                createChip("Route planning"),
                createChip("Intermediate stops"),
                createChip("Weather outlook"));

        VBox hero = new VBox(10, eyebrowRow, headline, supporting, chips);
        hero.setAlignment(Pos.TOP_LEFT);
        return hero;
    }

    private Label createChip(String text) {
        Label chip = new Label(text);
        chip.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 10));
        chip.setPadding(new Insets(5, 10, 5, 10));
        chip.setStyle("-fx-background-color: rgba(255,255,255,0.70);"
                + "-fx-background-radius: 999;"
                + "-fx-border-color: rgba(37,99,235,0.14);"
                + "-fx-border-radius: 999;"
                + "-fx-text-fill: #3f6f96;");
        return chip;
    }

    private GridPane createWorkspace() {
        VBox tripCard = createTripCard();
        VBox stopsCard = createStopsCard();

        ColumnConstraints left = new ColumnConstraints();
        left.setPercentWidth(54);
        left.setHgrow(Priority.ALWAYS);

        ColumnConstraints right = new ColumnConstraints();
        right.setPercentWidth(46);
        right.setHgrow(Priority.ALWAYS);

        GridPane workspace = new GridPane();
        workspace.setHgap(18);
        workspace.getColumnConstraints().addAll(left, right);
        workspace.add(tripCard, 0, 0);
        workspace.add(stopsCard, 1, 0);
        workspace.setMaxWidth(Double.MAX_VALUE);

        GridPane.setHgrow(tripCard, Priority.ALWAYS);
        GridPane.setVgrow(tripCard, Priority.ALWAYS);
        GridPane.setHgrow(stopsCard, Priority.ALWAYS);
        GridPane.setVgrow(stopsCard, Priority.ALWAYS);
        return workspace;
    }

    private VBox createTripCard() {
        VBox card = createCard();
        HBox header = createCardHeader(
                "01",
                "Trip Creation",
                "Start with the trip essentials. The full form will live here.");

        VBox fields = new VBox(9,
                createFieldRow("Trip name"),
                createFieldRow("Start city"),
                createFieldRow("Destination"),
                createFieldRow("Travel details"));

        Label note = createCardNote("Placeholder - form controls are not wired yet.");
        VBox.setVgrow(fields, Priority.ALWAYS);

        card.getChildren().addAll(header, fields, note);
        return card;
    }

    private VBox createStopsCard() {
        VBox card = createCard();
        HBox header = createCardHeader(
                "02",
                "Stops",
                "Intermediate cities will be added and reordered here.");

        VBox route = new VBox(9,
                createStopRow("1"),
                createStopRow("2"),
                createStopRow("3"));

        Label addStop = new Label("Add-stop control coming next");
        addStop.setMaxWidth(Double.MAX_VALUE);
        addStop.setAlignment(Pos.CENTER);
        addStop.setPadding(new Insets(8, 10, 8, 10));
        addStop.setFont(Font.font(FONT_FAMILY, 11));
        addStop.setStyle("-fx-text-fill: " + COLOR_FAINT + ";"
                + "-fx-background-color: rgba(244,248,252,0.85);"
                + "-fx-background-radius: 10;"
                + "-fx-border-color: #c5d9ec;"
                + "-fx-border-radius: 10;"
                + "-fx-border-style: dashed;");

        Label note = createCardNote("Placeholder - the stop list is not editable yet.");
        VBox.setVgrow(route, Priority.ALWAYS);

        card.getChildren().addAll(header, route, addStop, note);
        return card;
    }

    private VBox createCard() {
        VBox card = new VBox(18);
        card.setPadding(new Insets(22));
        card.setMaxWidth(Double.MAX_VALUE);
        card.setMaxHeight(Double.MAX_VALUE);
        card.setStyle(CARD_STYLE);
        return card;
    }

    private HBox createCardHeader(String step, String title, String description) {
        StackPane stepBadge = new StackPane();
        stepBadge.setMinSize(32, 32);
        stepBadge.setPrefSize(32, 32);
        stepBadge.setMaxSize(32, 32);
        stepBadge.setStyle("-fx-background-color: linear-gradient(to bottom right, #e0f2fe, #dbeafe);"
                + "-fx-background-radius: 10;"
                + "-fx-border-color: rgba(37,99,235,0.10);"
                + "-fx-border-radius: 10;");

        Label stepText = new Label(step);
        stepText.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 11));
        stepText.setStyle("-fx-text-fill: " + COLOR_ACCENT + ";");
        stepBadge.getChildren().add(stepText);

        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 17));
        titleLabel.setStyle("-fx-text-fill: " + COLOR_INK + ";");

        Label descriptionLabel = new Label(description);
        descriptionLabel.setFont(Font.font(FONT_FAMILY, 11));
        descriptionLabel.setStyle("-fx-text-fill: " + COLOR_MUTED + ";");
        descriptionLabel.setWrapText(true);

        VBox text = new VBox(2, titleLabel, descriptionLabel);
        HBox header = new HBox(11, stepBadge, text);
        header.setAlignment(Pos.TOP_LEFT);
        return header;
    }

    private HBox createFieldRow(String labelText) {
        Label label = new Label(labelText);
        label.setFont(Font.font(FONT_FAMILY, 11));
        label.setStyle("-fx-text-fill: " + COLOR_MUTED + ";");
        label.setMinWidth(102);
        label.setPrefWidth(102);

        Region field = new Region();
        field.setPrefHeight(34);
        field.setMaxWidth(Double.MAX_VALUE);
        field.setStyle("-fx-background-color: #f4f8fc;"
                + "-fx-background-radius: 10;"
                + "-fx-border-color: #e3edf6;"
                + "-fx-border-radius: 10;");
        HBox.setHgrow(field, Priority.ALWAYS);

        HBox row = new HBox(12, label, field);
        row.setAlignment(Pos.CENTER_LEFT);
        return row;
    }

    private HBox createStopRow(String number) {
        StackPane dot = new StackPane();
        dot.setMinSize(24, 24);
        dot.setPrefSize(24, 24);
        dot.setMaxSize(24, 24);
        dot.setStyle("-fx-background-color: #eef6fd;"
                + "-fx-background-radius: 50%;"
                + "-fx-border-color: #cfe3f5;"
                + "-fx-border-radius: 50%;");

        Label dotText = new Label(number);
        dotText.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 10));
        dotText.setStyle("-fx-text-fill: " + COLOR_ACCENT + ";");
        dot.getChildren().add(dotText);

        Region line = new Region();
        line.setPrefHeight(2);
        line.setMaxWidth(Double.MAX_VALUE);
        line.setStyle("-fx-background-color: #e8f1f9; -fx-background-radius: 2;");
        HBox.setHgrow(line, Priority.ALWAYS);

        HBox row = new HBox(11, dot, line);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(4, 0, 4, 0));
        return row;
    }

    private Label createCardNote(String text) {
        Label note = new Label(text);
        note.setFont(Font.font(FONT_FAMILY, 10));
        note.setStyle("-fx-text-fill: " + COLOR_FAINT + ";");
        return note;
    }

    private HBox createFooter() {
        Label left = new Label("Weather On The Way - CS 2043 Group 4");
        left.setFont(Font.font(FONT_FAMILY, 10));
        left.setStyle("-fx-text-fill: " + COLOR_FAINT + ";");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label right = new Label("JavaFX - BlueJ compatible");
        right.setFont(Font.font(FONT_FAMILY, 10));
        right.setStyle("-fx-text-fill: " + COLOR_FAINT + ";");

        HBox footer = new HBox(10, left, spacer, right);
        footer.setAlignment(Pos.CENTER_LEFT);
        return footer;
    }
}
