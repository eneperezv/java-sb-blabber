package com.enp.blabber.api.model;

/*
 * @(#)Like.java 1.0 6/09/2024
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

import jakarta.persistence.Basic;
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
@Table(name = "dbo_likes")
public class Like {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_like", unique=true, nullable=false)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;  // Usuario que dio el Like

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_blab", nullable = false)
    private Blab blab;  // Blab al que se le dio el Like

    @Column(nullable = false)
    private LocalDateTime likedAt;  // Fecha en la que se dio el Like
    
    public Like() {
    	
    }

	public Like(User user, Blab blab, LocalDateTime likedAt) {
		super();
		this.user = user;
		this.blab = blab;
		this.likedAt = likedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getLikedAt() {
		return likedAt;
	}

	public void setLikedAt(LocalDateTime likedAt) {
		this.likedAt = likedAt;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", user=" + user + ", blab=" + blab + ", likedAt=" + likedAt + "]";
	}

}
