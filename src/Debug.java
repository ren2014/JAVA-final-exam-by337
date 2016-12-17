import java.io.*;
import java.text.*;

public final class Debug{
	   private static Debug instance=null;
	   private static SimpleDateFormat dateFormat=null;
	   private static FileOutputStream fos=null;
	   private Debug(){
	   }
	static synchronized Debug init(String path){
		return instance;//保证在同一时刻最多只有一个线程执行该段代码。		
	}
	public static synchronized void log(String msg){
		
	}
	private String writeFile(String msg){
		return msg;
	}
	public static String getExceptionMsg(Exception e){
		StackTraceElement ste=e.getStackTrace()[0];
		String msg=ste.getClassName() + "." + ste.getMethodName() + "() Ln " + ste.getLineNumber() + ":   " + e.getMessage();
		return msg;
	  }
}
