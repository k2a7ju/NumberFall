import java.awt.*;
import javax.swing.*;

class GameFieldPanel extends JPanel {
    GameFieldPanel() {
	super();
	setBackground(Color.WHITE);
    }
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.BLACK);
	g.drawRect(0,0,384,384);

	for(int x = 0; x < 384; x+= 64) {
	    g.drawLine(x,0,x,384);
	}
	for(int y = 0; y < 384; y+= 64) {
	    g.drawLine(0,y,384,y);
	}
    }
}
