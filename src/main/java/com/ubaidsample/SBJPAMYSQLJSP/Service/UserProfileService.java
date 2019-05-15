package com.ubaidsample.SBJPAMYSQLJSP.Service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.ubaidsample.SBJPAMYSQLJSP.Model.UserProfile;
import com.ubaidsample.SBJPAMYSQLJSP.Repository.UserProfileRepository;

/*
 * @author Muhammad Ubaid Ur Raheem aka Shahbaz Haroon
 */

@Service
@Transactional
public class UserProfileService {

	private final UserProfileRepository userProfileRepository;

	public UserProfileService(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	public List<UserProfile> findAll() {
		List<UserProfile> userProfileList = new ArrayList<>();

		for (UserProfile userProfile : userProfileRepository.findAll()) {
			userProfileList.add(userProfile);
		}
		return userProfileList;
	}

	public void save(UserProfile userProfile) {
		userProfileRepository.save(userProfile);
	}

	public UserProfile findByUserProfileId(Long userProfileId) {
		return userProfileRepository.findOne(userProfileId);
	}

	public void delete(Long userProfileId) {
		userProfileRepository.delete(userProfileId);
	}

	public boolean exist(Long userProfileId) {
		return userProfileRepository.exists(userProfileId);
	}
}