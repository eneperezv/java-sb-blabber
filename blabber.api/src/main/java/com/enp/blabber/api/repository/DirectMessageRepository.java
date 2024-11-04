package com.enp.blabber.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enp.blabber.api.model.DirectMessage;

public interface DirectMessageRepository extends JpaRepository<DirectMessage, Long> {

}
