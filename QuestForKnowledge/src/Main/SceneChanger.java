package Main;

public class SceneChanger {
	
	GameManager gm;

	public SceneChanger(GameManager gm) {
		
		this.gm = gm;
		
	}
	
	public void showScene1() {
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("");
	}
	
	public void showScene2() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("");
	}
	
	public void showScene3( ) {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("");
		
	}
	
	public void showScene4() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(true);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("");
	}
	
	public void showScene5() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(true);
		gm.ui.messageText.setText("");
	}
	
}
