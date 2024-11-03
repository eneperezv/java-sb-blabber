package com.enp.blabber.api.dto;

import java.time.LocalDateTime;

public class DirectMessageDto {
	
	private Long id;
    private UserDto senderDto;  // Usuario que envía el mensaje
    private UserDto receiverDto;  // Usuario que recibe el mensaje
    private String content;  // Contenido del mensaje (limitado a 500 caracteres)
    private LocalDateTime sentAt;  // Fecha de envío del mensaje
    private boolean isRead;  // Indica si el mensaje ha sido leído
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getSenderDto() {
		return senderDto;
	}

	public void setSenderDto(UserDto senderDto) {
		this.senderDto = senderDto;
	}

	public UserDto getReceiverDto() {
		return receiverDto;
	}

	public void setReceiverDto(UserDto receiverDto) {
		this.receiverDto = receiverDto;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "DirectMessageDto [id=" + id + ", senderDto=" + senderDto + ", receiverDto=" + receiverDto + ", content="
				+ content + ", sentAt=" + sentAt + ", isRead=" + isRead + "]";
	}

}
