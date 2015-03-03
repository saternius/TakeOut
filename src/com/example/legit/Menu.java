package com.example.legit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;


public class Menu {
    static boolean pullUp;
	static TopMenu topMenu = new TopMenu();
	static BottomMenu bottomMenu = new BottomMenu();
	Paint backPaint = new Paint();
	Paint backText = new Paint();
	Paint descText = new Paint();
	Paint inputRect = new Paint();
	Paint fakeRect = new Paint();
	Rect back;
	static int yVel = -15;
	static int xVel = -100;
	static int x=0;
	static int y=0;
	static boolean falling = false;
	static int clock = 0;
	Paint dang = new Paint();
	public Menu(){
		backPaint.setColor(Color.rgb(19, 83, 82));
		inputRect.setColor(Color.rgb(150, 180, 190));
		dang.setColor(Color.rgb(34, 130, 180));
		backPaint.setAntiAlias(true);
		backText =  F.makeFont("fonts/revy.ttf","#DCDFE4",(.05)*GameView.stage_height);
		descText = F.makeFont("fonts/revy.ttf","#202226",(.045)*GameView.stage_height);
		fakeRect = F.makeFont("fonts/revy.ttf","#32505A",(.04)*GameView.stage_height);
	}
	public void draw(Canvas stage){
		stage.drawRect(new Rect(x,y,x+GameView.stage_width,y+GameView.stage_height),dang);
//		back = new Rect(x+0,y+1690,x+GameView.stage_width,y+2000);
//		stage.drawRect(back, backPaint);
//		stage.drawText("Back To Menu",x+200,y+1800,backText);
//		
//		stage.drawText("Age",x+437,y+300,descText);
//		stage.drawText("Gender",x+362,y+600,descText);
//		if(pullUp){
//		stage.drawText("Height",x+367,y+900,descText);
//		}
//		stage.drawText("Weight",x+356,y+1200,descText);
//		stage.drawText("Exercise",x+338,y+1500,descText);
//		
//		Rect inp = new Rect(x+0,y+350,x+GameView.stage_width,y+460);
//		stage.drawRect(inp, inputRect);
//		
//		inp = new Rect(x+0,y+650,x+GameView.stage_width,y+760);
//		stage.drawRect(inp, inputRect);
//		
//		inp = new Rect(x+0,y+950,x+GameView.stage_width,y+1060);
//		stage.drawRect(inp, inputRect);
//		
//		inp = new Rect(x+0,y+1250,x+GameView.stage_width,y+1360);
//		stage.drawRect(inp, inputRect);
//		
//		inp = new Rect(x,y+1550,x+GameView.stage_width,y+1660);
//		stage.drawRect(inp, inputRect);
//		
//		//fake data
//		stage.drawText("20",x+468,y+425,fakeRect);
//		stage.drawText("Male",x+398,y+725,fakeRect);
//		stage.drawText("68 Inches",x+353,y+1025,fakeRect);
//		stage.drawText("140 llbs",x+350,y+1325,fakeRect);
//		stage.drawText("Couch Potatoe",x+220,y+1625,fakeRect);
//		
//		
		topMenu.draw(stage);
		bottomMenu.draw(stage);
		if(pullUp){
			//topMenu.y += (Math.abs(topMenu.y) - 805)/12;
			//bottomMenu.y -= (Math.abs(bottomMenu.y) - 1900)/12;
		}else{
			//topMenu.y += (Math.abs(topMenu.y) - 0)/12;
			//bottomMenu.y -= (Math.abs(bottomMenu.y) - 930)/12;
			
		}
		
		if(falling){
			xVel*=.94;
			x+=xVel;
			//topMenu.x+=xVel;
			//bottomMenu.x+=xVel;
		}else{
			//topMenu.x += (Math.abs(topMenu.x) - 0)/9;
			//bottomMenu.x += (Math.abs(bottomMenu.x) - 0)/9;
			x += (Math.abs(x))/12;
		}
		
	}
	public void onTouchEvent(MotionEvent event) {
		bottomMenu.onTouchEvent(event);
		topMenu.onTouchEvent(event);
		if(pullUp && F.hitTest(back, event.getX(), event.getY())){
			pullUp = false;
			Landing.showInput();
		}
	}
	public static void changeToSettings() {
		pullUp = true;
		Landing.hideInput();
	}
	public static void fall() {
		falling = true;
		Landing.hideInput();
		Clock.begin = true;
	
	}
	
	public static void restore(){
		Log.d("pullup","PULL");
		falling = false;
		Curtains.alpha = 0;
		GameView.alive=true;
		Curtains.death = -1;
		Clock.day = 0;
		Clock.clock = 1;
		Clock.begin = false;
		Landing.showInput();
		xVel=-100;
		//topMenu.x=0;
		//bottomMenu.x=0;
	}

}
