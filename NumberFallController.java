//コントローラー
import java.awt.Graphics;//サンプルよう
import java.awt.Graphics2D;//サンプル用
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;//いらん

public class NumberFallController extends JApplet implements MouseListener {
    private static final long serialVersionUID = 1L;
    String message1 = "";
    String message2 = "";
    int x = 0;
    int y = 0;
    public void init() {
	addMouseListener(this);
    }
    public void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D)g;
	int w = getWidth();
	int h = getHeight();
	g2.clearRect(0, 0, w, h);
	g2.drawString(message1, 10, 10);
	g2.drawString(message2, 10, 30);
    }
    public void update(Graphics g){
	paint(g);
    }
    public void mouseClicked(MouseEvent e) {
	if ( e.getModifiers() == MouseEvent.BUTTON1_MASK ){
	    x = e.getX();
	    y = e.getY();
	    message1 = "左ボタンクリック";
	    message2 = "クリック地点 : X = " + x + " Y = " + y;
	    repaint();
	} else if ( e.getModifiers() == MouseEvent.BUTTON2_MASK ){
	    x = e.getX();
	    y = e.getY();
	    message1 = "ホイールボタンクリック";
	    message2 = "クリック地点 : X = " + x + " Y = " + y;
	    repaint();
	} else if ( e.getModifiers() == MouseEvent.BUTTON3_MASK ){
	    x = e.getX();
	    y = e.getY();
	    message1 = "右ボタンクリック";
	    message2 = "クリック地点 : X = " + x + " Y = " + y;
	    repaint();
	}
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
}
