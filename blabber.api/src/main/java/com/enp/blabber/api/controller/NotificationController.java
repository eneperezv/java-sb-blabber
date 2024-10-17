package com.enp.blabber.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.blabber.api.service.NotificationService;

@RestController
@RequestMapping("/api/v1/blabber/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;

}
