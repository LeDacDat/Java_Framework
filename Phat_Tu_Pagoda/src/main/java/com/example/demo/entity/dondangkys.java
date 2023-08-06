package com.example.demo.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "don_dang_kys")
public class dondangkys {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer don_dang_ky_id;
	
	@Column(name = "ngay_gui_don")
	private Date ngayGuiDon;
	
	@Column(name = "ngay_xu_ly")
	private Date ngayXuLy;
	
	@Column(name = "nguoi_xu_ly")
	private String nguoiXuLy;
	
	@Column(name = "trang_thai_don")
	private String trangThaiDon;
	
	@Column(name = "dao_trang_id",insertable = false, updatable = false)
	private Integer daotrangid;
	
	@Column(name = "phat_tu_id",insertable = false, updatable = false)
	private Integer phattuid;
	
	//ket noi don dang ky vs phat tu
	@ManyToOne
	@JoinColumn(name = "phat_tu_id")
	@JsonIgnoreProperties(value = "dondangkys")
	private PhatTu phatTu;
	
	//ket noi don dang ky vs dao trang
	@ManyToOne
	@JoinColumn(name = "dao_trang_id")
	@JsonIgnoreProperties(value = "dondangkys")
	private DaoTrangs daotrang;

	public Integer getDon_dang_ky_id() {
		return don_dang_ky_id;
	}

	public void setDon_dang_ky_id(Integer don_dang_ky_id) {
		this.don_dang_ky_id = don_dang_ky_id;
	}

	public Date getNgayGuiDon() {
		return ngayGuiDon;
	}

	public void setNgayGuiDon(Date ngayGuiDon) {
		this.ngayGuiDon = ngayGuiDon;
	}

	public Date getNgayXuLy() {
		return ngayXuLy;
	}

	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}

	public String getNguoiXuLy() {
		return nguoiXuLy;
	}

	public void setNguoiXuLy(String nguoiXuLy) {
		this.nguoiXuLy = nguoiXuLy;
	}

	public String getTrangThaiDon() {
		return trangThaiDon;
	}

	public void setTrangThaiDon(String trangThaiDon) {
		this.trangThaiDon = trangThaiDon;
	}

	public Integer getDaotrangid() {
		return daotrangid;
	}

	public void setDaotrangid(Integer daotrangid) {
		this.daotrangid = daotrangid;
	}

	public Integer getPhattuid() {
		return phattuid;
	}

	public void setPhattuid(Integer phattuid) {
		this.phattuid = phattuid;
	}

	public PhatTu getPhatTu() {
		return phatTu;
	}

	public void setPhatTu(PhatTu phatTu) {
		this.phatTu = phatTu;
	}

	public DaoTrangs getDaotrang() {
		return daotrang;
	}

	public void setDaotrang(DaoTrangs daotrang) {
		this.daotrang = daotrang;
	}

	
	
}
