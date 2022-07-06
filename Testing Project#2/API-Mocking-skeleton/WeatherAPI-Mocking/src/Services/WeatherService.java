package Services;

import Contracts.IHTTP;
import Contracts.IWeatherService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class WeatherService implements IWeatherService {

	//key 552f2ed7d4fba959c061080f49a5f445
	String appID ="552f2ed7d4fba959c061080f49a5f445";
	String weather;
	IHTTP h = new HTTP();
	public WeatherService(IHTTP http)
	{
		h=http;
	}
	public WeatherService() {
		// TODO Auto-generated constructor stub
	}
    @Override
    public String getCurrentWeather(String cityName){
    	
    	String uri ="https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=552f2ed7d4fba959c061080f49a5f445";
    	weather=h.Http(uri);
    	return weather;
    }
    @Override
    public String getCurrentWeather(int cityId){
    	String uri ="https://api.openweathermap.org/data/2.5/weather?id="+cityId+"&appid=552f2ed7d4fba959c061080f49a5f445";
    	weather=h.Http(uri);
    	return weather;
    }
    @Override
    public String getCurrentWeather(double latitude, double longitude){
    	String uri ="https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=552f2ed7d4fba959c061080f49a5f445";
    	weather=h.Http(uri);
    	return weather;
    }

}
