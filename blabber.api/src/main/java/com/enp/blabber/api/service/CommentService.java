package com.enp.blabber.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * @(#)CommentService.java 1.0 31/10/2024
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

import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.CommentDto;
import com.enp.blabber.api.dto.LikeDto;
import com.enp.blabber.api.model.Comment;
import com.enp.blabber.api.model.Like;
import com.enp.blabber.api.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private BlabService blabService;
	
	@Autowired
	private UserService userService;
	
	public Comment buildEntity(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setId(commentDto.getId());
		comment.setContent(commentDto.getContent());
		comment.setUser(userService.buildEntity(commentDto.getUserDto()));
		comment.setBlab(blabService.buildEntity(commentDto.getBlabDto()));
		comment.setCommentedAt(commentDto.getCommentedAt());
		
		return comment;
	}
	
	public CommentDto buildDto(Optional<Comment> optional) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(optional.get().getId());
		commentDto.setContent(optional.get().getContent());
		commentDto.setUserDto(userService.buildDtoFromUser(optional.get().getUser()));
		commentDto.setBlabDto(blabService.buildDtoFromBlab(optional.get().getBlab()));
		commentDto.setCommentedAt(optional.get().getCommentedAt());
		
		return commentDto;
	}
	
	public CommentDto buildDtoFromComment(Comment comment) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.setContent(comment.getContent());
		commentDto.setUserDto(userService.buildDtoFromUser(comment.getUser()));
		commentDto.setBlabDto(blabService.buildDtoFromBlab(comment.getBlab()));
		commentDto.setCommentedAt(comment.getCommentedAt());
		
		return commentDto;
	}

	public CommentDto setBlabComment(CommentDto commentDto) {
		return buildDto(Optional.of(commentRepository.save(buildEntity(commentDto))));
	}
	
	public List<CommentDto> findAllByBladId(Long blabid){
		List<Comment> commentsLista = new ArrayList<Comment>();
		commentRepository.findAllByBladId(blabid).forEach(commentsLista::add);
		
		List<CommentDto> commentsDto = new ArrayList<CommentDto>();
		
		for(Comment comment : commentsLista){
			commentsDto.add(buildDtoFromComment(comment));
		}

		return commentsDto;
	}

}
