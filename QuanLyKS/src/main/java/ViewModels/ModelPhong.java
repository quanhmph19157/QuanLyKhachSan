package ViewModels;




public class ModelPhong {
	private int maPhong;
	private ModelTang tang;
	
	public ModelPhong(int maPhong, ModelTang tang) {
		this.maPhong = maPhong;
		this.tang = tang;
	}

	public ModelPhong() {
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public ModelTang getTang() {
		return tang;
	}

	public void setTang(ModelTang tang) {
		this.tang = tang;
	}

}
