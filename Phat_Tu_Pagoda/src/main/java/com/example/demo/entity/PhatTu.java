package com.example.demo.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Phat_tus")
public class PhatTu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phat_tu_id")
	private Integer phat_tu_id;
	
	@Column(name = "anh_chup")
	private String anhChup;
	
	@Column(name = "da_hoan_tuc", columnDefinition = "Bit")
	private Boolean dahoantuc;
	
	@Column(name = "email" , columnDefinition = "varchar(255)")
	private String email;
	
	@Column(name = "gioi_tinh", columnDefinition = "Bit")
	private Boolean gioiTinh;
	
	@Column(name = "Ho" , columnDefinition = "varchar(255)")
	private String ho;
	
	@Column(name = "Ten_dem" , columnDefinition = "varchar(255)")
	private String tenDem;
	
	@Column(name = "Ten" , columnDefinition = "varchar(255)")
	private String ten;
	
	@Column(name = "ngay_cap_nhat" )
	private Date ngayCapNhat;
	
	@Column(name = "ngay_hoan_tuc")
	private Date ngayHoanTuc;
	
	@Column(name = "ngay_sinh")
	private Date ngaySinh;
	
	@Column(name = "ngay_xuat_gia")
	private Date ngayXuatGia;
	
	@Column(name = "Password" , columnDefinition = "varchar(255)")
	private String password;
	
	@Column(name = "phap_danh" , columnDefinition = "varchar(255)")
	private String phapDanh;
	
	@Column(name = "so_dien_thoai" , columnDefinition = "nvarchar(11)")
	private String soDienThoai;
	
	@Column(name = "kieu_thanh_vien_id",insertable = false, updatable = false)
	private Integer kieuthanhvienid;
	
	@Column(name = "chua_id",insertable = false, updatable = false)
	private Integer chua_id;
	//ket noi many to one voi bang chuas
	@ManyToOne
	@JsonIgnoreProperties(value = "phatTus")																
	@JoinColumn(name = "chua_id")
	private chuas chuas;
	//ket noi many to one vs bang thanh vien
	@ManyToOne
	@JsonIgnoreProperties(value = "phatTus")
	@JoinColumn(name = "kieu_thanh_vien_id")
	private KieuThanhViens kieuThanhViens;
	//ket noi one to many voi token
	@OneToMany(mappedBy = "phatTu",fetch = FetchType.LAZY)
	Set<token> tokens;
	//ket noi phat tu vs don dang ky
	@OneToMany(mappedBy = "phatTu",fetch = FetchType.LAZY)
	Set<dondangkys> dondangkys;
	//ket noi one to many vs phat tu dao trang
	@OneToMany(mappedBy = "phatTu",fetch = FetchType.LAZY)
	Set<PhatTuDaoTrangs> phatTuDaoTrangs;
	
	// set role
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "phat_tu_role",
               joinColumns = @JoinColumn(name = "phat_tu_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getPhat_tu_id() {
		return phat_tu_id;
	}
	public void setPhat_tu_id(Integer phat_tu_id) {
		this.phat_tu_id = phat_tu_id;
	}
	public String getAnhChup() {
		return anhChup;
	}
	public void setAnhChup(String anhChup) {
		this.anhChup = anhChup;
	}
	public Boolean getDahoantuc() {
		return dahoantuc;
	}
	public void setDahoantuc(Boolean dahoantuc) {
		this.dahoantuc = dahoantuc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTenDem() {
		return tenDem;
	}
	public void setTenDem(String tenDem) {
		this.tenDem = tenDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}
	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}
	public Date getNgayHoanTuc() {
		return ngayHoanTuc;
	}
	public void setNgayHoanTuc(Date ngayHoanTuc) {
		this.ngayHoanTuc = ngayHoanTuc;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayXuatGia() {
		return ngayXuatGia;
	}
	public void setNgayXuatGia(Date ngayXuatGia) {
		this.ngayXuatGia = ngayXuatGia;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhapDanh() {
		return phapDanh;
	}
	public void setPhapDanh(String phapDanh) {
		this.phapDanh = phapDanh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Integer getKieuthanhvienid() {
		return kieuthanhvienid;
	}
	public void setKieuthanhvienid(Integer kieuthanhvienid) {
		this.kieuthanhvienid = kieuthanhvienid;
	}
	public Integer getChua_id() {
		return chua_id;
	}
	public void setChua_id(Integer chua_id) {
		this.chua_id = chua_id;
	}
	public chuas getChuas() {
		return chuas;
	}
	public void setChuas(chuas chuas) {
		this.chuas = chuas;
	}
	public KieuThanhViens getKieuThanhViens() {
		return kieuThanhViens;
	}
	public void setKieuThanhViens(KieuThanhViens kieuThanhViens) {
		this.kieuThanhViens = kieuThanhViens;
	}
	public Set<token> getTokens() {
		return tokens;
	}
	public void setTokens(Set<token> tokens) {
		this.tokens = tokens;
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
