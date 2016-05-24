import javax.swing.*;
import java.awt.*;

class StartScreen extends JPanel {
	StartScreen() {
		super();
		setBackground(Color.BLACK);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		Graphics2D g2 = (Graphics2D)g;
		g2d.setColor(Color.GREEN);
		BasicStroke stroke = new BasicStroke(10.0f);
		g2d.setStroke(stroke);
		g2d.drawRect(5, 5, 376, 190);

		Font font = new Font("Arial", Font.BOLD, 40);
  		g2.setFont(font);
		g2d.drawString("NUMBER FALL", 50, 110);
	}
}