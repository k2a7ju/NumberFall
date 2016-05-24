

import javax.swing.*;
import java.awt.event.*;
public class DrawPlay {
    private NumberFallModel model;
    private NumberFallController controller;
    
    private static final int BOX_MAX = 36 + 1;
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    static GameFieldPanel gameFieldPanel;
    static JLabel[] scoreLabels = new JLabel[2];
    static JLabel byougaLabels;
    static JButton NumbershuffleButton;
    static JButton GameCloseButton;

    private int[] fieldNumber = new int[BOX_MAX];
    private int score = 123;
   
    public void draw() {
	
	JFrame frame = new JFrame();
	frame.setTitle("NumberFall");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	frame.setLayout(null);
        
	gameFieldPanel = new GameFieldPanel(this.model, this.fieldNumber);
	gameFieldPanel.setBounds(28,48,385,385);
	frame.add(gameFieldPanel);
        
	scoreLabels[0] = new JLabel("GAMELEVEL :       1");
	scoreLabels[0].setBounds(WINDOW_WIDTH - 170, 70, 200, 30);
	frame.add(scoreLabels[0]);
	scoreLabels[1] = new JLabel("SCOREPOINTS :    "+String.valueOf(score ));
	scoreLabels[1].setBounds(WINDOW_WIDTH - 170, 100, 200, 30);
	frame.add(scoreLabels[1]);
        
	byougaLabels = new JLabel(" Number Fall ");
	byougaLabels.setBounds(WINDOW_WIDTH - 150, 250, 200, 30);
	frame.add(byougaLabels);
        
	NumbershuffleButton = new JButton("Number shuffle");
	NumbershuffleButton.setBounds(WINDOW_WIDTH - 190, WINDOW_HEIGHT - 350, 150, 30);
	NumbershuffleButton.setFocusable(false);
	NumbershuffleButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
		    //コントローラにボタンが押されたことを知らせる
		    controller.pushedShuffleButton();
		    gameFieldPanel.setFieldNumber(fieldNumber);
		    gameFieldPanel.drawNumber();
		    frame.repaint();
                }
            });
	frame.add(NumbershuffleButton);
        
	GameCloseButton = new JButton("Game Close");
	GameCloseButton.setBounds(WINDOW_WIDTH - 120, WINDOW_HEIGHT - 50, 120, 30);
	GameCloseButton.setFocusable(false);
	GameCloseButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
	frame.add(GameCloseButton);
            
	frame.setVisible(true);
    }
    public void setValue(int[] number,int score){
	this.fieldNumber = number;
	this.score = score;
    }
    public void setModel(NumberFallModel model){
	this.model = model;
    }
    public void setController(NumberFallController controller){
	this.controller = controller;
    }
}
