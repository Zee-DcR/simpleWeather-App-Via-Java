package weatherApplicatioNovice;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.simple.parser.ParseException;
import javax.swing.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class apIBackend {
	public static JSONObject wedData(String loc) {
        JSONArray locData = getLocData(loc);
        
        JSONObject location = (JSONObject) locData.get(0);
        double lat =(double) location.get("latitude");
        double longI =(double) location.get("longitude");
        
        

        
	    String url = "https://api.open-meteo.com/v1/forecast?latitude="
	    		+ lat +
	    		"&longitude=" +
	    		 longI 
	    		+ "&hourly=temperature_2m,weather_code,relative_humidity_2m,wind_speed_10m";
	    		
	    
	    
	    
	    
		   try {
			  HttpURLConnection conn = fetchApiResponse(url);
			  if (conn.getResponseCode() != 200) {
				  System.out.print("API ERROR");
					System.out.print("ERROR 	1");
					return null;
			  } 
				  
				  //store api 
				  StringBuilder res = new StringBuilder();
				  Scanner s = new Scanner(conn.getInputStream());
				 
				  //read and store data to string builder
				  while (s.hasNext()) {
					  res.append(s.nextLine());
				  }
				  
				  // close
				  s.close();
				  conn.disconnect();
				  
				  //parse
				  JSONParser parser = new JSONParser();
				  JSONObject json = (JSONObject) parser.parse(res.toString());
				  				  
	    
				  JSONObject hour = (JSONObject) json.get("hourly");
				
				  
				  JSONArray time = (JSONArray) hour.get("time");
				  int index = nowTimeIndex(time);
				  
				  JSONArray tempData = (JSONArray) hour.get("temperature_2m");
				  double temps = ((Number) tempData.get(index)).doubleValue();

				  JSONArray weatherCode = (JSONArray) hour.get("weather_code");
				  String weatherCondition = wCodeCovert((long)  weatherCode.get(index));
				  
				  
				  JSONArray relativeH = (JSONArray) hour.get("relative_humidity_2m");
				  long humid = (long) relativeH.get(index);
				  

				  JSONArray wind = (JSONArray) hour.get("wind_speed_10m");
				  double realWind = (double) wind.get(index);
				  
				  
				  
				  JSONObject wData = new JSONObject();
				  
				  wData.put("temps", temps);
				  wData.put("humidity", humid);
				  wData.put("windSpeed", realWind);
				  wData.put("weather", weatherCondition);

				  return wData;
				    
	}     catch (Exception e) {
		   e.printStackTrace();
			System.out.print("ERROR 	303");

	   }
		   return null;
	}

	
	
   public static JSONArray getLocData(String locName) {
	   locName = locName.replace(" ", "+");
	   
	   String url = "https://geocoding-api.open-meteo.com/v1/search?name="+locName+"&count=1&language=en&format=json";
	   
	   try {
		  HttpURLConnection conn = fetchApiResponse(url);
		  if (conn.getResponseCode() != 200) {
			  System.out.print("API ERROR");
				System.out.print("ERROR 	1");
				return null;
		  } else {
			  
			  //store api 
			  StringBuilder res = new StringBuilder();
			  Scanner s = new Scanner(conn.getInputStream());
			 
			  //read and store data to string builder
			  while (s.hasNext()) {
				  res.append(s.nextLine());
			  }
			  
			  // close
			  s.close();
			  conn.disconnect();
			  
			  //parse
			  JSONParser parser = new JSONParser();
			  JSONObject json = (JSONObject) parser.parse(res.toString());
			  JSONArray results = (JSONArray) json.get("results");
			  return results;

			  
		  }
	   }catch (Exception e) {
		   e.printStackTrace();
		   System.out.print("erro 2.3   \n");
			return null;

	   }

   }
   
	   private static HttpURLConnection fetchApiResponse(String uRl) {
		   try {
			   URL u = new URL(uRl);
			   HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			   
			   conn.setRequestMethod("GET");
			   
			   conn.connect();
			   return conn;
		   } catch (IOException e) {
			   e.printStackTrace();
				System.out.print("ERROR 	3");

		   }
			System.out.print("ERROR 	4");

	   return null;
   }
	   private static int nowTimeIndex(JSONArray timeList) {
		   
		String currentTime = nowTime();
		
		for (int i=0; i < timeList.size(); i++ ) {
			String time = (String) timeList.get(i);
			if (time.equalsIgnoreCase(currentTime)) {
				return i;
			}
		}
		
		return 0;
	   }
	   
	   public static String nowTime() {
		  
		   LocalDateTime currentDateTime = LocalDateTime.now();
		  
		  
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd' T 'HH':00'");
		   
		   
		   String formattedTimezone = currentDateTime.format(formatter);
		   
		   
		   return formattedTimezone;
	   }
	   
	   public static String wCodeCovert(long code) {
		   String wCondition = "";
		   
		   if (code == 0) {
		        return "Clear";

		    } else if (code >= 1 && code <= 3) {
		    	wCondition = "Cloudy";

		    } else if (code == 45 || code == 48) {
		    	wCondition = "Foggy";

		    } else if ((code >= 51 && code <= 57) || 
		               (code >= 61 && code <= 67) || 
		               (code >= 80 && code <= 82)) {
		    	wCondition = "Rainy";

		    } else if ((code >= 71 && code <= 77) || 
		               (code >= 85 && code <= 86)) {
		    	wCondition = "Snowy";

		    } else if (code >= 95 && code <= 99) {
		    	wCondition = "Thunderstorm";

		    } else {
		        return "Unknown";
		    }
		   return wCondition;
	   }
}

