package copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class Database {
	//method for insert skill into testdb
	public void insertSkill(String email, String skill) {
		Connection c = null;
        Statement stmt = null;
        try {
           Class.forName("org.postgresql.Driver");
           c = DriverManager
              .getConnection("jdbc:postgresql://localhost:5432/testdb",
              "zhouxuqing", "123"); 
           stmt = c.createStatement();
           String sql = "insert into skill values ('" + email + "','" + skill + "');";
           stmt.executeUpdate(sql);
           stmt.close();
           c.close();
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
    }
	//method for insert name into testdb
	//input email, firstName, lastName as strings
	//execute insert command to testdb database
	public void insertName(String email, String firstName, String lastName) {
		Connection c = null;
        Statement stmt = null;
        try {
           Class.forName("org.postgresql.Driver");
           c = DriverManager
              .getConnection("jdbc:postgresql://localhost:5432/testdb",
              "zhouxuqing", "123"); 
           stmt = c.createStatement();
           String sql = "insert into name values ('" + email + "','" + firstName + "','" + lastName + "');";
           stmt.executeUpdate(sql);
           stmt.close();
           c.close();
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
    }
	
	//method for skill query
	//input skill name as string, output email | skill table
	public String[] skillQuery(String skill) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	    	 Class.forName("org.postgresql.Driver");
	         c = DriverManager
	              .getConnection("jdbc:postgresql://localhost:5432/testdb",
	              "zhouxuqing", "123"); 
	         c.setAutoCommit(false);
	         //command as Statement class
	         //intermediate result as ResultSet class, use getString to get email as string
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "select * from skill where (skill ='"+ skill +"');" );
	         //count the length of the email list;
	         int counter = 0;
	         while ( rs.next() ) {
	        	 counter++;
	         }
	         
	         //do search again to recover rs.next()
	         rs = stmt.executeQuery( "select * from skill where (skill ='"+ skill +"');" );
	         //generate email list;
	         String[]emailList = new String[counter];
	         int posi = 0;
	         while ( rs.next() ) {
	        	 emailList[posi] = rs.getString("email");
	        	 posi++;
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	         return emailList;
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	         return null;
	      }
	   }
} 
