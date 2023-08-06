package com.example.demo.entity;

import java.sql.Date;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Chuas")
public class chuas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chua_id")
	private Integer chua_id;
	@Column(name = "cap_nhat")
	private Date capNhat;
	@Column(name = "dia_chi", columnDefinition = "varchar(255)")
	private String diaChi;
	@Column(name = "ngay_thanh_lap")
	private Date ngayThanhLap;
	@Column(name = "ten_chua", columnDefinition = "varchar(255)")
	private String tenChua;
	@Column(name = "tru_tri")
	private Integer trutri;
	//ket noi 1 nhieu vs bang phat tu;
	@OneToMany(mappedBy = "chuas",fetch = FetchType.LAZY)
	private Set<PhatTu> phatTus;
	
	public Set<PhatTu> getPhatTus() {
		return phatTus;
	}
	public void setPhatTus(Set<PhatTu> phatTus) {
		this.phatTus = phatTus;
	}
	public Integer getChua_id() {
		return chua_id;
	}
	public void setChua_id(Integer chua_id) {
		this.chua_id = chua_id;
	}
	public Date getCapNhat() {
		return capNhat;
	}
	public void setCapNhat(Date capNhat) {
		this.capNhat = capNhat;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgayThanhLap() {
		return ngayThanhLap;
	}
	public void setNgayThanhLap(Date ngayThanhLap) {
		this.ngayThanhLap = ngayThanhLap;
	}
	public String getTenChua() {
		return tenChua;
	}
	public void setTenChua(String tenChua) {
		this.tenChua = tenChua;
	}
	public Integer getTrutri() {
		return trutri;
	}
	public void setTrutri(Integer trutri) {
		this.trutri = trutri;
	}
	
	
}
