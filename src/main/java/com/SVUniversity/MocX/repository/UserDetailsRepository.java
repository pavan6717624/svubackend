package com.SVUniversity.MocX.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.SVUniversity.MocX.domain.UserDetails;


@Repository
public interface UserDetailsRepository  extends JpaRepository<UserDetails,Long> {
	 @Query("select u from UserDetails u where u.mobile=(:username) and u.log.isDeleted=false and u.log.isDisabled=false")
		Optional<UserDetails> findByMobile(@Param("mobile") Long mobile);
}
