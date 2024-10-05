// package backup;

// import javax.swing.*;
// import control.UserController;
// import entity.User;

// import java.awt.*;

// public class UserHandler {
//     public void LoginGUI() {
//         boolean login = false;
//         while (!login) {
//             String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
//             try {
//                 UIManager.setLookAndFeel(lookAndFeel);
//                 System.out.println(lookAndFeel);
//             } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
//                      UnsupportedLookAndFeelException e){
//                 System.err.println("Couldn't find class for specified look and feel:"
//                         + lookAndFeel);
//                 System.err.println("Did you include the L&F library in the class path?");
//                 System.err.println("Using the default look and feel.");
//             }
//             JPanel panel = new JPanel();
//             panel.setLayout(new GridLayout(2,3));

//             JLabel idLabel = new JLabel("Username: ");
//             JLabel pwLabel = new JLabel("Password: ");
//             JTextField idField = new JTextField();
//             JPasswordField pwField = new JPasswordField();

//             panel.add(idLabel);
//             panel.add(idField);
//             panel.add(pwLabel);
//             panel.add(pwField);

            // int res = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            // if (res == JOptionPane.OK_OPTION) {
            //     String inpID = idField.getText();
            //     String inpPW = new String(pwField.getPassword());
            //     UserController uc = new UserController();
                // uc.AuthenticateDetails(inpID, inpPW);

//                 if (uc.AuthenticateDetails(inpID, inpPW) != null) {
//                     // JOptionPane.showMessageDialog(null, "Success???");
//                     checkRole(uc.AuthenticateDetails(inpID, inpPW));
//                     login = true;
//                 } else {
//                     JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
//                 }

//             } else if (res == JOptionPane.CANCEL_OPTION) {
//                 System.exit(0);
//                 break;
//             }
//         }
//     }

//     public void checkRole(User user) {
//         switch (user.getRole()) {
//             case "Sys Admin":
//                 JOptionPane.showMessageDialog(null, "Welcome Admin!");
//                 // new AdminGUI();
//                 break;
//             case "Buyer":
//                 JOptionPane.showMessageDialog(null, "Welcome Buyer!");
//                 // new BuyerGUI();
//                 break;
//             case "Seller":
//                 JOptionPane.showMessageDialog(null, "Welcome Seller!");
//                 // new SellerGUI();
//                 break;
//             case "REA":
//                 JOptionPane.showMessageDialog(null, "Welcome REA!");
//                 // new REAGUI();
//                 break;
//             default:
//                 break;
//         }
//     }

//     public static void main(String[] args) {
//         new UserHandler().LoginGUI();
//     }
// }
