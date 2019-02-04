package com.ms.commande.modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	
	@Id
    @GeneratedValue
    @Column(name = "command_id")
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "session_id")
	private Long sessionId;
	private Date date;
	private Boolean status;
	
	public Commande() {
	}

	public Commande(Long id, Long userId, Date date, Boolean status) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
