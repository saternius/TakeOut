package com.example.legit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Curtains {
	Rect black;
	Paint blackPaint= new Paint();
	static int alpha = 0;
	static int death = -1;
	Paint messPaint = new Paint();
	Paint replayPaint = new Paint();
	
	
	Organ outline = new Organ(R.drawable.outline);
	Organ inner_skel = new Organ(R.drawable.inner_skel);
	Organ kidneys = new Organ(R.drawable.kidneys);
	Organ pancreas = new Organ(R.drawable.pancreas);
	Organ liver = new Organ(R.drawable.liver);
	Lungs lungs = new Lungs(R.drawable.lungs);
	Organ stomach = new Organ(R.drawable.stomach);
	Heart heart = new Heart(R.drawable.heart);
	Organ large = new Organ(R.drawable.large_intestines);
	Organ small = new Organ(R.drawable.small_intestines);
	Ribs ribs = new Ribs(R.drawable.rib_cage);
	Organ hair = new Organ(R.drawable.hair);
	int drift = -50;
	Rect replayRect = new Rect();
	Paint abs = new Paint();
	public Curtains(){
		black = new Rect(0,0,GameView.stage_width,GameView.stage_height);
		messPaint =  F.makeFont("fonts/revy.ttf","#DCDFE4",(.02)*GameView.stage_height);
		replayPaint =  F.makeFont("fonts/revy.ttf","#DCDFE4",(.045)*GameView.stage_height);
		
		outline.x=0+drift;
		outline.y=1080;
		inner_skel.x = 55+drift;
		inner_skel.y = 1132;
		kidneys.x = 225+drift;
		kidneys.y = 1615;
		lungs.x =212+drift;
		lungs.y = 1381;
		
		liver.x = 200+drift;
		liver.y = 1555;
		
		stomach.x = 280+drift;
		stomach.y = 1575;
		
		pancreas.x = 283+drift;
		pancreas.y = 1670;
		
		heart.x = 330+drift;
		heart.y = 1490;
		
		large.x = 210+drift;
		large.y = 1670;
		small.x = 220+drift;
		small.y = 1713;
		
		ribs.x = 200+drift;
		ribs.y = 1440;
		hair.x = 170+drift;
		hair.y = 1100;
		abs.setColor(Color.rgb(0, 0, 0));
	}
	public void draw(Canvas stage) {
		blackPaint.setColor(Color.argb(alpha, 0, 0, 0));
		if(!GameView.alive){
			alpha+=(Math.abs(alpha)-100)/20;
		}
		stage.drawRect(black,blackPaint);
		if(death>-1){
			Rect bounds = new Rect();
			String mess = "Change Diet";
			replayPaint.getTextBounds(mess,0,mess.length(),bounds);
			stage.drawText(mess,GameView.stage_width/2-bounds.width()/2,940,replayPaint);
			replayRect = new Rect(250,850,820,970);
			//stage.drawRect(replayRect,abs);
		}
		if(death == 0){
			Rect bounds = new Rect();
			String mess = "You died from heart failure";
			messPaint.getTextBounds(mess,0,mess.length(),bounds);
			stage.drawText(mess,GameView.stage_width/2-bounds.width()/2,850,messPaint);
			heart.draw(stage);
		}else if(death == 1){
			Rect bounds = new Rect();
			String mess = "You died from liver failure";
			messPaint.getTextBounds(mess,0,mess.length(),bounds);
			stage.drawText(mess,GameView.stage_width/2-bounds.width()/2,850,messPaint);
			liver.draw(stage);
		}else if(death == 2){
			Rect bounds = new Rect();
			String mess = "You died from kidney failure";
			messPaint.getTextBounds(mess,0,mess.length(),bounds);
			stage.drawText(mess,GameView.stage_width/2-bounds.width()/2,850,messPaint);
			kidneys.draw(stage);
		}else if(death == 3){
			Rect bounds = new Rect();
			String mess = "You died from pancreas failure";
			messPaint.getTextBounds(mess,0,mess.length(),bounds);
			stage.drawText(mess,GameView.stage_width/2-bounds.width()/2,850,messPaint);
			pancreas.draw(stage);
		}else if(death == 4){
			Rect bounds = new Rect();
			String mess = "You died from stomach failure";
			messPaint.getTextBounds(mess,0,mess.length(),bounds);
			stage.drawText(mess,GameView.stage_width/2-bounds.width()/2,850,messPaint);
			stomach.draw(stage);
		}else if(death == 5){
			Rect bounds = new Rect();
			String mess = "You died from lung failure";
			messPaint.getTextBounds(mess,0,mess.length(),bounds);
			stage.drawText(mess,GameView.stage_width/2-bounds.width()/2,850,messPaint);
			lungs.draw(stage);
		}
		
		
		
		
	}
	public void death(int i) {
		death = i;
	}
	public void onTouchEvent(float mouseX, float mouseY) {
		if(F.hitTest(replayRect, mouseX, mouseY)){
			Log.d("RESTOREME","PLZ RESTORE");
			Menu.restore();
		}
	}
	
	
	

}
