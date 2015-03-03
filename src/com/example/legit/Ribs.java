package com.example.legit;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Ribs {
	Bitmap outline;
	int x=0;
	int y=0;
	int width=0;
	int height=0;
	double clock = 0;
	public Ribs(int part){
		outline= BitmapFactory.decodeResource(GameView.ctx.getResources(), part);
    	width = outline.getWidth();
    	height = outline.getHeight();
    	
	}
	
	public void draw(Canvas stage) {
		clock+=.025;
		double w = (2.1-(Math.sin(clock))/7)/2;
		double drift = 130+(-width*w)/2;
		stage.drawBitmap(outline, new Rect(0,0,outline.getWidth(),outline.getHeight()), new Rect((int)(x+drift),y,(int)(x+drift)+(int)(width*w),y+(int)(height)), null);
	}
	
}
