package nhom4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*import nhom4.utilities.Common;*/

public class ConnectDB {
	/*
	 * Sang: Nhat: "nhatnguyen1712"; Vi: "ef00tb@ll2022";
	 */
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/webfinal?useSSL=false";
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String JDBC_USER_NAME = "root";
	public static final String JDBC_PASSWORD = "ef00tb@ll2022";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	/* END CLASS */
}
