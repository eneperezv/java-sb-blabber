package com.enp.blabber.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.blabber.api.dto.FollowDto;
import com.enp.blabber.api.model.ErrorDetails;
import com.enp.blabber.api.model.ResponseDetails;
import com.enp.blabber.api.service.FollowService;
import com.enp.blabber.api.service.UserService;
import com.enp.blabber.api.utils.DataUtils;

@RestController
@RequestMapping("/api/v1/blabber/follows")
public class FollowController {
	
	@Autowired
	private FollowService followService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DataUtils util;
	
	@PostMapping("/create")
	public ResponseDetails<?> createFollow(@RequestBody FollowDto followDto) {
		FollowDto savedFollowDto;
		try{
			savedFollowDto = followService.createFollow(followDto);
			if(savedFollowDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Follow <"+savedFollowDto+"> not set.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<FollowDto>("OK",new Date(),new ResponseEntity<FollowDto>(savedFollowDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/get-by-user/{userid}")
	public ResponseDetails<?> getFollowsByUser(Long userid){
		
	}

}
