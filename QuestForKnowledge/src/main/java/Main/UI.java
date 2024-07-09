package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
	GameManager gm;
	JFrame window;

	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];
	
	// plyaer ui
	JPanel lifePanel; // make this a knowledge medal later 
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	
	public JLabel swordLabel, shieldLabel, lanternLabel, keyLabel; // rl
	
	public UI(GameManager gm) {
		this.gm = gm;
		
		createMainField();
		
		createPlayerField();
		
		generateScene();
		
		window.setVisible(true);
				
	}
	
	
	public void createMainField() {
		window = new JFrame(); 
		window.setTitle("Quest for Knowledge");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		messageText = new JTextArea("Your quest for knowledge has begun!");
		messageText.setBounds(50,400,700,150);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26 )); // set font style 
		window.add(messageText);
	}

	public void createBackground(int bgNum, String bgFileName) {
		
		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50,50,700,350);
		bgPanel[bgNum].setBackground(Color.black);
		bgPanel[bgNum].setLayout(null);
		window.add(bgPanel[bgNum]);
		
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);
		
		
	}
	
	public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName, String choiceName, String
			choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command) {
		
		//create pop menu
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem menuItem[] = new JMenuItem[4];
		
		//create menu items
		menuItem[1] = new JMenuItem(choiceName);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(choice1Command);
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(choice2Command);
		popMenu.add(menuItem[2]);
		
		menuItem[3] = new JMenuItem(choice3Name);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(choice3Command);
		popMenu.add(menuItem[3]);
		
		
		//Create Object
		JLabel objectLabel1 = new JLabel();
		objectLabel1.setBounds(objx,objy,objWidth,objHeight);
		// Remove Comments to see the hit boxes of objects
		//objectLabel1.setOpaque(true);
		//objectLabel1.setBackground(Color.blue);
		
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel1.setIcon(objectIcon);
		
		
		objectLabel1.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popMenu.show(objectLabel1, e.getX(), e.getY());
				}
			}

			public void mouseReleased(MouseEvent e) {
			
			}

			public void mouseEntered(MouseEvent e) {
			
			}

			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		
		bgPanel[bgNum].add(objectLabel1);
		
	}
	
	public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command ) {
		ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
		
		JButton arrowButton = new JButton();
		arrowButton.setBounds(x,y, width, height);
		arrowButton.setBackground(null);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setFocusPainted(false);
		arrowButton.setIcon(arrowIcon);
		arrowButton.addActionListener(gm.aHandler);
		arrowButton.setActionCommand(command);
		arrowButton.setBorderPainted(false);
		
		bgPanel[bgNum].add(arrowButton);
		
	}
	
	public void createPlayerField() {
		lifePanel = new JPanel();
		lifePanel.setBounds(50,0,150,50);
		lifePanel.setBackground(Color.black);
		lifePanel.setLayout(new GridLayout(1,3));
		window.add(lifePanel);
		
		ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("medal.png"));
		// Image image = lifeIcon.getImage().getScaledInstance(0, 0, image.SCALE_DEFAULT); // for changing size
		// lifeIcon = new 	ImageIcon(image);
		
		int i=1;
		while(i<4) {
			lifeLabel[i] = new JLabel();
			lifeLabel[i].setIcon(lifeIcon);
			lifePanel.add(lifeLabel[i]);
			i++;
		}
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(650,0,100,50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1,3));
		window.add(inventoryPanel);
		
		//create items
		keyLabel = new JLabel();
		ImageIcon keyIcon = new ImageIcon(getClass().getClassLoader().getResource("key.png"));
		Image image = keyIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT); // for changing size
		keyIcon = new 	ImageIcon(image);
		keyLabel.setIcon(keyIcon);
		inventoryPanel.add(keyLabel);
		
		lanternLabel = new JLabel();
		ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("lanternflame.png"));
		lanternLabel.setIcon(lanternIcon);
		inventoryPanel.add(lanternLabel);
		
		
	}
	
	public void generateScene() {
		// Scene 1 
		createBackground(1,"School.png");
		createObject(1,340,70,300,255,"blank.png","Look","Enter","","lookSchool","enterSchool","restHut");
		createObject(1,170,180,100,150,"master.png","Look","Talk","Quest","lookMaster","talkMaster","questMaster");
		createArrowButton(1,0,150,50,50,"sideleft.png","goScene2");
		createArrowButton(1,650,150,50,50,"sideright.png","goScene5");
		bgPanel[1].add(bgLabel[1]);
		
		// Scene 2
		createBackground(2,"castle.png");
		createObject(2,80,100,270,200,"blank.png","Look","Enter","","lookCastle","enterCastle","");
		createObject(2,470,270,100,100,"woodchest.png","Look","Talk","Open","lookChest","talkChest","openChest");
		createArrowButton(2,650,200,50,50,"sideright.png","goScene1");
		bgPanel[2].add(bgLabel[2]);
		
		// Scene 3
		createBackground(3,"Library.jpg");
		createObject(3,100,120,130,200,"blank.png","Look","Talk","Take a Quiz","lookTeacher","talkTeacher","takeQuiz2");
		createObject(3,370,80,100,100,"glow.png","Look","Read","","lookSubtraction","readSubtraction","");
		createArrowButton(3,650,200,50,50,"sideright.png","goScene1");
		bgPanel[3].add(bgLabel[3]);
		
		// Scene 4
		createBackground(4,"library.png");
		createObject(4,170,150,100,150,"wizard.png","Look","Talk","Take a Quiz","lookWizard","talkWizard","takeQuiz3");
		createObject(4,390,80,100,100,"glow.png","Look","Read","","lookMultiplication","readMultiplication","");
		createArrowButton(4,0,150,50,50,"sideleft.png","goScene2");
		bgPanel[4].add(bgLabel[4]);
		
		// Scene 5
		createBackground(5,"Farm.png");
		createObject(5,550,150,120,120,"farmer.png","Look","Talk","Take a Quiz","lookFarmer","talkFarmer","takeQuiz1");
		createObject(5,200,130,100,100,"woodchest.png","Look","Talk","Open","lookChest","talkChest","readAddition");
		createArrowButton(5,0,150,50,50,"sideleft.png","goScene1");
		bgPanel[5].add(bgLabel[5]);
		
		
		
	} 
}
