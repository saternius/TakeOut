package com.example.legit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Organ {
	Bitmap outline;
	int x=0;
	int y=0;
	int width=0;
	int height=0;
	public Organ(int part){
		outline= BitmapFactory.decodeResource(GameView.ctx.getResources(), part);
    	width = outline.getWidth();
    	height = outline.getHeight();
	}
	
	public void draw(Canvas stage) {
		stage.drawBitmap(outline, new Rect(0,0,outline.getWidth(),outline.getHeight()), new Rect(x,y,x+width,y+height), null);
	}
	
	
	
}
