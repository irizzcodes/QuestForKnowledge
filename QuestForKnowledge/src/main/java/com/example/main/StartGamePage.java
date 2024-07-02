package com.example.main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.GameManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartGamePage extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public StartGamePage() {
        setTitle("Start Game Page");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        JLayeredPane layeredPane = new JLayeredPane();
        setContentPane(layeredPane);

        // Background image
        JLabel lblNewLabel = new JLabel("");
        Image img = new ImageIcon("Pix/startgame.PNG").getImage();
        Image scaledImg = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(scaledImg));
        lblNewLabel.setBounds(0, 0, 1000, 600);
        layeredPane.add(lblNewLabel, JLayeredPane.DEFAULT_LAYER);

        // Buttons
        JButton btnStart = new JButton("Start");
        btnStart.setBounds(350, 451, 328, 30); // Positioning and sizing
        layeredPane.add(btnStart, JLayeredPane.PALETTE_LAYER);
        try {
            ImageIcon buttonImage = new ImageIcon("Pix/startbtn.PNG");
            btnStart.setIcon(buttonImage);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
        
        // Action listeners for the buttons
        btnStart.addActionListener(e -> startGame());
    }

    private void startGame() {
        // Logic to start the game using GameManager
        GameManager gameManager = new GameManager();
        gameManager.start();
        this.dispose();
    }

    private void gameSettings() {
        JOptionPane.showMessageDialog(this, "Opening game settings...");
        // Logic to open game settings
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StartGamePage frame = new StartGamePage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}