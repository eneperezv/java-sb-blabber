package com.enp.blabber.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enp.blabber.api.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {
	
	@Query(value = "SELECT a.* FROM follows a WHERE a.follower_id = :userid", nativeQuery = true)
	List<Follow> getFollows(Long userid);

	@Query(value = "SELECT a.* FROM follows a WHERE a.followed_id = :userid", nativeQuery = true)
	List<Follow> getFollowers(Long userid);

}
