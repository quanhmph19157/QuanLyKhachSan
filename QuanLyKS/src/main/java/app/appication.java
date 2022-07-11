package app;

import org.hibernate.Session;

import Entities.KhachSan;
import Utinities.hibernate_ultil;

public class appication {
	public static void main(String[] args) {
		Session ss=hibernate_ultil.sf().openSession();
		ss.save(new KhachSan());
	}
}
