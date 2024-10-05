package entity;

import java.sql.*;
import utility.dbConnect;

// import java.util.Scanner;
// import com.mysql.cj.xdevapi.Statement;

public class User {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String role;
    private boolean active;

    protected final dbConnect conn = new dbConnect();

    public User(String firstName, String lastName, String phone, String email, String username, String password, String role, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public User() {
    }

    public User authenticate(String username, String password) {
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "' AND  active = 1";
        ResultSet rs = conn.query(query);
        try {
            if (rs.next()) {
                System.out.println("Successfully authenticated");
                return new User(rs.getString("fName"), rs.getString("lName"), rs.getString("phone"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("role"), true);
            } else {
                System.out.println("Failed to authenticate");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean VerifyUserInput(String fName, String lName, String username, String password, String phone, String email, String role) {
        if (fName.length() > 0 && lName.length() > 0 && username.length() > 0 && password.length() > 0 && phone.length() > 0 && email.length() > 0 && role.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean CreateUser(String fName, String lName, String username, String password, String phone, String email, String role) {
        String sql = "INSERT INTO users (fName, lName, username, password, phone, email, role, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.setString(5, phone);
            pstmt.setString(6, email);
            pstmt.setString(7, role);
            pstmt.setBoolean(8, true); // Assuming 'active' is always set to 1 when creating a new user

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
            return false;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public boolean UpdateUser(String fName, String lName, String username, String phone, String email, String role, boolean active) {
        String sql = "UPDATE users SET fName = ?, lName = ?, username = ?, phone = ?, email = ?, role = ?, active = ? WHERE username = ?";
        try (PreparedStatement pstmt = conn.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, username);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.setString(6, role);
            pstmt.setBoolean(7, active);
            pstmt.setString(8, username);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
            return false;
        }
    }

    // for testing if the CreateUser method works
    // public static void main(String[] args) {
    //     User user = new User();
    //     user.CreateUser("testCreate", "John", "1234567890", "123", "testCreate", "testCreate", "Buyer");

    // }
    // for testing if the authenticate method works
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter username: ");
    //     String username = sc.nextLine();
    //     System.out.println("Enter password: ");
    //     String password = sc.nextLine();

    //     User user = new User("", "", "", "", "", "", "", false);
    //     user.authenticate(username, password);
    // }

}
