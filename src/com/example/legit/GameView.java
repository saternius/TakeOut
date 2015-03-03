package com.example.legit;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;


public class GameView extends SurfaceView {

	//======================================================
	private SurfaceHolder holder;
	public GameLoopThread gameLoopThread;
	static int stage_width=1080;
	static int stage_height=1920;
	static Context ctx;
	Menu menu;
	Body body;
	Clock clock;
	Vitamins vit;
	static Curtains curtains;
	static Paint textPaint;
	static Graph graph;
	public static boolean alive=true;
	
	public GameView(Context context) {
	    super(context);
	    init(context);
	    
	}

	public GameView(Context context, AttributeSet attrs) {
	    super(context, attrs);
	    init(context);

	}

	public GameView(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
	    init(context);
	  
	}
	
	public void init(Context context) {
		//
		
		gameLoopThread=new GameLoopThread(this);
		holder=getHolder();
		holder.addCallback(new Callback() {
			 
		
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			public void surfaceCreated(SurfaceHolder holder) {
				gameLoopThread.setRunning(true);
				gameLoopThread.start();
			}
			
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//=====================================================================
		ctx = context;
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		stage_width = size.x;
		stage_height = size.y;
		Log.d("kek","Screen Width:"+size.x);
		Log.d("kek","Screen Height:"+size.y);
		//======================================================================
		
		body = new Body();
		clock = new Clock();
		textPaint=  F.makeFont("fonts/revy.ttf","#1D2125",(.025)*GameView.stage_height);
		vit = new Vitamins();
		curtains = new Curtains();
		menu = new Menu();
		graph = new Graph();
	}
	
	
	protected void onDraw(Canvas stage){
		stage.drawColor(Color.parseColor("#25587F"));
	
		body.draw(stage);
		vit.draw(stage);
		clock.draw(stage);
		if(!GameView.alive){
			curtains.draw(stage);
		}
		graph.draw(stage);
		menu.draw(stage);
		
	}
	
	  
	@Override
      public boolean onTouchEvent(MotionEvent event) {
		//Landing.hideInput();
		float mouseX = event.getX();
		float mouseY = event.getY();
		menu.onTouchEvent(event);
		curtains.onTouchEvent(mouseX,mouseY);
        return true;
      }

	public static void DIE(int i) {
		 alive = false;
		 curtains.death(i);
	}

	
	
	
		
}
