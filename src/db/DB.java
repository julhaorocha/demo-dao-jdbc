package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {// conecta ao banco de dados
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbExeception(e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {// desconecta o banco de dados
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbExeception(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {// carrega as propriedades definidas no arquivo db.properties
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbExeception(e.getMessage());
		}
	}

	public static void closeStatement(Statement st) {//exece��es tratatadas para n�o ter que fazer v�rios try catch no program
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbExeception(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {//exece��es tratatadas para n�o ter que fazer v�rios try catch no program
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbExeception(e.getMessage());
			}
		}
	}

}
