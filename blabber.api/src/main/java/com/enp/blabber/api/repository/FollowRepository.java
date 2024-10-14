package com.enp.blabber.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enp.blabber.api.model.Follow;

public interface FollowRepository extends JpaRepository<Follow,Long> {

}
