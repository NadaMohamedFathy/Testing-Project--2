import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import Contracts.IHTTP;
import Services.ApplicationService;
import Services.GsonService;
import Services.HTTP;
import Services.WeatherService;

public class App {
	
    public static void main(String[] args) throws Exception {
    	
        var application = new ApplicationService(new WeatherService(), new GsonService());
        System.out.println(application.getCurrentWeather("London"));
        System.out.println(application.getCurrentWeather(2643743));
        System.out.println(application.getCurrentWeather(-0.1257,51.5085));
    }
}
