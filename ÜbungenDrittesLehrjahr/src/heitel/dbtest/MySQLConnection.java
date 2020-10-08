package heitel.dbtest;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
	private static final String DBURL_MYSQL = "jdbc:mysql://heitel.dynv6.net/";

	private static final String DB_USER = "hss";

	private static final String DB_PASSWORD = "hss";

	private String db_name;

	private Connection connection;

	public MySQLConnection() {
		db_name = "flug";
	}

	public MySQLConnection(String db) {
		db_name = db;
	}

	public void openDB() throws ClassNotFoundException, SQLException {
		connection = DriverManager.getConnection(DBURL_MYSQL + db_name + "?serverTimezone=UTC",
				DB_USER, // User
				DB_PASSWORD); // Password
		System.out.println("Opening MySQL db connection");
	}

	public void closeDB() throws SQLException {
		connection.close();
		System.out.println("Closing MySQL db connection");
	}

	public int writeData(String data) {
		int res = 0;
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(data, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public ResultSet readData(String req) throws SQLException {
		ResultSet rs = null;

		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(req);

		return rs;

	}

	public void writeBLOB(ByteArrayInputStream bin) {
		try {
			PreparedStatement pre = connection.prepareStatement("insert into image (img) values(?)");
			pre.setBinaryStream(1, bin, (int) bin.available());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setAutoCommit(boolean b) {
		try {
			connection.setAutoCommit(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void commit() {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
