package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	private static Connection con;

	public static void createConnection(){
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/Prabhu/student.db";
			// create a connection to the database
			con = DriverManager.getConnection(url);

			//System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String insert (String sid,String surname,String firstName, String subCode, String description, String year, String sem, String result) {
		String status = "";
		createConnection();
		//sql query
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			//using PreparedStatement to edit values in the sql query
			stmt.setString(1, sid);
			stmt.setString(2, surname);
			stmt.setString(3, firstName);
			stmt.setString(4, subCode);
			stmt.setString(5, description);
			stmt.setString(6, year);
			stmt.setString(7, sem);
			stmt.setString(8, result);
			stmt.execute();
			status = "Insert Successful!";
		} 
		catch (SQLException e) {
			status = "Insert Failed!";
			e.printStackTrace();
		}
		return status;
	}

	public static String retrieve (String sid) {
		String stid, fname, sname, subcode, desc, sem, year, result;
		String resultset = "";
		String allResults = "";
		createConnection();
		String sql = "SELECT * FROM student WHERE sid = "+sid;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				stid = rs.getString("sid");
				fname = rs.getString("firstname");
				sname = rs.getString("surname");
				subcode = rs.getString("subCode");
				desc = rs.getString("description");
				sem = rs.getString("sem");
				year = rs.getString("year");
				result = rs.getString("result");

				resultset = "\"" + stid + "\", " + "\"" + fname + "\", " + "\""+sname+"\", " + "\"" + subcode+"\", " + "\""+year+"\", " +"\""+sem+"\", " +"\""+result+"\", " +"\""+desc+"\"\n";
				//appending all records for the given student id
				allResults += resultset;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allResults;
	}
	
	public static String update(String sid, String subCode, String result) {
		String updateStatus = "";
//		String retrieveStatus = "";              	 // For validation
		createConnection();
		String sql = "update student set result =? where sid =? and subcode =?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, result);
			stmt.setString(2, sid);
			stmt.setString(3, subCode);
			stmt.execute();
			updateStatus = "Update Successful!";
//			retrieveStatus = Database.retrieve(sid);	// For validation
//			if (retrieveStatus.isEmpty()||!retrieveStatus.contains(subCode)) {
//				updateStatus = "Update Failed!";
//			}
			
		} catch (SQLException e) {
			updateStatus = "Update Failed!\n" +e.getMessage();
			e.printStackTrace();
		}
		
		return updateStatus;
		
	}
	
}



