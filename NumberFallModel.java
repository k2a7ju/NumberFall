/*
  Modelの実装
*/
import java.util.*;

class NumberFallModel {
    //NumberFallView view;
    //NumberFallController controller;
    private static final int BOX_MAX = 6;
    private static final int EMPTY = 184;
    private int score; //スコアを管理するための変数
    private int itemQuantity; //アイテムの個数を管理する
    private int[][] fieldNumber = new int[BOX_MAX][BOX_MAX]; //ボックスにどの値が格納されているかどうか管理するための配列
    private int[][] boxNumber = new int[BOX_MAX][BOX_MAX];
    private int level; //レベルを管理するための変数
    private int nowPanelFlag; //今の画面状況を管理するためのフラグ

    private int buffX = 0;
    private int buffY = 0;

    //コンストラクタ
    public NumberFallModel(){
        decideBoxNumber();
    }

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

    //ボックス番号→配列
    public void boxNumberToArray(int boxNum){
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0; j < BOX_MAX; j++){
		if(boxNumber[i][j] == boxNum){
		    this.buffX = j;
		    this.buffY = i;
		   
		    return;
		}
	    }
	}
    }

    //配列→ボックス番号
    public int arrayToBoxNumber(int x, int y){
	 System.out.println(boxNumber[y][x]);
	return boxNumber[y][x];
    }
    
    //アイテムが使われたかどうかをチェック
    public void checkItem(){
	if(itemQuantity > 0){
	    System.out.println("使える");
	}
	else {
	    System.out.println("使えない");
	}
    }

    //配列に格納されている値をシャッフルする
    public void shuffleField(){
	Random rand = new Random();
	for(int i = fieldNumber.length * 6; i > 0; i--){
	    int n1 = rand.nextInt(BOX_MAX);
	    int n2 = rand.nextInt(BOX_MAX);
	    int n3 = rand.nextInt(BOX_MAX);
	    int n4 = rand.nextInt(BOX_MAX);
	    
	    int buff =  fieldNumber[n1][n2];
	    fieldNumber[n1][n2] = fieldNumber[n3][n4];
	    fieldNumber[n3][n4] = buff;
	}
	printField();
    }
    
    //Controllerから来た数字を削除(184を代入することで削除扱いとする)
    public void removeNumber(int boxX, int boxY){
	boxNumberToArray(boxX);
	fieldNumber[buffY][buffX] = EMPTY;
	
	boxNumberToArray(boxY);
	fieldNumber[buffY][buffX] = EMPTY;
    }

    //削除された分の乱数を生成し、新たに格納
    public void addNumber(int x, int y){
	Random rand = new Random();
	int random = rand.nextInt(BOX_MAX);
	fieldNumber[y][x] = random;
     }

    //削除された上部分にペアがないかを判断して値を削除    
    public void checkField(){
	
    }
    public void fallNumber(){
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0; j < BOX_MAX; j++){
		if(boxNumber[i][j] == 128){}
	    }
	}
    }
    //スコアの計算を行う
    public void caluculateScore(int number,int kosu){
	if(kosu==2){
	    score=number*10+socre;
	}else{
	    score=number*20+score;
	}
    }
    //レベルアップするかどうか
    public void checkLevel(){
	
    }
    //ボックスに番号を振り分ける
    public void decideBoxNumber(){
        int count = 1;
        for(int i = 0; i <BOX_MAX; i++){
            for(int j = 0; j < BOX_MAX; j++){
                this.boxNumber[i][j] = count;
                count++;
            }
        }
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
    public int getNowPanelFlag(){
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
    
    
    //デバッグ用
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
	model.removeNumber(31,32);
		
	System.out.printf("\n");
	model.printField();
    }
}
