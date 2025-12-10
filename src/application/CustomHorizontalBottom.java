package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomHorizontalBottom extends HBox {

    public CustomHorizontalBottom(Button submitButton) {
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        setStyle(
            "-fx-border-color: black; " +
            "-fx-border-width: 2 0 0 0; " +
            "-fx-background-color: transparent;"
        );

        Label disclaimer = new Label(
            "By submitting this application, you agree to adhere to company policies\n" +
            "and provide accurate information throughout the employment process."
        );
        disclaimer.setWrapText(true);

        VBox rightBox = new VBox(5, submitButton);

        getChildren().addAll(disclaimer, rightBox);
    }
}
