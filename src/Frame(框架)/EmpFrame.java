package hospital.frame;

import hospital.util.JdbcUtil;

import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EmpFrame implements ActionListener {
	Statement stmt = null;
	String sql;
	Frame frm4 = new Frame("ҽԺ����ϵͳ");

	// ҽԺְԱ�������
	Label labe12 = new Label("    ��ҽԺ����Ա��������ע�⣺��ѯ��ɾ��������������");
	Label labe13 = new Label("    ��        ��:");
	Label labe14 = new Label("    �������:");
	Label labe15 = new Label("    ��       ��:");
	Label labe16 = new Label("    ��       ��:");
	Label labe17 = new Label("    ��ϵ�绰:");
	Label labe18 = new Label("    ְ       ��:");
	Label labe19 = new Label("    ѧ       ��:");
	Label labe20 = new Label("    ��������:");
	Label labe21 = new Label("    ��������:");
}
