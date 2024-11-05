package com.enp.blabber.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enp.blabber.api.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
