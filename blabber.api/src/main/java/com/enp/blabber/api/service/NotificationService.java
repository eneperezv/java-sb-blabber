package com.enp.blabber.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.NotificationDto;
import com.enp.blabber.api.repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	public void createNotification(NotificationDto notificationDto) {
		
	}

}
