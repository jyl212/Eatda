package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnect() {
		Connection connection = null;
		
//		String url = "jdbc:oracle:thin:@192.168.9.88:1521:xe";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "eatda";
		String password = "eatda";
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null){
				resultSet.close();
			}
			if (statement != null){
				statement.close();
			}
			if(connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
