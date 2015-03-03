package com.example.legit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class Fetch implements Runnable {
	     private volatile String value;
	     static String url;

	     public String getValue() {
	         return value;
	     }

		@Override
		public void run() {
			HttpResponse response = null;
	    	try {        
	    	        HttpClient client = new DefaultHttpClient();
	    	        HttpGet request = new HttpGet();
	    	        request.setURI(new URI(url));
	    	        response = client.execute(request);
	    	        HttpEntity entity = response.getEntity();
				    InputStream is = entity.getContent();
				    Log.d("bugger", convertStreamToString(is));
				    final String str = (convertStreamToString(is));
				   
	    	} catch (URISyntaxException e) {
	    	        e.printStackTrace();
	    	    } catch (ClientProtocolException e) {
	    	        // TODO Auto-generated catch block
	    	        e.printStackTrace();
	    	    } catch (IOException e) {
	    	        // TODO Auto-generated catch block
	    	        e.printStackTrace();
	    	    }   
	    	    //return response;
	    	}

		private static String convertStreamToString(InputStream is) {

		    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		    StringBuilder sb = new StringBuilder();

		    String line = null;
		    try {
		        while ((line = reader.readLine()) != null) {
		            sb.append((line + "\n"));
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            is.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    return sb.toString();
		}				
		
}
