package com.ubaidsample.SBJPAMYSQLJSP.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.ubaidsample.SBJPAMYSQLJSP.Enum.Gender;
import com.ubaidsample.SBJPAMYSQLJSP.Enum.MaritalStatus;
import com.ubaidsample.SBJPAMYSQLJSP.Enum.Title;

/*
 * @author Muhammad Ubaid Ur Raheem aka Shahbaz Haroon
 */

@Entity
@Table(name = "UserProfile")
public class UserProfile extends MainEntity implements Serializable {

	// constraint pk_Employee primary key (employeeId),
	// constraint fk_deptno foreign key (departmentId) references Department
	// (departmentId)

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long UserProfileId;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Title title;

	private String firstName, middleName, lastName, fatherName, CNIC, fax, address, district, phoneNumber, mobileNumber, emergencyContactNumber, zipCode;
	
	@Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Past
	private Date dateOfBirth, dateOfJoining, dateOfLeaving;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private MaritalStatus maritalStatus;

	// Default OR No Argument Constructor
	public UserProfile() {
	}

	// Full Argument Constructor
	public UserProfile(Title title, String firstName, String middleName, String lastName, String fatherName, String CNIC, String email, String fax, String address, String district, String phoneNumber, String mobileNumber, String emergencyContactNumber, String zipCode, Date dateOfBirth, Date dateOfJoining, Date dateOfLeaving, Gender gender, MaritalStatus maritalStatus) {
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.CNIC = CNIC;
		this.email = email;
		this.fax = fax;
		this.address = address;
		this.district = district;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.emergencyContactNumber = emergencyContactNumber;
		this.zipCode = zipCode;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.dateOfLeaving = dateOfLeaving;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}
	
	// Getters & Setters - Start
	public Long getUserProfileId() {
		return UserProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		UserProfileId = userProfileId;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}	
	// Getters & Setters - End
}