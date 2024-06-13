package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
	
	public UI(GameManager gm) {
		this.gm = gm;
		
		createMainField();
		
		generateScreen();
		
		window.setVisible(true);
				
	}
	
	public void createMainField() {
		window = new JFrame(); 
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		messageText = new JTextArea("THIS IS ");
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
		window.add(bgPanel[1]);
		
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("grassfield.png"));
		bgLabel[1].setIcon(bgIcon);
		
		
	}
	
	public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName, String choiceName, String
			choice2Name, String choice3Name) {
		
		//create pop menu
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem menuItem[] = new JMenuItem[4];
		
		//create menu items
		menuItem[1] = new JMenuItem(choiceName);
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2Name);
		popMenu.add(menuItem[2]);
		
		menuItem[3] = new JMenuItem(choice3Name);
		popMenu.add(menuItem[3]);
		
		
		//Create Object
		JLabel objectLabel1 = new JLabel();
		//objectLabel1.setBounds(350,100,300,255);
		objectLabel1.setBounds(objx,objy,objWidth,objHeight);
		
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel1.setIcon(objectIcon);
		
		//Create Object
		JLabel objectLabel2 = new JLabel();
		objectLabel2.setBounds(350,100,300,255);
				
		ImageIcon objectIcon2 = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel2.setIcon(objectIcon);
		
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
		bgPanel[bgNum].add(bgLabel[bgNum]);
	}
	
	public void generateScreen() {
		// screen
		createBackground(1,"grassfield.png");
		createObject(1,350,100,300,255,"housetrees.png","Look","Talk","Rest");
		createObject(1,70,180,150,150,"badboy.png","","","");
		//createObject(1,350,100,300,255,"housetrees.png","","","");
	} 
}
