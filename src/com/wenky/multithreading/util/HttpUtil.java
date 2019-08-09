package com.wenky.multithreading.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtil {

	public static String  get(String _url){
		StringBuffer result=new StringBuffer();
		try{  
			URL url=new URL(_url);  
			URLConnection urlConnection=url.openConnection();  
			InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
			}catch(Exception e){e.printStackTrace();}  
			
		
		return result.toString();
	}
}
