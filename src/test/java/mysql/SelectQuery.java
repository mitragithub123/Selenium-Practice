package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {

	public static void main(String[] args) throws SQLException {
		// Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/siku", "root", "sriram");

		// Create statement/query
		Statement stmt = con.createStatement();
		String str = "select * from student";

		// Execute statement & store data in result set
		ResultSet rs = stmt.executeQuery(str);
		// Print data
		while (rs.next()) {
			int id = rs.getInt("sid");
			String name = rs.getString("sname");
			int no = rs.getInt("sno");
			System.out.println(id + " " + name + " " + no);

		}
		
		//Using for loop
		//for (int i = 1; rs.next(); i++) {}

		// Close connection
		con.close();

		System.out.println("Query Executed...");

	}

}
