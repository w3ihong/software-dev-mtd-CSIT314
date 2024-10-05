package entity;

public class REA extends User{
    public REA(String firstName, String lastName, String phone, String email, String username, String password, String role, boolean active) {
        super(firstName, lastName, phone, email, username, password, role, active);
    }

    public REA(User user) {
        super(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.isActive());
    }
}
