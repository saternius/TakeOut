package com.example.legit;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

public class F {
	static int w(int width){
		return GameView.stage_width*width/420;
	}
	static int h(int height){
		return GameView.stage_height*height/250;
	}
	public static Paint makeFont(String string, String string2, double d) {
		Typeface NEOU = Typeface.createFromAsset(GameView.ctx.getAssets(), string); 
		Paint Neou = new Paint();
		Neou.setColor(Color.parseColor(string2));
		Neou.setTypeface(NEOU);
		Neou.setTextSize((int)(d));
		Neou.setAntiAlias(true);
		return Neou;
	}
	 static boolean hitTest(Rect rect, float mouseX, float mouseY){
		 return mouseX>rect.left && mouseX<rect.right && mouseY>rect.top && mouseY<rect.bottom;
	 }
}
