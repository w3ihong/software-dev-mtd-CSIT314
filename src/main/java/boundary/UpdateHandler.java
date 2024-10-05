package boundary;

import control.UpdateUserController;
import entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;

public class UpdateHandler extends javax.swing.JPanel {

    /**
     * Creates new form NewJFrame
     */
    private String originalFirstName;
    private String originalLastName;
    private String originalUsername;
    private String originalEmail;
    private String originalPhone;
    private String originalRole;
    private String isActive;

    public UpdateHandler(User user) {
        this.originalFirstName = user.getFirstName();
        this.originalLastName = user.getLastName();
        this.originalUsername = user.getUsername();
        this.originalEmail = user.getEmail();
        this.originalPhone = user.getPhone();
        this.originalRole = user.getRole();
        this.isActive = Boolean.toString(user.isActive());
        initComponents();
    }

    private void initComponents() {

        fNameLabel = new javax.swing.JLabel();
        lNameLabel = new javax.swing.JLabel();
        lNameTextField = new javax.swing.JTextField(originalLastName);
        fNameTextField = new javax.swing.JTextField(originalFirstName);
        updateButton = new javax.swing.JButton();
        userNameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField(originalUsername);
        emailTextField = new javax.swing.JTextField(originalEmail);
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField(originalPhone);
        cancelButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        roleTextField = new javax.swing.JTextField(originalRole);

        activeLabel = new javax.swing.JLabel();
        activeTextField = new javax.swing.JTextField(isActive);

        lNameLabel.setText("Last Name");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel8.setText("Update details");
        jLabel8.setToolTipText("");

        roleLabel.setText("Role");

        updateButton.setBackground(new java.awt.Color(0, 153, 153));
        updateButton.setForeground(new java.awt.Color(51, 51, 51));
        updateButton.setText("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        userNameLabel.setText("User Name");

        emailLabel.setText("Email");

        phoneLabel.setText("Phone");

        fNameLabel.setText("First Name");

        cancelButton.setText("Cancel");

        activeLabel.setText("Active");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(140)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(239)
        							.addComponent(cancelButton)
        							.addGap(18)
        							.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(62)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(roleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addGap(47)
        									.addComponent(roleTextField, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(phoneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addGap(47)
        									.addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addGap(20)
        									.addComponent(lNameTextField, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(fNameLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        									.addGap(20)
        									.addComponent(fNameTextField, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        										.addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(userNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        									.addGap(18)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(userNameTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
        										.addComponent(emailTextField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(activeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addGap(47)
        									.addComponent(activeTextField, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(122)
        					.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(119, Short.MAX_VALUE)
        			.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addGap(39)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(fNameLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(fNameTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(lNameLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lNameTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(roleLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(roleTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(activeLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(activeTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(46)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(73))
        );
        this.setLayout(layout);
    }


    private void updateButtonMouseClicked(ActionEvent evt) {
        String firstName = fNameTextField.getText();
        String lastName = lNameTextField.getText();
        String username = userNameTextField.getText();
        String email = emailTextField.getText();
        String phone = phoneTextField.getText();
        String role = roleTextField.getText();

        UpdateUserController updateUserController = new UpdateUserController();

        // For example, you could create a method in your UserHandler or AdminController class to update the user details
        boolean success = updateUserController.updateUserController(firstName, lastName, username, phone, email, role, isActive);
        if (success) {
            // If the update is successful
            JOptionPane.showMessageDialog(this, "User details updated successfully.");
        } else {
            // If the update fails
            JOptionPane.showMessageDialog(this, "Failed to update user details.");
        }
    }

    public JButton getCancelButton() {
        return cancelButton;
    }


    private javax.swing.JLabel activeLabel;
    private javax.swing.JTextField activeTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JTextField fNameTextField;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JTextField lNameTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JTextField roleTextField;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
}