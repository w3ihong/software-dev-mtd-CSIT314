package boundary;
import javax.swing.*;
import control.AdminController;
import control.AdminSearchUserAccountController;
import entity.User;
import java.sql.ResultSet;
import entity.SysAdmin;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.*;

public class AdminHandler extends JFrame{

    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel body;
	private JPanel listPanel;
	private JScrollPane scrollPane;	
	private JTextField searchField;




	public AdminHandler(SysAdmin sa) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();


		setContentPane(contentPane);
		setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		//page split into 3 sections
		JPanel header = new JPanel();
		contentPane.add(header);
		JPanel subHeader = new JPanel();
		body = new JPanel();
		contentPane.add(subHeader);
		contentPane.add(body);

		//header
		header.setLayout(new FlowLayout());
		header.setPreferredSize(new Dimension(900, 40));
		header.setBackground(Color.LIGHT_GRAY);
		header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                UserHandler uh = new UserHandler();
                AdminHandler.this.dispose();
                uh.runProgram();
			}
		});
		
		JLabel homeLabel = new JLabel("Home");
		homeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Home clicked");
			}
		});

		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(640, 20));
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
		header.add(btnNewButton);

		//subheader
		subHeader.setPreferredSize(new Dimension(900,60));
		subHeader.setLayout(new FlowLayout());

		JLabel subheaderLabel = new JLabel("Admin Dashboard");
		subheaderLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(150, 27));
		searchField.setText("Search");
		searchField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchField.getText().equals("Search")) {
					searchField.setText(""); 
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (searchField.getText().isEmpty()) {
					searchField.setText("Search");
				}
			}
		});
		
		JPanel subHeadspacer = new JPanel();
		subHeadspacer.setPreferredSize(new Dimension(150, 20));
		JPanel topmargin = new JPanel();
		topmargin.setPreferredSize(new Dimension(900, 10));

		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.out.println("Search clicked");
			listPanel.removeAll(); // Always clear the panel first

			if (searchField.getText().equals("") || searchField.getText().equals("Search")) {
				// If the search field is empty or says "Search", repopulate it with all users
				AdminController ac = new AdminController();
				ResultSet rs = ac.displayUsers(sa);
				try {
					while (rs.next()) {
						User user = new User(rs.getString("fName"), rs.getString("lName"), rs.getString("phone"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getBoolean("active"));
						ListItem item = new ListItem(user, sa);
						listPanel.add(item);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try {
						if (rs != null) rs.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} else {
				// If the search field is not empty or "Search", clear the list panel and do not repopulate it
				// This is for testing to see behavior when search field has content
				// If the search field is empty or says "Search", repopulate it with all users
				AdminSearchUserAccountController ac = new AdminSearchUserAccountController();
				ResultSet rs = ac.SearchUserAccount(sa, searchField.getText());
				try {
					while (rs.next()) {
						User user = new User(rs.getString("fName"), rs.getString("lName"), rs.getString("phone"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getBoolean("active"));
						ListItem item = new ListItem(user, sa);
						listPanel.add(item);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try {
						if (rs != null) rs.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}

			// Revalidate and repaint the list panel to reflect changes
			listPanel.revalidate();
			listPanel.repaint();
		}
	});
		
		JButton createUPButton = new JButton("Create");

		createUPButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Create User/Property clicked");
			}
		});

		subHeader.add(topmargin);
		subHeader.add(subheaderLabel);
		subHeader.add(subHeadspacer);
		subHeader.add(searchField);
		subHeader.add(searchButton);
		subHeader.add(createUPButton);
		
		//body
		body.setLayout(new FlowLayout());
		body.setPreferredSize(new Dimension(900, 500));
		//add JScrollPane to list users 
		listPanel = new JPanel();
		scrollPane = new JScrollPane(listPanel);
		scrollPane.setPreferredSize(new Dimension(600, 480));
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		
		AdminController ac = new AdminController();

		// for each item in list of users, create a panel with user details and append to listPanel
		ResultSet rs = ac.displayUsers(sa);
		//get size of the result set
		for (int i = 0; i < 30; i++) {
			try {
				rs.next();
				User user = new User(rs.getString("fName"), rs.getString("lName"), rs.getString("phone"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getBoolean("active"));
				ListItem item = new ListItem(user, sa);
				listPanel.add(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		body.add(scrollPane);
	}

	public class ListItem extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel username;
		private JLabel role;
		private JButton viewButton;

		public ListItem(User user, SysAdmin sa) {
			
			this.setLayout(new FlowLayout());
			this.setPreferredSize(new Dimension(600, 50));
			this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

			this.username = new JLabel(user.getUsername());
			this.role = new JLabel(user.getRole());
			this.viewButton = new JButton("Manage");
			JPanel spacer = new JPanel();

			this.username.setPreferredSize(new Dimension(150, 40));
			this.role.setPreferredSize(new Dimension(100, 40));
			spacer.setPreferredSize(new Dimension(150, 40));

			this.add(this.username);
			this.add(this.role);
			this.add(spacer);
			this.add(this.viewButton);

			this.viewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// terminate current window and open admin view account window
					AdminViewAccount ava = new AdminViewAccount(sa,user);
					ava.setVisible(true);
					AdminHandler.this.dispose();

				}
			});
		}
	}
}

