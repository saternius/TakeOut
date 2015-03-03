package com.example.legit;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

public class Graph {
	static ArrayList<Point> points = new ArrayList<Point>();
	Paint backPane = new Paint();
	Paint outlinePane = new Paint();
	int step = 0;
	int clock =0;
	Bitmap skull;
	int deathDate = (int) (5475+(Math.random()*2000)-1000);
	int module = 5;
	int midX = 200;
	int midY = 200;
	public Graph(){
		//test one
		for(int i=0; i<100; i++){
			points.add(new Point( (i*11),(int) -(Math.sin(i/32.0)*180)));
		}
		MakeSized();
		
		backPane.setColor(Color.parseColor("#BCCAD3"));
		outlinePane.setColor(Color.parseColor("#143247"));
		outlinePane.setStyle(Style.STROKE);
		skull= BitmapFactory.decodeResource(GameView.ctx.getResources(), R.drawable.skull);
	    
	}
	
	
	static void changeCoords(String str){
		Log.d("bugger","I WAS HERE");
		Log.d("bugger","s"+str.length());
		//str = str.substring(1, str.length()-1);
		//String[] cords = str.split(",");
		Log.d("bugger","size:");
		/*
		for(int i=0; i<cords.length;i++){
			Log.d("bugger","length:"+cords[i]+"\n");
		}
		*/
		
	}
	
	private void MakeSized() {
		points = interpolate(points);
		points = interpolate(points);
	}
	private ArrayList<Point> interpolate(ArrayList<Point> points) {
		ArrayList<Point> bigger = new ArrayList<Point>();
		for(int i=0; i<points.size()-1;i++){
			bigger.add(points.get(i));
			Point newPt = new Point(points.get(i).x+(points.get(i+1).x-points.get(i).x)/2, points.get(i).y+(points.get(i+1).y-points.get(i).y)/2);
			bigger.add(newPt);
		}
		return bigger;
		
	}
	public void draw(Canvas stage){
		if(Clock.begin2){
		stage.drawRect(new Rect(0,400,GameView.stage_width,800),backPane);
		stage.drawRect(new Rect(0,400,GameView.stage_width,800),outlinePane);
		
		Path path = new Path();
		path.moveTo(0,800);
		
		for (int i = 0; i < step; i++) {
            path.lineTo(points.get(i).x, points.get(i).y+800);  
		}
		if(step>1){
			path.lineTo(points.get(step-1).x,800);
		}
		clock++;
		//if(step<deathDate){
			if(clock%module == 0 && step<points.size()-1){
				step++;
			}
		//}else{
		//	if(clock%1 == 0 && step<points.size()-1){
		//		step++;
		//	}
		//}
		
		 Paint paint = new Paint();
		 paint.setStrokeWidth(2);
		 paint.setColor(Color.rgb(255, 102, 0));
		 paint.setStyle(Paint.Style.STROKE);
	     stage.drawPath(path, paint);
	     
	     Paint paint2 = new Paint();
		 paint2.setColor(Color.rgb(255, 180, 0));
		 paint.setStyle(Paint.Style.FILL);
	     stage.drawPath(path, paint2);
	     if(clock==500){
	    	 changeCoords(Landing.Globe);
	     }
	     if(!GameView.alive){
	    	 module = 1;
	    	 int x = points.get(midX).x;
	    	 int y = points.get(midY).y+800;
	    	 int width = skull.getWidth()/4;
	    	 int height = skull.getHeight()/4;
	    	 stage.drawBitmap(skull, new Rect(0,0, skull.getWidth(), skull.getHeight()),new Rect(x-width/2,y-height/2,x+width/2,y+height/2) ,null);
	     }
		}  
	}
	
	public static void clean(){
		points.clear();
	}
}
