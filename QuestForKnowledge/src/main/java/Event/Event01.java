package Event;

import Main.FinalResult;
import Main.GameManager;
import Quizzes.Quiz01;
import Quizzes.Quiz02;
import Quizzes.Quiz03;
import Lessons.Addition;
import Lessons.Multiplication;
import Lessons.Subtraction;

public class Event01 {
	GameManager gm;
	
	public Event01(GameManager gm) {
		this.gm = gm;
	}
	
	public void getFirst() {
		gm.ui.messageText.setText("is :" + gm.fr.getFirstScore());
	}
	
	public void lookChest() {
		gm.ui.messageText.setText("A chest on the ground");
	}
	
	public void talkChest() {
		gm.ui.messageText.setText("You talk to the chest but nothing happen");
	}
	
	public void openChest() {
		if(gm.player.hasLantern==0) {
			gm.ui.messageText.setText("You open the chest and find a lantern");
			gm.player.hasLantern=1;
			gm.player.updatePlayerStatus();
		}
		else {
			gm.ui.messageText.setText("You open the chest and find nothing");
		}
	}
	
	public void lookSubtraction() {
		gm.ui.messageText.setText("A book containing knowledge of subtraction");
	}
	
	public void lookMultiplication() {
		gm.ui.messageText.setText("A book containing knowledge of multiplication");
	}
	
	public void readAddition() {
		if(gm.player.hasStudyAddition==false) {
			gm.ui.messageText.setText("You have studied addition from the book in the chest");
			Addition addition = new Addition(gm);
			gm.player.hasStudyAddition=true;
			gm.player.updatePlayerStatus();
		}
		else {
			Addition addition = new Addition(gm);
			gm.ui.messageText.setText("You reviewed addition from the book in the chest");
		}
	}
	
	public void readSubtraction() {
		if(gm.player.hasStudySubtraction==false) {
			gm.ui.messageText.setText("You have studied subtraction");
			Subtraction sub = new Subtraction(gm);
			gm.player.hasStudySubtraction=true;
			gm.player.updatePlayerStatus();
		}
		else {
			Subtraction sub = new Subtraction(gm);
			gm.ui.messageText.setText("You reviewed subtraction");
		}
	}
	
	public void readMultiplication() {
		if(gm.player.hasStudyMultiplication==false) {
			gm.ui.messageText.setText("You have studied multiplication");
			Multiplication mul = new Multiplication(gm);
			gm.player.hasStudyMultiplication=true;
			gm.player.updatePlayerStatus();
		}
		else {
			Multiplication mul = new Multiplication(gm);
			gm.ui.messageText.setText("You reviewed multiplication");
		}
	}
	
	
	// Routes
	
	public void lookSchool() {
		gm.ui.messageText.setText("This looks like a school made for learning subtraction");
	}
	
	public void enterSchool() {
		gm.sChanger.showScene3();
	}
	
	public void lookCastle() {
		gm.ui.messageText.setText("An old castle that seems to be covered by vines and grasses");
	}
	
	public void enterCastle() {
		if(gm.player.hasLantern==1) {
			gm.sChanger.showScene4();
		}
		else {
			gm.ui.messageText.setText("It's too dark inside, you need something to lighten up the path to navigate the castle");
		}
	}
	
	//People
	public void lookMaster() {
		gm.ui.messageText.setText("A wise man is standing in front of you, looking at you positively!");
	}
	
	public void talkMaster() {
		gm.ui.messageText.setText("Man: Hello there, embark on the quest of knowledge!"
				+ " Learn all basic mathematics and receive enlightenment by receiving all"
				+ " the three medals. If you do so, come back to me again to finish your quest"
				+ " of knowledge");
	}
	
	public void questMaster() {
		if(gm.player.playerKey==gm.player.playerMaxKey) {
			gm.ui.messageText.setText("You finally finished your quest of knowledge!");
			gm.fr.updateFinalResult();
		}
		else {
			gm.ui.messageText.setText("Man: You still haven't receive all the medals, come"
					+ "back to me if you already collected them all");
		}
	}
	
