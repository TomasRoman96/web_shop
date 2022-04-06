package config;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public Connection getConnect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/web_shop";
		String username = "root";
		String password = "";

		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("Database Connected successfully");
		} else {
			System.out.println("Database Connection failed");
		}
        return con;
	}
}