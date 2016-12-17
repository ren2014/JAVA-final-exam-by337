import java.sql.*;

public abstract class connect{
	/**
	 * 与数据库建立连接,返回值－Connection对象
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try{
			if(conn == null){
				Class.forName("org.gjt.mm.mysql.Driver");		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","nemo");
				Debug.log("Connecion created.");
			}
			else{
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM administrator");
				if(rs==null||!rs.next()){
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","nemo");
					Debug.log("Connecion re-created.");
				}
			}
		}catch(Exception ex){
			System.out.println("连接不上");
			Debug.log(Debug.getExceptionMsg(ex));
		}
		return conn;
	}
}
