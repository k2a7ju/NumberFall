public class NumberFall {
    private NumberFallView view;
    private NumberFallModel model;
    private NumberFallController controller;

    public NumberFall(){
	this.view = new NumberFallView();
	this.controller = new NumberFallController();
	this.model = new NumberFallModel(this.view, this.controller);
	view.setModel(this.model);
	view.setController(this.controller);
	controller.setModel(this.model);
	controller.setView(this.view);
	view.setValue();
	view.practiceStart();
	/*
	  V =new v;
	  C = new c;
	  M = (C,V);
	  V.m = M;
	  V.c = C;
	  C.m = M;
	  C.v = V;
	*/
	
    }
    public static void main(String[] args){
	NumberFall play = new NumberFall();
	play.run();
    }
    public void run(){
	
    }



}