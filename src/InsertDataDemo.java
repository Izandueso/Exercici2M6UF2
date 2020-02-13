import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class InsertDataDemo {
	
	public InsertDataDemo() throws SQLException{
		
		Connection connection = null;
		Statement stmt = null;
		
		String stm = "DELETE FROM ALUMNES WHERE NOM = 'IZAN'";
		
		String stm2 = "INSERT INTO ALUMNES VALUES('fdsfsadf', '6482849P', '1992-12-12', 'CARRER',43840)";
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/alumnes", "root", "");

			stmt = connection.createStatement();
			
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			stmt.executeUpdate(stm);
			stmt.executeUpdate(stm2);
			connection.commit();
			connection.setAutoCommit(true);
			
		} 
		catch (Exception e) {
			connection.rollback();
			System.out.println("" + e.getMessage());
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}