/*
  NumberFallView.javaの実装
*/
public class NumberFallView{
    private NumberFallModel model;
    private NumberFallController controller;
    private static final int BOX_MAX = 36;
    private DrawStart start;
    private DrawPlay play;

    private int[] fieldNumber = new int[BOX_MAX];
    private int score;

    public void practiceStart(){
	this.play = new DrawPlay(this.model, this.controller, this.fieldNumber, this.score);
	this.start = new DrawStart(this.play);
        this.start.draw();
    }
    public void paint(){
	this.play.draw();
    }

    public int[] getFieldNumber(){
	return this.fieldNumber;
    }

    public void setModel(NumberFallModel model){
	this.model = model;
    }
    public void setController(NumberFallController controller){
	this.controller = controller;
    }
    public void setValue(){
	this.fieldNumber = model.getThrowNumber();
        this.score = model.getScore();
	System.out.println("score = "+score);
    }
}