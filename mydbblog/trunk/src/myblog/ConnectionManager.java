package myblog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 單純的連線管理類別
 */

public class ConnectionManager {

	/**
	 * JDBC 驅動程式的類別名稱
	 */
	final static String DRIVER = "com.mysql.jdbc.Driver";
	
	/**
	 * 資料庫的URL
	 */
	final static String URL = "jdbc:mysql://localhost/hanndb";
	
	/**
	 * 資料庫的使用者
	 */
	final static String USER = "hann";
	
	/**
	 * 資料庫的使用者密碼
	 */
	final static String PASS = "pig95513";
	
	/**
	 * 取得資料庫的Connection
	 */
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalStateException("fail to class load :"+e.getMessage());
		}
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		return con;
	}
	
		

}
