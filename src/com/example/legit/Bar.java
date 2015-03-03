package com.example.legit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Bar {
	String title;
	double nut = 1;
	int x=0;
	int y=0;
	int bar_height = 35;
	Rect status;
	Rect bounds;
	public double tends;
	int clock = 0;
	public Bar(String str){
		title = str;
		bounds = new Rect();
		GameView.textPaint.getTextBounds(title,0,title.length(),bounds);
		x = Vitamins.x;
		clock++;
	}
	public void draw(Canvas stage) {
		if(Clock.begin2){
			nut -= (nut - tends)/1000;
		}
		stage.drawText(title+":", x-bounds.width(), y, GameView.textPaint);
		status = new Rect(x+30,y-33,(int) (x+nut*125),y-33+bar_height);
		Paint barPaint = new Paint();
		barPaint.setColor(Color.rgb((int) (Math.abs(1-nut)*255), (int) (Math.abs(nut)*255), 0));
		stage.drawRect(status,barPaint);
	}
}
