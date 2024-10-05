import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

// Database Connector
public class Test2 {
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
        try {
            Connection connection = new Test().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));            }
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

