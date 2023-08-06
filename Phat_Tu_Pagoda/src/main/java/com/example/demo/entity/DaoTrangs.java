package com.example.demo.entity;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dao_trangs")
public class DaoTrangs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dao_trang_id")
	private Integer dao_trang_id;
	
	@Column(name = "da_ket_thuc",columnDefinition = "Bit")
	private Boolean daKetThuc;
	
	@Column(name = "noi_dung")
	private String noiDung;
	
	@Column(name = "noi_to_chuc")
	private String noiToChuc;
	
	@Column(name = "sotv_tham_gia")
	private Integer soTVThamGia;
	
	@Column(name = "thoi_gian_tc")
	private Date thoiGianToChuc;
	
	@Column(name = "nguoi_tru_tri")
	private String nguoiTruTri;
	
	//ket noi one to many vs don dang ky
	@OneToMany(mappedBy = "daotrang",fetch = FetchType.LAZY)
	Set<dondangkys> dondangkys;
	
	//ket noi one to many vs phat tu dao trang
	@OneToMany(mappedBy = "daotrang",fetch = FetchType.LAZY)
	Set<PhatTuDaoTrangs> phatTuDaoTrangs;
	
	public Integer getDao_trang_id() {
		return dao_trang_id;
	}
	public void setDao_trang_id(Integer dao_trang_id) {
		this.dao_trang_id = dao_trang_id;
	}
	public Boolean getDaKetThuc() {
		return daKetThuc;
	}
	public void setDaKetThuc(Boolean daKetThuc) {
		this.daKetThuc = daKetThuc;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getNoiToChuc() {
		return noiToChuc;
	}
	public void setNoiToChuc(String noiToChuc) {
		this.noiToChuc = noiToChuc;
	}
	public Integer getSoTVThamGia() {
		return soTVThamGia;
	}
	public void setSoTVThamGia(Integer soTVThamGia) {
		this.soTVThamGia = soTVThamGia;
	}
	public Date getThoiGianToChuc() {
		return thoiGianToChuc;
	}
	public void setThoiGianToChuc(Date thoiGianToChuc) {
		this.thoiGianToChuc = thoiGianToChuc;
	}
	public String getNguoiTruTri() {
		return nguoiTruTri;
	}
	public void setNguoiTruTri(String nguoiTruTri) {
		this.nguoiTruTri = nguoiTruTri;
	}
	public Set<dondangkys> getDondangkys() {
		return dondangkys;
	}
	public void setDondangkys(Set<dondangkys> dondangkys) {
		this.dondangkys = dondangkys;
	}
	public Set<PhatTuDaoTrangs> getPhatTuDaoTrangs() {
		return phatTuDaoTrangs;
	}
	public void setPhatTuDaoTrangs(Set<PhatTuDaoTrangs> phatTuDaoTrangs) {
		this.phatTuDaoTrangs = phatTuDaoTrangs;
	}
	
}
