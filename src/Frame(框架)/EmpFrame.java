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
	Frame frm4 = new Frame("医院管理系统");

	// 医院职员管理界面
	Label labe12 = new Label("    Ｆ医院工作员工管理：（注意：查询，删除请输入姓名）");
	Label labe13 = new Label("    姓        名:");
	Label labe14 = new Label("    工作编号:");
	Label labe15 = new Label("    年       龄:");
	Label labe16 = new Label("    性       别:");
	Label labe17 = new Label("    联系电话:");
	Label labe18 = new Label("    职       务:");
	Label labe19 = new Label("    学       历:");
	Label labe20 = new Label("    自我评价:");
	Label labe21 = new Label("    工作经历:");
}
