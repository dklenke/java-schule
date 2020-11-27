package heitel.baumdb;

import java.io.File;
import java.sql.SQLException;

import heitel.dbtest.MySQLConnection;

public class FileDB {
	private MySQLConnection con;
	private File root;
	
	public FileDB(File root) throws SQLException {
		super();
		this.root = root;
		con = new MySQLConnection();
		con.openDB();
	}
	public static void main(String[] args) {
		try {
			FileDB fileDB = new FileDB(new File("C:\\Users\\Dario\\Pictures"));
			fileDB.createDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createDB() throws SQLException{
		String sql = "DROP DATABASE IF EXISTS fileDB";
		con.writeData(sql);
		sql = "CREATE DATABASE fileDB CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_german2_ci'";
		con.writeData(sql);
		sql = "USE fileDB";
		con.writeData(sql);
		sql = "CREATE TABLE file(fid INT NOT NULL AUTO_INCREMENT, "
				+ "pid INT, directory BOOLEAN, name VARCHAR(255), "
				+ "modified BIGINT, length BIGINT, PRIMARY KEY(fid), "
				+ "CONSTRAINT `fk_pid` FOREIGN KEY (pid) REFERENCES file(fid))";
		con.writeData(sql);
	}
	
}
