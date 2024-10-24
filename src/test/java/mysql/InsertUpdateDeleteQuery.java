package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUpdateDeleteQuery {

	public static void main(String[] args) throws SQLException {
		//Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/siku", "root", "sriram");
		
		//Create statement/query
		Statement stmt = con.createStatement();
		String str = "INSERT INTO STUDENT VALUES (6, 'Hiku', 105)";
		//String str = "UPDATE STUDENT SET SNAME='ZIKU' WHERE SID=105";
		//String str = "DELETE FROM STUDENT WHERE SID=105";
		
		//Execute statement
		stmt.execute(str);
		
		//Close connection
		con.close();
		
		System.out.println("Query Executed...");

	}

}
