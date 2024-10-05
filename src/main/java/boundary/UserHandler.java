package boundary;

import control.LoginController;
import entity.*;

import java.awt.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.*;

public class UserHandler extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	// Create frame
	public void LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(75, 85, 100, 25);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(75, 125, 100, 25);
		contentPane.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(175, 85, 95, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 125, 95, 20);
		contentPane.add(passwordField);
		
		JLabel wrongInput = new JLabel("Invalid credentials. Please try again.");
		wrongInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		wrongInput.setForeground(Color.RED);
		wrongInput.setBounds(75, 150, 200, 25);
		wrongInput.setVisible(false);
		contentPane.add(wrongInput);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(200, 190, 70, 20);
		contentPane.add(loginButton);
		

		JLabel header = new JLabel("Login");
        header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		header.setBounds(140, 25, 80, 25);
		contentPane.add(header);
		
		
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
				
                LoginController lc = new LoginController();
                User currentUser = lc.AuthenticateDetails(username, password);
                if (currentUser != null) {
					UserHandler.this.dispose();
                    switch (currentUser.getRole()) {
						case "Sys Admin":
							// new AdminGUI();
							SysAdmin sa = new SysAdmin(currentUser);
							AdminHandler admin = new AdminHandler(sa);
							admin.setVisible(true);
							break;
						case "Buyer":
							// new BuyerGUI();
							Buyer b = new Buyer(currentUser);
							BuyerHandler buyer = new BuyerHandler(b);
							buyer.setVisible(true);
							break;
						case "Seller":
							// new SellerGUI();
							SellerHandler seller = new SellerHandler();
							seller.setVisible(true);
							break;
						case "REA":
							// new REAGUI();
							REAHandler rea = new REAHandler();
							rea.setVisible(true);
							break;
						default:
							break;
					}
                } else {
					// JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                    wrongInput.setVisible(true);
                }
            }
        });
		
		JLabel createAccLabel = new JLabel("Create an account");
		createAccLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        createAccLabel.setForeground(Color.BLUE);
        createAccLabel.setSize(120, 30);
		createAccLabel.setLocation(114, 232);
		createAccLabel.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) {
				UserCreateAccount uca = new UserCreateAccount();
				UserHandler.this.dispose();
				uca.setVisible(true);
		        System.out.println("Label clicked");
		    }
		});
		contentPane.add(createAccLabel);
	}

	public void runProgram() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHandler frame = new UserHandler();
					frame.setVisible(true);
                    frame.LoginGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Launch application
	public static void main(String[] args) {
		UserHandler uh = new UserHandler();
		uh.runProgram();	
	}
}
