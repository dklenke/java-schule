package heitel.blz;

import java.sql.SQLException;

import com.db4o.internal.convert.Converter;

import heitel.dbtest.MySQLConnection;

public class BLZIBAN {
	
	private MySQLConnection con;
	
	public BLZIBAN() throws SQLException {
		super();
		con = new MySQLConnection("blzbicDB");
	}

	public static void main(String[] args) {
		try {
			BLZIBAN blziban = new BLZIBAN();
			blziban.createDB();
			blziban.convertData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createDB() throws SQLException{
		String sql = "DROP DATABASE IF EXISTS blzbicDB";
		con.writeData(sql);
		sql = "CREATE DATABASE blzbicDB";
		con.writeData(sql);
		sql = "USE blzbicDB";
		con.writeData(sql);
		sql = "CREATE TABLE blzbicDB(id INT(6) ZEROFILL PRIMARY KEY,blz VARCHAR(8),bic VARCHAR(11),bezeichnung VARCHAR(64),plz VARCHAR(5),ort VARCHAR(32),kurz VARCHAR(64),pan VARCHAR(5))";
		con.writeData(sql);
	}
	
	public void convertData() {
		String[] line = FileInput.readTextFile("blzbic.csv");
		for (String s : line) {
			System.out.println(s);
		}
	}

}
