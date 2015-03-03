//EARLY
package com.example.legit;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class BottomMenu {
	int x = 0;
	int y = F.h(105);
	Paint messPanePaint = new Paint();
	Paint inputPanePaint = new Paint();
	Paint goPanePaint = new Paint();
	Paint go = new Paint();
	Paint rev;
	Paint edit;
	Bitmap skull_boarder;
	
	EditText ed;
	Rect inputRect;
	
	public BottomMenu(){
		rev =  F.makeFont("fonts/revy.ttf","#CCCCCC",(.028)*GameView.stage_height);
		edit = F.makeFont("fonts/revy.ttf", "#464D4D", (.035)*GameView.stage_height);
		go = F.makeFont("fonts/revy.ttf", "#F3CBCB", (.075)*GameView.stage_height);
		messPanePaint.setColor(Color.parseColor("#25587F"));
		messPanePaint.setAntiAlias(true);
		inputPanePaint.setColor(Color.rgb(150, 160, 160));
		inputPanePaint.setAntiAlias(true);
		goPanePaint.setColor(Color.rgb(100, 16, 16));
		goPanePaint.setAntiAlias(true);
		skull_boarder= BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.skull_border);
		
	}
	public void draw(Canvas stage){
		Rect bounds = new Rect();
		//top rect
		Rect rect = new Rect(x,y,x+GameView.stage_width,y+F.h(75));
		stage.drawRect(rect, messPanePaint);
		
		//edit rect
		stage.drawBitmap(skull_boarder, new Rect(0,0,skull_boarder.getWidth(),skull_boarder.getHeight()), new Rect(rect.left,rect.top,rect.right,rect.bottom), null);
		rect = new Rect(x,rect.bottom,x+GameView.stage_width,rect.bottom+F.h(23));
		stage.drawRect(rect, inputPanePaint);
		
		inputRect = new Rect(x,rect.bottom,x+GameView.stage_width,rect.bottom+F.h(50));
		stage.drawRect(inputRect, goPanePaint);
		
		
		
		String text = "..FOR THE REST OF MY LIFE,";
		rev.getTextBounds(text,0,text.length(),bounds);
		stage.drawText(text, x+GameView.stage_width/2-(bounds.width()/2), y+F.h(26), rev);
		
		text = "EVEN IF IT KILLS ME,";
		rev.getTextBounds(text,0,text.length(),bounds);
		stage.drawText(text, x+GameView.stage_width/2-(bounds.width()/2), y+F.h(40), rev);
		
		text = "I VOUCH ONLY TO EAT..";
		rev.getTextBounds(text,0,text.length(),bounds);
		stage.drawText(text, x+GameView.stage_width/2-(bounds.width()/2), y+F.h(55), rev);
		
		text = "GO";
		go.getTextBounds(text,0,text.length(),bounds);
		stage.drawText(text, x+GameView.stage_width/2-(bounds.width()/2), y+F.h(210), go);
		
		
	}
	public void onTouchEvent(MotionEvent event) {
		float mouseX = event.getX();
		float mouseY = event.getY();
		if(F.hitTest(inputRect, mouseX, mouseY)){
			Menu.fall();
			Landing.pingWolf();
		}
		
	}
}