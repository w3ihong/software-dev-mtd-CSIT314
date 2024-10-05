package entity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import utility.dbConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SysAdmin extends User{
    
    public SysAdmin(String firstName, String lastName, String phone, String email, String username, String password, String role, boolean active) {
        super(firstName, lastName, phone, email, username, password, role, active);
    }

    public SysAdmin(User user) {
        super(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.isActive());
    }

    public ResultSet displayUsers(){
        String query = "SELECT * FROM users";
        ResultSet rs = conn.query(query);
        if (rs == null) {
            System.out.println("No users found.");
        }
        return rs;
    }

    public ResultSet SearchUser(String username) {
        String query = "SELECT * FROM users WHERE username LIKE ?";
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, "%" + username + "%"); // Set parameter; '%' are wildcards for SQL LIKE
            rs = pstmt.executeQuery();

            if (!rs.isBeforeFirst()) { // Check if ResultSet is empty
                System.out.println("No users found.");
                return null; // Return null or continue as appropriate
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean suspendUser(String username) {
        String query = "UPDATE users SET active = 0 WHERE username = '" + username + "'";
        boolean successful = conn.executeUpdate(query);
        return successful;
        
    }

    public void activateUser(String username) {
        String query = "UPDATE users SET active = 1 WHERE username = '" + username + "'";
        ResultSet rs  = conn.query(query);
        if (rs == null) {
            System.out.println("Activation failed. User not found.");
            return;
        } else {
            System.out.println("User " + username + " activated successfully");
        }
    }

    public User RetrieveUserAccountData(User user) {
        String query = "SELECT * FROM users WHERE username = '" + user.getEmail() + "'";
        ResultSet rs = conn.query(query);
        if (rs == null) {
            System.out.println("Activation failed. User not found.");
            return null;
        } else {
            try {
                return new User(rs.getString("fName"), rs.getString("lName"), rs.getString("phone"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getBoolean("active"));
        
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
