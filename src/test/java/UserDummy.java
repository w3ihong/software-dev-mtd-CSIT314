public class UserDummy {
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private String username;
        private String password;
        private String role;
        private boolean active;

        public UserDummy(String firstName, String lastName, String phone, String email,
                         String username, String password, String role, boolean active) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.email = email;
            this.username = username;
            this.password = password;
            this.role = role;
            this.active = active;
        }

        // Getters and setters
        // You can also override toString() method for printing user details
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
    }