package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Kieu_thanh_viens")
public class KieuThanhViens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kieu_thanh_vien_id")
	private Integer kieu_thanh_vien_id;
	@Column(name = "code", columnDefinition = "varchar(255)")
	private String code ;
	@Column(name = "ten_kieu", columnDefinition = "varchar(255)")
	private String tenkieu;
	//ket noi one to many vs bang phat tu
	@OneToMany(mappedBy = "kieuThanhViens",fetch = FetchType.LAZY)
	private Set<PhatTu> phatTus;

	public Integer getKieu_thanh_vien_id() {
		return kieu_thanh_vien_id;
	}

	public void setKieu_thanh_vien_id(Integer kieu_thanh_vien_id) {
		this.kieu_thanh_vien_id = kieu_thanh_vien_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTenkieu() {
		return tenkieu;
	}

	public void setTenkieu(String tenkieu) {
		this.tenkieu = tenkieu;
	}

	public Set<PhatTu> getPhatTus() {
		return phatTus;
	}

	public void setPhatTus(Set<PhatTu> phatTus) {
		this.phatTus = phatTus;
	}
	
	
}
