package application;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EmploymentForm extends Application {

	@Override
	public void start(Stage primaryStage) {

		ApplicantDao applicantDao = new ApplicantDao();

		primaryStage.setTitle("Employment Application");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		//  Header with logo 
		Polygon star = new Polygon();
		for (int i = 0; i < 16; i++) {
			double angle = i * Math.PI / 8 - Math.PI / 2;
			double radius = (i % 2 == 0) ? 24 : 11;
			star.getPoints().addAll(radius * Math.cos(angle), radius * Math.sin(angle));
		}
		star.setFill(Color.BLACK);

		Text companyName = new Text("John");
		companyName.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		Text companySub = new Text("Company");
		companySub.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
		VBox companyText = new VBox(0, companyName, companySub);

		HBox logo = new HBox(10, star, companyText);
		logo.setAlignment(Pos.CENTER_LEFT);

		Text sceneTitle = new Text("Employment Application");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		sceneTitle.setFill(Color.WHITE);
		StackPane banner = new StackPane(sceneTitle);
		banner.setStyle("-fx-background-color: black;");
		banner.setPadding(new Insets(12, 20, 12, 20));

		HBox header = new HBox(20, logo, banner);
		header.setAlignment(Pos.CENTER_LEFT);
		grid.add(header, 0, 0, 2, 1);

		//  Personal Information 
		Text personalTitle = new Text("Personal Information");
		personalTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
		grid.add(personalTitle, 0, 1, 2, 1);

		Label fullNameLabel = new Label("Full Name:");
		grid.add(fullNameLabel, 0, 2);
		TextField fullNameField = new TextField();
		grid.add(fullNameField, 1, 2);

		Label addressLabel = new Label("Current Address:");
		grid.add(addressLabel, 0, 3);
		TextField addressField = new TextField();
		grid.add(addressField, 1, 3);

		Label contactLabel = new Label("Contact Number:");
		grid.add(contactLabel, 0, 4);
		TextField contactField = new TextField();
		grid.add(contactField, 1, 4);

		Label emailLabel = new Label("Email Address:");
		grid.add(emailLabel, 0, 5);
		TextField emailField = new TextField();
		grid.add(emailField, 1, 5);

		Label educationLabel = new Label("Highest Educational Attainment:");
		grid.add(educationLabel, 0, 6);
		TextField educationField = new TextField();
		grid.add(educationField, 1, 6);

		Label genderLabel = new Label("Gender:");
		grid.add(genderLabel, 0, 7);
		ToggleGroup genderGroup = new ToggleGroup();
		RadioButton maleButton = new RadioButton("Male");
		RadioButton femaleButton = new RadioButton("Female");
		RadioButton otherButton = new RadioButton("Other");
		maleButton.setToggleGroup(genderGroup);
		femaleButton.setToggleGroup(genderGroup);
		otherButton.setToggleGroup(genderGroup);
		grid.add(new HBox(15, maleButton, femaleButton, otherButton), 1, 7);

		//  Employment Eligibility 
		Text eligibilityTitle = new Text("Employment Eligibility");
		eligibilityTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
		grid.add(eligibilityTitle, 0, 8, 2, 1);

		Label dateLabel = new Label("Date Available:");
		grid.add(dateLabel, 0, 9);
		DatePicker datePicker = new DatePicker();
		grid.add(datePicker, 1, 9);

		Label positionLabel = new Label("Desired Position:");
		grid.add(positionLabel, 0, 10);
		TextField positionField = new TextField();
		grid.add(positionField, 1, 10);

		Label salaryLabel = new Label("Desired Salary:");
		grid.add(salaryLabel, 0, 11);
		TextField salaryField = new TextField();
		grid.add(salaryField, 1, 11);

		Label authorizedLabel = new Label("Are you legally authorized to work in the country?");
		grid.add(authorizedLabel, 0, 12);
		ToggleGroup authorizedGroup = new ToggleGroup();
		RadioButton authorizedYes = new RadioButton("Yes");
		RadioButton authorizedNo = new RadioButton("No");
		authorizedYes.setToggleGroup(authorizedGroup);
		authorizedNo.setToggleGroup(authorizedGroup);
		grid.add(new HBox(15, authorizedYes, authorizedNo), 1, 12);

		Label relativesLabel = new Label("Do you have relatives working for our company?");
		grid.add(relativesLabel, 0, 13);
		ToggleGroup relativesGroup = new ToggleGroup();
		RadioButton relativesYes = new RadioButton("Yes");
		RadioButton relativesNo = new RadioButton("No");
		relativesYes.setToggleGroup(relativesGroup);
		relativesNo.setToggleGroup(relativesGroup);
		grid.add(new HBox(15, relativesYes, relativesNo), 1, 13);

		Label explainLabel = new Label("If yes, please explain further:");
		grid.add(explainLabel, 0, 14);
		TextField explainField = new TextField();
		grid.add(explainField, 1, 14);

		Button submitButton = new Button("Submit");
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.BOTTOM_RIGHT);
		hBox.getChildren().add(submitButton);
		grid.add(hBox, 1, 15);

		submitButton.setOnAction(actionEvent -> {
			String fullName = fullNameField.getText().trim();
			String address = addressField.getText().trim();
			String contact = contactField.getText().trim();
			String email = emailField.getText().trim();
			String education = educationField.getText().trim();
			String gender = this.selectedText(genderGroup);
			LocalDate dateAvailable = datePicker.getValue();
			String position = positionField.getText().trim();
			String salaryText = salaryField.getText().trim();
			String authorized = this.selectedText(authorizedGroup);
			String relatives = this.selectedText(relativesGroup);
			String explanation = explainField.getText().trim();

			if (StringPool.BLANK.equals(fullName) || StringPool.BLANK.equals(address)
					|| StringPool.BLANK.equals(contact) || StringPool.BLANK.equals(email)
					|| StringPool.BLANK.equals(education) || StringPool.BLANK.equals(gender)
					|| dateAvailable == null || StringPool.BLANK.equals(position)
					|| StringPool.BLANK.equals(salaryText) || StringPool.BLANK.equals(authorized)
					|| StringPool.BLANK.equals(relatives)) {
				this.alert("Error", "Please complete fields!", AlertType.ERROR);
			} else if (!contact.matches("[0-9+()\\- ]{7,20}")) {
				this.alert("Error", "Enter a valid contact number!", AlertType.ERROR);
			} else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
				this.alert("Error", "Enter a valid email address!", AlertType.ERROR);
			} else if (!salaryText.matches("[0-9]+(\\.[0-9]{1,2})?")) {
				this.alert("Error", "Desired salary must be a number, for example 55000 or 55000.50", AlertType.ERROR);
			} else if ("Yes".equals(relatives) && StringPool.BLANK.equals(explanation)) {
				this.alert("Error", "Please explain about your relatives!", AlertType.ERROR);
			} else {
				try {
					Applicant applicant = this.createApplicantObject(fullName, address, contact, email, education,
							gender, dateAvailable, position, new BigDecimal(salaryText), authorized, relatives,
							explanation);
					int applicantId = applicantDao.saveApplicant(applicant);
					if (applicantId > 0) {
						this.alert("Submit", "Successful! Applicant ID: " + applicantId, AlertType.INFORMATION);
						fullNameField.clear();
						addressField.clear();
						contactField.clear();
						emailField.clear();
						educationField.clear();
						genderGroup.selectToggle(null);
						datePicker.setValue(null);
						positionField.clear();
						salaryField.clear();
						authorizedGroup.selectToggle(null);
						relativesGroup.selectToggle(null);
						explainField.clear();
					} else {
						this.alert("Error", "Failed!", AlertType.ERROR);
					}
				} catch (SQLException ex) {
					System.out.println("Exception occured");
					System.out.println(ex.getMessage());
					System.out.println(ex.getErrorCode());
					System.out.println(ex.getSQLState());
					this.alert("Error", "Database error: " + ex.getMessage(), AlertType.ERROR);
				}
			}
		});

		Scene scene = new Scene(grid, 640, 720);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public String selectedText(ToggleGroup group) {
		Toggle selected = group.getSelectedToggle();
		return (selected == null) ? StringPool.BLANK : ((RadioButton) selected).getText();
	}

	public void alert(String title, String message, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}

	public Applicant createApplicantObject(String fullName, String address, String contact, String email,
			String education, String gender, LocalDate dateAvailable, String position, BigDecimal salary,
			String authorized, String relatives, String explanation) {
		Applicant applicant = new Applicant();
		applicant.setFullName(fullName);
		applicant.setCurrentAddress(address);
		applicant.setContactNumber(contact);
		applicant.setEmail(email);
		applicant.setEducation(education);
		applicant.setGender(gender);
		applicant.setDateAvailable(dateAvailable);
		applicant.setDesiredPosition(position);
		applicant.setDesiredSalary(salary);
		applicant.setLegallyAuthorized(authorized);
		applicant.setHasRelatives(relatives);
		applicant.setRelativesExplanation(StringPool.BLANK.equals(explanation) ? null : explanation);

		return applicant;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
