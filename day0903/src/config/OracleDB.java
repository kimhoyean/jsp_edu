package config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OracleDB {
	
	public static Connection dbConnect() {
		Connection conn=null;
		DataSource ds=null;
		Context ct;
		try {
			//context.xml 파일을 분석하는 클래스
			ct=new InitialContext();
			//java:comp/env/
			//모든 설정된 엔트리와 자원은 JNDI namespace의
			//java:comp/env 위치에 놓인다.
			ds=(DataSource)ct.lookup("java:comp/env/jdbc/OracleDB");
			conn=ds.getConnection();
			System.out.println("DB연결 성공!");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
