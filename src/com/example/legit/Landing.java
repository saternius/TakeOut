package com.example.legit;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;


public class Landing extends Activity {
	
	public GameView gv;
	static EditText textbox;
	static String feed;
	static int totalFat;
	static int satFat;
	static int sodium;
	static int totalCarbs;
	static int fiber;
	static int sugar;
	static int protien;
	static int vitA;
	static int vitC;
	static int iron;
	static int thiamin;
	static int riboflavin;
	static int niacin;
	static int vitB6;
	static int folate;
	static int phosphorus;
	static int magnesium;
	static int zinc;	
	static int B12;
	
	static String Globe;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		//gv = new GameView(this);
		setContentView(R.layout.activity_landing);
		textbox = (EditText) findViewById(R.id.editText1);
		Typeface NEOU = Typeface.createFromAsset(GameView.ctx.getAssets(), "fonts/revy.ttf"); 
		textbox.setTypeface(NEOU);
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		//gv.gameLoopThread.onResume();
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		//gv.gameLoopThread.onPause();
	}


	public static void hideInput() {
		textbox.setVisibility(View.INVISIBLE);
		
	}


	public static void showInput() {
		textbox.setVisibility(View.VISIBLE);
	}
	
	public static void postman(final String url){
		
		
		Fetch foo = new Fetch();
		foo.url ="https://www.wolframcloud.com/objects/user-688cc3b3-b92b-4552-a07e-dc9e4f6df831/food3?totalFat=100000&satFat=1&sodium=50&totalCarbs=1&fiber=10000&sugar=1&protein=1&vitE=1&vitD=1&vitA=1&thiamin=1&niacin=1&vitB6=1&vitB12=1&vitC=1&calcium=1&riboflavin=1&folate=1&magnesium=1&zinc=1&iron=80";
		new Thread(foo).start();
		String value = foo.getValue();
		Log.d("bugger",""+value);
		Globe = value;
		    
		    
	}



	


	public static void pingWolf() {
		
		String input = textbox.getText().toString();
		postman("http://davidsilin.me/food/"+input);
		
		
		double[] myvals = new double[100];
		for(int i = 0; i<100;i++){
			myvals[i] = .01;
		}
		//gets the age of death given the distribution
		Log.d("AGE OF DEATH:","Age:"+getAgeOfDeath(myvals));
		Food[] myF = new Food[2];
		//note all values are either in percents or miligrams (hence some large values) must pass ints to server
		myF[0] = new Food(100000, 100000, 100000, 20, 20, 300, 20000, 10, 10,40, 80, 1000, 100, 100, 100, 100);
		myF[1] = new Food(100000, 100000, 100000, 20, 20, 300, 20000, 10, 10,40, 80, 1000, 100, 100, 100, 100);
		Food p = new Food(100000, 100000, 100000, 20, 20, 300, 20000, 10, 10,40, 80, 1000, 100, 100, 100, 100);
		
		
	}

	public static int getAgeOfDeath(double[] myvals){
		double med = 0;
		for(int i = 0; i<100; i++){
			med+=myvals[i];
			if(med >= .5){
				return i+1;
			}
		}
		return 100;
	}
}
