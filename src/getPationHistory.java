import java.sql.*;
public class getPatientsHistory(String orderBy){//查询病历
		conn=DBConnection.getConnection();
		int res=0;
		if(orderBy == null || orderBy.equals(""))
			orderBy=Doctor.NAME;
try{strSQL=
	"SELECT history.HID,history.Diagnose,history.Description,history.Rx,history.SDate,history.FDate,history.Finished,patient.Name,patient.Age,patient.Sex,patient.Address,patient.Phone" +
	 " FROM patient,doctor,history WHERE history.Doctor='" + this.id + "' AND doctor.DID='" + this.id +
		   "' AND history.Patient=patient.PID AND Finished=0 ORDER BY " + orderBy;   //医生只能查询当前患者的当前病历(“Finished=0”)
		  stmt=conn.createStatement();
		  rs=stmt.executeQuery(strSQL);
result=rs;   //将局部变量中的内容复制给类变量result，使外部类可以通过getResult()			          //访问
res=1;
		}
		catch(SQLException sqle){
			Debug.log(Debug.getExceptionMsg(sqle));  //记录异常日志
			res= -1;
		}
		catch(Exception e){
			res=0;
		}
		finally{
			return res;
		}
	}
