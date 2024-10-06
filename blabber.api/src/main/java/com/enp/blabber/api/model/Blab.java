package com.enp.blabber.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dbo_blabs")
public class Blab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_blab", unique=true, nullable=false)
    private Long id;
    
    @Column(nullable = false, length = 350)
    private String content;  // El contenido del Blab (limite a 280 caracteres)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;  // Usuario que publicó el Blab

    @OneToMany(mappedBy = "blab", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();  // Comentarios del Blab

    @OneToMany(mappedBy = "blab", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();  // Likes del Blab

    @Column(nullable = false)
    private LocalDateTime createdAt;  // Fecha de creación

    @Column(nullable = false)
    private LocalDateTime updatedAt;  // Fecha de última actualización
    
    public Blab() {
    	
    }

	public Blab(String content, User user, List<Comment> comments, List<Like> likes, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.content = content;
		this.user = user;
		this.comments = comments;
		this.likes = likes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
		return "Blab [id=" + id + ", content=" + content + ", user=" + user + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
