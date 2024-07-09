package Lessons;

import javax.swing.*;

import Main.GameManager;

import java.awt.*;
import java.io.IOException;

public class Multiplication {
	GameManager gm;
    JFrame frame = new JFrame();
    JTextArea textarea = new JTextArea();

    public Multiplication(GameManager gm) {
    	this.gm = gm;
        // Setup frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 500);
        frame.getContentPane().setBackground(Color.black); // Pink background
        frame.setLayout(null);
        frame.setResizable(false);


        // Setup background image label
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 900, 450);
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("multiplication.png"));
        backgroundLabel.setIcon(backgroundImageIcon);

        // Add components to frame
        frame.add(backgroundLabel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
     