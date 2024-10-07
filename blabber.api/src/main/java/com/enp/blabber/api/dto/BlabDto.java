package com.enp.blabber.api.dto;

/*
 * @(#)BlabDto.java 1.0 6/09/2024
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.enp.blabber.api.model.Comment;
import com.enp.blabber.api.model.Like;
import com.enp.blabber.api.model.User;

public class BlabDto {
	
	private Long id;
    private String content;  // El contenido del Blab (limite a 280 caracteres)
    private User user;  // Usuario que publicó el Blab
    private List<Comment> comments = new ArrayList<>();  // Comentarios del Blab
    private List<Like> likes = new ArrayList<>();  // Likes del Blab
    private LocalDateTime createdAt;  // Fecha de creación
    private LocalDateTime updatedAt;  // Fecha de última actualización
    
    public BlabDto() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "BlabDto [id=" + id + ", content=" + content + ", user=" + user + ", comments=" + comments + ", likes="
				+ likes + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
