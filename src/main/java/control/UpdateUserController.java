package control;

import entity.User;

public class UpdateUserController {

    public UpdateUserController() {}

    public boolean validateUserInput(String fName, String lName, String username, String phone, String email, String role, String isActive) {
        return !fName.isEmpty() && !lName.isEmpty() && !username.isEmpty()
                && !phone.isEmpty() && !email.isEmpty() && !role.isEmpty() && !isActive.isEmpty();
    }

    public boolean updateUserController(String fName, String lName, String username, String phone, String email, String role, String isActive){
        boolean active = !isActive.equalsIgnoreCase("false");
        if (!validateUserInput(fName, lName, username, phone, email, role, isActive)) {
            return false;
        } else{
            return new User().UpdateUser(fName, lName, username, phone, email, role, active);
        }
    }
}