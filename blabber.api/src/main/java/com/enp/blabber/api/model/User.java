package com.enp.blabber.api.model;

import java.util.ArrayList;
import java.util.List;

/*
 * @(#)User.java 1.0 5/09/2024
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

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="dbo_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_user", unique=true, nullable=false)
	private Long id;
	
	@Column(name="username")
    private String username;
	
	@Column(name="password")
    private String password;
	
	@Column(name="role")
    private String role; //Eg: ADMIN,USER
	
	@Column(name="name")
    private String name;

    // Relación con Blabs
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blab> blabs = new ArrayList<>();  // Blabs publicados por el usuario

    // Relación con Follows
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> following = new ArrayList<>();  // Usuarios a los que sigue

    @OneToMany(mappedBy = "followed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> followers = new ArrayList<>();  // Usuarios que lo siguen

    // Relación con Notifications
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();  // Notificaciones recibidas

    // Relación con Direct Messages
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DirectMessage> sentMessages = new ArrayList<>();  // Mensajes enviados por el usuario

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DirectMessage> receivedMessages = new ArrayList<>();  // Mensajes recibidos por el usuario

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Blab> getBlabs() {
		return blabs;
	}

	public void setBlabs(List<Blab> blabs) {
		this.blabs = blabs;
	}

	public List<Follow> getFollowing() {
		return following;
	}

	public void setFollowing(List<Follow> following) {
		this.following = following;
	}

	public List<Follow> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follow> followers) {
		this.followers = followers;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<DirectMessage> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<DirectMessage> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<DirectMessage> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<DirectMessage> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", name="
				+ name + ", blabs=" + blabs + ", following=" + following + ", followers=" + followers
				+ ", notifications=" + notifications + ", sentMessages=" + sentMessages + ", receivedMessages="
				+ receivedMessages + "]";
	}

}
