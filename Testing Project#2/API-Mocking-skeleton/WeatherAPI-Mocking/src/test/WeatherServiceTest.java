package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import Contracts.IHTTP;
import Contracts.IJsonService;
import Services.ApplicationService;
import Services.GsonService;
import ViewModels.Result;
import ViewModels.Weather;
import Services.WeatherService;

public class WeatherServiceTest {
	
	ApplicationService app ;
	IJsonService json=new GsonService();
	WeatherService weather;
	Result response= new Result();//Services.Result@8b87145
	Result response1= new Result();
	Weather m=new Weather();
	String result ="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81},\"visibility\":10000,\"wind\":{\"speed\":1.79,\"deg\":83,\"gust\":4.92},\"clouds\":{\"all\":40},\"dt\":1622406707,\"sys\":{\"type\":2,\"id\":268730,\"country\":\"GB\",\"sunrise\":1622346644,\"sunset\":1622405144},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	String result1="{\"cod\":\"404\",\"message\":\"city not found\"}";

	//CityName
	@Test
	void getCurrentWeatherWithCityNameTest1(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?q="+""+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result1));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather("");
		assertEquals(result1,resultt);

	}
	@Test
	void getCurrentWeatherWithCityNameTest2(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?q="+null+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result1));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(null);
		assertEquals(result1,resultt);

	}
	@Test
	void getCurrentWeatherWithCityNameTest3(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?q="+"Londo"+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result1));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather("Londo");
		assertEquals(result1,resultt);

	}

	@Test
	void getCurrentWeatherWithCityNameTest4(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?q="+"London"+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather("London");
		assertEquals(result,resultt);

	}


	//-------------------------------------------------------------------------------------------
	//CityId
	@Test
	void getCurrentWeatherWithCityIdTest1(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?id="+-2+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result1));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(-2);
		assertEquals(result1,resultt);
	}
	@Test
	void getCurrentWeatherWithCityIdTest2(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?id="+0+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result1));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(0);
		assertEquals(result1,resultt);
	}
	@Test
	void getCurrentWeatherWithCityIdTest3(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?id="+800+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result1));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(800);
		assertEquals(result1,resultt);
	}
	@Test
	void getCurrentWeatherWithCityIdTest4(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?id="+2643743+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(2643743);
		assertEquals(result,resultt);
	}

	//-------------------------------------------------------------------------------------------
	//Coord
	@Test
	void getCurrentWeatherWithCoordTest1(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?lat="+-0.1257+"&lon="+51.5085+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(-0.1257,51.5085);
		assertEquals(result,resultt);
	}
	@Test
	void getCurrentWeatherWithCoordTest2(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?lat="+-1.0+"&lon="+-1.0+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result1));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(-1,-1);
		assertEquals(result1,resultt);
	}
	@Test
	void getCurrentWeatherWithCoordTest3(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?lat="+-0.1257+"&lon="+0.0+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(-0.1257,0);
		assertEquals(result,resultt);
	}
	@Test
	void getCurrentWeatherWithCoordTest4(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?lat="+0.0+"&lon="+0.0+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(0,0);
		assertEquals(result,resultt);
	}
	@Test
	void getCurrentWeatherWithCoordTest5(){
		
		Mockery mockingContext;
		mockingContext = new Mockery();
		IHTTP mockedObject = mockingContext.mock(IHTTP.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).Http("https://api.openweathermap.org/data/2.5/weather?lat="+0.1257+"&lon="+0.0+"&appid=552f2ed7d4fba959c061080f49a5f445");
			will(returnValue(result));
		}
		});
		weather=new WeatherService(mockedObject);
		String resultt=weather.getCurrentWeather(0.1257,0);
		assertEquals(result,resultt);
	}

	}
