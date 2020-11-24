package heitel.dbtest;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {
		MySQLConnection con = new MySQLConnection();
		try {
			con.openDB();
			
			String sql = "select * from scarr";
			ResultSet res = con.readData(sql);
			ResultSetMetaData md = res.getMetaData();
			int colCount = md.getColumnCount();
			
			for (int i=0;i<colCount;i++) {
				int size = md.getColumnDisplaySize(i+1);
				String name = md.getColumnName(i+1);
				if (name.length()>=size) {
					name = name.substring(0, size);
				}
				System.out.print(Console.padStringRight(name, size) + " | ");
			}
			
			
			while(res.next()) {
				String mandt = res.getString("mandt");
				String carrid = res.getString("carrid");
				String carrname = res.getString("carrname");
				String currcode = res.getString("currcode");
				String url = res.getString("url");
				
				System.out.println(mandt + " | " + carrid  + " | " + carrname  + " | " + currcode  + " | " + url);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
