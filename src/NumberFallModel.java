/*
  Modelの実装
*/
import java.util.*;

class NumberFallModel {
   
    private NumberFallView view;
    private NumberFallController controller;
 
    private static final int BOX_MAX = 6;
    private static final int EMPTY = 184;
    private int score; //スコアを管理するための変数
    private int itemQuantity; //アイテムの個数を管理する
    private int[][] fieldNumber = new int[BOX_MAX][BOX_MAX]; //ボックスにどの値が格納されているかどうか管理するための配列
    private int[][] boxNumber = new int[BOX_MAX][BOX_MAX];
    private int[] throwNumber = new int[37];
    private int level; //レベルを管理するための変数
    private int nowPanelFlag; //今の画面状況を管理するためのフラグ
    
    private int buffX;
    private int buffY;
    
    public NumberFallModel(NumberFallView view, NumberFallController controller){
	this.view = view;
	this.score = 0;
	this.controller = controller;
	this.createNewStage();
	this.decideBoxNumber();
    }
    
    //配列に乱数で得た値を格納する
    public void createNewStage(){//あり
	Random rand = new Random();
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0; j < BOX_MAX; j++){
		fieldNumber[i][j] = rand.nextInt(9);
	    }
	}
	
	this.changeBoxNumber();

	System.out.println("createNewStageにて");
	printField();
    }
    
    //ボックス番号→配列
    public void boxNumberToArray(int boxNum){//あり
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
    public int arrayToBoxNumber(int x, int y){//あり
	System.out.println(boxNumber[y][x]);
	return boxNumber[y][x];
    }
    
    //アイテムが使われたかどうかをチェック
    public void checkItem(){//あり
	if(itemQuantity > 0){
	    System.out.println("使える");
	}
	else {
	    System.out.println("使えない");
	}
    }
    
    //配列に格納されている値をシャッフルする
    public void shuffleField(){//あり
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
	this.changeBoxNumber();
	//printField();
    }
    
    //Controllerから来た数字を削除(184を代入することで削除扱いとする)
    public void removeNumber(int boxX, int boxY){//あり
	
	boxNumberToArray(boxX);
	
	fieldNumber[buffY][buffX] = EMPTY;
	System.out.println(fieldNumber[buffY][buffX]);
	boxNumberToArray(boxY);
	fieldNumber[buffY][buffX] = EMPTY;
    }
  
    //EMPTYに乱数を挿入する
    public void addNumber(){//あり
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0;j < BOX_MAX; j++){
		if(this.fieldNumber[i][j] == EMPTY){
		    this.fieldNumber[i][j] = addRandomNumber();
		}
	    }
	}
	this.changeBoxNumber();
	//this.view.paint();
	this.printField();
    }
    //削除された分の乱数を生成する
    public int addRandomNumber(){//あり
	Random rand = new Random();
	int random = rand.nextInt(BOX_MAX);
	return random;
    }
    
    //削除された上部分にペアがないかを判断して値を削除    
    public void checkField(int boxX,int boxY){//あり
	//boxX側の上
	upRemove(boxX);
	upRemove(boxY);
    }
    //上にペアがないか見てあればEMPTYを挿入
    public void upRemove(int boxNum){//あり
	boxNumberToArray(boxNum);
	int x = buffX;
	int y = buffY;
	int buffUpBox;
        int buffDownBox;
	buffUpBox = buffY;
        for(int i = y; buffUpBox - 1 > 0; i--){
            buffUpBox = i - 2;
            buffDownBox = i - 1;
	    //System.out.println("チェック : "+ fieldNumber[buffUpBox][x] +", "+fieldNumber[buffDownBox][x]);
            if(fieldNumber[buffUpBox][x] == fieldNumber[buffDownBox][x]){
		System.out.println("score += "+fieldNumber[buffUpBox][x]);
		this.score += fieldNumber[buffUpBox][x];
		fieldNumber[buffUpBox][x] = EMPTY;
		fieldNumber[buffDownBox][x] = EMPTY;
            }
        }
	return;
    }
    public void fallNumber(int boxX, int boxY){//あり
	this.fall(boxX);
	this.fall(boxY);
	return;
    }
    public void fall(int boxNum){//あり
	int[] buff = new int[6];
	int count = 0;
	int count2 = 0;
	this.boxNumberToArray(boxNum);
	int x = this.buffX;
	//一時的に別配列へ移動
	for(int i = BOX_MAX - 1; i >= 0; i--){
	    if(this.fieldNumber[i][x] != EMPTY){
		buff[count] = fieldNumber[i][x];
		count++;
	    }
	}
	//System.out.println("count = "+ count);
	//配列に入っているのを戻す
	for(int i = BOX_MAX - 1; i >= 0; i--){
	    if(count2 < count){
		this.fieldNumber[i][x] = buff[count2];
	    }
	    else{
		this.fieldNumber[i][x] = EMPTY;
	    }
	    count2++;
	    //System.out.println("count2 = "+count2);
	}
		
	return;
    }
    //配列からボックスの番号に変換
    public void changeBoxNumber(){//あり
 	int count = 1;
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0; j < BOX_MAX; j++){
		this.throwNumber[count] = this.fieldNumber[i][j];
		//System.out.println("["+i+"]["+j+"] = "+fieldNumber[i][j]+" ,"+this.throwNumber[count]);
		count++;
	    }
	}
    }

    //スコア計算を行う
    public void caluculateScore(int number,int kosu){//あり
        int zenscore = getScore();
        if(kosu==2){
            zenscore=number*10+zenscore;
        }else{
            zenscore=number*20+zenscore;
        }
        setScore(zenscore);
    }
    //レベルアップするかどうか
    public void checkLevel(){//削除
	
    }

    //ボックスに番号を振り分ける
    public void decideBoxNumber(){//
        int count = 1;
        for(int i = 0; i <BOX_MAX; i++){
            for(int j = 0; j < BOX_MAX; j++){
                this.boxNumber[i][j] = count;
                count++;
            }
        }
    }
    //コントローラからきたボックス番号のペアの中身が一致しているかをチェックし、
    //一致しているならデリートする
    public void checkClickedNumber(int box1, int box2){//あり
	if(this.throwNumber[box1] == this.throwNumber[box2]){
	    System.out.println("一致しました");
	    this.removeNumber(box1, box2);
	    this.checkField(box1,box2);
	    this.changeBoxNumber();
	    this.fallNumber(box1,box2);
	    this.changeBoxNumber();
	    this.addNumber();  
	    this.view.setModel(this);
	    System.out.println("score = "+score);
	}else{
	    System.out.println("一致しません");
	}
	this.view.paint();
    }
    //getterメソッド
    public int getScore(){//あり
	return this.score;
    }
    public int[][] getFieldNumber(){//あり
	return this.fieldNumber;
    }
    public int getLevel(){//削除
	return this.level;
    }
    public int getNowPanelFlag(){//あり
	return this.nowPanelFlag;
    }
    public int[] getThrowNumber(){//
	return this.throwNumber;
    }
    //setterメソッド
    public void setScore(int score){//あり
	this.score = score;
    }
    public void setItemQuanitity(int itemQuantity){//あり
	this.itemQuantity = itemQuantity;
    }
    public void setFieldNumber(int[][] fieldNumber){//あり
	this.fieldNumber = fieldNumber;
    }
    public void setLevel(int level){//削除
	this.level = level;
    }
    public void setNowPanelFlag(int flag){//あり
	this.nowPanelFlag = flag;
    }
    
    
    //デバッグ用
    public void printField(){
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0; j < BOX_MAX; j++){
		System.out.printf("%d\t",fieldNumber[i][j]);
	    }
	    System.out.printf("\n");
	}
	    System.out.printf("\n");
    }
    /*
    public static void main(String[] args){
	NumberFallModel model = new NumberFallModel();
	model.createNewStage();
	model.removeNumber(31,32);
	model.checkField(31,32);
	System.out.printf("\nEMPTY追加後\n");
	model.printField();
	model.fallNumber(31,32);
	System.out.printf("\nfallNumber後\n");
	model.printField();
	System.out.printf("\n乱数で埋める\n");
	model.addNumber();
    }
    */
}
