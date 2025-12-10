package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;

public class submitHandlerClass implements EventHandler<ActionEvent> {

    private final TextField fullNameField;
    private final TextField currentAddressField;
    private final TextField contactNumberField;
    private final TextField emailField;
    private final ComboBox<String> educationCombo;
    private final HBox genderBox;
    private final DatePicker availablePicker;
    private final TextField positionField;
    private final TextField salaryField;
    private final HBox legalBox;
    private final HBox relativeBox;
    private final TextField relativeExplainField;

    public submitHandlerClass(TextField fullNameField,
                              TextField currentAddressField,
                              TextField contactNumberField,
                              TextField emailField,
                              ComboBox<String> educationCombo,
                              HBox genderBox,
                              DatePicker availablePicker,
                              TextField positionField,
                              TextField salaryField,
                              HBox legalBox,
                              HBox relativeBox,
                              TextField relativeExplainField) {

        this.fullNameField = fullNameField;
        this.currentAddressField = currentAddressField;
        this.contactNumberField = contactNumberField;
        this.emailField = emailField;
        this.educationCombo = educationCombo;
        this.genderBox = genderBox;
        this.availablePicker = availablePicker;
        this.positionField = positionField;
        this.salaryField = salaryField;
        this.legalBox = legalBox;
        this.relativeBox = relativeBox;
        this.relativeExplainField = relativeExplainField;
    }

    @Override
    public void handle(ActionEvent event) {

        Applicant applicant = new Applicant();


        String fullName = fullNameField.getText().trim();
        if (!fullName.matches("[A-Za-z ]{1,50}")) {
            showError("Full name must be letters/spaces only, max 50 characters.");
            return;
        }
        applicant.setFullName(fullName);

        applicant.setAddress(currentAddressField.getText().trim());

        String phoneStr = contactNumberField.getText().trim();
        if (!phoneStr.matches("\\d{10}")) {
            showError("Contact number must be exactly 10 digits.");
            return;
        }

        applicant.setPhone(phoneStr);

        applicant.setEmail(emailField.getText().trim());

        String education = educationCombo.getValue();
        if (education == null) {
            showError("Please select your highest education.");
            return;
        }
        applicant.setEducation(education);

        String gender = getSelectedRadioText(genderBox);
        applicant.setGender(gender);


        if (availablePicker.getValue() == null) {
            showError("Please pick an available start date.");
            return;
        }
        String startDate = availablePicker.getValue().toString();
        applicant.setStartDate(startDate);

        applicant.setPosition(positionField.getText().trim());


        String salaryStr = salaryField.getText().trim();
        if (!salaryStr.matches("\\d{1,8}\\.\\d{2}")) {
            showError("Salary must be up to 8 digits plus 2 decimals (e.g. 12345678.50).");
            return;
        }
        applicant.setSalary(salaryStr);

        String legalAnswer = getSelectedRadioText(legalBox);
        applicant.setLegal(legalAnswer);

        String relativeAnswer = getSelectedRadioText(relativeBox);
        applicant.setRelative(relativeAnswer);

        String relativesExplanation = relativeExplainField.getText().trim();
        applicant.setRelativeExplanation(relativesExplanation);

        // Save to DB
        boolean saved = Database.saveApplicant(applicant);
        Alert alert = new Alert(saved ? AlertType.INFORMATION : AlertType.ERROR);
        alert.setTitle(saved ? "Success" : "Error");
        alert.setHeaderText(null);
        alert.setContentText(saved
                ? "Application submitted successfully."
                : "Failed to submit application. Please try again.");
        alert.showAndWait();

        if (saved) {
            clearForm();
        }
    }

    private String getSelectedRadioText(HBox box) {
        for (Node node : box.getChildren()) {
            if (node instanceof RadioButton) {
                RadioButton rb = (RadioButton) node;
                if (rb.isSelected()) {
                    return rb.getText();
                }
            }
        }
        return "";
    }

    private void clearForm() {
        fullNameField.clear();
        currentAddressField.clear();
        contactNumberField.clear();
        emailField.clear();
        positionField.clear();
        salaryField.clear();
        relativeExplainField.clear();
        availablePicker.setValue(null);
        educationCombo.setValue(null);
        educationCombo.getSelectionModel().clearSelection();

        resetRadios(genderBox);
        resetRadios(legalBox);
        resetRadios(relativeBox);
    }

    private void resetRadios(HBox box) {
        boolean first = true;
        for (Node node : box.getChildren()) {
            if (node instanceof RadioButton) {
                RadioButton rb = (RadioButton) node;
                rb.setSelected(first);
                first = false;
            }
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
