/*
  NumberFallController.javaの実装
*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

public class NumberFallController implements MouseListener{

    private NumberFallModel model;
    private NumberFallView view;

    private int x = 0;
    private int y = 0;
    private int xa = 64,ya = 64;
    private int box1 = 0,box2 = 0;
    private int clickCount = 0;
    private Point pointxy = new Point(0,0);

    public int checkPair(int box1,int box2){
	for(int i = 0; i < 6; i++){
	    for(int j = 1 + 6 * i; j < 6 + 6 * i; j++){
		if((box1 == j) && (box2 == j + 1)){
		    return 1;
		}
	    }
	}
	//this.box1 = 0;
	//this.box2 = 0;
	//flag1 = 0;
	//flag2 = 0;
	return 0;
	
    }
    public Point getPointxy(){
	return pointxy;
    }
    public int getbox1(){
	return box1;
    }
    public int getbox2(){
	return box2;
    }
	
    public void mouseClicked(MouseEvent e){
      x = e.getX();
      y = e.getY();
      pointxy = e.getPoint();
      int boxNumber = 1;
      //System.out.println("X = "+x+"Y = "+y);
      for(int j = 0; j < 384;j = j + ya){
	  for(int i = 0;i < 384; i = i + xa){
	      if((x >= i && x < i + xa) && (y >= j && y < j + ya)){
		  if(clickCount == 0){
		      box1 = boxNumber;
		      System.out.println("box1= "+box1);
		      clickCount++;
		  }else if(clickCount == 1){
		      box2 = boxNumber;
		      System.out.println("box2= "+box2);
		      this.clickCount = 0;
		  }
	      }
	      boxNumber += 1;
	  }   
      }
      if(checkPair(box1,box2) == 1){
	  model.checkClickedNumber(box1,box2);
      }
    }
    public void resetBox(){
	this.box1 = 0;
	this.box2 = 0;
    }

    public void mouseEntered(MouseEvent e){
	
    }
    
    public void mouseExited(MouseEvent e){
	
    }
    
    public void mousePressed(MouseEvent e){
      
    }
    
    public void mouseReleased(MouseEvent e){
    }
    public void setModel(NumberFallModel model){
	this.model = model;
    }
    public void setView(NumberFallView view){
	this.view = view;
    }
    public void pushedShuffleButton(){
	System.out.println("入った");
	this.model.setScore(this.model.getScore() + 100);
	System.out.println("score = "+this.model.getScore());
	this.model.reduceItem();
	this.model.shuffleField();
	//model.printField();
    }

    public void paint(){
	this.view.paint();
    }
    
}

