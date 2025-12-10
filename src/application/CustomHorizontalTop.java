package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class CustomHorizontalTop extends HBox {

    public CustomHorizontalTop() {
        setSpacing(10);
        setPadding(new Insets(8));
        setAlignment(Pos.CENTER_LEFT);

        Image logoImage = new Image(
            getClass().getResourceAsStream("images/daily-grind-logo.png")
        );
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitHeight(100);
        logoView.setPreserveRatio(true);

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label title = new Label("Employment Application");
        title.setStyle(
            "-fx-font-size: 32px; -fx-font-weight: bold; " +
            "-fx-background-color: black; -fx-text-fill: white; " +
            "-fx-padding: 5 5 5 5;"
        );

        getChildren().addAll(logoView, spacer, title);
    }
}