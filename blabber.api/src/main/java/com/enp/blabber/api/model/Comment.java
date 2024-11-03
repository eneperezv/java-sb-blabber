package com.enp.blabber.api.model;

/*
 * @(#)Comment.java 1.0 29/10/2024
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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 500)
    private String content;  // El contenido del comentario (limitado a 280 caracteres)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Usuario que hizo el comentario

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blab_id", nullable = false)
    private Blab blab;  // Blab comentado

    @Column(nullable = false)
    private LocalDateTime commentedAt;  // Fecha del comentario
    
    public Comment() {
    	
    }

	public Comment(String content, User user, Blab blab, LocalDateTime commentedAt) {
		super();
		this.content = content;
		this.user = user;
		this.blab = blab;
		this.commentedAt = commentedAt;
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

	public Blab getBlab() {
		return blab;
	}

	public void setBlab(Blab blab) {
		this.blab = blab;
	}

	public LocalDateTime getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(LocalDateTime commentedAt) {
		this.commentedAt = commentedAt;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", user=" + user + ", blab=" + blab + ", commentedAt="
				+ commentedAt + "]";
	}

}
