package com.enp.blabber.api.controller;

import java.util.ArrayList;

/*
 * @(#)BlabController.java 1.0 6/09/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.blabber.api.dto.BlabDto;
import com.enp.blabber.api.model.ErrorDetails;
import com.enp.blabber.api.service.BlabService;

@RestController
@RequestMapping("/api/v1/blabber/blabs")
public class BlabController {
	
	@Autowired
	private BlabService blabService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBlab(@PathVariable Long id){
		BlabDto blabDto;
		try {
			blabDto = blabService.findById(id);
			if(blabDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Blab <"+blabDto+"> not found");
				return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<BlabDto>(blabDto, HttpStatus.CREATED);
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),"INTERNAL SERVER ERROR -> " + e.getMessage());
			return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getBlabsByUser(@PathVariable Long id){
		List<BlabDto> lista = new ArrayList<BlabDto>();
		try {
			blabService.getBlabsByUser(id).forEach(lista::add);
			if(lista.isEmpty()) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NO_CONTENT.toString(),"NO CONTENT");
				return new ResponseEntity<>(err,HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),"INTERNAL SERVER ERROR -> " + e.getMessage());
			return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> postBlab(@RequestBody BlabDto blabDto){
		BlabDto savedBlabDto;
		try{
			savedBlabDto = blabService.createBlab(blabDto);
			if(savedBlabDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Blab <"+savedBlabDto+"> not saved");
				return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<BlabDto>(savedBlabDto, HttpStatus.CREATED);
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),"INTERNAL SERVER ERROR -> " + e.getMessage());
			return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
