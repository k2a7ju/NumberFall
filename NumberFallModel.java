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
  
    //EMPTYに乱数を挿入する
    public void addNumber(){
	for(int i = 0; i < BOX_MAX; i++){
	    for(int j = 0;j < BOX_MAX; j++){
		if(this.fieldNumber[i][j] == EMPTY){
		    this.fieldNumber[i][j] = addRandomNumber();
		}
	    }
	}
	this.printField();
    }
    //削除された分の乱数を生成する
    public int addRandomNumber(){
	Random rand = new Random();
	int random = rand.nextInt(BOX_MAX);
	return random;
    }
    
    //削除された上部分にペアがないかを判断して値を削除    
    public void checkField(int boxX,int boxY){
	//boxX側の上
	upRemove(boxX);
	upRemove(boxY);
    }
    //上にペアがないか見てあればEMPTYを挿入
    public void upRemove(int boxNum){
	boxNumberToArray(boxNum);
	int x = buffX;
	int y = buffY;
	int buffUpBox;
        int buffDownBox;
	buffUpBox = buffY;
        for(int i = y; buffUpBox - 1 >= 0; i--){
            buffUpBox = i - 2;
            buffDownBox = i - 1;
	    //System.out.println("チェック : "+ fieldNumber[buffUpBox][x] +", "+fieldNumber[buffDownBox][x]);
            if(fieldNumber[buffUpBox][x] == fieldNumber[buffDownBox][x]){
		fieldNumber[buffUpBox][x] = EMPTY;
		fieldNumber[buffDownBox][x] = EMPTY;
            }
        }
	return;
    }
    public void fallNumber(int boxX, int boxY){
	this.fall(boxX);
	this.fall(boxY);
	return;
    }
    public void fall(int boxNum){
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

    //スコア計算を行う
    public void caluculateScore(int number,int kosu){
        int zenscore = getScore();
        if(kosu==2){
            zenscore=number*10+zenscore;
        }else{
            zenscore=number*20+zenscore;
        }
        setScore(zenscore);
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
		System.out.printf("%d\t",fieldNumber[i][j]);
	    }
	    System.out.printf("\n");
	}
	    System.out.printf("\n");
    }
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
}