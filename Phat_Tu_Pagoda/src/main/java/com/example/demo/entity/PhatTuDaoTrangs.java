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

@Entity
@Table(name = "phat_tu_dao_trangs")
public class PhatTuDaoTrangs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pha_tu_dao_trang_id;
	
	@Column(name = "da_tham_gia",columnDefinition = "Bit")
	private Boolean daThamGia;
	
	@Column(name = "ly_do_khong_tham_gia")
	private String lyDoKhongThamGia;
	
	@Column(name = "dao_trang_id",insertable = false, updatable = false)
	private Integer dao_trang_id;
	
	@Column(name = " phat_tu_id",insertable = false, updatable = false)
	private Integer phat_tu_id;
	
	//ket noi many to one vs dao trang
	@ManyToOne
	@JsonIgnoreProperties(value = "phatTuDaoTrangs")
	@JoinColumn(name = "dao_trang_id")
	private DaoTrangs daotrang;
	
	//ket noi many to one vs phat tu
	@ManyToOne
	@JsonIgnoreProperties(value = "phatTuDaoTrangs")
	@JoinColumn(name = "phat_tu_id")
	private PhatTu phatTu;

	public Integer getPha_tu_dao_trang_id() {
		return pha_tu_dao_trang_id;
	}

	public void setPha_tu_dao_trang_id(Integer pha_tu_dao_trang_id) {
		this.pha_tu_dao_trang_id = pha_tu_dao_trang_id;
	}

	public Boolean getDaThamGia() {
		return daThamGia;
	}

	public void setDaThamGia(Boolean daThamGia) {
		this.daThamGia = daThamGia;
	}

	public String getLyDoKhongThamGia() {
		return lyDoKhongThamGia;
	}

	public void setLyDoKhongThamGia(String lyDoKhongThamGia) {
		this.lyDoKhongThamGia = lyDoKhongThamGia;
	}

	public Integer getDao_trang_id() {
		return dao_trang_id;
	}

	public void setDao_trang_id(Integer dao_trang_id) {
		this.dao_trang_id = dao_trang_id;
	}

	public Integer getPhat_tu_id() {
		return phat_tu_id;
	}

	public void setPhat_tu_id(Integer phat_tu_id) {
		this.phat_tu_id = phat_tu_id;
	}

	public DaoTrangs getDaotrang() {
		return daotrang;
	}

	public void setDaotrang(DaoTrangs daotrang) {
		this.daotrang = daotrang;
	}

	public PhatTu getPhatTu() {
		return phatTu;
	}

	public void setPhatTu(PhatTu phatTu) {
		this.phatTu = phatTu;
	}
	
	
	
}
