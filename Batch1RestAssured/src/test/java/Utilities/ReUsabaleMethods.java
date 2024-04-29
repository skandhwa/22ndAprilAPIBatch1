package Utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import io.restassured.path.json.JsonPath;

public class ReUsabaleMethods {
	
	public static JsonPath rawtoJson(String response)
	{
		
		JsonPath js=new JsonPath(response);
		return js;
		
	}
	
	public static String RandomStringValue()
	{
		 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		   
		    StringBuilder sb = new StringBuilder();

		   
		    Random random = new Random();

		   
		    int length = 7;

		    for(int i = 0; i < length; i++) {

		    
		      int index = random.nextInt(alphabet.length());

		    
		      char randomChar = alphabet.charAt(index);

		   
		      sb.append(randomChar);
		    }

		    String ISBN = sb.toString();
		    return ISBN;
		    
	}
	
	
	
	public static int RandomNumberGen()
	{
		  
	    int randomNumber = ( int )( Math. random() * 9999 ); 
	    if( randomNumber <= 1000 ) 
	    { 
	    	randomNumber = randomNumber + 1000; Math. random();
	    }
	    
	   return randomNumber;
	}
	
	
	
	public static Map getCookieData()
	
	{
		Map<String,String> cookie=new LinkedHashMap<String,String>();
		cookie.put("skill1","Tester");
		cookie.put("skill2","Developer");
		cookie.put("skill3","DBA");
		
		return cookie;
		
		
		
	}
	

}
