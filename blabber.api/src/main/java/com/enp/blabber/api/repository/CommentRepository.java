package com.enp.blabber.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enp.blabber.api.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query(value = "SELECT a.* FROM comments a WHERE a.blab_id = :blabid", nativeQuery = true)
	List<Comment> findAllByBladId(Long blabid);

}
