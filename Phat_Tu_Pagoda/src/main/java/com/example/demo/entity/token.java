package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "token")
public class token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "expired")
	private Boolean expired;
	
	@Column(name = "revoked")
	private Boolean revoked;
	
	@Column(name = "token_type")
	token_type token_type;
	
	@Column(name = "phat_tu_id",insertable = false, updatable = false)
	private Integer phat_tu_id;
	// ket noi many to one vs phat tu
	
	@ManyToOne
	@JsonIgnoreProperties(value = "tokens")
	@JoinColumn(name = "phat_tu_id")
	private PhatTu phatTu;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getExpired() {
		return expired;
	}
	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
	public Boolean getRevoked() {
		return revoked;
	}
	public void setRevoked(Boolean revoked) {
		this.revoked = revoked;
	}
	public token_type getToken_type() {
		return token_type;
	}
	public void setToken_type(token_type token_type) {
		this.token_type = token_type;
	}
	public Integer getPhat_tu_id() {
		return phat_tu_id;
	}
	public void setPhat_tu_id(Integer phat_tu_id) {
		this.phat_tu_id = phat_tu_id;
	}
	public PhatTu getPhatTu() {
		return phatTu;
	}
	public void setPhatTu(PhatTu phatTu) {
		this.phatTu = phatTu;
	}
	
}
