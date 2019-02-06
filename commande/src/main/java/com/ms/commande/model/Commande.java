package com.ms.commande.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande implements Serializable{
	

	private static final Long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "command_id")
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "session_id")
	private Integer sessionId;
	 @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "command_date")
	private Date date;
	private Boolean status;
	
	public Commande() {
	}

	
	public Commande(Integer id, Integer userId, Integer sessionId, Date date, Boolean status) {
		super();
		this.id = id;
		this.userId = userId;
		this.sessionId = sessionId;
		this.date = date;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getSessionId() {
		return sessionId;
	}


	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
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


	@Override
	public String toString() {
		return String.format("Commande[id=%d, user_id='%s', session_id='%s', date='%s', status='%s']", id, userId, sessionId, date, status);
	}

}
