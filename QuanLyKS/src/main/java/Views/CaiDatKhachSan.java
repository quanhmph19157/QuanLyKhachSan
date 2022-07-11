package Views;

import java.awt.Color;
import ViewModels.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CaiDatKhachSan extends JFrame {

	List<ModelTang> khachsan = new ArrayList<ModelTang>();
	List<JPanel> ks = new ArrayList<JPanel>();

	JPanel pnl_chinh = new JPanel();
	JTextField txt_soTang = new JTextField();
	JTextField txt_soPhong = new JTextField();
	JPanel pnl_autoGen = new JPanel();
	ModelKhachSan hotel;
	boolean runOnly1=false;

	public CaiDatKhachSan(ModelKhachSan hotel) {
		this.hotel = hotel;
		settingForm();
		SetEvent();
	}

	private void settingForm() {
		setSize(480, 740);
		setLocationRelativeTo(null);
		add(pnl_chinh);

		pnl_chinh.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pnl_chinh.setBackground(Color.white);

		JPanel pnl_input = new JPanel();
		pnl_input.setPreferredSize(new Dimension(460,30));
		pnl_input.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pnl_input.setBackground(Color.white);

		JLabel lbl_tang = new JLabel("Nhập số tầng:");
		txt_soTang.setPreferredSize(new Dimension(30, 20));
		pnl_input.add(lbl_tang);
		pnl_input.add(txt_soTang);

		JLabel lbl_PhongTang = new JLabel("Nhập số phòng/tầng:");
		txt_soPhong.setPreferredSize(new Dimension(30, 20));
		pnl_input.add(lbl_PhongTang);
		pnl_input.add(txt_soPhong);

		pnl_chinh.add(pnl_input);
	}

	private void SetEvent() {
		txt_soTang.addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				caret_update();
				display();
			}
		});

		txt_soPhong.addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				caret_update();
				display();
			}
		});
	}

	private void caret_update() {
		if (txt_soTang.getText().isBlank()) {
			new Thread(new Runnable() {
				public void run() {
					txt_soTang.setText("0");
				}
			}).start();;
		}
		if (txt_soPhong.getText().isBlank()) {
			new Thread(new Runnable() {
				public void run() {
					txt_soPhong.setText("0");
				}
			}).start();;
		}
		ks.clear();
		khachsan.clear();
		int delValue=pnl_chinh.getComponentCount();
		for(int i=1;i<delValue;i++) {
			pnl_chinh.remove(1);
		}
		revalidate();
		repaint();
		int soTang=0;
		if(!txt_soTang.getText().equals(""))soTang=Integer.parseInt(txt_soTang.getText());
		int soPhong=0;
		if(!txt_soPhong.getText().equals(""))soPhong=Integer.parseInt(txt_soPhong.getText());
		for (int i = 1; i <=soTang ; i++) {
			ks.add(new JPanel());
			ks.get(ks.size() - 1).setSize(460, 20);
			ks.get(ks.size() - 1).add(new JLabel("Tầng " + i+" Số phòng: "));
			List<ModelPhong> dsphong = new ArrayList<ModelPhong>();
			khachsan.add(new ModelTang(i, hotel, dsphong));
			final JTextField a = new JTextField(String.valueOf(soPhong));
			a.setPreferredSize(new Dimension(30,20));
			for (int y = 0; y < Integer.parseInt(a.getText()); y++) {
				int tang = khachsan.get(khachsan.size() - 1).getMaTang();
				khachsan.get(khachsan.size() - 1).getDSPhong()
						.add(new ModelPhong(tang * 100 + y + 1, khachsan.get(khachsan.size() - 1)));
			}
			a.addCaretListener(new CaretListener() {
				public void caretUpdate(CaretEvent e) {
					// TODO Auto-generated method stub
					khachsan.get(khachsan.size() - 1).getDSPhong().clear();
					int soPhong=0;
					if(!a.getText().equals(""))soPhong=Integer.parseInt(a.getText());
					else {
						new Thread(new Runnable() {
							public void run() {
								a.setText("0");
							}
						}).start();
					}
					for (int y = 0; y < soPhong; y++) {
						int tang = khachsan.get(khachsan.size() - 1).getMaTang();
						khachsan.get(khachsan.size() - 1).getDSPhong()
								.add(new ModelPhong(tang * 100 + y + 1, khachsan.get(khachsan.size() - 1)));
					}
				}
			});
			ks.get(ks.size() - 1).add(a);
			JButton del = new JButton("Xóa");
			final int b = i;
			del.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ks.remove(b-1);
					khachsan.remove(b-1);
					new Thread(new Runnable() {
						public void run() {
							txt_soTang.setText(String.valueOf(Integer.parseInt(txt_soTang.getText())-1));
							caret_update();
							display();
						}
					}).start();;
					revalidate();
					repaint();
				}
			});
			ks.get(ks.size() - 1).add(del);
			revalidate();
			repaint();
		}
	}
	
	private void display() {
		for(int i=0;i<ks.size();i++) {
			pnl_chinh.add(ks.get(i));
			if(i==23) {
				break;
			}
		}
		addPage();
	}
	// không đổi được màu btn khi nhấn
	private void addPage (){
		final List<JButton> page_list=new ArrayList<JButton>();
		for(int i=0;i<(int)ks.size()/24+1;i++) {
			final JButton btn_page=new JButton(String.valueOf(i+1));
			page_list.add(btn_page);
			btn_page.setPreferredSize(new Dimension(40,40));
			final int page=i+1;
			btn_page.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int a=0;a<page_list.size();a++) {
						page_list.get(a).setBackground(Color.white);//đổi màu btn
					}
					int pageChosen=Integer.parseInt(btn_page.getText())-1;
					page_list.get(pageChosen).setForeground(Color.gray);//đổi màu btn
					int del=pnl_chinh.getComponentCount();
					for(int x=0;x<del-1;x++) {
						pnl_chinh.remove(1);
					}
					for(int y=24*pageChosen;y<ks.size();y++) {
						pnl_chinh.add(ks.get(y));
						if(y==24*pageChosen+23) {
							break;
						}
					}
					addPage();
					revalidate();
					repaint();
				}
			});
			pnl_chinh.add(btn_page);
			revalidate();
			repaint();
		}
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				new CaiDatKhachSan(new ModelKhachSan()).setVisible(true);
			}
		}).start();
	}
}
