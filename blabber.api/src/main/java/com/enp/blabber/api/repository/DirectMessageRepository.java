package com.enp.blabber.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enp.blabber.api.model.DirectMessage;

public interface DirectMessageRepository extends JpaRepository<DirectMessage, Long> {
	
	@Query(value = "SELECT a.* FROM direct_messages a WHERE a.sender_id_id = :userId", nativeQuery = true)
	List<DirectMessage> getDmSent(Long userId);

}
