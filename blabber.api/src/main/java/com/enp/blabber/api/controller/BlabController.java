package com.enp.blabber.api.controller;

import java.util.ArrayList;

/*
 * @(#)BlabController.java 1.0 29/10/2024
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
import com.enp.blabber.api.dto.CommentDto;
import com.enp.blabber.api.dto.LikeDto;
import com.enp.blabber.api.model.ErrorDetails;
import com.enp.blabber.api.model.ResponseDetails;
import com.enp.blabber.api.service.BlabService;
import com.enp.blabber.api.service.CommentService;
import com.enp.blabber.api.service.LikeService;

@RestController
@RequestMapping("/api/v1/blabber/blabs")
public class BlabController {
	
	@Autowired
	private BlabService blabService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/create")
	public ResponseDetails<?> createBlab(@RequestBody BlabDto blabDto){
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
	
	@GetMapping("/{id}")
	public ResponseDetails<?> getBlab(@PathVariable Long id){
		BlabDto savedBlabDto;
		try {
			savedBlabDto = blabService.findById(id);
			if(savedBlabDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Blab <"+savedBlabDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			List<LikeDto> likes = new ArrayList<LikeDto>();
			likeService.findAllByBladId(savedBlabDto.getId()).forEach(likes::add);
			if(likes.isEmpty()) {
				savedBlabDto.setLikes(new ArrayList<LikeDto>());
				savedBlabDto.setLikesCount(0);
				savedBlabDto.setComments(new ArrayList<CommentDto>());
				savedBlabDto.setCommentsCount(0);
			}else {
				savedBlabDto.setLikes(likes);
				savedBlabDto.setLikesCount(likes.size());
				savedBlabDto.setComments(new ArrayList<CommentDto>());
				savedBlabDto.setCommentsCount(0);
			}
			return new ResponseDetails<BlabDto>("OK",new Date(),new ResponseEntity<BlabDto>(savedBlabDto, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	//
	//LIKES
	//
	@PostMapping("/like")
	public ResponseDetails<?> setBlabLike(@RequestBody LikeDto likeDto){
		LikeDto savedLikeDto;
		try{
			savedLikeDto = likeService.setBlabLike(likeDto);
			if(savedLikeDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Like <"+savedLikeDto+"> not registered");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_CREATED", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<LikeDto>("OK",new Date(),new ResponseEntity<LikeDto>(savedLikeDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/likes/{blabid}")
	public ResponseDetails<?> getBlabLikes(@PathVariable Long blabid){
		List<LikeDto> likes = new ArrayList<LikeDto>();
		try {
			likeService.findAllByBladId(blabid).forEach(likes::add);
			if(likes.isEmpty()) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"This Blab has no likes.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<List<LikeDto>>("OK",new Date(),new ResponseEntity<List<LikeDto>>(likes, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	//
	//COMENTS
	//
	@PostMapping("/comment")
	public ResponseDetails<?> setBlabComment(@RequestBody CommentDto commentDto){
		CommentDto savedCommentDto;
		try{
			savedCommentDto = commentService.setBlabComment(commentDto);
			if(savedCommentDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Comment <"+savedCommentDto+"> not registered");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_CREATED", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<CommentDto>("OK",new Date(),new ResponseEntity<CommentDto>(savedCommentDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/comments/{blabid}")
	public ResponseDetails<?> getBlabComments(@PathVariable Long blabid){
		List<LikeDto> likes = new ArrayList<LikeDto>();
		try {
			likeService.findAllByBladId(blabid).forEach(likes::add);
			if(likes.isEmpty()) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"This Blab has no likes.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<List<LikeDto>>("OK",new Date(),new ResponseEntity<List<LikeDto>>(likes, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
