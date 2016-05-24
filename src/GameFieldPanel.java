/*
  GameFieldPanel.java
*/
import java.awt.*;
import javax.swing.*;

class GameFieldPanel extends JPanel {
    private NumberFallModel model;
    private static final int BOX_MAX = 36 + 1;
    private int[] fieldNumber = new int[BOX_MAX];
    private int count = 1;
    Graphics2D g2d;
    Graphics2D g2;
    
    GameFieldPanel(NumberFallModel model, int[] number) {
	super();
	this.model = model;
	setBackground(Color.WHITE);
	this.fieldNumber = number;
    }
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	this.g2d = (Graphics2D)g;
	this.g2 = (Graphics2D)g;
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
	this.drawNumber();
	/*
	for(int y = 0; y < 384; y+= 64) {
	    for(int x = 0; x < 384; x+= 64) {
		g2d.drawString(String.valueOf(this.fieldNumber[count]), x + 23, y + 40);
		count++;
	    }
	}
	count = 1;
	*/
    }
    public void drawNumber(){
	System.out.println("drawNumber");
	count = 1;
	this.fieldNumber = this.model.getThrowNumber();
	
	System.out.println("[1] = " + this.fieldNumber[1]);
	for(int y = 0; y < 384; y+= 64) {
            for(int x = 0; x < 384; x+= 64) {
                this.g2d.drawString(String.valueOf(this.fieldNumber[count]), x + 23, y + 40);
                /*for(int i = 0; i < 36;i++){                                                                                                                                                    
                    System.out.println("ああああああから"+this.fieldNumber[i]);                                                                                                                  
                }                                                                                                                                                                                
                */
                count++;
            }
        }
       
    }
    public void setFieldNumber(int[] number){
	
	this.fieldNumber = number;
    }

}
