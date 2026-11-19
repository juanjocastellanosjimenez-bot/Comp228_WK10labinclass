package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplicantDao {

	/** Inserts one applicant with a PreparedStatement and returns the generated id (0 if none). */
	public int saveApplicant(Applicant applicant) throws SQLException {
		String query = "INSERT INTO applicants(full_name, current_address, contact_number, email, education, gender, "
				+ "date_available, desired_position, desired_salary, legally_authorized, has_relatives, "
				+ "relatives_explanation) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			int counter = 1;
			statement.setString(counter++, applicant.getFullName());
			statement.setString(counter++, applicant.getCurrentAddress());
			statement.setString(counter++, applicant.getContactNumber());
			statement.setString(counter++, applicant.getEmail());
			statement.setString(counter++, applicant.getEducation());
			statement.setString(counter++, applicant.getGender());
			statement.setDate(counter++, Date.valueOf(applicant.getDateAvailable()));
			statement.setString(counter++, applicant.getDesiredPosition());
			statement.setBigDecimal(counter++, applicant.getDesiredSalary());
			statement.setString(counter++, applicant.getLegallyAuthorized());
			statement.setString(counter++, applicant.getHasRelatives());
			statement.setString(counter++, applicant.getRelativesExplanation());
			statement.executeUpdate();

			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				if (resultSet.next()) {
					return resultSet.getInt(1);
				}
			}
		}
		return 0;
	}
}
