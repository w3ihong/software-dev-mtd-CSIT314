import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Database Connector
public class Test {
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

    public static void main(String[] args) {
        // Class.forName("com.mysql.jdbc.Driver");
        Connection testCon = new Test().getConnection();
        if (testCon != null) {
            System.out.println("Connection successful!");
            
        } else {
            System.out.println("Connection failed!");
        }
    }
}

