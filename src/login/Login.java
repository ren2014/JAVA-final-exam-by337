package hospital.login;
import hospital.frame.MainFunction;
import hospital.util.JdbcUtil;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Login implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frmD = new Frame("ҽԺ����ϵͳ��½ƽ̨");

	// ����ϵͳ��½����
	Label l1 = new Label("��ӭ��½ҽԺ����ϵͳ");
	Label l2 = new Label("�ʺ�:");
	Label l3 = new Label("����:");
	Label l4 = new Label("�ʻ��Ų����ڣ�");
	TextField t1 = new TextField();
	TextField t2 = new TextField();
	Button b1 = new Button("��½");
	Button b2 = new Button("ȡ��");

	public static void main(String args[]) {
		new Login();
	}

	public Login() {
		// ��½����
		l1.setBounds(110, 50, 150, 20);
		l2.setBounds(50, 90, 50, 20);
		l3.setBounds(50, 120, 50, 20);
		l4.setBounds(120, 200, 150, 20);
		t1.setBounds(120, 90, 150, 20);
		t2.setBounds(120, 120, 150, 20);
		b1.setBounds(125, 160, 50, 20);
		b1.addActionListener(this);
		b2.setBounds(210, 160, 50, 20);
		b2.addActionListener(this);
		frmD.add(l1);
		frmD.add(l2);
		frmD.add(l3);
		frmD.add(t1);
		frmD.add(t2);
		frmD.add(b1);
		frmD.add(b2);
		frmD.setLayout(null);
		frmD.setBounds(500, 200, 350, 230);
		frmD.setBackground(Color.GREEN);
		frmD.setVisible(true);
		t2.setEchoChar('*');

		// ʵ�ִ��ڹر�
		frmD.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frmD.setResizable(false);// �̶����ڵĴ�С

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object soruce = e.getSource();

		if (soruce == b1) {

			if (soruce == b1) {
				String name = t1.getText();
				String pass = t2.getText();
				if (!"".equals(name.trim()) && !"".equals(pass.trim())) {
					if ("123".equals(name.trim()) && "123".equals(pass.trim())) {
						new MainFunction();
						frmD.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "�û���������������������룡",
								"ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "������������½��Ϣ��",
							"ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);}
			}
		}

		if (soruce == b2) {
			System.exit(0);
		}
	}

}
