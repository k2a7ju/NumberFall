import javax.swing.*;
import java.awt.*;

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
			frame.add(gameStartButton);

			gameCloseButton = new JButton("Game Close");
			gameCloseButton.setBounds(WINDOW_WIDTH - 260, WINDOW_HEIGHT - 170, 120, 30);
			gameCloseButton.setFocusable(false);
			frame.add(gameCloseButton);

			frame.setVisible(true);
		}

		public static void main (String[] args) {
				NumberFallViewUI app = new NumberFallViewUI();
		}
}
