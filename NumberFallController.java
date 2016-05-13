//コントローラー
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class NumberFallController extends JFrame implements MouseListener{

    private int x = 0;
    private int y = 0;
    private int xa=64,ya=64;
    private int box1=0,box2=0;

    public void checkPair(int box1,int box2){
	if(box1==box2-1||box1==box2+1){

	}else{
	    
	}
    }
	
    public void mouseClicked(MouseEvent e){
      x = e.getX();
      y = e.getY();
      int boxnumber=1;
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
	  checkPair(box1,box2);
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

