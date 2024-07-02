package Main;

import Event.Event01;
import Quizzes.Quiz01;

public class GameManager {
	
	ActionHandler aHandler = new ActionHandler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this);
	public SceneChanger sChanger = new SceneChanger(this);
	
	public Event01 ev1 = new Event01(this);
	
	public FinalResult fr = new FinalResult(this);
	
	
	public static void main(String[] args) {
		new GameManager();
		
		
	}
	
	public GameManager() {
		player.setPlayerDefaultStatus();
		// sChanger.showScene1();
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
