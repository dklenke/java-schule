package heitel.blz;

import java.sql.PreparedStatement;
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
		sql = "CREATE DATABASE blzbicDB CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_german2_ci'";
		con.writeData(sql);
		sql = "USE blzbicDB";
		con.writeData(sql);
		sql = "CREATE TABLE blzbictab(id INT(6) ZEROFILL PRIMARY KEY,blz VARCHAR(8),bic VARCHAR(11),bez VARCHAR(64),bezeichnung VARCHAR(64),plz VARCHAR(5),ort VARCHAR(64),kurz VARCHAR(64),pan VARCHAR(5))";
		con.writeData(sql);
	}
	
	public void convertData() throws SQLException {
		String[] line = FileInput.readTextFile("blzbic.csv");
		String sqlInsert = "insert into blzbicTab (id, blz, bic, bez, plz, ort, kurz, pan) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stat = con.getPreparedStatement(sqlInsert);
		for (String s : line) {
			String[] values = s.split(";");
			stat.setInt(1, Integer.parseInt(values[0]));
			stat.setString(2, values[1]);
			stat.setString(3, values[2]);
			stat.setString(4, values[3]);
			stat.setString(5, values[4]);
			stat.setString(6, values[5]);
			stat.setString(7, values[6]);
			String pan = null;
			if (values.length>7) {
				pan = values[7];
			}
			stat.setString(8, pan);
			stat.execute();
		}
	}

}
