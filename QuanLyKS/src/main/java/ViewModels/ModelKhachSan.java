package ViewModels;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import Entities.Tang;

public class ModelKhachSan {
	private int maKS;
	private String TenKhachSan;
	private String Email;
	private String sdt;
	private List<ModelTang> DSTang;
	
	

	public ModelKhachSan(int maKS, String tenKhachSan, String email, String sdt, List<ModelTang> dSTang) {
		super();
		this.maKS = maKS;
		TenKhachSan = tenKhachSan;
		Email = email;
		this.sdt = sdt;
		DSTang = dSTang;
	}

	public ModelKhachSan() {
	}

	public int getMaKS() {
		return maKS;
	}

	public void setMaKS(int maKS) {
		this.maKS = maKS;
	}

	public String getTenKhachSan() {
		return TenKhachSan;
	}

	public void setTenKhachSan(String tenKhachSan) {
		TenKhachSan = tenKhachSan;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<ModelTang> getDSTang() {
		return DSTang;
	}

	public void setDSTang(List<ModelTang> dSTang) {
		DSTang = dSTang;
	}
	
	
}
