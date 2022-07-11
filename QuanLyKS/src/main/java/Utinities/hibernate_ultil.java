package Utinities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Entities.*;
public class hibernate_ultil {
	static SessionFactory session_factory=null;
	public static SessionFactory sf() {
		if(session_factory==null) {
			Configuration conf =new Configuration().configure()
					.addAnnotatedClass(KhachSan.class)
					.addAnnotatedClass(Tang.class)
					.addAnnotatedClass(Phong.class)
					.addAnnotatedClass(LoaiPhong.class)
					.addAnnotatedClass(HoaDonPhong.class)
					.addAnnotatedClass(HoaDon.class)
					.addAnnotatedClass(DichVu.class)
					.addAnnotatedClass(ChiTietDichVu.class)
					.addAnnotatedClass(KhachHang.class)
					.addAnnotatedClass(NhanVien.class)
					.addAnnotatedClass(ChucVu.class)
					.addAnnotatedClass(Quyen.class)
					.addAnnotatedClass(TaiKhoan.class);
			
			ServiceRegistry svr=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
			session_factory =conf.buildSessionFactory(svr);
			System.out.println("sdasd");
		}
		return session_factory;
	}
}
