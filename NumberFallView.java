//ビュー

import javax.swing.*;

class NumberFallView {
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    private GameFieldPanel gameFieldPanel;

    NumberFallView() {
	JFrame frame = new JFrame();
	frame.setTitle("NumberFall");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	frame.setLayout(null);

	gameFieldPanel = new GameFieldPanel();
	gameFieldPanel.setBounds(128,48,385,385);
	frame.add(gameFieldPanel);

	frame.setVisible(true);
    }

    public static void main(String[] args) {
	NumberFallView app = new NumberFallView();
    }
}
