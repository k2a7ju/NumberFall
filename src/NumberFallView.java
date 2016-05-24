
public class NumberFallView{
    private NumberFallModel model;
    private NumberFallController controller;
    private static final int BOX_MAX = 36;
    private DrawStart start;

    private int[] fieldNumber = new int[BOX_MAX];
    private int score;

    public void practiceStart(){
	this.start = new DrawStart(this.model, this.controller,this.fieldNumber,score);
        this.start.draw();
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
    }
}