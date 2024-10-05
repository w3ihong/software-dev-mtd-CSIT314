package control;

import entity.*;

public class CreateUserAccountController {
    public boolean CreateUserAccount(String lName, String fName, String uName, String password, String phone, String email, String role){
        if (VerifyUserInputForAccountCreation(lName, fName, uName, password, phone, email, role)) {
            User user = new User();
            if (user.CreateUser(lName, fName, uName, password, phone, email, role)) {
                return true;
            } else {
                return false;
            }
    
        } else {
            return false;
        }
    
    }
    
    public boolean VerifyUserInputForAccountCreation(String lName, String fName, String uName, String password, String phone, String email, String role){
        return new User().VerifyUserInput(lName, fName, uName, password, phone, email, role);
    }

    //For testing purposes
    // public static void main(String[] args) {
    //     CreateUserAccountController cuac = new CreateUserAccountController();
    //     System.out.println(cuac.CreateUserAccount("testCreate2", "John123", "12345678902", "123123", "testCreate123", "testCreate123", "Buyer"));
    // }
}
