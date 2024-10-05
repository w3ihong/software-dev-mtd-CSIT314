import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class UserGenerator {

    private static final String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "Robert", "Jennifer", "William", "Jessica", "James", "Linda", "Charles", "Mary", "Joseph", "Patricia", "Thomas", "Elizabeth", "Christopher", "Karen"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez"};
    private static final String[] ROLES = {"Sys Admin", "Buyer", "Seller", "REA"};

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/314";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            for (int i = 0; i < 100; i++) {
                UserDummy user = generateRandomUser();
                insertUser(connection, user);
                System.out.println("Inserted user: " + user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static UserDummy generateRandomUser() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        String username = firstName.toLowerCase() + lastName.toLowerCase();
        String password = firstName + "password";
        String phone = generateRandomPhoneNumber();
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
        String role = ROLES[random.nextInt(ROLES.length)];
        boolean active = random.nextBoolean();
        return new UserDummy(firstName, lastName, phone, email, username, password, role, active);
    }

    private static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("+");
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    private static void insertUser(Connection connection, UserDummy user) throws SQLException {
        String sql = "INSERT INTO users (fName, lName, username, password, phone, email, role, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getRole());
            statement.setBoolean(8, user.isActive());
            statement.executeUpdate();
        }
    }
}
