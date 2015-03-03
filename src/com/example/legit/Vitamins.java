package com.example.legit;

import android.graphics.Canvas;
import android.graphics.Paint;

//fats
//sodium
//carbs
//fiber
//protien
//vitA
//vitC
//thiamin
//riboflavin
//niacin vitB6
//vit b12
//folate
//phosphorus
//magnisium
//zinc


public class Vitamins {
	Bar fats = new Bar("Fats");
	Bar sodium = new Bar("Sodium");
	Bar carbs = new Bar("Carbs");
	Bar fiber = new Bar("Fiber");
	Bar protien = new Bar("Protien");
	Bar vitA = new Bar("VitA");
	Bar vitC = new Bar("VitC");
	Bar thiamin = new Bar("Thiamin");
	Bar riboflavin = new Bar("Riboflavin");
	Bar niacin = new Bar("Niacin");
	Bar vitB6 = new Bar("VitB6");
	Bar vitB12 = new Bar("VitB12");
	Bar folate = new Bar("Folate");
	Bar phosphorus = new Bar("Phosphorus");
	Bar zinc = new Bar("Zinc");
	
	static int x = 875;
	static int y = 1100;
	public Vitamins(){
		fats.y=y;
		sodium.y = y+50;
		carbs.y = y+100;
		fiber.y = y+150;
		protien.y =y+200;
		vitA.y = y+250;
		vitC.y = y+300;
		thiamin.y = y+350;
		riboflavin.y = y+400;
		niacin.y = y+450;
		vitB6.y = y+500;
		vitB12.y = y+550;
		folate.y = y+600;
		phosphorus.y = y+650;
		zinc.y = y+700;
		
		
		fats.tends = 1.5;
		sodium.tends = 1.1;
		carbs.tends = 1.6;
		fiber.tends = .3;
		protien.tends = 1;
		vitA.tends = .25;
		vitC.tends = .2;
		thiamin.tends = .5;
		niacin.tends = .7;
		riboflavin.tends = .6;
		vitB6.tends = .4;
		vitB12.tends = .23;
		folate.tends = .3;
		phosphorus.tends = .4;
		zinc.tends = .7;
		
		
	}
	public void draw(Canvas stage) {
		fats.draw(stage);
		sodium.draw(stage);
		carbs.draw(stage);
		fiber.draw(stage);
		protien.draw(stage);
		vitA.draw(stage);
		vitC.draw(stage);
		thiamin.draw(stage);
		riboflavin.draw(stage);
		niacin.draw(stage);
		vitB6.draw(stage);
		vitB12.draw(stage);
		folate.draw(stage);
		phosphorus.draw(stage);
		zinc.draw(stage);
	}

}
