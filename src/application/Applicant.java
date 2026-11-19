package application;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Applicant {

	private int id;
	private String fullName;
	private String currentAddress;
	private String contactNumber;
	private String email;
	private String education;
	private String gender;
	private LocalDate dateAvailable;
	private String desiredPosition;
	private BigDecimal desiredSalary;
	private String legallyAuthorized;
	private String hasRelatives;
	private String relativesExplanation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(LocalDate dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public String getDesiredPosition() {
		return desiredPosition;
	}

	public void setDesiredPosition(String desiredPosition) {
		this.desiredPosition = desiredPosition;
	}

	public BigDecimal getDesiredSalary() {
		return desiredSalary;
	}

	public void setDesiredSalary(BigDecimal desiredSalary) {
		this.desiredSalary = desiredSalary;
	}

	public String getLegallyAuthorized() {
		return legallyAuthorized;
	}

	public void setLegallyAuthorized(String legallyAuthorized) {
		this.legallyAuthorized = legallyAuthorized;
	}

	public String getHasRelatives() {
		return hasRelatives;
	}

	public void setHasRelatives(String hasRelatives) {
		this.hasRelatives = hasRelatives;
	}

	public String getRelativesExplanation() {
		return relativesExplanation;
	}

	public void setRelativesExplanation(String relativesExplanation) {
		this.relativesExplanation = relativesExplanation;
	}
}
