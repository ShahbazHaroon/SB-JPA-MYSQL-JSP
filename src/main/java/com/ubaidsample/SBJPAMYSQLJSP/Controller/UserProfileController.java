package com.ubaidsample.SBJPAMYSQLJSP.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ubaidsample.SBJPAMYSQLJSP.Enum.Gender;
import com.ubaidsample.SBJPAMYSQLJSP.Enum.MaritalStatus;
import com.ubaidsample.SBJPAMYSQLJSP.Enum.Title;
import com.ubaidsample.SBJPAMYSQLJSP.Model.UserProfile;
import com.ubaidsample.SBJPAMYSQLJSP.Service.UserProfileService;

/*
 * @author Muhammad Ubaid Ur Raheem aka Shahbaz Haroon
 */

@Controller
public class UserProfileController {

	private static final Logger logger = Logger.getLogger(UserProfileController.class);

	@Autowired
	private UserProfileService userProfileService;

	String message;

	@GetMapping("/")
	public String home(HttpServletRequest request) {

		logger.info("home Called...");
		request.setAttribute("mode", "MODE_HOME");
		return "userProfile";
	}

	@GetMapping("/allUserProfiles")
	public String findAllUserProfiles(HttpServletRequest request) {

		logger.info("allUserProfiles Called...");
		try {
			request.setAttribute("userProfiles", userProfileService.findAll());
			request.setAttribute("mode", "MODE_USERPROFILES");
		} catch (Exception ex) {
			logger.info("Error in allUserProfiles Method: " + ex);
		}
		return "userProfile";
	}

	@GetMapping("/newUserProfile")
	public String newTask(HttpServletRequest request) {

		logger.info("newUserProfile Called...");
		showTitle(request);
		request.setAttribute("mode", "MODE_NEW");
		return "userProfile";
	}

	@PostMapping("/saveUserProfile")
	public String saveUserProfile(@ModelAttribute UserProfile userProfile, BindingResult bindingResult,
			HttpServletRequest request) {

		userProfile.setCreateByAddress(request.getRemoteAddr());
		userProfile.setCreateBy(request.getRemoteUser());
		userProfile.setCreateDate(new Date());
		userProfile.setUpdateByAddress(request.getRemoteAddr());
		userProfile.setUpdateBy(request.getRemoteUser());
		userProfile.setUpdateDate(new Date());

		try {
			if (inputValidation(userProfile.getTitle(), userProfile.getFirstName(), userProfile.getLastName(),
					userProfile.getFatherName(), userProfile.getCNIC(), userProfile.getEmail(),
					userProfile.getAddress(), userProfile.getDateOfBirth(), userProfile.getDateOfJoining(),
					userProfile.getGender(), userProfile.getMaritalStatus()) == 0) {

				logger.info("saveUserProfile Called...");
				userProfileService.save(userProfile);

			}
			request.setAttribute("userProfiles", userProfileService.findAll());
			request.setAttribute("mode", "MODE_USERPROFILES");
		} catch (Exception ex) {
			logger.info("Error: " + ex);
			return "Error while creating userprofile: " + ex.toString();
		}
		return "userProfile";
	}

	@GetMapping("/updateUserProfile")
	public String updateUserProfile(@RequestParam Long userProfileId, HttpServletRequest request) {

		logger.info("updateUserProfile Called...");
		try {
			request.setAttribute("userProfiles", userProfileService.findByUserProfileId(userProfileId));
			request.setAttribute("mode", "MODE_UPDATE");
		} catch (Exception ex) {
			logger.info("Error: " + ex);
			ex.printStackTrace();
		}
		return "userProfile";
	}

	@GetMapping("/deleteUserProfile")
	public String deleteUserProfile(@RequestParam Long userProfileId, HttpServletRequest request) {

		logger.info("deleteUserProfile Called...");
		try {
			userProfileService.delete(userProfileId);
			request.setAttribute("userProfiles", userProfileService.findAll());
			request.setAttribute("mode", "MODE_USERPROFILES");
		} catch (Exception ex) {
			return "Error while deleting userprofile: " + ex.toString();
		}
		return "userProfile";
	}

	// Get list of titles from enum Title class
	@GetMapping("/requirement")
	public String showTitle(HttpServletRequest request) {
		List<Title> titleList = new ArrayList<Title>(Arrays.asList(Title.values()));
		request.setAttribute("titleList", titleList);
		return "userProfile";
	}

	private int inputValidation(Title title, String firstName, String lastName, String fatherName, String CNIC,
			String email, String address, Date dateOfBirth, Date dateOfJoining, Gender gender,
			MaritalStatus maritalStatus) {

		logger.info("inputValidation for saveUserProfile Called...");

		int a = 0;

		if (title == null || title.equals("")) {
			message = "Please enter Title";
			a++;
		} else if (firstName == null || firstName.trim().equals("")) {
			message = "Please enter First Name";
			a++;
		} else if (lastName == null || lastName.trim().equals("")) {
			message = "Please enter Last Name";
			a++;
		} else if (fatherName == null || fatherName.trim().equals("")) {
			message = "Please enter Father Name";
			a++;
		} else if (dateOfBirth == null || dateOfBirth.equals("")) {
			message = "Please enter Date of Birth";
			a++;
		} else if (dateOfJoining == null || dateOfJoining.equals("")) {
			message = "Please enter Date of Joining";
			a++;
		} else if (gender == null || gender.equals("")) {
			message = "Please enter Gender";
			a++;
		} else if (maritalStatus == null || maritalStatus.equals("")) {
			message = "Please enter Marital Status";
			a++;
		} else if (CNIC == null || CNIC.trim().equals("")) {
			message = "Please enter CNIC Number";
			a++;
		} else if (email == null || email.trim().equals("")) {
			message = "Please enter Email";
			a++;
		} else if (address == null || address.trim().equals("")) {
			message = "Please enter Address";
			a++;
		}

		return a;
	}
}