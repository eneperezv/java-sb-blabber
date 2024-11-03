package com.enp.blabber.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enp.blabber.api.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
