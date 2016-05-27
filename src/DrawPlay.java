/*
  DrawPlay.javaの実装
*/
import javax.swing.*;
import java.awt.event.*;
public class DrawPlay {

    private NumberFallModel model;
    private NumberFallController controller;
    private NumberFallView view;

    private static final int BOX_MAX = 36 + 1;
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    static GameFieldPanel gameFieldPanel;
    static JLabel[] scoreLabels = new JLabel[2];
    static JLabel byougaLabels;
    static JButton NumbershuffleButton;
    static JButton GameCloseButton;

    JFrame frame;
    private int[] fieldNumber = new int[BOX_MAX];
    private int score;
    private int itemQuantity;
    
    public DrawPlay(NumberFallModel model, NumberFallController controller, NumberFallView view, int[] fieldNumber,int score){
	this.model = model;
	this.controller = controller;
	this.view = view;
	this.fieldNumber = fieldNumber;
	this.score = score;
    }
    public void draw() {
	this.fieldNumber = model.getThrowNumber();

				
	this.frame = new JFrame();
	frame.setTitle("NumberFall");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	frame.setLayout(null);
        
	gameFieldPanel = new GameFieldPanel(this.model, this.fieldNumber);
	gameFieldPanel.addMouseListener(controller);
	gameFieldPanel.setBounds(28,48,385,385);
	frame.add(gameFieldPanel);

	scoreLabels[0] = new JLabel("シャッフル残数 :      " + this.model.getItemQuantity());
	scoreLabels[0].setBounds(WINDOW_WIDTH - 190, 70, 200, 30);
	frame.add(scoreLabels[0]);
	scoreLabels[1] = new JLabel("スコア :    " + String.valueOf(this.score));
	
	scoreLabels[1].setBounds(WINDOW_WIDTH - 170, 100, 200, 30);
	frame.add(scoreLabels[1]);
	this.resetLabel();  
	byougaLabels = new JLabel(" Number Fall ");
	byougaLabels.setBounds(WINDOW_WIDTH - 150, 250, 200, 30);
	frame.add(byougaLabels);
        
	NumbershuffleButton = new JButton("Number Shuffle");
	    NumbershuffleButton.setBounds(WINDOW_WIDTH - 190, WINDOW_HEIGHT - 320, 150, 30);
	    NumbershuffleButton.setFocusable(false);

	    //シャッフルボタンが押されたとき
	    NumbershuffleButton.addActionListener(e -> {
			//コントローラにボタンが押されたことを知らせる
			controller.pushedShuffleButton();
			
			System.out.println(this.score);
			gameFieldPanel.setFieldNumber(fieldNumber);
			gameFieldPanel.drawNumber();
			this.model.reduceItem();
			
			this.repaint();
		}   
		);
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
    public void resetLabel(){
	scoreLabels[0].setText("シャッフル残数 :      "+ String.valueOf(this.model.getItemQuantity()));
	System.out.println(this.model.getItemQuantity());
	scoreLabels[1].setText("スコア :    " + String.valueOf(this.score));
    }
    public void repaint(){
	this.score = this.model.getScore();
	this.resetLabel();
	frame.repaint();
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
    public void setView(NumberFallView view){
	this.view = view;
    }
    public void setItemQuantity(int item){
	this.itemQuantity = item;
    }
}