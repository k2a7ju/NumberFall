/*
  DrawStart.java
*/
import javax.swing.*;
import java.awt.event.*;

public class DrawStart {
   
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    private static final int BOX_MAX = 36 + 1;
    private StartScreen startScreen;
    private JButton gameStartButton;
    private JButton gameCloseButton; 
    
    private GameFieldPanel gameFieldPanel;
    private JLabel[] scoreLabels = new JLabel[2];
    private JLabel byougaLabels;
    private JButton NumbershuffleButton;
    private JButton GameCloseButton;
    
    private DrawPlay play;
    
    public DrawStart(DrawPlay play){
	this.play = play;
    }
    public void draw(){

	JFrame frame = new JFrame();
	frame.setTitle("NumberFall");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	frame.setLayout(null);
	
	startScreen = new StartScreen();
	startScreen.setBounds(128, 48, 386, 200);
	frame.add(startScreen);
	
	gameStartButton = new JButton("Game Start");
	gameStartButton.setBounds(WINDOW_WIDTH - 510, WINDOW_HEIGHT - 170, 120, 30);
	gameStartButton.setFocusable(false);
	gameStartButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    
		    play.draw();
		    frame.dispose();
		}
	    });
	frame.add(gameStartButton);
	gameCloseButton = new JButton("Game Close");
	gameCloseButton.setBounds(WINDOW_WIDTH - 260, WINDOW_HEIGHT - 170, 120, 30);
	gameCloseButton.setFocusable(false);
	gameCloseButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	    });
	frame.add(gameCloseButton);
	
	frame.setVisible(true);
    }
}