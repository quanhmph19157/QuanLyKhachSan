package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class LoaiPhong {
	@Id
	private int MaLoaiPhong;
	private String TenLoai;
	private int SoNguoiToiDa;
	private float GiaQuaDem;
	private float GiaTinhTheoGio;
	private int GioTinhGiaQuaDem;
	private float CheckInSom;
	private float CheckOutMuon;
	@OneToMany(mappedBy = "loaiphong")
	private List<Phong> DSPhong;
	
	

	public LoaiPhong(int maLoaiPhong, String tenLoai, int soNguoiToiDa, float giaQuaDem, float giaTinhTheoGio,
			int gioTinhGiaQuaDem, float checkInSom, float checkOutMuon, List<Phong> dSPhong) {
		MaLoaiPhong = maLoaiPhong;
		TenLoai = tenLoai;
		SoNguoiToiDa = soNguoiToiDa;
		GiaQuaDem = giaQuaDem;
		GiaTinhTheoGio = giaTinhTheoGio;
		GioTinhGiaQuaDem = gioTinhGiaQuaDem;
		CheckInSom = checkInSom;
		CheckOutMuon = checkOutMuon;
		DSPhong = dSPhong;
	}

	public LoaiPhong() {
	}

	public int getMaLoaiPhong() {
		return MaLoaiPhong;
	}

	public void setMaLoaiPhong(int maLoaiPhong) {
		MaLoaiPhong = maLoaiPhong;
	}

	public String getTenLoai() {
		return TenLoai;
	}

	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

	public int getSoNguoiToiDa() {
		return SoNguoiToiDa;
	}

	public void setSoNguoiToiDa(int soNguoiToiDa) {
		SoNguoiToiDa = soNguoiToiDa;
	}

	public float getGiaQuaDem() {
		return GiaQuaDem;
	}

	public void setGiaQuaDem(float giaQuaDem) {
		GiaQuaDem = giaQuaDem;
	}

	public float getGiaTinhTheoGio() {
		return GiaTinhTheoGio;
	}

	public void setGiaTinhTheoGio(float giaTinhTheoGio) {
		GiaTinhTheoGio = giaTinhTheoGio;
	}

	public int getGioTinhGiaQuaDem() {
		return GioTinhGiaQuaDem;
	}

	public void setGioTinhGiaQuaDem(int gioTinhGiaQuaDem) {
		GioTinhGiaQuaDem = gioTinhGiaQuaDem;
	}

	public float getCheckInSom() {
		return CheckInSom;
	}

	public void setCheckInSom(float checkInSom) {
		CheckInSom = checkInSom;
	}

	public float getCheckOutMuon() {
		return CheckOutMuon;
	}

	public void setCheckOutMuon(float checkOutMuon) {
		CheckOutMuon = checkOutMuon;
	}

	public List<Phong> getDSPhong() {
		return DSPhong;
	}

	public void setDSPhong(List<Phong> dSPhong) {
		DSPhong = dSPhong;
	}
	
	
}