	public void lookWizard() {
		gm.ui.messageText.setText("You see an old man happily reading and studying the books he has");
	}
	
	public void talkWizard() {
		if (gm.player.hasLearnMultiplication == true) {
			gm.ui.messageText.setText("Old Man: I shall again congratulate you for learning multiplication!");
		} else {
		gm.ui.messageText.setText("Old Man: hohoho, grab a book my dear, learn the fantastic world"
				+ " of multiplication. After you're done, I'm gonna test your potential in multiplying");
		}
	}
	
	public void lookFarmer() {
		gm.ui.messageText.setText("You see a farmer in front of you carefully counting his carrots");
	}
	
	public void talkFarmer() {
		if (gm.player.hasLearnAddition == true) {
			gm.ui.messageText.setText("Farmer: Thank you again for taking my quiz! Please"
					+ " have a nice day.");
		} else {
		gm.ui.messageText.setText("Farmer: I love counting carrots, I learn how to count thanks to the"
				+ " scroll my father gave me which I remember storing it in my vault."
				+ " I can test your mastery of addition if you'll learn it and grant you a"
				+ " medal after");
		}
	}
	
	public void lookTeacher() {
		gm.ui.messageText.setText("The teacher is happily reviewing her lessons.");
	}
	
	public void talkTeacher() {
		if (gm.player.hasLearnSubtraction == true) {
			gm.ui.messageText.setText("Teacher: You done great, don't forget to review sometimes!");
		} else {
			gm.ui.messageText.setText("Teacher: Did you know that subtraction is fun? Please"
					+ " find a book that you'll like. If you want to test your knowledge, "
					+ "come to and I'll test your wits in subtraction");
		}
		
	}
	
	
	//Quizzes
	
	public void takeQuiz1() {
		if (gm.player.hasLearnAddition == false) {
			if (gm.player.hasStudyAddition == true) {
				Quiz01 quiz1 = new Quiz01(gm);
				gm.player.playerKey++;
				gm.player.updatePlayerStatus();
				gm.player.hasLearnAddition = true;
				gm.ui.messageText.setText("Farmer: Thank you for taking my quiz, I'll grant"
						+ " you this medal yippee!");
			}
			else {
				gm.ui.messageText.setText("Farmer: You need to study addition first");
			}
		}
		else {
			gm.ui.messageText.setText("Farmer: You already take the quiz");
		}
	}
	
	public void takeQuiz2() {
		if (gm.player.hasLearnSubtraction == false) {
			if (gm.player.hasStudySubtraction == true) {
				Quiz02 quiz2 = new Quiz02(gm);
				gm.player.playerKey++;
				gm.player.updatePlayerStatus();
				gm.player.hasLearnSubtraction = true;
				gm.ui.messageText.setText("Teacher: You've done great for you quiz, please have"
						+ " this medal as your recognition for your effort! ");
			}
			else {
				gm.ui.messageText.setText("Teacher: You need to study subtraction first");
			}
		}
		else {
			gm.ui.messageText.setText("Teacher: You already take the quiz");
		}
		
	}
	
	public void takeQuiz3() {
		if (gm.player.hasLearnMultiplication == false) {
			if (gm.player.hasStudyMultiplication == true) {
				Quiz03 quiz3 = new Quiz03(gm);
				gm.player.playerKey++;
				gm.player.updatePlayerStatus();
				gm.player.hasLearnMultiplication = true;
				gm.ui.messageText.setText("Old Man: Congratulations for taking my quiz! I shall"
						+ " grant you this medal for your thirst of knowledge");
			}
			else {
				gm.ui.messageText.setText("Old Man: You need to study multiplication first");
			}
		}
		else {
			gm.ui.messageText.setText("Old Man: You already take the quiz");
		}
		
	}

}
