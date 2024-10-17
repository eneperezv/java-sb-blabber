package com.enp.blabber.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.repository.DirectMessageRepository;

@Service
public class DirectMessageService {
	
	@Autowired
	private DirectMessageRepository dmRepository;

}
