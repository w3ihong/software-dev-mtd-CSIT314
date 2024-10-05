package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// Database Connector
public class dbConnect {
	// Database url, user and password
	String DB_URL = "jdbc:mysql://localhost:3306/314";
	String DB_USER = "root";
	String DB_PASSWORD = "";

	public Connection getConnection() {
    	try {
        	return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    	} catch (SQLException e) {
        	e.printStackTrace();
        	return null;
        }
    }

    public ResultSet query(String query) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Connection get(String column) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean executeUpdate(String query) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    // code to test if connection is successful.
    // public static void main(String[] args) {
    //     Connection testCon = new dbConnect().getConnection();
    //     if (testCon != null) {
    //         System.out.println("Connection successful!");
            
    //     } else {
    //         System.out.println("Connection failed!");
    //     }
    // }
}