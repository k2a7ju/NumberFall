import java.awt.*;
import javax.swing.*;

class GameFieldPanel extends JPanel {
    GameFieldPanel() {
	super();
	setBackground(Color.WHITE);
    }
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D)g;
	Graphics2D g2 = (Graphics2D)g;
	g.setColor(Color.BLACK);
	g.drawRect(0,0,384,384);

	for(int x = 0; x < 384; x+= 64) {
	    g.drawLine(x,0,x,384);
	}
	for(int y = 0; y < 384; y+= 64) {
	    g.drawLine(0,y,384,y);
	}

	Font font = new Font("Arial",Font.BOLD,30);
	g2.setFont(font);

	for(int y = 0; y < 384; y+= 64) {
	    for(int x = 0; x < 384; x+= 64) {
		g2d.drawString("1", x + 23, y + 40);
	    }
	}

    }
}
