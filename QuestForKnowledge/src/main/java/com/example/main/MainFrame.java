package com.example.main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.example.model.User;
import com.example.repository.UserRepository;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(() -> {
	        try {
	            MainFrame frame = new MainFrame();
	            frame.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    });
	}

	
	 public MainFrame() {
	        setTitle("Quest For Knowledge");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 1000, 600);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel = new JLabel("");
	        Image img = new ImageIcon(this.getClass().getResource("/LoginBG.JPG")).getImage();
	        Image scaledImg = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
	        lblNewLabel.setIcon(new ImageIcon(scaledImg));
	        lblNewLabel.setBounds(0, 0, 1000, 600);
	        contentPane.add(lblNewLabel);

	        JLabel textLabel = new JLabel("Welcome to Quest For Knowledge");
	        textLabel.setForeground(Color.WHITE);
	        textLabel.setBounds(50, 50, 300, 30);
	        contentPane.add(textLabel);

	        JButton btnLogin = new JButton("Login");
	        btnLogin.setBounds(500, 429, 300, 52);
	        try {
	            ImageIcon buttonImage = new ImageIcon("Pix/Login.JPG");
	            Image scaledImage = buttonImage.getImage().getScaledInstance(300, 52, Image.SCALE_SMOOTH);
	            Icon scaledIcon = new ImageIcon(scaledImage);
	            btnLogin.setIcon(scaledIcon);
	        } catch (Exception e) {
	            System.err.println("Error loading image: " + e.getMessage());
	        }
	        contentPane.add(btnLogin);

	        JButton btnRegister = new JButton("Register");
	        btnRegister.setBounds(500, 502, 300, 30);
	        try {
	            ImageIcon buttonImage1 = new ImageIcon("Pix/register.JPG");
	            Image scaledImage1 = buttonImage1.getImage().getScaledInstance(300, 52, Image.SCALE_SMOOTH);
	            Icon scaledIcon1 = new ImageIcon(scaledImage1);
	            btnRegister.setIcon(scaledIcon1);
	        } catch (Exception e) {
	            System.err.println("Error loading image: " + e.getMessage());
	        }
	        contentPane.add(btnRegister);

	        btnLogin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new Thread(() -> showLoginDialog()).start();
	            }
	        });

	        btnRegister.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new Thread(() -> showRegisterDialog()).start();
	            }
	        });
	    }

	    private void showLoginDialog() {
	        JDialog loginDialog = new JDialog(this, "Please Log-In", true);
	        loginDialog.setSize(400, 400);
	        loginDialog.setLocationRelativeTo(this);

	        JPanel loginPanel = new JPanel(new GridBagLayout());
	        loginPanel.setBackground(new Color(60, 63, 65));
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10);

	        JLabel usernameLabel = new JLabel("Username:");
	        usernameLabel.setForeground(Color.WHITE);
	        JTextField usernameField = new JTextField(20);
	        JLabel emailLabel = new JLabel("Email:");
	        emailLabel.setForeground(Color.WHITE);
	        JTextField emailField = new JTextField(20);
	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setForeground(Color.WHITE);
	        JPasswordField passwordField = new JPasswordField(20);

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.EAST;
	        loginPanel.add(usernameLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;
	        loginPanel.add(usernameField, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.anchor = GridBagConstraints.EAST;
	        loginPanel.add(emailLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.anchor = GridBagConstraints.WEST;
	        loginPanel.add(emailField, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.anchor = GridBagConstraints.EAST;
	        loginPanel.add(passwordLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        loginPanel.add(passwordField, gbc);

	        JButton loginBtn = new JButton("Login");
	        loginBtn.setBackground(new Color(75, 110, 175));
	        loginBtn.setForeground(Color.WHITE);
	        loginBtn.setFocusPainted(false);

	        loginBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new Thread(() -> {
	                    String username = usernameField.getText();
	                    String email = emailField.getText();
	                    String password = new String(passwordField.getPassword());

	                    if (validateLogin(username, email, password)) {
	                        JOptionPane.showMessageDialog(loginDialog, "Login successful.");
	                        loginDialog.dispose();
	                        openStartGamePage();
	                    } else {
	                        JOptionPane.showMessageDialog(loginDialog, "Invalid username, email, or password.");
	                    }
	                }).start();
	            }
	        });

	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.CENTER;
	        loginPanel.add(loginBtn, gbc);

	        loginDialog.getContentPane().add(loginPanel);
	        loginDialog.setVisible(true);
	    }

	    

	    private void showRegisterDialog() {
	        JDialog registerDialog = new JDialog(this, "Register", true);
	        registerDialog.setSize(400, 400);
	        registerDialog.setLocationRelativeTo(this);

	        JPanel registerPanel = new JPanel(new GridBagLayout());
	        registerPanel.setBackground(new Color(60, 63, 65));
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10);

	        JLabel usernameLabel = new JLabel("Username:");
	        usernameLabel.setForeground(Color.WHITE);
	        JTextField usernameField = new JTextField(20);
	        JLabel emailLabel = new JLabel("Email:");
	        emailLabel.setForeground(Color.WHITE);
	        JTextField emailField = new JTextField(20);
	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setForeground(Color.WHITE);
	        JPasswordField passwordField = new JPasswordField(20);

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.EAST;
	        registerPanel.add(usernameLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;
	        registerPanel.add(usernameField, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.anchor = GridBagConstraints.EAST;
	        registerPanel.add(emailLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.anchor = GridBagConstraints.WEST;
	        registerPanel.add(emailField, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.anchor = GridBagConstraints.EAST;
	        registerPanel.add(passwordLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.anchor = GridBagConstraints.WEST;
	        registerPanel.add(passwordField, gbc);

	        JButton registerBtn = new JButton("Register");
	        registerBtn.setBackground(new Color(75, 110, 175));
	        registerBtn.setForeground(Color.WHITE);
	        registerBtn.setFocusPainted(false);

	        registerBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new Thread(() -> {
	                    String username = usernameField.getText();
	                    String email = emailField.getText();
	                    String password = new String(passwordField.getPassword());

	                    if (registerUser(username, email, password)) {
	                        JOptionPane.showMessageDialog(registerDialog, "Registration successful.");
	                        registerDialog.dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(registerDialog, "Registration failed. Username or email might be already in use.");
	                    }
	                }).start();
	            }
	        });

	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.CENTER;
	        registerPanel.add(registerBtn, gbc);

	        registerDialog.getContentPane().add(registerPanel);
	        registerDialog.setVisible(true);
	    }
	    
	    private void openStartGamePage() {
	        SwingUtilities.invokeLater(() -> {
	            StartGamePage startGamePage = new StartGamePage();
	            startGamePage.setVisible(true);
	            this.dispose(); // Close the current window
	        });
	    }

	    private boolean validateLogin(String username, String email, String password) {
	        UserRepository userRepository = new UserRepository();
	        return userRepository.validateUser(username, email, password);
	    }

	    private boolean registerUser(String username, String email, String password) {
	        UserRepository userRepository = new UserRepository();
	        User user = new User(username, password, email);
	        return userRepository.registerUser(user);
	    }
	}