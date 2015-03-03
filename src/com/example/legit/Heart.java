package com.example.legit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Heart {
	Bitmap outline;
	int x=0;
	int y=0;
	int width=0;
	int height=0;
	double clock = 0;
	public Heart(int part){
		outline= BitmapFactory.decodeResource(GameView.ctx.getResources(), part);
    	width = outline.getWidth();
    	height = outline.getHeight();
    	
	}
	
	public void draw(Canvas stage) {
		clock+=.75;
		if((int)(clock)%50<10){
			double w = Math.abs(Math.sin(clock/(10*Math.PI))/3);
			stage.drawBitmap(outline, new Rect(0,0,outline.getWidth(),outline.getHeight()), new Rect(x,y,(int) (x+width*.8+width*w),(int) (y+height*.9+height*(w/2))), null);
		}else{
			stage.drawBitmap(outline, new Rect(0,0,outline.getWidth(),outline.getHeight()), new Rect(x,y,x+width,y+height), null);
		}
	}
	

	
}
