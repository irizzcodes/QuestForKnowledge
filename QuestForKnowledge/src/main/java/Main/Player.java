package Main;

public class Player {
	GameManager gm;
	
	public boolean hasLearnAddition;
	public boolean hasLearnSubtraction;
	public boolean hasLearnMultiplication;
	public boolean hasStudyAddition;
	public boolean hasStudySubtraction;
	public boolean hasStudyMultiplication;
	
	public int playerMaxKey;
	public int playerKey;
	
	public int hasKey;
	public int hasLantern;
	
	public Player(GameManager gm) {
		this.gm = gm;
	}
	
	public void setPlayerDefaultStatus() {
		hasLearnAddition = false; 
		hasLearnSubtraction = false;
		hasLearnMultiplication = false;
		hasStudyAddition = true; // switch to false later
		hasStudySubtraction = true; // switch to false later
		hasStudyMultiplication = true; // switch to false later
		
		playerMaxKey = 3;
		playerKey = 0;
		hasKey = 0;
		hasLantern = 0;
		
		updatePlayerStatus();
		
	}
	
	public void updatePlayerStatus() {
		// remove medals icon
		int i=1;
		while (i<4) {
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}
		int keyCount = playerKey;
		while(keyCount!=0) {
			gm.ui.lifeLabel[keyCount].setVisible(true);
			keyCount--;
		}
		
		// check player items
		if(hasKey==0) {
			gm.ui.keyLabel.setVisible(false);
		}
		if(hasKey==1) {
			gm.ui.keyLabel.setVisible(true);
		}
		
		if(hasLantern==0) {
			gm.ui.lanternLabel.setVisible(false);
		}
		if(hasLantern==1) {
			gm.ui.lanternLabel.setVisible(true);
		}

	}
	
	

}
