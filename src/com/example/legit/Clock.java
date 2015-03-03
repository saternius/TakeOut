package com.example.legit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

public class Clock {
	static int clock = 1;
	static int day = 0;
	Paint clockPaint;
	Paint WolfPaint;
	private static MediaPlayer[] tick = new MediaPlayer[2];
	private static MediaPlayer gong;
	boolean tik = true;
	double speed=1;
	int inner_speed=0;
	static boolean begin = false;
	static boolean begin2 = false;
	int load_clock=0;
	Bitmap wolf;
	int inc= 1;
	public Clock(){
		clockPaint =  F.makeFont("fonts/milk.ttf","#DCDFE4",(.1)*GameView.stage_height);
		WolfPaint =  F.makeFont("fonts/revy.ttf","#DCDFE4",(.04)*GameView.stage_height);
		
		tick[0] = MediaPlayer.create(GameView.ctx, R.raw.clacky);
		tick[1] = MediaPlayer.create(GameView.ctx, R.raw.clicky);
		gong = MediaPlayer.create(GameView.ctx, R.raw.gong);
		tick[0].setLooping(false);
		tick[1].setLooping(false);
		gong.setLooping(false);
		
		wolf= BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.wolf);
		
	}

	public void draw(Canvas stage) {
		if(GameView.alive && begin2){
		clock++;
		
		}
		if(!begin2){
			if(begin){			
				load_clock++;
			}
			Rect bound = new Rect();
			String text;
			if(load_clock%20<5){
				text = "Pinging Wolfram";
			}else if(load_clock%20<10){
				text = "Pinging Wolfram.";
			}else if(load_clock%20<15){
				text = "Pinging Wolfram..";
			}else{
				text = "Pinging Wolfram...";
			}
			WolfPaint.getTextBounds(text,0,text.length(),bound);
			stage.drawText(text,GameView.stage_width/2-bound.width()/2 , 750, WolfPaint);
			int wx=400;
			int wy=350;
			int ww= 300;
			int wh=300;
			stage.drawBitmap(wolf,new Rect(0,0,wolf.getWidth(),wolf.getHeight()), new Rect(wx,wy,wx+ww,wy+wh),null);
			if(load_clock>100){
				begin2 = true;
			}
		}
		
		if(clock%30 == 0){
			day+=inc;
			tik=!tik;
			if(tik){
				tick[0].start();
			}else{
				tick[1].start();
			}
			
		}
		if(clock%60 == 0){
			inc+=17;
		}
		if(clock>=30){
			Rect bounds = new Rect();
			String text = "Day "+day;
			clockPaint.getTextBounds(text,0,text.length(),bounds);
			stage.drawText(text, GameView.stage_width/2-bounds.width()/2, 250, clockPaint);
		}
		
		if(day>5420){
			clock=31;
			if(GameView.alive){
				gong.start();
			}
			GameView.DIE(0);
		}
	}
	
	
	
}
