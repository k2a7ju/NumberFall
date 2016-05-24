import javax.swing.*;
import java.awt.event.*;

class NumberFallViewUI {
		private static final int WINDOW_WIDTH = 640;
		private static final int WINDOW_HEIGHT = 480;
		private StartScreen startScreen;
		private JButton gameStartButton;
		private JButton gameCloseButton;

		NumberFallViewUI() {
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
                    NumberFallView.method();
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

		public static void main (String[] args) {
                NumberFallViewUI aaa = new NumberFallViewUI();
                NumberFallView bbb = new NumberFallView();
            }
     	}
    
class NumberFallView extend NumberFallController {
	private static final int WINDOW_WIDTH = 640;
	private static final int WINDOW_HEIGHT = 480;
	static GameFieldPanel gameFieldPanel;
    static JLabel[] scoreLabels = new JLabel[2];
    static JLabel byougaLabels;
    static JButton NumbershuffleButton;
    static JButton GameCloseButton;
            static void method() {

            JFrame frame = new JFrame();
			frame.setTitle("NumberFall");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			frame.setLayout(null);
        
            gameFieldPanel = new GameFieldPanel();
            gameFieldPanel.setBounds(28,48,385,385);
	    gameFieldPanel.addMouseListener(this);
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
    }
