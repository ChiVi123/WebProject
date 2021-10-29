package nhom4.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import nhom4.utilities.Common;

public class ConnectDB {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {
				Class.forName(Common.JDBC_DRIVER);
				connection = DriverManager.getConnection(Common.LINKDB, Common.DB_USER, Common.DB_PASS);
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return connection;
		}
	}
}
