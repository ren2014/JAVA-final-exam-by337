package hospital.util;


import java.sql.Connection;
import java.sql.DriverManager;

//��ȡ���ݿ�����
public class JdbcUtil {

	public static Connection getConnection() {
		Connection con = null;
		// ���ݿ�����
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// ���ӵ����ݿ�
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=master";
		String userName = "sa";// ���ݿ��û���
		String userPwd = "123456";// ���ݿ�����
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (Exception e) {
			System.out.println("��ȡ����ʧ��." + e.getMessage());
		}
		return con;
	}
	


}
