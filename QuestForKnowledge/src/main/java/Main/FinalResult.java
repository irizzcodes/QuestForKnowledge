package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FinalResult {
	GameManager gm;
	
	public int MaxScore;
	public int FirstScore;
	public int SecondScore;
	public int ThirdScore;
	
	JFrame frame = new JFrame();
	JTextField resultField = new JTextField();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	
	public FinalResult(GameManager gm) {
	    this.gm = gm;

	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(500, 500);
	    frame.getContentPane().setBackground(new Color(255, 208, 246)); 
	    frame.setLayout(null);
	    frame.setResizable(false);

	    resultField.setBounds(0, 0, 500, 50);
	    resultField.setBackground(new Color(255, 204, 153)); // Light orange
	    resultField.setForeground(new Color(0, 102, 204)); // Blue
	    resultField.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	    resultField.setBorder(BorderFactory.createLineBorder(new Color(255, 153, 51), 3)); // Orange border
	    resultField.setHorizontalAlignment(JTextField.CENTER);
	    resultField.setEditable(false);

	    textfield.setBounds(0, 50, 500, 50);
	    textfield.setBackground(new Color(239, 255, 153)); // Light orange
	    textfield.setForeground(new Color(0, 102, 204)); // Blue
	    textfield.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
	    textfield.setBorder(BorderFactory.createLineBorder(new Color(255, 153, 51), 3)); // Orange border
	    textfield.setHorizontalAlignment(JTextField.CENTER);
	    textfield.setEditable(false);

	    textarea.setBounds(15, 100, 460, 400);
	    textarea.setLineWrap(true);
	    textarea.setWrapStyleWord(true);
	    textarea.setBackground(new Color(255, 193, 229)); // Light yellow
	    textarea.setForeground(new Color(102, 0, 204)); // Purple
	    textarea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	    textarea.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 204), 3));
	    textarea.setEditable(false);
	}

		public void updateMaxScore() {
			MaxScore = (FirstScore + SecondScore + ThirdScore);
		}
		
		public void updateFinalResult() {
			
		updateMaxScore();
		
		String firstScorelow = "You got a low remarks on addition, you need to focus on studying addition a little bit harder. ";
		String firstScoremed = "You got a good understanding of addition although you still need to study a bit more. ";
		String firstScorehigh = "You got a high score in addition, a little bit more studying"
				+ "and you will master addition in no time. ";
		String firstScoreperf = "You got a perfect score on addition! You display total excellency in Addition! ";
		
		String secondScorelow = "You got low grades in subtraction therefore you need to put more time in studying it. ";
		String secondScoremed = "You have a grasp of subtraction but you still need to study it more. ";
		String secondScorehigh = "You got a high score in subtraction, just ounce more studying and you will excel on it. ";
		String secondScoreperf = "Great Job! You mastered subtraction! ";
		
		String thirdScorelow = "You got low score on multiplication, please study harder and put more time in learning it.";
		String thirdScoremed = "You know how to multiply but you still have a long way to go to master it!";
		String thirdScorehigh = "Nice! You got a high score in multiplication, a little bit more studying and you will master it.";
		String thirdScoreperf = "Amazing! You got a perfect score and you actually mastered multiplication!";
		
		String maxScorelow = "";
		String maxScoremed = "";
		String maxScorehigh = "";
		String maxScoreperf = "";
		
		resultField.setText("RESULTS!");
		textfield.setText("You got an overall score of: "+ MaxScore + "/30");
		
		// 1
		if(FirstScore<4) {
			if(SecondScore<4) {
				if(ThirdScore<4) {
					textarea.setText(firstScorelow + "Additionally, " + secondScorelow + "Lastly, " + thirdScorelow );
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorelow + "Additionally, " + secondScorelow + "Lastly, " + thirdScoremed );
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorelow + "Additionally, " + secondScorelow + "Lastly, " + thirdScorehigh );
				}
				else {
					textarea.setText(firstScorelow + "Additionally, " + secondScorelow + "Lastly, " + thirdScoreperf );
				}
			}
			else if(SecondScore<7) {
				if(ThirdScore<4) {
					textarea.setText(firstScorelow + "Additionally, " + secondScoremed + "Lastly, " + thirdScorelow );
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorelow + "Additionally, " + secondScoremed + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorelow + "Additionally, " + secondScoremed + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScorelow + "Additionally, " + secondScoremed + "Lastly, " + thirdScoreperf);
				}
			}
			else if(SecondScore<10) {
				if(ThirdScore<4) {
					textarea.setText(firstScorelow + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorelow + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorelow + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScorelow + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoreperf);
				}
			}
			else {
				if(ThirdScore<4) {
					textarea.setText(firstScorelow + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorelow + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorelow + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScorelow + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoreperf);
				}
			}
		}
		else if(FirstScore<7) {
			if(SecondScore<4) {
				if(ThirdScore<4) {
					textarea.setText(firstScoremed + "Additionally, " + secondScorelow + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoremed + "Additionally, " + secondScorelow + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoremed + "Additionally, " + secondScorelow + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoremed + "Additionally, " + secondScorelow + "Lastly, " + thirdScoreperf);
				}
			}
			else if(SecondScore<7) {
				if(ThirdScore<4) {
					textarea.setText(firstScoremed + "Additionally, " + secondScoremed + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoremed + "Additionally, " + secondScoremed + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoremed + "Additionally, " + secondScoremed + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoremed + "Additionally, " + secondScoremed + "Lastly, " + thirdScoreperf);
				}
			}
			else if(SecondScore<10) {
				if(ThirdScore<4) {
					textarea.setText(firstScoremed + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoremed + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoremed + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoremed + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoreperf);
				}
			}
			else {
				if(ThirdScore<4) {
					textarea.setText(firstScoremed + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoremed + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoremed + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoremed + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoreperf);
				}
			}
		}
		else if(FirstScore<10) {
			if(SecondScore<4) {
				if(ThirdScore<4) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorelow + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorelow + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorelow + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorelow + "Lastly, " + thirdScoreperf);
				}
			}
			else if(SecondScore<7) {
				if(ThirdScore<4) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoremed + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoremed + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoremed + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoremed + "Lastly, " + thirdScoreperf);
				}
			}
			else if(SecondScore<10) {
				if(ThirdScore<4) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScorehigh + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoreperf);
				}
			}
			else {
				if(ThirdScore<4) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScorehigh + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoreperf);
				}
			}
		}
		else {
			if(SecondScore<4) {
				if(ThirdScore<4) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorelow + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorelow + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorelow + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorelow + "Lastly, " + thirdScoreperf);
				}
			}
			else if(SecondScore<7) {
				if(ThirdScore<4) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoremed + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoremed + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoremed + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoremed + "Lastly, " + thirdScoreperf);
				}
			}
			else if(SecondScore<10) {
				if(ThirdScore<4) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorehigh + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoreperf + "Additionally, " + secondScorehigh + "Lastly, " + thirdScoreperf);
				}
			}
			else {
				if(ThirdScore<4) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorelow);
				}
				else if(ThirdScore<7) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoremed);
				}
				else if(ThirdScore<10) {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoreperf + "Lastly, " + thirdScorehigh);
				}
				else {
					textarea.setText(firstScoreperf + "Additionally, " + secondScoreperf + "Lastly, " + thirdScoreperf);
				}
			}
		}
		
		
		frame.add(textfield);
		frame.add(textarea);
		frame.add(resultField);
		frame.setVisible(true);
	}
	
	
	
	
	
	// GETTER AND SETTERS 
	public int getFirstScore() {
		return FirstScore;
	}

	public void setFirstScore(int firstScore) {
		FirstScore = firstScore;
	}

	public int getSecondScore() {
		return SecondScore;
	}

	public void setSecondScore(int secondScore) {
		SecondScore = secondScore;
	}

	public int getThirdScore() {
		return ThirdScore;
	}

	public void setThirdScore(int thirdScore) {
		ThirdScore = thirdScore;
	}

}


