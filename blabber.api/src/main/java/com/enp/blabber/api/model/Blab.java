package com.enp.blabber.api.model;

/*
 * @(#)Blab.java 1.0 29/10/2024
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
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="dbo_blabs")
public class Blab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_blab", unique=true, nullable=false)
	private Long id;
	
	@Column(nullable = false, length = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "blab", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();  // Comentarios del blab

    @OneToMany(mappedBy = "blab", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();  // Likes del blab

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Transient
    private Integer commentsCount;

    @Transient
    private Integer likesCount;

    @PostLoad
    @PostPersist
    public void updateCounts() {
        this.commentsCount = comments.size();
        this.likesCount = likes.size();
    }
    
    public Blab() {
    	
    }

	public Blab(String content, User user, List<Comment> comments, List<Like> likes, LocalDateTime createdAt,
			Integer commentsCount, Integer likesCount) {
		super();
		this.content = content;
		this.user = user;
		this.comments = comments;
		this.likes = likes;
		this.createdAt = createdAt;
		this.commentsCount = commentsCount;
		this.likesCount = likesCount;
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

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Integer getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}

	@Override
	public String toString() {
		return "Blab [id=" + id + ", content=" + content + ", user=" + user + ", comments=" + comments + ", likes="
				+ likes + ", createdAt=" + createdAt + ", commentsCount=" + commentsCount + ", likesCount=" + likesCount
				+ "]";
	}

}
