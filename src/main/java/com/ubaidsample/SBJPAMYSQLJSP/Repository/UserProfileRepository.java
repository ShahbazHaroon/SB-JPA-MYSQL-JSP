package com.ubaidsample.SBJPAMYSQLJSP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ubaidsample.SBJPAMYSQLJSP.Model.UserProfile;

/*
 * @author Muhammad Ubaid Ur Raheem aka Shahbaz Haroon
 */

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}