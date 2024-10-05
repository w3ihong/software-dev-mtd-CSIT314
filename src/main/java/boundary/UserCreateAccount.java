package boundary;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.CreateUserAccountController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UserCreateAccount extends JFrame{

    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JLabel phone;
	private JTextField phoneField;
	private JLabel email;
	private JTextField emailField;
	private JLabel role;

    public UserCreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fName = new JLabel("First name");
        fName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fName.setBounds(134, 111, 100, 25);
		contentPane.add(fName);
		
		JLabel lName = new JLabel("Last name");
        lName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lName.setBounds(134, 151, 100, 25);
		contentPane.add(lName);
		
		fnameField = new JTextField();
		fnameField.setBounds(234, 111, 134, 20);
		contentPane.add(fnameField);
		fnameField.setColumns(10);
		
		lnameField = new JTextField();
		lnameField.setBounds(234, 151, 134, 20);
		contentPane.add(lnameField);
		
		JLabel lblCreateAccount = new JLabel("Create account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateAccount.setBounds(192, 30, 152, 25);
		contentPane.add(lblCreateAccount);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBounds(134, 186, 100, 25);
		contentPane.add(username);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(234, 191, 134, 20);
		contentPane.add(usernameField);
		
		passwordField = new JTextField();
		passwordField.setBounds(234, 226, 134, 20);
		contentPane.add(passwordField);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(134, 226, 100, 25);
		contentPane.add(password);
		
		phone = new JLabel("Phone");
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setBounds(134, 261, 100, 25);
		contentPane.add(phone);
		
		phoneField = new JTextField();
		phoneField.setBounds(234, 261, 134, 20);
		contentPane.add(phoneField);
		
		email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email.setBounds(134, 296, 100, 25);
		contentPane.add(email);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(234, 301, 134, 20);
		contentPane.add(emailField);

		String roleArray[] = {"Buyer", "Seller", "REA"};
		JComboBox<String> roles = new JComboBox<>(roleArray);
		roles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		roles.setEditable(false);
		roles.setBounds(283, 333, 85, 25);
		contentPane.add(roles);
		
		role = new JLabel("Profile");
		role.setFont(new Font("Tahoma", Font.PLAIN, 16));
		role.setBounds(134, 331, 100, 25);
		contentPane.add(role);

		JButton createButton = new JButton("Create");
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createButton.setBounds(283, 380, 85, 21);
		contentPane.add(createButton);

        createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                CreateUserAccountController createController = new CreateUserAccountController();
                boolean createSuccess = createController.CreateUserAccount(lnameField.getText(), fnameField.getText(), usernameField.getText(), passwordField.getText(), phoneField.getText(), emailField.getText(), roles.getSelectedItem().toString());
                if (createSuccess) {
					UserCreateAccount.this.dispose();
                    JOptionPane.showMessageDialog(null, "Account created, you may now login.");
                    UserHandler uh = new UserHandler();
                    uh.runProgram();
                } else { 
                    // TODO: Add more specific error messages and check for specific invalid entries
					JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                    // wrongInput.setVisible(true);
                }
            }
        });

	}
}
