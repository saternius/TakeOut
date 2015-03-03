package com.example.legit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;


public class TopMenu {
	int x = 0;
	int y = 0;
	Paint topPanePaint = new Paint();
	Paint editPanePaint = new Paint();
	Paint rev;
	Paint edit;
	Rect edit_rect;
	public TopMenu(){
		rev =  F.makeFont("fonts/revy.ttf","#CCCCCC",(.12)*GameView.stage_height);
		edit = F.makeFont("fonts/revy.ttf", "#133C52", (.035)*GameView.stage_height);
		topPanePaint.setColor(Color.rgb(19, 60, 82));
		topPanePaint.setAntiAlias(true);
		editPanePaint.setColor(Color.rgb(34, 115, 150));
		editPanePaint.setAntiAlias(true);
		
	}
	public void draw(Canvas stage){
		Rect bounds = new Rect();
		//top rect
		Rect rect = new Rect(x,y,x+GameView.stage_width,y+F.h(90));
		stage.drawRect(rect, topPanePaint);
		
		//edit rect
		edit_rect = new Rect(x,rect.bottom,x+GameView.stage_width,rect.bottom+F.h(30));
		stage.drawRect(rect, editPanePaint);
		
		String text = "TAKE";
		rev.getTextBounds(text,0,text.length(),bounds);
		stage.drawText(text, x+GameView.stage_width/2-(bounds.width()/2), y+F.h(36), rev);
		
		text = "OUT";
		rev.getTextBounds(text,0,text.length(),bounds);
		stage.drawText(text, x+GameView.stage_width/2-(bounds.width()/2), y+F.h(73), rev);
		
		text = "Edit Health Info";
		edit.getTextBounds(text,0,text.length(),bounds);
		stage.drawText(text, x+GameView.stage_width/2-(bounds.width()/2), y+F.h(100), edit);
		
	}
	public void onTouchEvent(MotionEvent event) {
		if(F.hitTest(edit_rect, event.getX(), event.getY())){
			Menu.changeToSettings();
		}
		
	}
}
