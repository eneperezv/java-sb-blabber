package com.enp.blabber.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.blabber.api.service.FollowService;

@RestController
@RequestMapping("/api/v1/blabber/follows")
public class FollowController {
	
	@Autowired
	private FollowService followService;

}
