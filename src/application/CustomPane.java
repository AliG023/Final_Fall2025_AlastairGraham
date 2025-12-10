package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class CustomPane extends StackPane {

    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: black");
        setPadding(new Insets(12));
        setAlignment(Pos.CENTER);

    }

    public static BorderPane createEmploymentFormLayout() {
        BorderPane pane = new BorderPane();

        pane.setTop(new CustomHorizontalTop());

        GridPane employmentForm = new GridPane();
        pane.setCenter(employmentForm);

        return pane;
    }
}