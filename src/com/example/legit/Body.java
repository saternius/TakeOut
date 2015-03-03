package com.example.legit;

import android.graphics.Canvas;

public class Body {
	Organ outline = new Organ(R.drawable.outline);
	Organ inner_skel = new Organ(R.drawable.inner_skel);
	Organ kidneys = new Organ(R.drawable.kidneys);
	Organ pancreas = new Organ(R.drawable.pancreas);
	Organ liver = new Organ(R.drawable.liver);
	Lungs lungs = new Lungs(R.drawable.lungs);
	Organ stomach = new Organ(R.drawable.stomach);
	Heart heart = new Heart(R.drawable.heart);
	Organ large = new Organ(R.drawable.large_intestines);
	Organ small = new Organ(R.drawable.small_intestines);
	Ribs ribs = new Ribs(R.drawable.rib_cage);
	Organ hair = new Organ(R.drawable.hair);
	
	int x=0;
	int y=0;
	int width=0;
	int height=0;
	int drift = -50;
	public Body(){
		outline.x=0+drift;
		outline.y=1080;
		inner_skel.x = 55+drift;
		inner_skel.y = 1132;
		kidneys.x = 225+drift;
		kidneys.y = 1615;
		lungs.x =212+drift;
		lungs.y = 1381;
		
		liver.x = 200+drift;
		liver.y = 1555;
		
		stomach.x = 280+drift;
		stomach.y = 1575;
		
		pancreas.x = 283+drift;
		pancreas.y = 1670;
		
		heart.x = 330+drift;
		heart.y = 1490;
		
		large.x = 210+drift;
		large.y = 1670;
		small.x = 220+drift;
		small.y = 1713;
		
		ribs.x = 200+drift;
		ribs.y = 1440;
		hair.x = 170+drift;
		hair.y = 1100;
	}
	
	public void draw(Canvas stage){
		outline.draw(stage);
		inner_skel.draw(stage);
		large.draw(stage);
		small.draw(stage);
		kidneys.draw(stage);
		stomach.draw(stage);
		pancreas.draw(stage);
		liver.draw(stage);
		lungs.draw(stage);
		heart.draw(stage);
		ribs.draw(stage);
		hair.draw(stage);
	}
}
