
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class sample extends JFrame implements MouseListener{
    private static final long serialVersionUID = 1L;
    
    private int x = 0;
    private int y = 0;
    private int xa=64,ya=64;
    private int box1=0,box2=0;

    protected JList list;
    protected DefaultListModel model;
    
    public static void main(String[] args){
	sample test = new sample("sample");
	
	test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	test.setVisible(true);
    }
    
    sample(String title){
	setTitle(title);
	setBounds( 10, 10, 640, 480);
	JPanel p = new JPanel();
	
	p.addMouseListener(this);
	getContentPane().add(p, BorderLayout.CENTER);
	
	
    }
    public void mouseClicked(MouseEvent e){
	int boxnumber=1;
	x = e.getX();
	y = e.getY();
	System.out.println("X = "+x+"Y = "+y);
	for(int j=48;j<385;j=j+ya){
	    for(int i=28;i<365;i=i+xa){
		if((x>=i&&x<i+xa)&&(y>=j&&y<j+ya)){
		    if(box1==0&&box2==0){
			box1=boxnumber;
			System.out.println("box1="+box1);
		    }else if(box1!=0&&box2==0){
			box2=boxnumber;
			System.out.println("box2="+box2);
		       
		    }else{
		    }
		}
		boxnumber=boxnumber+1;
	    }   
	}
	if(box1!=0&&box2!=0){
	    System.out.println("確定");
	    System.out.println("box1="+box1);
	    System.out.println("box2="+box2);
	    box1=0;
	    box2=0;
	}
    }
    
    public void mouseEntered(MouseEvent e){
	
    }
    
    public void mouseExited(MouseEvent e){
	
    }
    
    public void mousePressed(MouseEvent e){
	
    }
    
    public void mouseReleased(MouseEvent e){
    }
}
