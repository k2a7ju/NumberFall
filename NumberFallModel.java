/*
  Modelの実装
*/
import java.util.*;

class NumberFallModel {
    //NumberFallView view;
    //NumberFallController controller;
    private static final int BOX_MAX = 6;
    int score; //スコアを管理するための変数
    int itemQuantity; //アイテムの個数を管理する
    int[][] fieldNumber = new int[BOX_MAX][BOX_MAX]; //ボックスにどの値が格納されているかどうか管理するための配列
    int level; //レベルを管理するための変数
    int nowPanelFlag; //今の画面状況を管理するためのフラグ
    /*
    public NumberFallModel(NumberFallView view, NumberFallController controller){
    this.view = view;
    this.controller = controller;
    }
    */
    //配列に乱数で得た値を格納する
    public void createNewStage(){
	Random rand = new Random();
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0; j < BOX_MAX; j++){
		fieldNumber[i][j] = rand.nextInt(9);
	    }
	}
	printField();
    }
    //アイテムが使われたかどうかをチェック
    public void checkItem(){
    }
    //配列に格納されている値をシャッフルする
    public void shuffleField(){
	Random rand = new Random();
	for(int i = fieldNumber.length * 6; i > 0; i--){
	    int n1 = rand.nextInt(BOX_MAX - 1);
	    int n2 = rand.nextInt(BOX_MAX - 1);
	    int n3 = rand.nextInt(BOX_MAX - 1);
	    int n4 = rand.nextInt(BOX_MAX - 1);
	    
	    int buff =  fieldNumber[n1][n2];
	    fieldNumber[n1][n2] = fieldNumber[n3][n4];
	    fieldNumber[n3][n4] = buff;
	}
	printField();
    }
    //Controllerから来た数字を削除
    public void removeNumber(){
    }
    //削除された分の乱数を生成し、新たに格納
    public void addNumber(){
    }
    //削除された上部分にペアがないかを判断して値を削除    
    public void checkField(){
    }
    //スコアの計算を行う
    public void caluculateScore(){
    }
    //レベルアップするかどうか
    public void checkLevel(){
    }

    //getterメソッド
    public int getScore(){
	return this.score;
    }
    public int[][] getFieldNumber(){
	return this.fieldNumber;
    }
    public int getLevel(){
	return this.level;
    }
    int getNowPanelFlag(){
	return this.nowPanelFlag;
    }
    
    //setterメソッド
    public void setScore(int score){
	this.score = score;
    }
    public void setItemQuanitity(int itemQuantity){
	this.itemQuantity = itemQuantity;
    }
    public void setFieldNumber(int[][] fieldNumber){
	this.fieldNumber = fieldNumber;
    }
    public void setLevel(int level){
	this.level = level;
    }
    public void setNowPanelFlag(int flag){
	this.nowPanelFlag = flag;
    }
    public void printField(){
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0; j < BOX_MAX; j++){
		System.out.printf("%d ",fieldNumber[i][j]);
	    }
	    System.out.printf("\n");
	}
    }
    public static void main(String[] args){
	NumberFallModel model = new NumberFallModel();
	model.createNewStage();
	System.out.printf("\n");
	model.shuffleField();
    }
}