package Contracts;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface IWeatherService {
	
    public String getCurrentWeather(String cityName);

    public String getCurrentWeather(int cityId);

    public String getCurrentWeather(double latitude, double longitude);
}
