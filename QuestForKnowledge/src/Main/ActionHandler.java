package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	GameManager gm;
	
	public ActionHandler(GameManager gm) {
		this.gm = gm;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		case "restHut": gm.ev1.getFirst(); break;
		case "lookChest": gm.ev1.lookChest();  break;
		case "talkChest": gm.ev1.talkChest();  break;
		case "openChest": gm.ev1.openChest();  break;
		
		//Routes
		case "lookSchool": gm.ev1.lookSchool(); break;
		case "enterSchool": gm.ev1.enterSchool(); break;
		case "lookCastle": gm.ev1.lookCastle(); break;
		case "enterCastle": gm.ev1.enterCastle(); break;
		
		//People
		case "lookTeacher": gm.ev1.lookTeacher(); break;
		case "talkTeacher": gm.ev1.talkTeacher(); break;
		case "lookFarmer": gm.ev1.lookFarmer(); break;
		case "talkFarmer": gm.ev1.talkFarmer(); break;
		case "lookMaster": gm.ev1.lookMaster(); break;
		case "talkMaster": gm.ev1.talkMaster(); break;
		case "questMaster": gm.ev1.questMaster(); break;
		case "lookWizard": gm.ev1.lookWizard(); break;
		case "talkWizard": gm.ev1.talkWizard(); break;
		
		//quizzes
		case "takeQuiz1": gm.ev1.takeQuiz1(); break;
		case "takeQuiz2": gm.ev1.takeQuiz2(); break;
		case "takeQuiz3": gm.ev1.takeQuiz3(); break;
		
		//change scenes
		case "goScene1": gm.sChanger.showScene1(); break;
		case "goScene2": gm.sChanger.showScene2(); break;
		case "goScene3": gm.sChanger.showScene3(); break;
		case "goScene4": gm.sChanger.showScene4(); break;
		case "goScene5": gm.sChanger.showScene5(); break;
		}
		
	}
	
	

}
