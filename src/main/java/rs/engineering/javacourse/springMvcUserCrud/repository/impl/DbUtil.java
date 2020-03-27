package rs.engineering.javacourse.springMvcUserCrud.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

@Controller
public class DbUtil {

	private static JdbcTemplate conn = null;
	private static DbUtil instance = null;

	private DbUtil() {
	}

	public static DbUtil getInstance() {
		if (instance == null) {
			instance = new DbUtil();
		}
		return instance;
	}

	public JdbcTemplate getConn() {
		return conn;
	}

	static {
		String dbname = "springdb";
		String port = "3306";
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:" + port + "/" + dbname;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DriverManagerDataSource r = new org.springframework.jdbc.datasource.DriverManagerDataSource(url, user,
				password);
		conn = new org.springframework.jdbc.core.JdbcTemplate(r);
//	Class.forName("com.mysql.jdbc.Driver");
//	conn = DriverManager.getConnection(url, user, password);
	}

}
