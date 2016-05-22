//ビュー

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

class NumberFallView extends NumberFallController{
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    private GameFieldPanel gameFieldPanel;
    private JLabel[] scoreLabels = new JLabel[2];
    private JLabel byougaLabels;
    private JButton NumbershuffleButton;
    private JButton GameCloseButton;

    NumberFallView() {
	JFrame frame = new JFrame();
	frame.setTitle("NumberFall");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	frame.setLayout(null);

	gameFieldPanel = new GameFieldPanel();
	gameFieldPanel.addMouseListener(this);
	gameFieldPanel.setBounds(28,48,385,385);
	frame.add(gameFieldPanel);

	scoreLabels[0] = new JLabel("GAMELEVEL :       1");
	scoreLabels[0].setBounds(WINDOW_WIDTH - 170, 70, 200, 30);
	frame.add(scoreLabels[0]);
	scoreLabels[1] = new JLabel("SCOREPOINTS :    0");
	scoreLabels[1].setBounds(WINDOW_WIDTH - 170, 100, 200, 30);
	frame.add(scoreLabels[1]);

	byougaLabels = new JLabel(" Number Fall ");
	byougaLabels.setBounds(WINDOW_WIDTH - 150, 250, 200, 30);
	frame.add(byougaLabels);

	NumbershuffleButton = new JButton("Number shuffle");
	NumbershuffleButton.setBounds(WINDOW_WIDTH - 190, WINDOW_HEIGHT - 350, 150, 30);
	NumbershuffleButton.setFocusable(false);
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
    public static void main(String[] args) {
       NumberFallView app = new NumberFallView();
    }

}
