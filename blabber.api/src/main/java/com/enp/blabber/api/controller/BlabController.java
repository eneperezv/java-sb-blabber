package com.enp.blabber.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.blabber.api.dto.BlabDto;
import com.enp.blabber.api.model.ErrorDetails;
import com.enp.blabber.api.model.ResponseDetails;
import com.enp.blabber.api.service.BlabService;

@RestController
@RequestMapping("/api/v1/blabber/blabs")
public class BlabController {
	
	@Autowired
	private BlabService blabService;
	
	@PostMapping("/create")
	public ResponseDetails<?> createUser(@RequestBody BlabDto blabDto){
		BlabDto savedBlabDto;
		try{
			savedBlabDto = blabService.createBlab(blabDto);
			if(savedBlabDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Blab <"+savedBlabDto+"> not created");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_CREATED", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<BlabDto>("OK",new Date(),new ResponseEntity<BlabDto>(savedBlabDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
