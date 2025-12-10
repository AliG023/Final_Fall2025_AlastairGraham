package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		BorderPane pane = new BorderPane();

		pane.setTop(new CustomHorizontalTop());
		pane.setCenter(new CustomPane("Center"));

		GridPane employmentForm = new GridPane();
		pane.setCenter(employmentForm);

		// Form Layout Settings ------------------------------
		employmentForm.setAlignment(Pos.CENTER);
		employmentForm.setHgap(10);
		employmentForm.setVgap(10);
		employmentForm.setPadding(new Insets(10));
		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
		col1.setPercentWidth(50);
		col2.setPercentWidth(50);
		col1.setHgrow(Priority.ALWAYS);
		col2.setHgrow(Priority.ALWAYS);
		employmentForm.getColumnConstraints().addAll(col1, col2);

		// Form Fields ---------------------------------------
		Label nameLabel = new Label("Personal Information");
		nameLabel.setStyle(
		    "-fx-font-size: 16px; -fx-font-weight: bold; " +
		    "-fx-background-color: black; -fx-text-fill: white; -fx-padding: 5 10 5 10;"
		);
		employmentForm.add(nameLabel, 0, 1, 2, 1);
		employmentForm.add(new Label("Full Name: "), 0, 2);
		TextField fullNameField = new TextField();
		employmentForm.add(fullNameField, 1, 2);
		employmentForm.add(new Label("Current Address: "), 0, 3);
		TextField currentAddressField = new TextField();
		employmentForm.add(currentAddressField, 1, 3);

		// Contact Row --------------------------------
		HBox contactBox = new HBox(20);
		contactBox.setAlignment(Pos.CENTER_LEFT);

		// Contact column
		Label contactLabel = new Label("Contact Number: ");
		TextField contactNumberField = new TextField();
		VBox contactContainer = new VBox(5);
		contactContainer.setAlignment(Pos.CENTER_LEFT);
		contactContainer.getChildren().addAll(contactLabel, contactNumberField);

		// Email column
		Label emailLabel = new Label("Email Address:");
		TextField emailField = new TextField();
		VBox emailContainer = new VBox(5);
		emailContainer.setAlignment(Pos.CENTER_LEFT);
		emailContainer.getChildren().addAll(emailLabel, emailField);

		HBox.setHgrow(contactContainer, Priority.ALWAYS);
		HBox.setHgrow(emailContainer, Priority.ALWAYS);

		contactBox.getChildren().addAll(contactContainer, emailContainer);
		employmentForm.add(contactBox, 0, 4, 2, 1);


		// Education & Gender Row --------------------
		HBox educationGenderBox = new HBox(20);
		educationGenderBox.setAlignment(Pos.CENTER_LEFT);


		Label educationLabel = new Label("Highest Education Attainment:");
		ComboBox<String> educationCombo = new ComboBox<>();
		educationCombo.getItems().addAll("Masters", "Bachelors", "College Diploma");

		VBox educationBox = new VBox(5);
		educationBox.setAlignment(Pos.CENTER_LEFT);
		educationBox.getChildren().addAll(educationLabel, educationCombo);


		Label genderLabel = new Label("Gender: ");

		HBox genderBox = new HBox(10);
		genderBox.setAlignment(Pos.CENTER_LEFT);
		ToggleGroup genderGroup = new ToggleGroup();
		RadioButton genderMale = new RadioButton("Male");
		genderMale.setToggleGroup(genderGroup);
		RadioButton genderFemale = new RadioButton("Female");
		genderFemale.setToggleGroup(genderGroup);
		genderFemale.setSelected(true);
		RadioButton genderOther = new RadioButton("Other");
		genderOther.setToggleGroup(genderGroup);
		genderBox.getChildren().addAll(genderMale, genderFemale, genderOther);

		VBox genderContainer = new VBox(5);
		genderContainer.setAlignment(Pos.CENTER_LEFT);
		genderContainer.getChildren().addAll(genderLabel, genderBox);


		HBox.setHgrow(educationBox, Priority.ALWAYS);
		HBox.setHgrow(genderContainer, Priority.ALWAYS);

		educationGenderBox.getChildren().addAll(educationBox, genderContainer);
		employmentForm.add(educationGenderBox, 0, 6, 2, 1);


		Label jobLabel = new Label("Employment Eligibility");
		jobLabel.setStyle(
		    "-fx-font-size: 16px; -fx-font-weight: bold; " +
		    "-fx-background-color: black; -fx-text-fill: white; -fx-padding: 5 10 5 10;"
		);
		employmentForm.add(jobLabel, 0, 8, 2, 1);

		HBox datePositionBox = new HBox(10);
		datePositionBox.setAlignment(Pos.CENTER_LEFT);

		Label dateLabel = new Label("Date Available:");
		DatePicker availablePicker = new DatePicker();
		availablePicker.setPromptText("mm/dd/yyyy");
		availablePicker.setValue(null);

		Label desiredPosLabel = new Label("Desired Position:");
		TextField positionField = new TextField();

		datePositionBox.getChildren().addAll(
		    dateLabel, availablePicker,
		    desiredPosLabel, positionField
		);

		employmentForm.add(datePositionBox, 0, 9, 2, 1);

		employmentForm.add(new Label("Desired Salary:"), 0, 10);
		TextField salaryField = new TextField();
		employmentForm.add(salaryField, 1, 10);
		employmentForm.add(new Label("Are you legally eligible to work in this country?"), 0, 11);

		// Legal Radio Buttons --------------------------------
		HBox legalBox = new HBox(10);
		legalBox.setAlignment(Pos.CENTER);
		ToggleGroup legalGroup = new ToggleGroup();
		RadioButton legalYes = new RadioButton("Yes");
		legalYes.setToggleGroup(legalGroup);
		RadioButton legalNo = new RadioButton("No");
		legalNo.setToggleGroup(legalGroup);
		legalNo.setSelected(true);
		employmentForm.add(legalYes, 0, 12);
		employmentForm.add(legalNo, 2, 12);

		legalBox.getChildren().addAll(legalYes, legalNo);
		employmentForm.add(legalBox, 0, 12);


		employmentForm.add(new Label("Do you have relatives working for out company?"), 0, 13);

		// Relavtives Radio Buttons --------------------------------
		HBox relativeBox = new HBox(10);
		relativeBox.setAlignment(Pos.CENTER);
		ToggleGroup relativeGroup = new ToggleGroup();
		RadioButton relativeYes = new RadioButton("Yes");
		relativeYes.setToggleGroup(relativeGroup);
		RadioButton relativeNo = new RadioButton("No");
		relativeNo.setToggleGroup(relativeGroup);
		relativeNo.setSelected(true);
		employmentForm.add(relativeYes, 0, 14);
		employmentForm.add(relativeNo, 2, 14);
		
		relativeBox.getChildren().addAll(relativeYes, relativeNo);
		employmentForm.add(relativeBox, 0, 14);


		employmentForm.add(new Label("If yes, please explain further:"), 0, 15);
		TextField relativeExplainField = new TextField();
		employmentForm.add(relativeExplainField, 1, 15);

		// Submit Button -------------------------------------
		Button submitButton = new Button("Submit Application");
		submitHandlerClass submitHandler = new submitHandlerClass(
			fullNameField, currentAddressField, contactNumberField, emailField,
			educationCombo, genderBox,
			availablePicker, positionField, salaryField,
			legalBox, relativeBox, relativeExplainField
		);
		submitButton.setOnAction(submitHandler);
		

		CustomHorizontalBottom footer = new CustomHorizontalBottom(submitButton);
		pane.setBottom(footer);
		BorderPane.setAlignment(footer, Pos.CENTER);

		// Create A Scene and Place In The Stage
		pane.setStyle("-fx-border-color: black; -fx-border-width: 2;");

		StackPane root = new StackPane(pane);
		root.setPadding(new Insets(50));

		Scene scene = new Scene(root);
		scene.getStylesheets().add(
    getClass().getResource("application.css").toExternalForm()
);
primaryStage.setTitle("Final Exam | Alastair Graham");
primaryStage.setScene(scene);
primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}