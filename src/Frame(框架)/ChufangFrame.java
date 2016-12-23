package hospital.frame;

import hospital.util.JdbcUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JOptionPane;

public class ChufangFrame implements ActionListener {
	Statement stmt = null;
	String sql;

	Frame frm3 = new Frame("ҽԺ����ϵͳ");

	// �����������
	Label labe9 = new Label("    �Ŵ�����������ѯ��ɾ��ʱֱ�����봦�����)");
	Label labe10 = new Label("    ������ţ�");
	Label labe11 = new Label("    �������ݣ�");
	Button qry = new Button("E ��ѯ");
	Button del = new Button("E ɾ��");
	Button add = new Button("E ¼��");

	TextField lst41 = new TextField();
	TextArea txa1 = new TextArea();

	public void clearFrame() {
		lst41.setText("");
		txa1.setText("");
	}


	public ChufangFrame() {

		// ��������ϵͳ����
		labe9.setBounds(5, 45, 400, 20);
		labe10.setBounds(5, 70, 90, 20);
		labe11.setBounds(5, 100, 90, 20);
		lst41.setBounds(100, 70, 100, 20);
		txa1.setBounds(20, 125, 400, 175);
		add.setBounds(30, 325, 50, 20);
		del.setBounds(140, 325, 50, 20);
		qry.setBounds(250, 325, 50, 20);
		frm3.add(labe9);
		frm3.add(labe10);
		frm3.add(labe11);
		frm3.add(lst41);
		frm3.add(txa1);
		frm3.add(qry);
		frm3.add(del);
		frm3.add(add);

		qry.addActionListener(this);
		del.addActionListener(this);
		add.addActionListener(this);

		frm3.setLayout(null);
		frm3.setBounds(500, 200, 460, 400);
		frm3.setBackground(Color.white);
		frm3.setVisible(true);

		// ʵ�ִ��ڹرհ�Ť���¼�
		frm3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frm3.dispose();
			}
		});

		frm3.setResizable(false);// �̶����ڵĴ�С

		try {
			stmt = JdbcUtil.getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	public void actionPerformed(ActionEvent e) {
			Object soruce = e.getSource();
			ResultSet rs = null;
			String _id = lst41.getText().trim();
			if (soruce == qry) {
				try {

					if (_id.equals("")) {
						JOptionPane.showMessageDialog(null, "��������Ҫ��ѯ�Ĵ�����ţ�");
						return;
					}

					sql = "select * from Presno where Presno='" + _id + "'";

					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						txa1.setText(rs.getString(2));
					} else {
						JOptionPane.showMessageDialog(null, "û�в�ѯ����" + _id + "��!");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (soruce == del) {
				try {
					if (_id.equals("")) {
						JOptionPane.showMessageDialog(null, "��������Ҫɾ���Ĵ�����ţ�");
						return;
					}

					sql = "delete from Presno where Presno='" + _id + "'";
					int result = stmt.executeUpdate(sql);
					if (result == 0) {
						JOptionPane.showMessageDialog(null, "û�в�ѯ����" + _id + "����");
					} else {
						JOptionPane.showMessageDialog(null, "ɾ����" + _id + "���ɹ���");
						clearFrame();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (soruce == add) {
				try {
					if (_id.equals("")) {
						JOptionPane.showMessageDialog(null, "������Ų���Ϊ�գ�");
						return;
					}

					sql = "select * from Presno where Presno='" + _id + "'";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "������š�" + _id
								+ "���Ѿ����ڣ����������룡");
						return;
					}

					sql = "insert into Presno" + "(Presno,Pcontent) values('"
							+ lst41.getText().trim() + "','"
							+ txa1.getText().trim() + "')";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "¼����Ϣ�ɹ���");
					clearFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		}
		
}}

