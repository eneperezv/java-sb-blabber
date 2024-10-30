package com.enp.blabber.api.model;

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
@Table(name = "likes")
public class Like {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Usuario que dio el Like

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blab_id", nullable = false)
    private Blab blab;  // Blab al que se le dio el Like

    @Column(nullable = false)
    private LocalDateTime likedAt;  // Fecha en la que se dio el Like

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
