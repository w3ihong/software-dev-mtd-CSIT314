package boundary;
import javax.swing.*;
import entity.User;
import entity.SysAdmin;
import control.AdminController;
import java.awt.Component;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.*;
import java.security.URIParameter;
import java.util.ArrayList;
import java.util.Collections;

public class AdminViewAccount extends JFrame{

    private static final long serialVersionUID = 1L;
	private JLabel fname;
	private JButton editButton;
	private JTextField lNameField;
	private JTextField usernameField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField typeField;
	private JTextField activeField;
	private JPanel contentPane;
	private ArrayList<Component> originalComponents;


	public AdminViewAccount(SysAdmin sa, User user) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 10, 0));


		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//page split into 3 sections
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		JPanel body = new JPanel();
		contentPane.add(body, BorderLayout.CENTER);

		body.setLayout(null);

		//header
		header.setLayout(new FlowLayout());
		header.setPreferredSize(new Dimension(900, 40));
		header.setBackground(Color.LIGHT_GRAY);
		header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserHandler uh = new UserHandler();
				AdminViewAccount.this.dispose();
				uh.runProgram();
			}
		});

		JLabel homeLabel = new JLabel("Home");
		homeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminHandler ah = new AdminHandler(sa);
				AdminViewAccount.this.dispose();
				ah.setVisible(true);
			}
		});

		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(650, 20));
		spacer.setBackground(Color.LIGHT_GRAY);

		JPanel spacer2 = new JPanel();
		spacer2.setPreferredSize(new Dimension(5, 20));
		spacer2.setBackground(Color.LIGHT_GRAY);

		// username label
		JLabel nameLabel = new JLabel(sa.getUsername());
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 12));

		header.add(homeLabel);
		header.add(spacer);
		header.add(nameLabel);
		header.add(spacer2);
		header.add(logoutButton);

		this.editButton = new JButton("Edit");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editButton.setBounds(500, 401, 65, 25);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateHandler updateHandler = new UpdateHandler(user);
				originalComponents = new ArrayList<>();

                Collections.addAll(originalComponents, body.getComponents());
				body.removeAll(); // Remove all current components in the body panel
				body.revalidate(); // Revalidate the body panel to clear removed components
				body.repaint(); // Repaint the body panel to ensure the UI is updated

				body.setLayout(new BorderLayout()); // Set layout for body panel
				body.add(updateHandler, BorderLayout.CENTER); // Add the update panel to the body

				JButton cancelButton = updateHandler.getCancelButton();
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						body.removeAll();
						body.setLayout(null);
						for (Component comp : originalComponents) {
							body.add(comp);
						}
						body.revalidate();
						body.repaint();
					}
				});
			}
		});

		fname = new JLabel("First name");
		AdminViewAccount.this.fname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AdminViewAccount.this.fname.setBounds(339, 197, 92, 30);
		body.add(AdminViewAccount.this.fname);

		body.add(this.fname);
		body.add(editButton);
		JLabel lname = new JLabel("Last name");
		lname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lname.setBounds(339, 225, 92, 30);
		body.add(lname);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(339, 254, 92, 30);
		body.add(lblUsername);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(339, 282, 92, 30);
		body.add(lblEmail);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setBounds(339, 311, 92, 30);
		body.add(lblPhone);

		JLabel lblAccountType = new JLabel("Account type");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAccountType.setBounds(339, 339, 92, 30);
		body.add(lblAccountType);

		JLabel activeLabel = new JLabel("Active");
		activeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		activeLabel.setBounds(339, 367, 92, 30);
		body.add(activeLabel);

		JTextField fNameField = new JTextField(user.getFirstName());
		fNameField.setEditable(false);
		fNameField.setBounds(457, 204, 108, 21);
		body.add(fNameField);

		lNameField = new JTextField(user.getLastName());
		lNameField.setEditable(false);
		lNameField.setBounds(457, 231, 108, 21);
		body.add(lNameField);

		usernameField = new JTextField(user.getUsername());
		usernameField.setEditable(false);
		usernameField.setBounds(457, 260, 108, 21);
		body.add(usernameField);

		emailField = new JTextField(user.getEmail());
		emailField.setEditable(false);
		emailField.setBounds(457, 287, 108, 21);
		body.add(emailField);

		phoneField = new JTextField(user.getPhone());
		phoneField.setEditable(false);
		phoneField.setBounds(457, 317, 108, 21);
		body.add(phoneField);

		typeField = new JTextField(user.getRole());
		typeField.setEditable(false);
		typeField.setBounds(457, 345, 108, 21);
		body.add(typeField);

		activeField = new JTextField(Boolean.toString(user.isActive()));
		activeField.setEditable(false);
		activeField.setBounds(457, 373, 108, 21);
		body.add(activeField);

		JLabel lblUserDetails = new JLabel("User details");
		lblUserDetails.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUserDetails.setBounds(280, 125, 139, 62);
		body.add(lblUserDetails);

		JButton btnSuspend = new JButton("Suspend");
		btnSuspend.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuspend.setBounds(339, 401, 90, 25);
		btnSuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suspendConfirmation sc = new suspendConfirmation(sa, user);
				sc.frame.setVisible(true);
			}
		});
		body.add(btnSuspend);
	}
	public class suspendConfirmation extends JFrame{
		private JFrame frame;
		private JLabel confirmationLabel;

		public suspendConfirmation(SysAdmin sa,User user) {
			
			this.frame = new JFrame();
			this.frame.setBounds(300, 300, 450, 270);
			this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.frame.getContentPane().setLayout(null);

			confirmationLabel = new JLabel(String.format("Are you sure you want to suspend %s?", user.getUsername()));
			confirmationLabel.setBounds(95, 70, 300, 13);
			frame.getContentPane().add(confirmationLabel);
			
			JButton btnYes = new JButton("Yes");
			btnYes.setBounds(109, 93, 85, 21);
			btnYes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminController ac = new AdminController();
					boolean success = ac.suspendUser(sa,user.getUsername());
					if(success) {
						JOptionPane.showMessageDialog(null, "User suspended successfully");
					} else {
						JOptionPane.showMessageDialog(null, "User suspension failed");
					}
					frame.dispose();
				}
			});
			frame.getContentPane().add(btnYes);
			
			JButton btnNo = new JButton("No");
			btnNo.setBounds(246, 93, 85, 21);
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			frame.getContentPane().add(btnNo);
		}
	}
}