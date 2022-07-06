package Services;

import java.util.List;
import Contracts.IJsonService;
import Contracts.IWeatherService;
import ViewModels.Result;
import ViewModels.Weather;

public class ApplicationService {
    private IWeatherService weatherService;
    private IJsonService jsonService;

    public ApplicationService(IWeatherService wService, IJsonService jService) {
        weatherService = wService;
        jsonService = jService;
    }
   
    public String getCurrentWeather(String cityName){
    	
    	if(cityName==null || cityName=="") {
    		return "invalid input";
    	}
    	else {
    		String obj = weatherService.getCurrentWeather(cityName);
        	Result response = jsonService.fromJson(obj,Result.class);
        	String c=response.cod.toString();
    		if(c.equals("404")) {
    			return "invalid response";
    		}
    		else {
    			//List w=(List) response.weather;
    			//String e=w.get(0).toString();
    			String q=response.main.toString();
    			Weather main=jsonService.fromJson(q,Weather.class);
    			String result = "Temp : " + main.temp;
    			return result;
    			
    		}
    	}
    }
    public String getCurrentWeather(int cityId) {
    	
    	if(cityId<=0) {
    		return "invalid input";
    	}
    	else {
    		String obj = weatherService.getCurrentWeather(cityId);
        	Result response = jsonService.fromJson(obj,Result.class);
        	String c=response.cod.toString();
    		if(c.equals("404")) {
    			return "invalid response";
    		}
    		else {
    			//List w=(List) response.weather;
    			//String e=w.get(0).toString();
    			String q=response.main.toString();
    			Weather main=jsonService.fromJson(q,Weather.class);
    			String result ="Temp : " + main.temp;
    			return result;
    			
    		}
    	}
    }
    public String getCurrentWeather(double latitude, double longitude){
    	
    	if(latitude==0 && longitude==0) {
    		return "invalid input";
    	}
    	else {
    		String obj = weatherService.getCurrentWeather(latitude,longitude);
        	Result response = jsonService.fromJson(obj,Result.class);
        	String c=response.cod.toString();
    		if(c.equals("404")) {
    			return "invalid response";
    		}
    		else {
    			//List w=(List) response.weather;
    			//String e=w.get(0).toString();
    			String q=response.main.toString();
    			Weather main=jsonService.fromJson(q,Weather.class);
    			String result ="Temp : " + main.temp;
    			return result;
    			
    		}
    	}
    }
}
/*{"coord":{"lon":-0.1257,"lat":51.5085},
 * "weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],
 * "base":"stations",
 * "main":{"temp":285.88,"feels_like":285.11,"temp_min":284.02,"temp_max":287.76,"pressure":1030,"humidity":73},
 * "visibility":10000,
 * "wind":{"speed":3.19,"deg":82,"gust":8.26},
 * "clouds":{"all":0},"dt":1622323310,
 * "sys":{"type":2,"id":2019646,"country":"GB","sunrise":1622260298,"sunset":1622318674},
 * "timezone":3600,"id":2643743,
 * "name":"London",
 * "cod":200}*/
//JsonObject jsonObject = new JsonParser().parse(weatherService.getCurrentWeather(cityName)).getAsJsonObject();
//return jsonObject.get("weather").getAsString(); 
//WeatherService object  = new Gson().fromJson(weatherService.getCurrentWeather(cityName),WeatherService.class);
//JsonObject jsonObject = new JsonParser().parse(jsonService.fromJson(response, null).toString()).getAsJsonObject();
//return jsonObject.get("base").getAsString();
//return jsonObject.weather.toString();
/*Weather weather = new Gson().fromJson(e,Weather.class);
String r=weather.id.toString();
System.out.println(r);*/
//early exits if any
// invoke weatherService method with cityName
// check response for errors and if so early exit
// parse response from weatherService using jsonService
// return appropriate response
//return null;
