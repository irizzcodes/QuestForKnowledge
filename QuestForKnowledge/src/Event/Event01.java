package Event;

import Main.GameManager;

public class Event01 {
	GameManager gm;
	
	public Event01(GameManager gm) {
		this.gm = gm;
	}
	
	public void lookHut() {
		gm.ui.messageText.setText("This is your house");
	}
	
	public void talkHut() {
		gm.ui.messageText.setText("I'm a house, why are you talking to me?");
	}
	
	public void restHut() {
		gm.ui.messageText.setText("You rest at the house. \n Life has Recovered");
	}
	
	public void lookGuard() {
		gm.ui.messageText.setText("A man is standing in front of you");
	}
	
	public void talkGuard() {
		gm.ui.messageText.setText("Man: Hello Konnichiwa");
	}
	
	public void attackGuard() {
		gm.ui.messageText.setText("Man: Why are you hurting me? \n Remember, you have no enemy");
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
	

}
