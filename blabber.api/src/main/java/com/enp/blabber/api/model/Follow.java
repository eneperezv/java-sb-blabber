package com.enp.blabber.api.model;

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
@Table(name = "dbo_follows")
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_follow", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_follower", nullable = false)
	private User follower;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_follows", nullable = false)
	private User follows;
	
	@Column(nullable = false)
	private LocalDateTime followedAt;
	
	public Follow() {
		
	}

	public Follow(User follower, User follows, LocalDateTime followedAt) {
		super();
		this.follower = follower;
		this.follows = follows;
		this.followedAt = followedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getFollows() {
		return follows;
	}

	public void setFollows(User follows) {
		this.follows = follows;
	}

	public LocalDateTime getFollowedAt() {
		return followedAt;
	}

	public void setFollowedAt(LocalDateTime followedAt) {
		this.followedAt = followedAt;
	}

	@Override
	public String toString() {
		return "Follow [id=" + id + ", follower=" + follower + ", follows=" + follows + ", followedAt=" + followedAt
				+ "]";
	}

}
