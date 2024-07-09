package Quizzes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Main.GameManager;

public class Quiz03 implements ActionListener{
	GameManager gm;
	
	String[] questions = 	{
								"What is 12 + 26?",
								"What is 19 + 18?",
								"What is 24 + 22?",
								"What is 13 + 34?",
								"What is 12 + 15?",
								"What is 226 + 442?",
								"What is 74 + 11?",
								"What is 26 + 76?",
								"What is 38 + 73?",
								"What is 815 + 400?"
							};
	String[][] options = 	{
								{"38","48","11","44"},
								{"35","37","40","39"},
								{"50","44","46","64"},
								{"45","57","40","47"},
								{"37","27","25","23"},
								{"668","666","696","656"},
								{"90","75","95","85"},
								{"92","96","102","112"},
								{"109","101","111","99"},
								{"1165","1215","1315","1115"},
								
								
							};
	char[] answers = 		{
								'A',
								'B',
								'C',
								'D',
								'B',
								'A',
								'D',
								'C',
								'C',
								'B'
							};
	char guess;
	char answer;
	int index;
	int correct_guesses =0;
	int total_questions = questions.length;
	int result;
	int seconds=90;
	
		
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Quiz03(GameManager gm) {
		this.gm = gm;
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(504, 763);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(220, 255, 220)); // Light mint green

        textfield.setBounds(0, 0, 504, 50);
        textfield.setBackground(new Color(255, 182, 193)); // Light pink
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Arial", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(25, 60, 454, 80);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(Color.WHITE);
        textarea.setForeground(Color.BLACK);
        textarea.setFont(new Font("Arial", Font.PLAIN, 20));
        textarea.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
        textarea.setEditable(false);

        buttonA.setBounds(25, 160, 220, 80);
        buttonA.setFont(new Font("Arial", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");
        buttonA.setBackground(new Color(135, 206, 250)); // Light blue
        buttonA.setBorder(new RoundedBorder(20));

        buttonB.setBounds(259, 160, 220, 80);
        buttonB.setFont(new Font("Arial", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");
        buttonB.setBackground(new Color(255, 182, 193)); // Light pink
        buttonB.setBorder(new RoundedBorder(20));

        buttonC.setBounds(25, 260, 220, 80);
        buttonC.setFont(new Font("Arial", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");
        buttonC.setBackground(new Color(144, 238, 144)); // Light green
        buttonC.setBorder(new RoundedBorder(20));

        buttonD.setBounds(259, 260, 220, 80);
        buttonD.setFont(new Font("Arial", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");
        buttonD.setBackground(Color.YELLOW);
        buttonD.setBorder(new RoundedBorder(20));

        time_label.setBounds(200, 350, 100, 30);
        time_label.setBackground(null);
        time_label.setForeground(Color.BLACK);
        time_label.setFont(new Font("Arial", Font.BOLD, 20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("TIME:");

        seconds_left.setBounds(200, 380, 100, 50);
        seconds_left.setBackground(new Color(255, 105, 180)); // Hot pink
        seconds_left.setForeground(Color.WHITE);
        seconds_left.setFont(new Font("Arial", Font.BOLD, 30));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);
        
        nextQuestion();
    }
    
	public void nextQuestion() {
	    if (index >= total_questions) {
	        results();
	    } else {
	        textfield.setText("Question " + (index + 1));
	        textarea.setText(questions[index]);
	        buttonA.setText("A. " + options[index][0]);
	        buttonB.setText("B. " + options[index][1]);
	        buttonC.setText("C. " + options[index][2]);
	        buttonD.setText("D. " + options[index][3]);
	        timer.start();
	    }
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        if(e.getSource()==buttonA) {
            answer= 'A';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonB) {
            answer= 'B';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonC) {
            answer= 'C';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonD) {
            answer= 'D';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        displayAnswer();
    }
    
    public void displayAnswer() {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer = ' ';
                seconds = 90;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    
    public void results() {
        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);
        
        result = (int)((correct_guesses/(double)total_questions)*100);
        gm.fr.setThirdScore(correct_guesses);
        
        
        textfield.setText("RESULTS!");
        textarea.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        textarea.setBackground(new Color(255, 253, 208)); // Light yellow
        
        String message;
        Color messageColor;
        if (result >= 80) {
            message = "Quiz Done!";
            messageColor = new Color(50, 205, 50); // Limegreen
        } else {
            message = "Quiz Done!";
            messageColor = new Color(255, 99, 71); // Tomato
        }
        textarea.setText(message);
        textarea.setForeground(messageColor);
        
        number_right = new JTextField();
        percentage = new JTextField();
        
        number_right.setBounds(125, 225, 250, 100);
        number_right.setBackground(new Color(173, 216, 230)); // Light blue
        number_right.setForeground(new Color(25,25,25));
        number_right.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);
        number_right.setText(correct_guesses + "/" + total_questions);
        
        percentage.setBounds(125, 325, 250, 100);
        percentage.setBackground(new Color(255, 182, 193)); // Light pink
        percentage.setForeground(new Color(25,25,25));
        percentage.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);
        percentage.setText(result + "%");
        
        frame.add(number_right);
        frame.add(percentage);
        
        timer.stop();
        seconds_left.setVisible(false);
        time_label.setVisible(false);
        
        // Add a button with conditional behavior
        JButton actionButton = new JButton(result >= 80 ? "Continue" : "Continue");
        actionButton.setBounds(175, 450, 150, 50);
        actionButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        actionButton.setBackground(new Color(144, 238, 144)); // Light green
        actionButton.addActionListener(e -> {
            if (result >= 80) {
                // Return to GameManager
                frame.dispose();
               // Assuming there's a method in GameManager to show its GUI
            } else {
                // Restart the quiz
                frame.dispose();
                
            }
        });
        frame.add(actionButton);
        
        frame.repaint();
    }
    
    private class RoundedBorder implements Border {
        private int radius;
        
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        
        public boolean isBorderOpaque() {
            return true;
        }
        
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}