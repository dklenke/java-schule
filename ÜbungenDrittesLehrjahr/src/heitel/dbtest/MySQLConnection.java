package heitel.dbtest;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
	private static final String DBURL_MYSQL = "jdbc:mysql://localhost/";

	private static final String DB_USER = "root";

	private static final String DB_PASSWORD = "";

	private String db_name;

	private Connection connection;

	public MySQLConnection() {
		db_name = "";
	}

	public MySQLConnection(String db) throws SQLException {
		db_name = db;
		openDB();
	}

	public void openDB() throws SQLException {
		connection = DriverManager.getConnection(DBURL_MYSQL + db_name + "?serverTimezone=UTC", DB_USER, // User
				DB_PASSWORD); // Password
		System.out.println("Opening MySQL db connection");
	}

	public boolean isClosed() throws SQLException {
		boolean res = false;
		if (connection != null) {
			res = connection.isClosed();
		}
		return res;
	}

	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		PreparedStatement ps = null;

		if (connection != null) {
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		}
		return ps;
	}

	public void closeDB() throws SQLException {
		connection.close();
		System.out.println("Closing MySQL db connection");
	}

	public int writeData(String data) throws SQLException {
		int res = 0;
		Statement stmt = connection.createStatement();
		stmt.execute(data, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			res = rs.getInt(1);
		}
		return res;
	}

	public ResultSet readData(String req) throws SQLException {
		ResultSet rs = null;

		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(req);
		return rs;

	}

	public void writeBLOB(ByteArrayInputStream bin) throws SQLException {
		PreparedStatement pre = connection.prepareStatement("insert into image (img) values(?)");
		pre.setBinaryStream(1, bin, (int) bin.available());
		pre.executeUpdate();
	}

	public void setAutoCommit(boolean b) throws SQLException {
		connection.setAutoCommit(b);
	}

	public void commit() throws SQLException {
		connection.commit();

	}

	public void rollback() throws SQLException {
		connection.rollback();
	}
}
