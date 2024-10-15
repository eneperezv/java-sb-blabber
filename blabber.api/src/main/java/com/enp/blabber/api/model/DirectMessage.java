package com.enp.blabber.api.model;

/*
 * @(#)DirectMessage.java 1.0 14/09/2024
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
@Table(name = "dbo_direct_messages")
public class DirectMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_direct_message", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_sender", nullable = false)
	private User sender;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_receiver", nullable = false)
	private User receiver;
	
	@Column(nullable = false, length = 500)
	private String message;
	
	@Column(nullable = false)
	private boolean isRead;
	
	@Column(nullable = false)
	private LocalDateTime sentAt;
	
	public DirectMessage() {
		
	}

	public DirectMessage(User sender, User receiver, String message, boolean isRead, LocalDateTime sentAt) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.isRead = isRead;
		this.sentAt = sentAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	@Override
	public String toString() {
		return "DirectMessage [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", message=" + message
				+ ", isRead=" + isRead + ", sentAt=" + sentAt + "]";
	}

}
