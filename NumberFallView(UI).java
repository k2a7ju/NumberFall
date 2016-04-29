import javax.swing.*;
import java.awt.*;

class NumberFallView {
		private static final int WINDOW_WIDTH = 640;
		private static final int WINDOW_HEIGHT = 480;
		private JLabel numberFall = new JLabel();
		private JButton gamestart;
		private JButton gameclose;

		NumberFallView() {
			JFrame frame = new JFrame();
			frame.setTitle("NumberFall");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			frame.setLayout(null);

			JLabel numberFall = new JLabel("NumberFall");
			 /*numberFall.setPreferredSize(new Dimention(300,300));
			numberFall.setBorder(new LineBorder(Color.GREEN, 10, true)); */
			numberFall.setFont(new Font("Century", Font.ITALIC, 80));

			frame.setVisible(true);
		}

		public static void main (String[] args) {
				NumberFallView app = new NumberFallView();
		}
}
